import org.example.BoyerMoor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Random;

/**
 * Test for BoyerMoor.
 */
public class BoyerMoorTest {
    /**
     * Test for BoyerMoor.
     */
    @Test
    public void equivalenceTest() throws IOException {
        String pattern = Tools.generateString();
        String filename = Tools.generateFile(pattern);
        ArrayList<Integer> res1 = BoyerMoor.find(filename, pattern);
        ArrayList<Integer> res2 = BoyerMoor.find(filename, pattern);

        Assertions.assertArrayEquals(res1.toArray(), res2.toArray());
    }
}
