package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class BoyerMoor {
    private static final int alphabetLength = 65536;

    private static int max(int a, int b) {
        return (a > b) ? a : b;
    }

//    public static ArrayList<Integer> find(String filename, String pattern) throws FileNotFoundException {
//        ArrayList<Integer> answer = new ArrayList<>();
//        int ops = 0;
//        try {
//            // Для демо!!!!
//            List<String> lines = Files.readAllLines(Path.of(filename));
//            StringBuilder stringBuilder = new StringBuilder();
//            for (String line : lines) {
//                stringBuilder.append(line);
//                stringBuilder.append("\n");
//            }
//            char[] text = stringBuilder.toString().toCharArray();
//            RingBuffer
//            // КОНЕЦ ДЕМО!!!
//            // pre-calculations
//            char[] substring = pattern.toCharArray();
//            int[] stopCharacter = stopCharHeuristic(substring);
//            // MAIN LOGIC
//            int patternLength = pattern.length();
//
//            if (patternLength > text.length) {
//                System.out.println("Pattern is too long");
//                return answer;
//            }
//
//            int j = patternLength - 1;
//            int patternShift = 0;
//
//
//            while (j + patternShift < text.length) {
//                while (j >= 0 && substring[j] == text[patternShift + j]) {
//                    j--;
//                    ops++;
//                }
//                if (j < 0) {
//                    answer.add(patternShift);
//
//                    patternShift += (patternShift + patternLength < text.length)
//                            ? patternLength - stopCharacter[text[patternShift + patternLength]]
//                            : 1;
//                } else
//                    patternShift += max(1, j - stopCharacter[text[patternShift + j]]);
//
//                j = patternLength - 1;
//            }
//
//        } catch (Exception e) {
//            System.out.println(e);
//            System.out.println(ops);
//            return answer;
//        }
//        System.out.println(ops);
//        return answer;
//    }

    public static ArrayList<Integer> find(String filename, String pattern) {
        RingedBuffer ringedBuffer = new RingedBuffer(pattern.length(), filename);
        ArrayList<Integer> answer = new ArrayList<>();
        char[] arrayPattern = pattern.toCharArray();
        int[] stopCharacter = stopCharHeuristic(arrayPattern);
        int offset = 0;
        CharIndex couple;
        while (ringedBuffer.getNext(offset)) {
            couple = ringedBuffer.compareStrings(arrayPattern);
            if (couple.character == '\u001a') {
                answer.add(ringedBuffer.absIndex - 1);
                offset = 1;
            } else {
                offset = max(1, couple.index - stopCharacter[couple.character]);
            }
        }
        return answer;
    }

    private static int[] stopCharHeuristic(char[] substring) {
        int[] stopCharacter = new int[alphabetLength];
        // Initialize all occurrences as -1
        for (int i = 0; i < alphabetLength; i++)
            stopCharacter[i] = -1;

        // Fill the actual value of last occurrence of a character
        for (int i = 0; i < substring.length; i++)
            stopCharacter[(int) substring[i]] = i;

        return stopCharacter;
    }

}
