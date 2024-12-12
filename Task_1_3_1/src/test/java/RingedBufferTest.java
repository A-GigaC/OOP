import org.example.RingedBuffer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Test for ringed buffer.
 */
public class RingedBufferTest {
    /**
     * Test for ringed buffer compareStrings.
     */
    @Test
    public void compareStringsTest() throws IOException {
        String pattern = "Aobobaobbaodsd";
        File file = new File("abobaTest");

        FileOutputStream fis = new FileOutputStream(file);
        fis.write(pattern.getBytes());
        fis.close();

        RingedBuffer ringedBuffer = new RingedBuffer(pattern.length(), "abobaTest");

        Assertions.assertEquals(
                ringedBuffer.compareStrings(pattern).character,
                '\u001a'
        );
    }
}
