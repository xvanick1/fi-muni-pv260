
import com.puppycrawl.tools.checkstyle.api.AbstractCheck;
import com.puppycrawl.tools.checkstyle.api.DetailAST;

import static com.puppycrawl.tools.checkstyle.api.TokenTypes.*;

public class AlwaysFalseConstraintForCheck extends AbstractCheck {

    private boolean forStatement;
    private boolean forInit;
    private boolean forCondition;
    private boolean forIterator;

    private boolean incrementGoesUp;

    private DetailAST forLiteral;
    private String condition;

    @Override
    public int[] getDefaultTokens(){

        return new int[] {FOR_INIT,FOR_CONDITION,EXPR,ASSIGN,LITERAL_FOR,FOR_ITERATOR};
    }

    @Override
    public int[] getAcceptableTokens() {
        return new int[] {FOR_INIT,FOR_CONDITION,EXPR,ASSIGN,LITERAL_FOR,FOR_ITERATOR};
    }

    @Override
    public int[] getRequiredTokens() {
        return new int[] {FOR_INIT,FOR_CONDITION};
    }

    @Override
    public void visitToken(DetailAST ast) {
        if(ast.getType()==LITERAL_FOR){
            saveAST(ast);
            enterFor();
        }

        else if(ast.getType() == FOR_INIT){
            enterForInit();
        }

        else if(ast.getType()==FOR_CONDITION){
            enterForCondition();
        }

        else if( ast.getType() == FOR_ITERATOR){
            enterForIterator();
        }

        else if(forInit && forStatement){
            if(ast.getType()==EXPR){
                if(ast.getChildCount()==1){
                    condition= ast.getFirstChild().getText();
                }
            leaveForInit();
            }
        }
        else if(forCondition && forStatement){
            if(ast.getType()==EXPR){
                condition+=ast.getFirstChild().getText();
                if(ast.getFirstChild().getChildCount()==2){
                    condition+=ast.getFirstChild().getLastChild().getText();
                }
                leaveForCondition();
            }
        }
        else if(forIterator && forStatement){
            boolean conditionAndInitConflict= (boolean) ExpresionEvaluator.eval(condition);
            if(ast.branchContains(MINUS) || ast.branchContains(MINUS_ASSIGN) || ast.branchContains(DEC) || ast.branchContains(POST_DEC) || ast.branchContains(UNARY_MINUS)){
                incrementGoesUp=false;
                if(conditionAndInitConflict==true){
                    logDetection();
                }
            }
            else{
                if(conditionAndInitConflict==false){
                    logDetection();
                }
            }

        }
    }

    private void enterForCondition() {
        this.forCondition=true;
    }

    private void leaveForCondition() {
        forCondition =false;
    }

    private void enterForInit() {
        forInit =true;
    }

    private void leaveForInit() {
        forInit =false;
    }

    private void enterForIterator() {
        forIterator =true;
    }

    private void leaveForIterator() {
        forIterator =false;
    }

    private void enterFor() {
        forStatement =true;
    }

    private void leaveFor() {
        forStatement =false;
    }

    private void saveAST(DetailAST ast) {
        this.forLiteral = ast;
    }

    @Override
    public void leaveToken(DetailAST ast){
        if(ast.getType() == FOR_ITERATOR){
            leaveFor();
            leaveForInit();
            leaveForCondition();
            leaveForIterator();
        }
        if(ast.getType()==FOR_INIT){
            leaveForInit();
        }
        if(ast.getType()==FOR_CONDITION){
            leaveForCondition();
        }
        if(ast.getType()==FOR_ITERATOR){
            leaveForIterator();
        }
    }

    private void logDetection(){
        log(this.forLiteral, "Always false condition in for: " + this.forLiteral);
    }
}