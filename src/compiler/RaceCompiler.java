package compiler;


import main.race.RaceBaseVisitor;
import main.race.RaceParser;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.tree.TerminalNode;
import org.codehaus.plexus.util.StringUtils;
import utilities.RaceRuntimeConstant;

public class RaceCompiler extends RaceBaseVisitor{
	
	private class IntermediateCodeGenerator {
        private String IntermediateOutput = "";
        private void addIntermediateOutput(String output) {
            this.IntermediateOutput += output + "\n";
        }
    }
	
	private IntermediateCodeGenerator intermediateCodeGenerator = new IntermediateCodeGenerator();

	public String getOutput() {
		return intermediateCodeGenerator.IntermediateOutput;
	}

	@Override 
	public Object visitProgram(RaceParser.ProgramContext ctx) 
	{ 
		return visitChildren(ctx); 
	}
	
	
	@Override public Object visitBody(RaceParser.BodyContext ctx) 
	{ 
		return visitChildren(ctx); 
	}
	
	@Override public Object visitStatement(RaceParser.StatementContext ctx) 
	{ 
		return visitChildren(ctx); 
	}
	
	@Override 
	public Object visitAssignmentInteger(RaceParser.AssignmentIntegerContext ctx) 
	{ 
		String indentifier = ctx.IDENTIFIER().getText();
		if(ctx.EQUALSto()!= null)
		{
			//if initialization and assignment done in the same statement
			visit(ctx.num_expressn());
			intermediateCodeGenerator.addIntermediateOutput("SAVE " + indentifier + " REG");
		}
		else {
			//if no assignment to the variable is done. Default value is can be 0
			intermediateCodeGenerator.addIntermediateOutput("SAVE " + indentifier + " NULL");
		}
		return null;
	}
	
	@Override 
	public Object visitAssignmentBoolean(RaceParser.AssignmentBooleanContext ctx) 
	{ 
		String identifier = ctx.IDENTIFIER().getText();
		if(ctx.EQUALSto() != null) {
            visit(ctx.bool_expressn());
            intermediateCodeGenerator.addIntermediateOutput("SAVE " + identifier + " REG");
        }
        else {
        	intermediateCodeGenerator.addIntermediateOutput("SAVE " + identifier + " NULL");
        }
        return null;
		
	}
	
	
	@Override 
	public Object visitAssignmentIncrementOrDecrement(RaceParser.AssignmentIncrementOrDecrementContext ctx) 
	{ 
		String identifier = ctx.IDENTIFIER().getText();
		intermediateCodeGenerator.addIntermediateOutput("SAVE REG 1");
		switch(ctx.op.getType()) {
			case RaceParser.INCR:
				intermediateCodeGenerator.addIntermediateOutput("ADD "+ identifier + " " +identifier+" REG" );
				break;
			case RaceParser.DECR:
				intermediateCodeGenerator.addIntermediateOutput("SUB " + identifier + " " + identifier +" REG");
				break;
		
		}
		return null;		
	}
	
	
	@Override 
	public Object visitAssignmentShortHand(RaceParser.AssignmentShortHandContext ctx) 
	{ 
		String identifier = ctx.IDENTIFIER().getText();
		visit(ctx.num_expressn());
		switch(ctx.op.getType()) {
			case RaceParser.ADD:
				intermediateCodeGenerator.addIntermediateOutput("ADD " +identifier + " " + identifier+ " REG");
				break;
			case RaceParser.SUB:
				intermediateCodeGenerator.addIntermediateOutput("SUB " + identifier + " " + identifier +" REG");
				break;
			case RaceParser.MUL:
				intermediateCodeGenerator.addIntermediateOutput("MUL " + identifier + " " + identifier + " REG");
				break;
			case RaceParser.DIV:
				intermediateCodeGenerator.addIntermediateOutput("DIV " + identifier + " " + identifier + " REG");
				break;
		}
		return null;
		
	}
	

	@Override 
	public Object visitExpressionBooleanParentheses(RaceParser.ExpressionBooleanParenthesesContext ctx) 
	{ 
		visit(ctx.bool_expressn());
		return null;
		
	}
	
	
	@Override 
	public Object visitExpressionBoolean(RaceParser.ExpressionBooleanContext ctx) 
	{ 
		visit(ctx.bool_expressn(0));
        intermediateCodeGenerator.addIntermediateOutput("SAVE A REG");
        visit(ctx.bool_expressn(1));
        intermediateCodeGenerator.addIntermediateOutput("SAVE B REG");

        switch(ctx.op.getType()) {
            case RaceParser.ISEquals:
                intermediateCodeGenerator.addIntermediateOutput("BOOL_ISEQUALS REG A B");
                break;
            case RaceParser.NotEquals:
                intermediateCodeGenerator.addIntermediateOutput("BOOL_IS_NOT_EQUALS REG A B");
                break;
        }
		return null;
		
	}
	

	@Override 
	public Object visitExpressionBooleanComparison(RaceParser.ExpressionBooleanComparisonContext ctx) 
	{ 
		visit(ctx.comp_expressn());
		return null; 
	}
	

	@Override 
	public Object visitExpressionBooleanConnector(RaceParser.ExpressionBooleanConnectorContext ctx) 
	{ 
		visit(ctx.bool_expressn(0));
        intermediateCodeGenerator.addIntermediateOutput("SAVE C REG");
        visit(ctx.bool_expressn(1));
        intermediateCodeGenerator.addIntermediateOutput("SAVE B REG");

        switch(ctx.op.getType()) {
            case RaceParser.AND:
            	intermediateCodeGenerator.addIntermediateOutput("AND REG C B");
                break;
            case RaceParser.OR:
            	intermediateCodeGenerator.addIntermediateOutput("OR REG C B");
                break;
        }
		return null; 
	}
	
	@Override 
	public Object visitExpressionBooleanFunctionCall(RaceParser.ExpressionBooleanFunctionCallContext ctx)
	{ 
        visit(ctx.func());
		return null; 
	}
	
	@Override 
	public Object visitExpressionBooleanIdentifierOnly(RaceParser.ExpressionBooleanIdentifierOnlyContext ctx)
	{ 
		intermediateCodeGenerator.addIntermediateOutput("READ REG " + ctx.IDENTIFIER().getText());
		if(ctx.NOT() != null) {
			intermediateCodeGenerator.addIntermediateOutput("NOT REG");
		}
		return null; 
	}
	
	@Override 
	public Object visitExpressionBooleanOnly(RaceParser.ExpressionBooleanOnlyContext ctx) 
	{ 
		String value = ctx.BOOLEAN().getText();
		boolean bolVal;
		if(value.equals("T")) {
			bolVal = true;
		}
		else {
			bolVal = false;
		}
        if(ctx.NOT() != null) {
            bolVal = !bolVal;
        }
        intermediateCodeGenerator.addIntermediateOutput("SAVE REG " + bolVal);
		return null; 
	}
	

	@Override 
	public Object visitExpressionNumberComparison(RaceParser.ExpressionNumberComparisonContext ctx) 
	{ 
		visit(ctx.num_expressn(0));
		intermediateCodeGenerator.addIntermediateOutput("SAVE A REG");
		visit(ctx.num_expressn(1));
		intermediateCodeGenerator.addIntermediateOutput("SAVE B REG");
		
		switch(ctx.op.getType()) {
			case RaceParser.GREATER:
				intermediateCodeGenerator.addIntermediateOutput("GREATER REG A B");
				break;
			case RaceParser.MORE_or_EQU:
				intermediateCodeGenerator.addIntermediateOutput("GREATER_OR_EQUAL REG A B");
				break;
			case RaceParser.LESSER:
				intermediateCodeGenerator.addIntermediateOutput("LESSER REG A B");
				break;
			case RaceParser.LESS_or_EQU:
				intermediateCodeGenerator.addIntermediateOutput("LESSER_OR_EQUAL REG A B");
				break;
			case RaceParser.ISEquals:
				intermediateCodeGenerator.addIntermediateOutput("EQUAL_TO REG A B");
				break;
			case RaceParser.NotEquals:
				intermediateCodeGenerator.addIntermediateOutput("NOT_EQUAL_TO REG A B");
				break;
		}
		return null; 
	}
	

	@Override 
	public Object visitExpressionNumberParentheses(RaceParser.ExpressionNumberParenthesesContext ctx) 
	{ 
		visit(ctx.num_expressn());
		return null; 
	}
	

	@Override 
	public Object visitExpressionNumberPlusMinus(RaceParser.ExpressionNumberPlusMinusContext ctx) 
	{
		visit(ctx.num_expressn(0));
		intermediateCodeGenerator.addIntermediateOutput("SAVE C REG");
		visit(ctx.num_expressn(1));
		intermediateCodeGenerator.addIntermediateOutput("SAVE B REG");
		
		switch(ctx.op.getType()) {
			case RaceParser.ADD:
				intermediateCodeGenerator.addIntermediateOutput("ADD REG C B");
				break;
			case RaceParser.SUB:
				intermediateCodeGenerator.addIntermediateOutput("SUB REG C B");
				break;
		}
		return null; 
	}
	

	@Override 
	public Object visitExpressionNumberMultiplyDivide(RaceParser.ExpressionNumberMultiplyDivideContext ctx) 
	{ 
		visit(ctx.num_expressn(0));
		intermediateCodeGenerator.addIntermediateOutput("SAVE A REG");
		visit(ctx.num_expressn(1));
		intermediateCodeGenerator.addIntermediateOutput("SAVE B REG");
		
		switch(ctx.op.getType()) {
			case RaceParser.MUL:
				intermediateCodeGenerator.addIntermediateOutput("MUL REG A B");
				break;
			case RaceParser.DIV:
				intermediateCodeGenerator.addIntermediateOutput("DIV REG A B");
				break;
		}
		return null; 
	}
	

	@Override 
	public Object visitExpressionNumberIdentifierOnly(RaceParser.ExpressionNumberIdentifierOnlyContext ctx) 
	{
		String identifier = ctx.IDENTIFIER().getText();
		intermediateCodeGenerator.addIntermediateOutput("SAVE REG " + identifier);
		if(ctx.SUB() != null)
		{
			intermediateCodeGenerator.addIntermediateOutput("UNARY REG");
		}
		return null; 
	}
	

	@Override 
	public Object visitExpressionNumberOnly(RaceParser.ExpressionNumberOnlyContext ctx) 
	{ 
		String value = ctx.DIGITS().getText();
		Double doubleValue = Double.parseDouble(value);
		if(ctx.SUB() != null) {
			doubleValue = -doubleValue;
		}
		intermediateCodeGenerator.addIntermediateOutput("SAVE REG "+ doubleValue);
		return null; 
	}
	

	@Override 
	public Object visitExpressionNumberFunctionCall(RaceParser.ExpressionNumberFunctionCallContext ctx) 
	{ 
		visit(ctx.func());
		return null; 
	}
	
	
	@Override 
	public Object visitCond_expressn(RaceParser.Cond_expressnContext ctx) 
	{ 
		intermediateCodeGenerator.addIntermediateOutput(RaceRuntimeConstant.CONDITION_START);
		visit(ctx.bool_expressn());
		intermediateCodeGenerator.addIntermediateOutput(RaceRuntimeConstant.CONDITION_END);
		return null; 
	}
	

	@Override 
	public Object visitInputParams(RaceParser.InputParamsContext ctx) 
	{ 
		return visitChildren(ctx); 
	}
	
	
	@Override 
	public Object visitInputArgs(RaceParser.InputArgsContext ctx) 
	{ 
		return visitChildren(ctx); 
	}
	

	@Override 
	public Object visitFuncStmt(RaceParser.FuncStmtContext ctx) 
	{ 
		List<String> parameters = new ArrayList<>();
		intermediateCodeGenerator.addIntermediateOutput(RaceRuntimeConstant.FUNCTION_START);
		intermediateCodeGenerator.addIntermediateOutput(RaceRuntimeConstant.FUNCTION_NAME + " " + ctx.IDENTIFIER().getText());
		//intermediateCodeGenerator.addIntermediateOutput(ctx.IDENTIFIER().getText());
		if(ctx.inputParams().IDENTIFIER() != null) {
			for(TerminalNode parameter: ctx.inputParams().IDENTIFIER()) {
				parameters.add(parameter.getText());
			}
		}
		intermediateCodeGenerator.addIntermediateOutput(RaceRuntimeConstant.FUNCTION_PARAMS + " " + StringUtils.join(parameters.toArray(), " "));
		//intermediateCodeGenerator.addIntermediateOutput(StringUtils.join(parameters.toArray(), " "));
		visit(ctx.body());
		intermediateCodeGenerator.addIntermediateOutput(RaceRuntimeConstant.FUNCTION_END);
		return null; 
	}
	

	@Override 
	public Object visitFunc(RaceParser.FuncContext ctx) 
	{
		String stmtIdentifier = ctx.IDENTIFIER().getText();

        if(ctx.inputArgs().bool_id_Dig() != null) {
            List<String> arguments = new ArrayList<>();
            for(RaceParser.Bool_id_DigContext boolIdContext : ctx.inputArgs().bool_id_Dig()) {
                arguments.add(boolIdContext.getText());
            }
            stmtIdentifier += " " + StringUtils.join(arguments.toArray(), " ");
        }

        intermediateCodeGenerator.addIntermediateOutput(RaceRuntimeConstant.FUNCTION_CALL + " " + stmtIdentifier);

		return null;
	}
	

	@Override 
	public Object visitReturnStmt(RaceParser.ReturnStmtContext ctx) 
	{ 
		intermediateCodeGenerator.addIntermediateOutput(RaceRuntimeConstant.FUNCTION_RETURN_START);
        if(ctx.bool_id_Dig() != null) {
            visit(ctx.bool_id_Dig());
        }
        else if(ctx.num_expressn() != null) {
            visit(ctx.num_expressn());
        }
        else if(ctx.bool_expressn() != null) {
            visit(ctx.bool_expressn());
        }
        else if(ctx.func() != null) {
            visit(ctx.func());
        }
        intermediateCodeGenerator.addIntermediateOutput(RaceRuntimeConstant.FUNCTION_RETURN_END);
		return null; 
	}
	

	@Override 
	public Object visitIfExpressn(RaceParser.IfExpressnContext ctx)
	{
		intermediateCodeGenerator.addIntermediateOutput(RaceRuntimeConstant.IF_ELSE_BLOCK_START);
		intermediateCodeGenerator.addIntermediateOutput(RaceRuntimeConstant.IF_BLOCK_START);
		visit(ctx.cond_expressn());
		visit(ctx.body());
		intermediateCodeGenerator.addIntermediateOutput(RaceRuntimeConstant.IF_BLOCK_END);
		for(int i=0; i <ctx.elseIfExpressn().size(); i++) {
			visit(ctx.elseIfExpressn(i));
		}
		if(ctx.elseExpressn() != null) {
			visit(ctx.elseExpressn());
		}
		intermediateCodeGenerator.addIntermediateOutput(RaceRuntimeConstant.IF_ELSE_BLOCK_END);
		return null; 
		
	}
	

	@Override 
	public Object visitElseIfExpressn(RaceParser.ElseIfExpressnContext ctx) 
	{ 
		intermediateCodeGenerator.addIntermediateOutput(RaceRuntimeConstant.ELSE_IF_BLOCK_START);
		visit(ctx.cond_expressn());
		visit(ctx.body());
		intermediateCodeGenerator.addIntermediateOutput(RaceRuntimeConstant.ELSE_IF_BLOCK_END);
		return null; 
	}
	

	@Override 
	public Object visitElseExpressn(RaceParser.ElseExpressnContext ctx) 
	{
		intermediateCodeGenerator.addIntermediateOutput(RaceRuntimeConstant.ELSE_BLOCK_START);
		visit(ctx.body());
		intermediateCodeGenerator.addIntermediateOutput(RaceRuntimeConstant.ELSE_BLOCK_END);
		return null; 
	}
	
	
	@Override 
	public Object visitWhileExpressn(RaceParser.WhileExpressnContext ctx) 
	{
		intermediateCodeGenerator.addIntermediateOutput(RaceRuntimeConstant.WHILE_BLOCK_START);
        visit(ctx.cond_expressn());
        visit(ctx.body());
        intermediateCodeGenerator.addIntermediateOutput(RaceRuntimeConstant.WHILE_BLOCK_END);
		return null; 
	}
	
	
	@Override 
	public Object visitForExpressn(RaceParser.ForExpressnContext ctx) 
	{
		visit(ctx.expression(0));
		intermediateCodeGenerator.addIntermediateOutput(RaceRuntimeConstant.FOR_LOOP_START);
		intermediateCodeGenerator.addIntermediateOutput(RaceRuntimeConstant.COMPARISION_START);
        visit(ctx.comp_expressn());
        intermediateCodeGenerator.addIntermediateOutput(RaceRuntimeConstant.COMPARISION_END);

        visit(ctx.body());
        visit(ctx.expression(1));
        intermediateCodeGenerator.addIntermediateOutput(RaceRuntimeConstant.FOR_LOOP_END);
		return null; 
	}
	

	@Override 
	public Object visitDisp(RaceParser.DispContext ctx) 
	{ 
		if(ctx.IDENTIFIER() != null) {
			intermediateCodeGenerator.addIntermediateOutput("DISPLAY " + ctx.IDENTIFIER().getText());
        }
        else if(ctx.DIGITS() != null) {
        	intermediateCodeGenerator.addIntermediateOutput("DISPLAY " + ctx.DIGITS().getText());            
        }
        else if(ctx.BOOLEAN() != null) {
        	intermediateCodeGenerator.addIntermediateOutput("DISPLAY " + ctx.BOOLEAN().getText());
        }
        else if(ctx.num_expressn() != null) {
            visit(ctx.num_expressn());
            intermediateCodeGenerator.addIntermediateOutput("DISPLAY REG");
        }
        else if(ctx.bool_expressn() != null) {
            visit(ctx.bool_expressn());
            intermediateCodeGenerator.addIntermediateOutput("DISPLAY REG");
        }
        else if(ctx.func() != null) {
            visit(ctx.func());
            intermediateCodeGenerator.addIntermediateOutput("DISPLAY REG");
        }
		return null; 
	}
	
	
	@Override 
	public Object visitBool_id_Dig(RaceParser.Bool_id_DigContext ctx) 
	{
		if(ctx.IDENTIFIER() != null) {
			intermediateCodeGenerator.addIntermediateOutput("SAVE REG " + ctx.IDENTIFIER().getText());
        }
        else if(ctx.DIGITS() != null) {
        	intermediateCodeGenerator.addIntermediateOutput("SAVE REG " + ctx.DIGITS().getText());
        }
        else if(ctx.BOOLEAN() != null) {
        	intermediateCodeGenerator.addIntermediateOutput("SAVE REG " + ctx.BOOLEAN().getText());
        }
        return null; 
	}
}
