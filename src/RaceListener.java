// Generated from Race.g4 by ANTLR 4.7.1
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
	 * Enter a parse tree produced by {@link RaceParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaration(RaceParser.VariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link RaceParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaration(RaceParser.VariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link RaceParser#varDeclarators}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclarators(RaceParser.VarDeclaratorsContext ctx);
	/**
	 * Exit a parse tree produced by {@link RaceParser#varDeclarators}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclarators(RaceParser.VarDeclaratorsContext ctx);
	/**
	 * Enter a parse tree produced by {@link RaceParser#varDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclarator(RaceParser.VarDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link RaceParser#varDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclarator(RaceParser.VarDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link RaceParser#varDecalaratorId}.
	 * @param ctx the parse tree
	 */
	void enterVarDecalaratorId(RaceParser.VarDecalaratorIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link RaceParser#varDecalaratorId}.
	 * @param ctx the parse tree
	 */
	void exitVarDecalaratorId(RaceParser.VarDecalaratorIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link RaceParser#varInit}.
	 * @param ctx the parse tree
	 */
	void enterVarInit(RaceParser.VarInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link RaceParser#varInit}.
	 * @param ctx the parse tree
	 */
	void exitVarInit(RaceParser.VarInitContext ctx);
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
	 * Enter a parse tree produced by {@link RaceParser#ifExpression}.
	 * @param ctx the parse tree
	 */
	void enterIfExpression(RaceParser.IfExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RaceParser#ifExpression}.
	 * @param ctx the parse tree
	 */
	void exitIfExpression(RaceParser.IfExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RaceParser#forControl}.
	 * @param ctx the parse tree
	 */
	void enterForControl(RaceParser.ForControlContext ctx);
	/**
	 * Exit a parse tree produced by {@link RaceParser#forControl}.
	 * @param ctx the parse tree
	 */
	void exitForControl(RaceParser.ForControlContext ctx);
	/**
	 * Enter a parse tree produced by {@link RaceParser#forInit}.
	 * @param ctx the parse tree
	 */
	void enterForInit(RaceParser.ForInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link RaceParser#forInit}.
	 * @param ctx the parse tree
	 */
	void exitForInit(RaceParser.ForInitContext ctx);
	/**
	 * Enter a parse tree produced by {@link RaceParser#expressionBody}.
	 * @param ctx the parse tree
	 */
	void enterExpressionBody(RaceParser.ExpressionBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link RaceParser#expressionBody}.
	 * @param ctx the parse tree
	 */
	void exitExpressionBody(RaceParser.ExpressionBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link RaceParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(RaceParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link RaceParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(RaceParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link RaceParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(RaceParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link RaceParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(RaceParser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link RaceParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(RaceParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link RaceParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(RaceParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link RaceParser#basicType}.
	 * @param ctx the parse tree
	 */
	void enterBasicType(RaceParser.BasicTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link RaceParser#basicType}.
	 * @param ctx the parse tree
	 */
	void exitBasicType(RaceParser.BasicTypeContext ctx);
}