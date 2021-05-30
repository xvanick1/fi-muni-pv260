package cz.muni.fi.pv260.a03.t02.brainmethod;

/**
 * Simple listener for checking if all checks are fulfilled at once
 */
public class ActionListener {

    private static boolean cycloComplexCheck;
    private static boolean lengthCheck;
    private static boolean depthNestCheck;
    private static boolean variablesCountCheck;


    /**
     * Takes care about messages
     *
     * @param message message from check module
     */
    public static void actionPerformed(String message) {

        handleMessage(message);
        validateAndPrint();
    }

    /**
     * Checks if all checks ended with positive finding, and if so prints to output message
     */
    private static void validateAndPrint() {
        if (cycloComplexCheck && lengthCheck && depthNestCheck && variablesCountCheck)
            System.out.println("Brain Method detected");
    }

    /**
     * StateManager for handling the message
     *
     * @param message Message from check modules
     */
    private static void handleMessage(String message) {
        switch (message) {
            case "cycloComplexCheck":
                cycloComplexCheck = true;
                break;
            case "lengthCheck":
                lengthCheck = true;
                break;
            case "depthNestCheck":
                depthNestCheck = true;
                break;
            case "variablesCountCheck":
                variablesCountCheck = true;
                break;
        }
    }
}
