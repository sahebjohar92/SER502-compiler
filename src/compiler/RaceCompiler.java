package compiler;


import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import main.race.RaceBaseListener;
import main.race.RaceParser.*;

import utilities.StorageTable;

import java.lang.*;
import java.util.Stack;

public class RaceCompiler extends RaceBaseListener{
	
	StorageTable storageTable = new StorageTable();
	Stack<String> expressionStack = new Stack<>(); 
	private String output = "";
	
	@Override
    public void enterProgram(ProgramContext ctx) {

    }

    @Override
    public void exitProgram(ProgramContext ctx) {

    }

    @Override
    public void enterBody(BodyContext ctx) {
    	
    }

    @Override
    public void exitBody(BodyContext ctx) {

    }

    @Override
    public void enterVariableDeclaration(VariableDeclarationContext ctx) {
    	
    }

    @Override
    public void exitVariableDeclaration(VariableDeclarationContext ctx) {

    }

    @Override
    public void enterVarDeclarators(VarDeclaratorsContext ctx) {

    }

    @Override
    public void exitVarDeclarators(VarDeclaratorsContext ctx) {

    }

    @Override
    public void enterVarDeclarator(VarDeclaratorContext ctx) {

    }

    @Override
    public void exitVarDeclarator(VarDeclaratorContext ctx) {

    }

    @Override
    public void enterVarDecalaratorId(VarDecalaratorIdContext ctx) {

    }

    @Override
    public void exitVarDecalaratorId(VarDecalaratorIdContext ctx) {

    }

    @Override
    public void enterVarInit(VarInitContext ctx) {

    }

    @Override
    public void exitVarInit(VarInitContext ctx) {

    }

    @Override
    public void enterStatement(StatementContext ctx) {

    }

    @Override
    public void exitStatement(StatementContext ctx) {

    }

    @Override
    public void enterIfExpression(IfExpressionContext ctx) {

    }

    @Override
    public void exitIfExpression(IfExpressionContext ctx) {

    }

    @Override
    public void enterForControl(ForControlContext ctx) {

    }

    @Override
    public void exitForControl(ForControlContext ctx) {

    }

    @Override
    public void enterForInit(ForInitContext ctx) {

    }

    @Override
    public void exitForInit(ForInitContext ctx) {

    }

    @Override
    public void enterExpressionBody(ExpressionBodyContext ctx) {

    }

    @Override
    public void exitExpressionBody(ExpressionBodyContext ctx) {

    }

    @Override
    public void enterPrimary(PrimaryContext ctx) {

    }

    @Override
    public void exitPrimary(PrimaryContext ctx) {

    }

    @Override
    public void enterExpression(ExpressionContext ctx) {

    }

    @Override
    public void exitExpression(ExpressionContext ctx) {

    }

    @Override
    public void enterType(TypeContext ctx) {

    }

    @Override
    public void exitType(TypeContext ctx) {

    }

    @Override
    public void enterBasicType(BasicTypeContext ctx) {

    }

    @Override
    public void exitBasicType(BasicTypeContext ctx) {

    }
}
