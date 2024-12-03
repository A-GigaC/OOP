import org.example.BoyerMoor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Random;

public class BoyerMoorTest {
    @Test
    public void equivalenceTest() throws IOException {
        StringBuilder builder = new StringBuilder();
        Random random = new Random();
        int stringSize = random.nextInt() % 25000 ;
        if (stringSize < 0) {
            stringSize = -stringSize;
        }
        while (stringSize-- > 0) {
            builder.append(random.nextInt());
        }
        String pattern = builder.toString();
        String filename = generateFile(pattern);
        ArrayList<Integer> res1 = BoyerMoor.find(filename, pattern);
        ArrayList<Integer> res2 = BoyerMoor.find(filename, pattern);

        Assertions.assertArrayEquals(res1.toArray(), res2.toArray());
    }

    private String generateFile(String pattern) throws IOException {
        Random random = new Random();
        int fileSize = random.nextInt() % 250000;
        if (fileSize < 0) {
            fileSize = -fileSize;
        }
        while (fileSize < pattern.length()) {
            fileSize = random.nextInt();
        }

        String name = "all1l93nfnc1l2l4mcn309s";
        File file = new File(name);
        FileOutputStream fos = new FileOutputStream(file);
        while (fileSize-- > 0) {
            fos.write((byte)random.nextInt() % 255);
        }
        fos.close();
        return name;
    }
}
