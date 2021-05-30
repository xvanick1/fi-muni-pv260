package cz.muni.fi.pv260.a03.t02.brainmethod.checks;

import com.puppycrawl.tools.checkstyle.api.AbstractCheck;
import com.puppycrawl.tools.checkstyle.api.DetailAST;
import cz.muni.fi.pv260.a03.t02.brainmethod.ActionListener;

import java.util.HashSet;

import static com.puppycrawl.tools.checkstyle.api.TokenTypes.*;


/**
 * Module which checks if number of different variables used in method does not cross threshold
 */
public class VariablesCountCheck extends AbstractCheck {

    DetailAST method;
    HashSet<String> variablesInMethod = new HashSet<>();
    private int max;
    private boolean methodActive;
    // ActionListener actionListener = ActionListener.getActionListener();

    public void setMax(int aMax) {
        this.max = aMax;
    }

    @Override
    public int[] getDefaultTokens() {

        return new int[]{CTOR_DEF, IDENT, METHOD_DEF};
    }

    @Override
    public int[] getAcceptableTokens() {
        return new int[]{CTOR_DEF, IDENT, METHOD_DEF};
    }

    @Override
    public int[] getRequiredTokens() {
        return new int[]{CTOR_DEF};
    }

    @Override
    public void visitToken(DetailAST ast) {
        if (ast.getType() == CTOR_DEF || ast.getType() == METHOD_DEF) {
            this.method = ast;
            enterMethod();
            variablesInMethod.clear();
        }
        if (methodActive) {
            if (ast.getType() == IDENT) {
                variablesInMethod.add(ast.getText());
            }
            if (variablesInMethod.size() > max) {
                logDetection(method);
                leaveMethod();
            }
        }
    }

    @Override
    public void leaveToken(DetailAST ast) {
    }

    public void enterMethod() {
        methodActive = true;
    }

    public void leaveMethod() {
        methodActive = false;
    }

    private void logDetection(DetailAST ast) {
        ActionListener.actionPerformed("variablesCountCheck");
        //log(ast, "Number of variables used in method is higher than max allowed value (" + max + "), current(" + variablesInMethod.size() + "):" + ast);
    }
}