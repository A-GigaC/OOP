import org.example.BoyerMoor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Test for BoyerMoor.
 */
public class BoyerMoorTest {
    /**
     * Test that BoyerMoor determined.
     */
    @Test
    public void equivalenceTest() throws IOException {
        String pattern = Tools.generateString();
        String filename = Tools.generateFile(pattern);
        ArrayList<Integer> res1 = BoyerMoor.find(filename, pattern);
        ArrayList<Integer> res2 = BoyerMoor.find(filename, pattern);

        Assertions.assertArrayEquals(res1.toArray(), res2.toArray());
    }

    /**
     * Test B-M correctness.
     */
    @Test
    public void boyerMoorShortTest() throws IOException {
        //String pattern = "邈遴⛔➰遴⛔➰";
        String pattern = "邈遴遴";
        ArrayList<Integer> indexes = new ArrayList<>(Arrays.asList(1, 50, 100, 500, 1000, 6500));
        //ArrayList<Integer> indexes = new ArrayList<>(Arrays.asList(1));
        String filename = "shortTest.txt";
        File file = new File(filename);
        FileOutputStream fos = new FileOutputStream(file);
        OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);

        Random random = new Random();
        for (int i = 1; i <= 6550; i++) {
            Integer integer = i;
            if (indexes.contains(integer)) {
                osw.write(pattern);
                i += pattern.length();
            }
            osw.write((char)random.nextInt());
        }

        osw.close();

        ArrayList<Integer> res = BoyerMoor.find(filename, pattern);
        System.out.println(indexes);
        System.out.println(res);
        Assertions.assertArrayEquals(res.toArray(), indexes.toArray());
    }

    /**
     * Big test for B-M.
     */
    @Test
    public void boyerMoorLongTest() throws IOException {
        String filename = "longTest.txt";
        String pattern = "邈遴⛔➰遴遴⛔➰遴⛔➰⛔➰邈遴⛔➰遴";
        ArrayList<Integer> indexes = new ArrayList<>(
                Arrays.asList(3, 50, 100, 500, 1000, 6500, 38493, 129457, 777777777)
        );
        //
        generateLongFile(filename, pattern, indexes);
        //
        ArrayList<Integer> res = BoyerMoor.find(filename, pattern);
        System.out.println(indexes);
        System.out.println(res);
        Assertions.assertArrayEquals(res.toArray(), indexes.toArray());
    }

    /**
     * Generate big file for test big file.
     */
    private void generateLongFile(
            String filename, String pattern, ArrayList<Integer> indexes
    ) throws IOException {
        File file = new File(filename);

        if (file.exists()) {
            return;
        }
        FileOutputStream fos = new FileOutputStream(file);
        OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);

        Random random = new Random();

        for (int i = 1; i <= indexes.get(indexes.size() - 1) + pattern.length() * 2; i++) {
            Integer integer = i;
            if (indexes.contains(integer)) {
                osw.write(pattern);
                i += pattern.length();
            }
            osw.write((char)random.nextInt());
        }

        osw.close();
    }
}
