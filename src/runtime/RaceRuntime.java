package runtime;

import edu.emory.mathcs.backport.java.util.Arrays;

import java.util.*;

/**
 * Created by saheb johar on 4/25/18.
 */
public class RaceRuntime implements RaceRuntimeConstant {
    public HashMap<String, Integer> functions = new HashMap<>();
    private Stack<HashMap<String, DataValues>> stackFrame = new Stack<>();
    private List<String> intermediateCode;
    private boolean storeReturn = false;

    private int programCounter = 0;
    private String output = "";

    public RaceRuntime(String intermediateCode) {
        this.intermediateCode = Arrays.asList(intermediateCode.split("\\n"));
        System.out.println("intermediate code"+ this.intermediateCode) ;
    }

    private void addOutput(String output) {
        this.output += output + "\n";
    }

    private void pushStackFrame() {

        stackFrame.push(new HashMap<>());

    }

    private void popStackFrame() {
        stackFrame.pop();
    }

    private void setValue(String identifier, DataValues value) {
        HashMap<String, DataValues> hashMap = stackFrame.peek();
        hashMap.put(identifier, value);
        
    }

    private DataValues getValue(String identifier) {
        HashMap<String, DataValues> hashMap = stackFrame.peek();
        return hashMap.get(identifier);
    }

    public String getOutput() {
        return this.output;
    }

    private String[] splitInstruction(String instruction) {
        return instruction.split("\\s");
    }
    
    private int executeInstructionHandler(String completeInstruction, int counter) {

    	String[] instruction = splitInstruction(completeInstruction);

        switch(instruction[0]) {
            case STORE_INSTRUCTION:
                executeStoreInstruction(instruction);
                break;
            case READ_INSTRUCTION:
                executeReadInstruction(instruction);
                break;
            case WRITE_INSTRUCTION:
            	executeWriteInstruction(instruction);
            	break;

            // All Arithmetic Operations
            case ADD_INSTRUCTION:
            case SUBTRACT_INSTRUCTION:
            case MULTIPLY_INSTRUCTION:
            case DIVIDE_INSTRUCTION:
                executeArithemticInstruction(instruction);
                break;

            // All Boolean Operations
            case OR:
            case AND:
            case BOOLEAN_EQUAL_EQUAL:
            case BOOLEAN_NOT_EQUAL:
                executeBooleanInstruction(instruction);
                break;
                
            // All Comparison Operations
            case GREATER_THAN:
            case GREATER_THAN_EQUAL:
        	case LESS_THAN:
        	case LESS_THAN_EQUAL:
        	case EQUAL_EQUAL:
        	case NOT_EQUAL:
            	executeBooleanComparisonInstruction(instruction);
            	break;
            	
        	case UNARY_MINUS:
        		executeUnaryMinusInstruction(instruction);
        		break;
        	case NOT:
        		executeNot(instruction);
        		break;

            // Loops
            case WHILE_BLOCK_START:
                counter = executeWhileBlock(++counter);
                break;
            case FOR_LOOP_START:
            	counter = executeForBlock(++counter);
            	break;

            // Decisions
            case IF_BLOCK_START:
                counter = executeIfBlock(++counter);
                break;
            case ELSE_IF_BLOCK_START:
                counter = executeElseIfBlock(++counter);
                break;
            case ELSE_BLOCK_START:
                counter = executeElseBlock(++counter);
                break;

            // Functions
            case FUNCTION_START:
                counter = executeFunctionBlock(++counter);
                break;
            case FUNCTION_CALL:
                executeFunctionCall(instruction);
                break;
            case FUNCTION_RETURN_END:
                counter = executeFunctionReturn();
                break;
 	
        }

        return counter;
    }

    public void execute() {
        pushStackFrame();

        while(programCounter < intermediateCode.size()) {
        	programCounter = executeInstructionHandler(intermediateCode.get(programCounter), programCounter) + 1;
        }

        System.out.println();
    }
    private void executeUnaryMinusInstruction(String[] instruction){
    	setValue(instruction[1], new DataValues(-getValue(instruction[1]).asDouble()));
    }
    private void executeNot(String[] instruction){
    	setValue(instruction[1], new DataValues(!getValue(instruction[2]).asBoolean()));
    }
    

    private boolean isDouble(String value) {
        try {
            Double.parseDouble(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isBoolean(String value) {
        return value.equalsIgnoreCase("true") || value.equalsIgnoreCase("false");
    }

    private DataValues getWildCardValue(String value) {
        if(value.equals("NULL")) {
            return null;
        }
        else if(isDouble(value)) {
            return new DataValues(Double.parseDouble(value));
        }
        else if(isBoolean(value)) {
            return new DataValues(Boolean.parseBoolean(value));
        }
        else {
            return getValue(value);
        }
    }

    private void executeStoreInstruction(String[] instruction) {
        if(instruction[1].equals(ACC_REGISTER)) {
            setValue(ACC_REGISTER, getWildCardValue(instruction[2]));
        }
        else {
            setValue(instruction[1], getValue(instruction[2]));
        }
    }

    private void executeReadInstruction(String[] instruction) {

        if(instruction[1].equals(ACC_REGISTER)) {
            setValue(ACC_REGISTER, getWildCardValue(instruction[2]));
        }
        else {
            setValue(instruction[1], getValue(instruction[2]));
        }
    }

    // Need to check if write works after this change
    private void executeWriteInstruction(String[] instruction) {

        if (null != getWildCardValue(instruction[1])) {
            try {
                addOutput(getWildCardValue(instruction[1]).toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void executeArithemticInstruction(String[] instruction) {
        double left = getValue(instruction[2]).asDouble();
        double right = getValue(instruction[3]).asDouble();

        switch(instruction[0]) {
            case ADD_INSTRUCTION:
                setValue(instruction[1], new DataValues(left + right));
                break;
            case SUBTRACT_INSTRUCTION:
                setValue(instruction[1], new DataValues(left - right));
                break;
            case MULTIPLY_INSTRUCTION:
                setValue(instruction[1], new DataValues(left * right));
                break;
            case DIVIDE_INSTRUCTION:
                setValue(instruction[1], new DataValues(left / right));
                break;
        }
    }

    private void executeBooleanInstruction(String[] instruction) {
        boolean left = getValue(instruction[2]).asBoolean();
        boolean right = getValue(instruction[3]).asBoolean();
        
        switch(instruction[0]) {
            case BOOLEAN_EQUAL_EQUAL:
                setValue(instruction[1], new DataValues(left == right));
                break;
            case AND:
            	setValue(instruction[1], new DataValues(left && right));
            	break;
            case OR:
            	setValue(instruction[1], new DataValues(left || right));
            	break;
            case BOOLEAN_NOT_EQUAL:
                setValue(instruction[1], new DataValues(left != right));
                break;
        }
    }
    
    private void executeBooleanComparisonInstruction(String[] instruction) {
    	double left = getValue(instruction[2]).asDouble();
    	double right = getValue(instruction[3]).asDouble();
    	
    	switch(instruction[0]) {
	    	case GREATER_THAN:
	    		setValue(instruction[1], new DataValues(left > right));
	    		break;
	    	case GREATER_THAN_EQUAL:
	    		setValue(instruction[1], new DataValues(left >= right));
	    		break;
	    	case LESS_THAN:
	    		setValue(instruction[1], new DataValues(left < right));
	    		break;
	    	case LESS_THAN_EQUAL:
	    		setValue(instruction[1], new DataValues(left <= right));
	    		break;
	    	case EQUAL_EQUAL:
	    		setValue(instruction[1], new DataValues(left == right));
	    		break;
	    	case NOT_EQUAL:
	    		setValue(instruction[1], new DataValues(left != right));
	    		break;        
    	}
    	
    }

    private int executeBlock(int counter, String stopCondition, boolean skip) {
    	//System.out.println(counter);
        while(counter > -1) {
            String instruction = intermediateCode.get(counter);
            if (instruction.equals(stopCondition)) {
                break;
            }
            else {
                if(!skip) {
                    counter = executeInstructionHandler(instruction, counter);
                    if(counter == -1) {
                        break;
                    }
                }
                ++counter;
            }
        }
        return counter;
    }

    private int executeWhileBlock(int whileStartCounter) {
        int counter;
        while(true) {
            counter = executeBlock(whileStartCounter, CONDITION_END, false);
            if(getValue(ACC_REGISTER).asBoolean()) {
                executeBlock(counter, WHILE_BLOCK_END, false);
            }
            else {
                counter = executeBlock(counter, WHILE_BLOCK_END, true);
                break;
            }
        }
        return counter;
    }
   
    private int executeForBlock(int forStartCounter) {
        int counter;
        while(true) {
            counter = executeBlock(forStartCounter, COMPARISION_END, false);
            if(getValue(ACC_REGISTER).asBoolean()) {
                executeBlock(counter, FOR_LOOP_END, false);
            }
            else {
                counter = executeBlock(counter, FOR_LOOP_END, true);
                break;
            }
        }
        return counter;
    }
    
    private int executeIfBlock(int counter) {
    	counter = executeBlock(counter, CONDITION_END, false);
    	if(getValue(ACC_REGISTER).asBoolean()){
    		counter = executeBlock(counter, IF_BLOCK_END, false);
    		counter = executeBlock(counter, IF_ELSE_BLOCK_END, true);
    	} else {
    		counter = executeBlock(counter, IF_BLOCK_END, true);
    	}
    	return counter;
    }

    private int executeElseBlock(int counter) {
    	counter = executeBlock(counter, ELSE_BLOCK_END, false);
     	return counter;
    }

    private int executeElseIfBlock(int counter) {
    	counter = executeBlock(counter, CONDITION_END, false);
    	if(getValue(ACC_REGISTER).asBoolean()){
    		counter = executeBlock(counter, RaceRuntimeConstant.ELSE_IF_BLOCK_END, false);
    		counter = executeBlock(counter, IF_ELSE_BLOCK_END, true);
    	} else {
    		counter = executeBlock(counter, ELSE_IF_BLOCK_END, true);
    	}
    	return counter;
    }

    private int executeFunctionBlock(int counter) {
        String[] instruction = splitInstruction(intermediateCode.get(counter));
        String[] parametersInstruction = splitInstruction(intermediateCode.get(counter + 1));
        int parametersLength = parametersInstruction.length - 1;

        functions.put(instruction[1] + "_" + String.valueOf(parametersLength), counter);
        counter = executeBlock(counter, FUNCTION_END, true);
        return counter;
    }

    private int executeFunctionReturn() {
        storeReturn = true;
        return -1;
    }

    private void executeFunctionCall(String[] instruction) {
        List<DataValues> arguments = new ArrayList<>();
        DataValues returnValue = null;
        int argumentsLength = instruction.length - 2, counter;

        // When Arguments exist
        if(argumentsLength > 0) {
            for(int index = 2; index < instruction.length; index++) {
                arguments.add(getWildCardValue(instruction[index]));
            }
        }

        pushStackFrame();
        counter = functions.get(instruction[1] + "_" + argumentsLength);
        List<String> parameterInstruction = Arrays.asList(splitInstruction(intermediateCode.get(counter + 1)));
        parameterInstruction = parameterInstruction.subList(1, parameterInstruction.size());

        // Assign Arguments to Parameters
        for(int index = 0; index < parameterInstruction.size(); index++) {
            setValue(parameterInstruction.get(index), arguments.get(index));
        }

        // Execute Function Block
        storeReturn = false;
        executeBlock(counter, FUNCTION_END, false);

        if(storeReturn) {
            returnValue = getValue(ACC_REGISTER);
        }
        popStackFrame();
        setValue(ACC_REGISTER, returnValue);
    }
}
