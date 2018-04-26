package utilities;

import utilities.RaceRuntimeConstant;
import utilities.Value;

public class Operators implements RaceRuntimeConstant {

 public static double performMathematicOperation(double operand1, double operand2, String operator)
 {	
	 if(operator.equals("+"))
	 	return operand1 + operand2;
 	if(operator.equals("-"))
 		return operand1 - operand2;
 	if(operator.equals("*"))
 		return operand1 * operand2;
 	if(operator.equals("/"))
 		return operand1 / operand2;
 
 	return 0;
 }

 
 public static String mapArithmaticStringToOperator(String operator){
	 switch(operator) {
     case "+":
    	 return ADD_INSTRUCTION;
     case "-":
    	 return SUBTRACT_INSTRUCTION;
     case "*":
    	 return MULTIPLY_INSTRUCTION;
     case "/":
    	 return DIVIDE_INSTRUCTION;
     default:
    	 return ADD_INSTRUCTION;
 }	 
 }

 public static String performBooleanOperation(boolean operand1, boolean operand2, String operator)
 {	 boolean result = false;
	 switch(operator) 
	 { case "&&":
			 result = operand1 && operand2;
			 break;
		 case "||":
			 result = operand1 || operand2;
			 break;
			 
	 }
	if(result == true){
		return "T";
	} else{
		return "F";
		}
 }


 public static String performCompareOperation(double operand1, double operand2, String operator){
	 //'<'|'>'|'<='|'>='|'=='|'!='	
	 boolean result = false;
	 switch (operator) {
		case "<":
			result = operand1 < operand2;
			break;
		case ">":
			result = operand1 > operand2;
			break;
		case "<=":
			result = operand1 <= operand2;
			break;
		case ">=":
			result = operand1 >= operand2;
			break;
		case "==":
			result = operand1 == operand2;
			break;	
		case "!=":
			result = operand1 != operand2;
			break;
		default:
			break;
		}
	 if(result == true){
		 return "T";
	 }else{
		return "F";
		 }		 
	 }

 
 public static boolean isCompareOperator(String input){
	 if(input == null){
		 return false;
	 }
	 if(input.equals("<") || input.equals(">") || input.equals("<=")
			 || input.equals(">=") ||input.equals("==") || input.equals("!=")){
		 return true;
	 }
	 return false;
 }

 
 
 public static String performEqualOperation(String operand1, String operand2, String operator){
	 boolean result = false;
	 switch(operator){
	 case "==":
		 result = operand1.equals(operand2);
		 break;
	 case "!=":
		 result = !operand1.equals(operand2);		 
		 break;	 
	 }
	 if(result == true){
		 return "T";
	 }else{
		return "F";
		 }		 
	 }
}
 
