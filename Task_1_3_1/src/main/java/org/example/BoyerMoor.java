package org.example;

import java.io.IOException;
import java.util.ArrayList;

/**
 * BoyerMoor class.
 */
public class BoyerMoor {
    private static final int alphabetLength = 65536;

    /**
     * Max of two ints.
     */
    private static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    /**
     * Find substring in file.
     */
    public static ArrayList<Integer> find(String filename, String pattern) throws IOException {
        RingedBuffer ringedBuffer = new RingedBuffer(pattern.length(), filename);
        ArrayList<Integer> answer = new ArrayList<>();
        int[] stopCharacter = stopCharHeuristic(pattern);
        int offset = 0;
        StatusCharIndex couple;
        while (ringedBuffer.getNext(offset)) {
            couple = ringedBuffer.compareStrings(pattern);
            if (couple.status == 0) {
                answer.add(couple.index + 1);
                offset = 1;
            } else {
                offset = max(1, couple.index - stopCharacter[couple.character]);
            }
        }
        ringedBuffer.close();

        return answer;
    }

    /**
     * Stop-char heuristic.
     */
    private static int[] stopCharHeuristic(String pattern) {
        int[] stopCharacter = new int[alphabetLength];
        // Initialize all occurrences as -1
        for (int i = 0; i < alphabetLength; i++) {
            stopCharacter[i] = -1;
        }

        // Fill the actual value of last occurrence of a character
        for (int i = 0; i < pattern.length(); i++) {
            stopCharacter[(int) pattern.charAt(i)] = i;
        }

        return stopCharacter;
    }

}
