// Generated from ./race/grammer/Race.g4 by ANTLR 4.7.1
package main.race;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link RaceParser}.
 */
public interface RaceListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link RaceParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(RaceParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link RaceParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(RaceParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link RaceParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(RaceParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link RaceParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(RaceParser.BodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link RaceParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(RaceParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link RaceParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(RaceParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignmentInteger}
	 * labeled alternative in {@link RaceParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentInteger(RaceParser.AssignmentIntegerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignmentInteger}
	 * labeled alternative in {@link RaceParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentInteger(RaceParser.AssignmentIntegerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignmentBoolean}
	 * labeled alternative in {@link RaceParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentBoolean(RaceParser.AssignmentBooleanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignmentBoolean}
	 * labeled alternative in {@link RaceParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentBoolean(RaceParser.AssignmentBooleanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignmentIncrementOrDecrement}
	 * labeled alternative in {@link RaceParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentIncrementOrDecrement(RaceParser.AssignmentIncrementOrDecrementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignmentIncrementOrDecrement}
	 * labeled alternative in {@link RaceParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentIncrementOrDecrement(RaceParser.AssignmentIncrementOrDecrementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignmentShortHand}
	 * labeled alternative in {@link RaceParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentShortHand(RaceParser.AssignmentShortHandContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignmentShortHand}
	 * labeled alternative in {@link RaceParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentShortHand(RaceParser.AssignmentShortHandContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressionBooleanParentheses}
	 * labeled alternative in {@link RaceParser#bool_expressn}.
	 * @param ctx the parse tree
	 */
	void enterExpressionBooleanParentheses(RaceParser.ExpressionBooleanParenthesesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressionBooleanParentheses}
	 * labeled alternative in {@link RaceParser#bool_expressn}.
	 * @param ctx the parse tree
	 */
	void exitExpressionBooleanParentheses(RaceParser.ExpressionBooleanParenthesesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressionBoolean}
	 * labeled alternative in {@link RaceParser#bool_expressn}.
	 * @param ctx the parse tree
	 */
	void enterExpressionBoolean(RaceParser.ExpressionBooleanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressionBoolean}
	 * labeled alternative in {@link RaceParser#bool_expressn}.
	 * @param ctx the parse tree
	 */
	void exitExpressionBoolean(RaceParser.ExpressionBooleanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressionBooleanComparison}
	 * labeled alternative in {@link RaceParser#bool_expressn}.
	 * @param ctx the parse tree
	 */
	void enterExpressionBooleanComparison(RaceParser.ExpressionBooleanComparisonContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressionBooleanComparison}
	 * labeled alternative in {@link RaceParser#bool_expressn}.
	 * @param ctx the parse tree
	 */
	void exitExpressionBooleanComparison(RaceParser.ExpressionBooleanComparisonContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressionBooleanConnector}
	 * labeled alternative in {@link RaceParser#bool_expressn}.
	 * @param ctx the parse tree
	 */
	void enterExpressionBooleanConnector(RaceParser.ExpressionBooleanConnectorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressionBooleanConnector}
	 * labeled alternative in {@link RaceParser#bool_expressn}.
	 * @param ctx the parse tree
	 */
	void exitExpressionBooleanConnector(RaceParser.ExpressionBooleanConnectorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressionBooleanFunctionCall}
	 * labeled alternative in {@link RaceParser#bool_expressn}.
	 * @param ctx the parse tree
	 */
	void enterExpressionBooleanFunctionCall(RaceParser.ExpressionBooleanFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressionBooleanFunctionCall}
	 * labeled alternative in {@link RaceParser#bool_expressn}.
	 * @param ctx the parse tree
	 */
	void exitExpressionBooleanFunctionCall(RaceParser.ExpressionBooleanFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressionBooleanIdentifierOnly}
	 * labeled alternative in {@link RaceParser#bool_expressn}.
	 * @param ctx the parse tree
	 */
	void enterExpressionBooleanIdentifierOnly(RaceParser.ExpressionBooleanIdentifierOnlyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressionBooleanIdentifierOnly}
	 * labeled alternative in {@link RaceParser#bool_expressn}.
	 * @param ctx the parse tree
	 */
	void exitExpressionBooleanIdentifierOnly(RaceParser.ExpressionBooleanIdentifierOnlyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressionBooleanOnly}
	 * labeled alternative in {@link RaceParser#bool_expressn}.
	 * @param ctx the parse tree
	 */
	void enterExpressionBooleanOnly(RaceParser.ExpressionBooleanOnlyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressionBooleanOnly}
	 * labeled alternative in {@link RaceParser#bool_expressn}.
	 * @param ctx the parse tree
	 */
	void exitExpressionBooleanOnly(RaceParser.ExpressionBooleanOnlyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressionNumberComparison}
	 * labeled alternative in {@link RaceParser#comp_expressn}.
	 * @param ctx the parse tree
	 */
	void enterExpressionNumberComparison(RaceParser.ExpressionNumberComparisonContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressionNumberComparison}
	 * labeled alternative in {@link RaceParser#comp_expressn}.
	 * @param ctx the parse tree
	 */
	void exitExpressionNumberComparison(RaceParser.ExpressionNumberComparisonContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressionNumberParentheses}
	 * labeled alternative in {@link RaceParser#num_expressn}.
	 * @param ctx the parse tree
	 */
	void enterExpressionNumberParentheses(RaceParser.ExpressionNumberParenthesesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressionNumberParentheses}
	 * labeled alternative in {@link RaceParser#num_expressn}.
	 * @param ctx the parse tree
	 */
	void exitExpressionNumberParentheses(RaceParser.ExpressionNumberParenthesesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressionNumberPlusMinus}
	 * labeled alternative in {@link RaceParser#num_expressn}.
	 * @param ctx the parse tree
	 */
	void enterExpressionNumberPlusMinus(RaceParser.ExpressionNumberPlusMinusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressionNumberPlusMinus}
	 * labeled alternative in {@link RaceParser#num_expressn}.
	 * @param ctx the parse tree
	 */
	void exitExpressionNumberPlusMinus(RaceParser.ExpressionNumberPlusMinusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressionNumberMultiplyDivide}
	 * labeled alternative in {@link RaceParser#num_expressn}.
	 * @param ctx the parse tree
	 */
	void enterExpressionNumberMultiplyDivide(RaceParser.ExpressionNumberMultiplyDivideContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressionNumberMultiplyDivide}
	 * labeled alternative in {@link RaceParser#num_expressn}.
	 * @param ctx the parse tree
	 */
	void exitExpressionNumberMultiplyDivide(RaceParser.ExpressionNumberMultiplyDivideContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressionNumberIdentifierOnly}
	 * labeled alternative in {@link RaceParser#num_expressn}.
	 * @param ctx the parse tree
	 */
	void enterExpressionNumberIdentifierOnly(RaceParser.ExpressionNumberIdentifierOnlyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressionNumberIdentifierOnly}
	 * labeled alternative in {@link RaceParser#num_expressn}.
	 * @param ctx the parse tree
	 */
	void exitExpressionNumberIdentifierOnly(RaceParser.ExpressionNumberIdentifierOnlyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressionNumberOnly}
	 * labeled alternative in {@link RaceParser#num_expressn}.
	 * @param ctx the parse tree
	 */
	void enterExpressionNumberOnly(RaceParser.ExpressionNumberOnlyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressionNumberOnly}
	 * labeled alternative in {@link RaceParser#num_expressn}.
	 * @param ctx the parse tree
	 */
	void exitExpressionNumberOnly(RaceParser.ExpressionNumberOnlyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressionNumberFunctionCall}
	 * labeled alternative in {@link RaceParser#num_expressn}.
	 * @param ctx the parse tree
	 */
	void enterExpressionNumberFunctionCall(RaceParser.ExpressionNumberFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressionNumberFunctionCall}
	 * labeled alternative in {@link RaceParser#num_expressn}.
	 * @param ctx the parse tree
	 */
	void exitExpressionNumberFunctionCall(RaceParser.ExpressionNumberFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link RaceParser#cond_expressn}.
	 * @param ctx the parse tree
	 */
	void enterCond_expressn(RaceParser.Cond_expressnContext ctx);
	/**
	 * Exit a parse tree produced by {@link RaceParser#cond_expressn}.
	 * @param ctx the parse tree
	 */
	void exitCond_expressn(RaceParser.Cond_expressnContext ctx);
	/**
	 * Enter a parse tree produced by {@link RaceParser#inputParams}.
	 * @param ctx the parse tree
	 */
	void enterInputParams(RaceParser.InputParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link RaceParser#inputParams}.
	 * @param ctx the parse tree
	 */
	void exitInputParams(RaceParser.InputParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link RaceParser#inputArgs}.
	 * @param ctx the parse tree
	 */
	void enterInputArgs(RaceParser.InputArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link RaceParser#inputArgs}.
	 * @param ctx the parse tree
	 */
	void exitInputArgs(RaceParser.InputArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link RaceParser#funcStmt}.
	 * @param ctx the parse tree
	 */
	void enterFuncStmt(RaceParser.FuncStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link RaceParser#funcStmt}.
	 * @param ctx the parse tree
	 */
	void exitFuncStmt(RaceParser.FuncStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link RaceParser#func}.
	 * @param ctx the parse tree
	 */
	void enterFunc(RaceParser.FuncContext ctx);
	/**
	 * Exit a parse tree produced by {@link RaceParser#func}.
	 * @param ctx the parse tree
	 */
	void exitFunc(RaceParser.FuncContext ctx);
	/**
	 * Enter a parse tree produced by {@link RaceParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void enterReturnStmt(RaceParser.ReturnStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link RaceParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void exitReturnStmt(RaceParser.ReturnStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link RaceParser#ifExpressn}.
	 * @param ctx the parse tree
	 */
	void enterIfExpressn(RaceParser.IfExpressnContext ctx);
	/**
	 * Exit a parse tree produced by {@link RaceParser#ifExpressn}.
	 * @param ctx the parse tree
	 */
	void exitIfExpressn(RaceParser.IfExpressnContext ctx);
	/**
	 * Enter a parse tree produced by {@link RaceParser#elseIfExpressn}.
	 * @param ctx the parse tree
	 */
	void enterElseIfExpressn(RaceParser.ElseIfExpressnContext ctx);
	/**
	 * Exit a parse tree produced by {@link RaceParser#elseIfExpressn}.
	 * @param ctx the parse tree
	 */
	void exitElseIfExpressn(RaceParser.ElseIfExpressnContext ctx);
	/**
	 * Enter a parse tree produced by {@link RaceParser#elseExpressn}.
	 * @param ctx the parse tree
	 */
	void enterElseExpressn(RaceParser.ElseExpressnContext ctx);
	/**
	 * Exit a parse tree produced by {@link RaceParser#elseExpressn}.
	 * @param ctx the parse tree
	 */
	void exitElseExpressn(RaceParser.ElseExpressnContext ctx);
	/**
	 * Enter a parse tree produced by {@link RaceParser#whileExpressn}.
	 * @param ctx the parse tree
	 */
	void enterWhileExpressn(RaceParser.WhileExpressnContext ctx);
	/**
	 * Exit a parse tree produced by {@link RaceParser#whileExpressn}.
	 * @param ctx the parse tree
	 */
	void exitWhileExpressn(RaceParser.WhileExpressnContext ctx);
	/**
	 * Enter a parse tree produced by {@link RaceParser#forExpressn}.
	 * @param ctx the parse tree
	 */
	void enterForExpressn(RaceParser.ForExpressnContext ctx);
	/**
	 * Exit a parse tree produced by {@link RaceParser#forExpressn}.
	 * @param ctx the parse tree
	 */
	void exitForExpressn(RaceParser.ForExpressnContext ctx);
	/**
	 * Enter a parse tree produced by {@link RaceParser#disp}.
	 * @param ctx the parse tree
	 */
	void enterDisp(RaceParser.DispContext ctx);
	/**
	 * Exit a parse tree produced by {@link RaceParser#disp}.
	 * @param ctx the parse tree
	 */
	void exitDisp(RaceParser.DispContext ctx);
	/**
	 * Enter a parse tree produced by {@link RaceParser#bool_id_Dig}.
	 * @param ctx the parse tree
	 */
	void enterBool_id_Dig(RaceParser.Bool_id_DigContext ctx);
	/**
	 * Exit a parse tree produced by {@link RaceParser#bool_id_Dig}.
	 * @param ctx the parse tree
	 */
	void exitBool_id_Dig(RaceParser.Bool_id_DigContext ctx);
}