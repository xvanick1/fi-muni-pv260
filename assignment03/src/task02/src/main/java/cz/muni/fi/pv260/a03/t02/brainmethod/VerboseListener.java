package cz.muni.fi.pv260.a03.t02.brainmethod;

import com.puppycrawl.tools.checkstyle.api.*;


public class VerboseListener
        extends AutomaticBean
        implements AuditListener {
    private boolean lengthCheck=false, depthNestCheck=false, variablesCountCheck=false, cycloComplexCheck=false;


    @Override
    public void auditStarted(AuditEvent event) {
    }

    @Override
    public void auditFinished(AuditEvent event) {
        if(cycloComplexCheck && lengthCheck && depthNestCheck && variablesCountCheck){
            System.out.println("Brain Method detected");
        }
    }

    @Override
    public void fileStarted(AuditEvent event) {
    }

    @Override
    public void fileFinished(AuditEvent event) {

    }

    public void addError(AuditEvent aEvt) {

        switch(aEvt.getMessage()){
            case "cycloComplexCheck":
                cycloComplexCheck=true;
                break;
            case "lengthCheck":
                lengthCheck=true;
                break;
            case "depthNestCheck":
                depthNestCheck=true;
                break;
            case "variablesCountCheck":
                variablesCountCheck=true;
                break;
        }



    }

    public void addException(AuditEvent aEvt, Throwable aThrowable) {
    }

    @Override
    protected void finishLocalSetup() {

    }
}