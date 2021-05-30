package cz.muni.fi.pv260.a03.t02.brainmethod.checks;

import com.puppycrawl.tools.checkstyle.api.AbstractCheck;
import com.puppycrawl.tools.checkstyle.api.DetailAST;

import static com.puppycrawl.tools.checkstyle.api.TokenTypes.*;

public class MethodLengthCheck extends AbstractCheck {

    private int max;
    private boolean methodActive;
    DetailAST method;
    private int lineOfCode;

    public void setMax(int aMax)
    {
        this.max = aMax;
    }

    @Override
    public int[] getDefaultTokens(){

        return new int[] {CTOR_DEF,SLIST,METHOD_DEF};
    }

    @Override
    public int[] getAcceptableTokens() {
        return new int[] {CTOR_DEF,SLIST,METHOD_DEF};
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
            this.lineOfCode = ast.getLineNo();
        }
        if(methodActive){
            if(ast.getType()==SLIST){
                 if(ast.getLastChild().getLineNo()-this.lineOfCode - 2 > max){
                    logDetection(method,ast.getLastChild().getLineNo()-this.lineOfCode - 1);
                }
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

    private void logDetection(DetailAST ast,int loc){
        log(ast, "Method exceeds allowed number of lines (" + max + "), current("+loc+"):"+ ast);
    }
}