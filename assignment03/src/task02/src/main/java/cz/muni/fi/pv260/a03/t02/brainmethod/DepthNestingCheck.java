
package cz.muni.fi.pv260.a03.t02.brainmethod;

import com.puppycrawl.tools.checkstyle.api.AbstractCheck;
import com.puppycrawl.tools.checkstyle.api.DetailAST;

import java.util.List;

import static com.puppycrawl.tools.checkstyle.api.TokenTypes.*;

public class DepthNestingCheck extends AbstractCheck {

    private int max;
    private boolean methodActive;
    DetailAST method;
    private int nestingLevel;
    List<Integer> listOfNestingTokens = List.of(LITERAL_FOR,LITERAL_WHILE,LITERAL_TRY,LITERAL_IF);
    //ActionListener actionListener = ActionListener.getActionListener();

    public void setMax(int aMax)
    {
        this.max = aMax;
    }

    @Override
    public int[] getDefaultTokens(){

        return new int[] {CTOR_DEF,METHOD_DEF,LITERAL_FOR,LITERAL_WHILE,LITERAL_TRY,LITERAL_IF};
    }

    @Override
    public int[] getAcceptableTokens() {
        return new int[] {CTOR_DEF,METHOD_DEF,LITERAL_FOR,LITERAL_WHILE,LITERAL_TRY,LITERAL_IF};
    }

    @Override
    public int[] getRequiredTokens() {
        return new int[] {CTOR_DEF};
    }

    @Override
    public void visitToken(DetailAST ast) {
        if(ast.getType() == CTOR_DEF || ast.getType() == METHOD_DEF){
            this.method = ast;
            enterMethod();
            nestingLevel=0;
        }
        if(methodActive){
            if(listOfNestingTokens.contains(ast.getType())){
                nestingLevel +=1;
                if(nestingLevel > max){
                    logDetection(method);
                }
            }

        }
    }

    @Override
    public void leaveToken(DetailAST ast){
        if(listOfNestingTokens.contains(ast.getType()))
            nestingLevel-=1;
    }

    public void enterMethod(){
        methodActive =true;
    }


    private void logDetection(DetailAST ast){
        ActionListener.actionPerformed("depthNestCheck");
        //log(ast, "Method exceeds allowed number of nesting (" + max + "), current("+nestingLevel+"):"+ ast);
    }
}