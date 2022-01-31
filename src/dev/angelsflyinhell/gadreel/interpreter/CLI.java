package dev.angelsflyinhell.gadreel.interpreter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CLI {

    public static void runFile(String path) throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get(path));

        Runtime r = new Runtime((byte) 1);
        r.run(new String(bytes, Charset.defaultCharset()));

        if (Gadreel.hadError) System.exit(65);
    }

    public static void runPrompt() throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);

        boolean active = true;
        while (active) {
            System.out.print("> ");
            String line = reader.readLine();

            Runtime r = new Runtime((byte) 1);
            if(line == null) break;
            r.run(line);
        }
    }

}
