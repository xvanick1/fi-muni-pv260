package cz.muni.fi.pv260.a03.t02.brainmethod;

import com.puppycrawl.tools.checkstyle.api.AbstractCheck;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import com.puppycrawl.tools.checkstyle.api.TokenTypes;


import javax.swing.*;
import java.util.List;

import static com.puppycrawl.tools.checkstyle.api.TokenTypes.*;

public class CyclomaticComplexityCheck extends AbstractCheck {

    private int max;
    private boolean methodActive;
    DetailAST method;
    private int complexity = 1;
    List<Integer> listOfComplexityTokens = List.of(LITERAL_IF,LITERAL_ELSE, LITERAL_CASE, LITERAL_DEFAULT,LITERAL_FOR,LITERAL_WHILE,LITERAL_BREAK,LITERAL_CONTINUE, LITERAL_CATCH,LITERAL_FINALLY,LITERAL_THROW,LITERAL_THROWS, QUESTION,COLON);
    //ActionListener actionListener = ActionListener.getActionListener();

    public void setMax(int aMax)
    {
        this.max = aMax;
    }

    @Override
    public int[] getDefaultTokens(){

        return new int[] {CTOR_DEF,METHOD_DEF,LITERAL_IF,LITERAL_ELSE, LITERAL_CASE, LITERAL_DEFAULT,LITERAL_FOR,LITERAL_WHILE,LITERAL_BREAK,LITERAL_CONTINUE, LITERAL_CATCH,LITERAL_FINALLY,LITERAL_THROW,LITERAL_THROWS, QUESTION,COLON};
    }

    @Override
    public int[] getAcceptableTokens() {
        return new int[] {CTOR_DEF,METHOD_DEF,LITERAL_IF,LITERAL_ELSE, LITERAL_CASE, LITERAL_DEFAULT,LITERAL_FOR,LITERAL_WHILE,LITERAL_BREAK,LITERAL_CONTINUE, LITERAL_CATCH,LITERAL_FINALLY,LITERAL_THROW,LITERAL_THROWS, QUESTION,COLON};
    }

    @Override
    public int[] getRequiredTokens() {
        return new int[] {};
    }

    @Override
    public void visitToken(DetailAST ast) {
        if(ast.getType() == CTOR_DEF || ast.getType() == METHOD_DEF){
            this.method = ast;
            this.complexity= 1 ;
            enterMethod();
        }
        if(methodActive){
            if(listOfComplexityTokens.contains(ast.getType())){
                complexity+=1;
            }
            if(complexity>max){
                logDetection(method);
                leaveMethod();
            }

        }
    }

    @Override
    public void leaveToken(DetailAST ast){

    }

    public void enterMethod(){
        methodActive =true;
    }

    public void leaveMethod(){
        methodActive =false;
    }

    private void logDetection(DetailAST ast){
        ActionListener.actionPerformed("cycloComplexCheck");
        //log(ast, "Method complexity is higher than max allowed value (" + max + "), current("+complexity+"):"+ ast);
    }
}