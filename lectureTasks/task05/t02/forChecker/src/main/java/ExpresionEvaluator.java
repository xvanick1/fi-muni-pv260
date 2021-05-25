import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class ExpresionEvaluator {
    private static final ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");

    public static Object eval(String expression)  {
        try {
            return engine.eval(expression);
        } catch (ScriptException e) {
            System.out.println("ScriptEngine went wrong");
        }

        //This should be never reached, line just to suppress warning
        return null;
    }
}
