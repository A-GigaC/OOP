package org.example;

import java.io.FileNotFoundException;

/**
 * Main class.
 */
public class Main {
    /**
     * Program's entrypoint.
     */
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(BoyerMoor.find("src/main/java/org/example/file", "bal"));
    }
}
