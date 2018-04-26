// Generated from ./race/grammer/Race.g4 by ANTLR 4.7.1
package main.race;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link RaceParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface RaceVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link RaceParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(RaceParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link RaceParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody(RaceParser.BodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link RaceParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(RaceParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignmentInteger}
	 * labeled alternative in {@link RaceParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentInteger(RaceParser.AssignmentIntegerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignmentBoolean}
	 * labeled alternative in {@link RaceParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentBoolean(RaceParser.AssignmentBooleanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignmentIncrementOrDecrement}
	 * labeled alternative in {@link RaceParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentIncrementOrDecrement(RaceParser.AssignmentIncrementOrDecrementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignmentShortHand}
	 * labeled alternative in {@link RaceParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentShortHand(RaceParser.AssignmentShortHandContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expressionBooleanParentheses}
	 * labeled alternative in {@link RaceParser#bool_expressn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionBooleanParentheses(RaceParser.ExpressionBooleanParenthesesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expressionBoolean}
	 * labeled alternative in {@link RaceParser#bool_expressn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionBoolean(RaceParser.ExpressionBooleanContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expressionBooleanComparison}
	 * labeled alternative in {@link RaceParser#bool_expressn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionBooleanComparison(RaceParser.ExpressionBooleanComparisonContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expressionBooleanConnector}
	 * labeled alternative in {@link RaceParser#bool_expressn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionBooleanConnector(RaceParser.ExpressionBooleanConnectorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expressionBooleanFunctionCall}
	 * labeled alternative in {@link RaceParser#bool_expressn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionBooleanFunctionCall(RaceParser.ExpressionBooleanFunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expressionBooleanIdentifierOnly}
	 * labeled alternative in {@link RaceParser#bool_expressn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionBooleanIdentifierOnly(RaceParser.ExpressionBooleanIdentifierOnlyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expressionBooleanOnly}
	 * labeled alternative in {@link RaceParser#bool_expressn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionBooleanOnly(RaceParser.ExpressionBooleanOnlyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expressionNumberComparison}
	 * labeled alternative in {@link RaceParser#comp_expressn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionNumberComparison(RaceParser.ExpressionNumberComparisonContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expressionNumberParentheses}
	 * labeled alternative in {@link RaceParser#num_expressn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionNumberParentheses(RaceParser.ExpressionNumberParenthesesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expressionNumberPlusMinus}
	 * labeled alternative in {@link RaceParser#num_expressn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionNumberPlusMinus(RaceParser.ExpressionNumberPlusMinusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expressionNumberMultiplyDivide}
	 * labeled alternative in {@link RaceParser#num_expressn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionNumberMultiplyDivide(RaceParser.ExpressionNumberMultiplyDivideContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expressionNumberIdentifierOnly}
	 * labeled alternative in {@link RaceParser#num_expressn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionNumberIdentifierOnly(RaceParser.ExpressionNumberIdentifierOnlyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expressionNumberOnly}
	 * labeled alternative in {@link RaceParser#num_expressn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionNumberOnly(RaceParser.ExpressionNumberOnlyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expressionNumberFunctionCall}
	 * labeled alternative in {@link RaceParser#num_expressn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionNumberFunctionCall(RaceParser.ExpressionNumberFunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link RaceParser#cond_expressn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCond_expressn(RaceParser.Cond_expressnContext ctx);
	/**
	 * Visit a parse tree produced by {@link RaceParser#inputParams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInputParams(RaceParser.InputParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link RaceParser#inputArgs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInputArgs(RaceParser.InputArgsContext ctx);
	/**
	 * Visit a parse tree produced by {@link RaceParser#funcStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncStmt(RaceParser.FuncStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link RaceParser#func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc(RaceParser.FuncContext ctx);
	/**
	 * Visit a parse tree produced by {@link RaceParser#returnStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStmt(RaceParser.ReturnStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link RaceParser#ifExpressn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfExpressn(RaceParser.IfExpressnContext ctx);
	/**
	 * Visit a parse tree produced by {@link RaceParser#elseIfExpressn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseIfExpressn(RaceParser.ElseIfExpressnContext ctx);
	/**
	 * Visit a parse tree produced by {@link RaceParser#elseExpressn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseExpressn(RaceParser.ElseExpressnContext ctx);
	/**
	 * Visit a parse tree produced by {@link RaceParser#whileExpressn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileExpressn(RaceParser.WhileExpressnContext ctx);
	/**
	 * Visit a parse tree produced by {@link RaceParser#forExpressn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForExpressn(RaceParser.ForExpressnContext ctx);
	/**
	 * Visit a parse tree produced by {@link RaceParser#disp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDisp(RaceParser.DispContext ctx);
	/**
	 * Visit a parse tree produced by {@link RaceParser#bool_id_Dig}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool_id_Dig(RaceParser.Bool_id_DigContext ctx);
}