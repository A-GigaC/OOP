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
    public void boyerMoorTest() throws IOException {
        String pattern = "MMM";
        ArrayList<Integer> indexes = new ArrayList<>(Arrays.asList(1, 20, 30, 44, 54, 100, 1000, 6500));
        String filename = "abobaTest";
        File file = new File(filename);
        FileOutputStream fos = new FileOutputStream(file);
        OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);

        Random random = new Random();

        for (int i = 0; i <= 6500; i++) {
            if (indexes.contains(new Integer(i))) {
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
}
