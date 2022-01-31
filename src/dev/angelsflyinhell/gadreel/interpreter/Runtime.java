package dev.angelsflyinhell.gadreel.interpreter;

import dev.angelsflyinhell.gadreel.interpreter.tokens.Token;
import dev.angelsflyinhell.gadreel.utils.CLO;

import java.util.List;

public class Runtime {

    private byte interpreterLevel;
    public Runtime(byte interpreterLevel) {
        this.interpreterLevel = interpreterLevel;
    }

    public void run(String source) {
        Scanner scanner = new Scanner(source);
        List<Token> tokens = scanner.scanTokens();

        for (Token token : tokens) {
            System.out.println(token);
        }
    }

    public static void error(int line, String message) {
        report(line, "", message);
    }

    private static void report(int line, String where, String message) {
        System.err.println(CLO.PREFIX + "[line " + line + "] Error " + where + ": " + message);
        Gadreel.hadError = true;
    }

}
