
import com.puppycrawl.tools.checkstyle.api.AbstractCheck;
import com.puppycrawl.tools.checkstyle.api.DetailAST;

import static com.puppycrawl.tools.checkstyle.api.TokenTypes.*;

public class NegativeForIterator extends AbstractCheck {

    private boolean forIteratorActive;
    private boolean plusIterator;
    private boolean assignExpresion;

    @Override
    public int[] getDefaultTokens(){
        return new int[] {FOR_ITERATOR, MINUS_ASSIGN};
    }

    @Override
    public int[] getAcceptableTokens() {
        return new int[] {FOR_ITERATOR, MINUS_ASSIGN};
    }

    @Override
    public int[] getRequiredTokens() {
        return new int[] {FOR_ITERATOR};
    }

    @Override
    public void visitToken(DetailAST ast) {
        if(ast.getType() == FOR_ITERATOR){
            enterForIterator();
        }
        else if(forIteratorActive){
            switch(ast.getType()){
                case MINUS_ASSIGN:
                case POST_DEC:
                case DEC:
                    logDetection(ast);
                    break;
                case PLUS_ASSIGN:
                    enterPlusIterator();
                    break;
                case ASSIGN:
                    enterAssignExpresion();
            }
        }
        else if(plusIterator){
            if(ast.getType()!=IDENT && ast.getType()!=UNARY_MINUS)
                leavePlusIterator();
            else if(ast.getType()==UNARY_MINUS) {
                logDetection(ast);
            }
        }
        else if(assignExpresion){
            if(ast.getType()!=IDENT && ast.getType()!=MINUS)
                leaveAssignExpresion();
            else if(ast.getType()==MINUS) {
                logDetection(ast);
            }
        }

    }

    private void enterAssignExpresion() {
        assignExpresion=true;
    }

    private void leaveAssignExpresion() {
        assignExpresion=false;
    }

    private void enterPlusIterator() {
        plusIterator=true;
    }

    private void leavePlusIterator() {
        plusIterator=false;
    }


    @Override
    public void leaveToken(DetailAST ast){
        if(ast.getType() == FOR_ITERATOR)
            leaveForIterator();
    }

    public void enterForIterator(){
        forIteratorActive=true;
    }

    public void leaveForIterator(){
        forIteratorActive=false;
    }

    private void logDetection(DetailAST ast){
        log(ast, "Negative iterator in for: " + ast);
    }
}