package org.example;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Main class.
 */
public class Main {
    /**
     * Program's entrypoint.
     */
    public static void main(String[] args) throws IOException {
        System.out.println(BoyerMoor.find("src/main/java/org/example/file", "bal"));
    }
}
