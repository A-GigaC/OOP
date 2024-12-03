package org.example;
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

    /**
     * Stop-char heuristic.
     */
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
