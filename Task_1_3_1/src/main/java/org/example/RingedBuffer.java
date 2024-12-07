package org.example;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * RingedBuffer.
 */
public class RingedBuffer {
    char []string;
    int size;
    int index;
    int absIndex;
    InputStreamReader stream;

    /**
     * Constructor.
     */
    public RingedBuffer(int size, String fileName) {
        this.size = size;
        string = new char[size];
        index = size - 1;
        absIndex = index + 1;
        File file = new File(fileName);
        try {
            stream = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8);
        } catch (FileNotFoundException ex) {
            System.err.print("Not found" + fileName);
            throw new RuntimeException(ex);
        }

        for (int i = 0; i < size; i++) {
            try {
                string[i] = (char) stream.read();
            } catch (IOException e) {
                System.err.print("Read error");
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Get next n-chars
     */
    public boolean getNext(int cntNext) {
        for (int i = 0; i < cntNext; i++) {
            if (!setNext()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Set new char.
     */
    private boolean setNext() {
        int ch;
        int newIndex = getNextIndex();
        absIndex++;
        try {
            ch = stream.read();
            if (ch == -1) {
                return false;
            } else {
                string[newIndex] = (char)ch;
                this.index = newIndex;
            }

        } catch (IOException e) {
            System.out.print("read error");
            throw new RuntimeException(e);
        }

        return true;
    }

    /**
     * Get next index in buffer.
     */
    private int getNextIndex() {
        if (index + 1 == size) {
            return 0;
        } else {
            return index + 1;
        }
    }

    /**
     * Compare string in buffer with inputed char array.
     */
    public StatusCharIndex compareStrings(String pattern) {
        int iter = index;
        for (int i = size - 1; i >= 0; i--) {
            if (pattern.charAt(i) != this.string[iter]) {
                return new StatusCharIndex(-1, this.string[iter], i);
            }
            iter = (iter - 1 < 0) ? size - 1 : iter - 1;
        }

        return new StatusCharIndex(0, '\u001a', absIndex - size);
    }

    /**
     * Close.
     */
    public void close() throws IOException {
        stream.close();
    }
}
