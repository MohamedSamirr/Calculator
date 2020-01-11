package com.nopalyer.calculator;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class Model {

    public String tf(String process, String tvOutput) {
        process = process.replaceAll("×", "*");
        process = process.replaceAll("%", "/100");
        process = process.replaceAll("÷", "/");

        Context rhino = Context.enter();

        rhino.setOptimizationLevel(-1);

        String finalResult = "";

        try {
            Scriptable scriptable = rhino.initStandardObjects();
            finalResult = rhino.evaluateString(scriptable, process, "javascript", 1, null).toString();
        } catch (Exception e) {
            finalResult = "0";
        }

        return finalResult;
    }
}
