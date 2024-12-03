import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Random;

/**
 * Tools for testing.
 */
public class Tools {
    /**
     * Generate new file with length gt pattern.
     */
    static String generateFile(String pattern) throws IOException {
        Random random = new Random();
        int fileSize = random.nextInt();
        if (fileSize < 0) {
            fileSize = -fileSize;
        }
        while (fileSize < pattern.length()) {
            fileSize = random.nextInt();
            if (fileSize < 0) {
                fileSize = -fileSize;
            }
        }

        String name = "all1l93nfnc1l2l4mcn309s";
        File file = new File(name);
        FileOutputStream fos = new FileOutputStream(file);
        OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
        while (fileSize-- > 0) {
            osw.write((char)random.nextInt());
        }
        fos.close();
        return name;
    }

    /**
     * Generate string.
     */
    static String generateString() {
        StringBuilder builder = new StringBuilder();
        Random random = new Random();
        int stringSize = random.nextInt();
        if (stringSize < 0) {
            stringSize = -stringSize;
        }
        while (stringSize-- > 0) {
            builder.append(random.nextInt());
        }
        return builder.toString();
    }
}
