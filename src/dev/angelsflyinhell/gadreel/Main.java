package dev.angelsflyinhell.gadreel;

import dev.angelsflyinhell.gadreel.utils.CLO;

import java.io.IOException;

import static dev.angelsflyinhell.gadreel.interpreter.CLI.runFile;
import static dev.angelsflyinhell.gadreel.interpreter.CLI.runPrompt;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println(CLO.PREFIX + CLO.VERSION + "Starting Interpreter");

        if (args.length > 1) {
            System.out.println(CLO.PREFIX + "Usage: gadreel [script]");
            System.exit(64);
        } else if (args.length == 1) {
            runFile(args[0]);
        }else {
            runPrompt();
        }
    }

}
