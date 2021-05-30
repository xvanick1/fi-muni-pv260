package cz.muni.fi.pv260.a03.t02.brainmethod;

import java.awt.event.ActionEvent;

public class ActionListener  {

    private static boolean cycloComplexCheck;
    private static boolean lengthCheck;
    private static boolean depthNestCheck;
    private static boolean variablesCountCheck;


    public static void actionPerformed(String message) {

        switch(message){
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
        if(cycloComplexCheck && lengthCheck && depthNestCheck && variablesCountCheck)
            System.out.println("Brain Method detected");
    }
}
