package org.example;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(BoyerMoor.find("src/main/java/org/example/file", "bal"));
    }
}
