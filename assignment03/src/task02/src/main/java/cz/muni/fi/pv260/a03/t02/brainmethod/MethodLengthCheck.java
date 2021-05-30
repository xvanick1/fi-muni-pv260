package cz.muni.fi.pv260.a03.t02.brainmethod;

import com.puppycrawl.tools.checkstyle.api.AbstractCheck;
import com.puppycrawl.tools.checkstyle.api.DetailAST;


import static com.puppycrawl.tools.checkstyle.api.TokenTypes.*;

public class MethodLengthCheck extends AbstractCheck {

    private final int maxLOC;
    private boolean methodActive;
    DetailAST method;
    private int lineOfCode;

    public MethodLengthCheck(){
        System.out.println("SMTH1");
        //this.maxLOC = maxLoc;
        this.maxLOC = 5;
    }

    @Override
    public int[] getDefaultTokens(){
        System.out.println("SMTH1");
        return new int[] {CTOR_DEF,SLIST};
    }

    @Override
    public int[] getAcceptableTokens() {
        return new int[] {CTOR_DEF,SLIST};
    }

    @Override
    public int[] getRequiredTokens() {
        return new int[] {CTOR_DEF};
    }

    @Override
    public void visitToken(DetailAST ast) {
        System.out.println("SMTH");
        if(ast.getType() == CTOR_DEF){
            this.method = ast;
            enterMethod();
            this.lineOfCode = ast.getLineNo();
            System.out.println(lineOfCode);
        }
        if(methodActive){
            System.out.println("Active");
            if(ast.getType()==SLIST){
                if(ast.getLineNo()-this.lineOfCode > maxLOC){
                    logDetection(method);
                }
            }
            leaveMethod();
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
        log(ast, "Method exceeds allowed number of lines" + ast);
    }
}