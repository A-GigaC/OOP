package org.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * RingedBuffer.
 */
public class RingedBuffer {
    char []string;
    int size;
    int index;
    int absIndex;
    FileInputStream stream;


    /**
     * Constructor.
     */
    public RingedBuffer(int size, String fileName) {
        this.size = size;
        string = new char[size];
        index = size - 1;
        absIndex = index;
        File file = new File(fileName);
        try {
            stream = new FileInputStream(file);
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
    public CharIndex compareStrings(char[] charArray) {
        int iter = index;
        for (int i = size - 1; i >= 0; i--) {
            if (charArray[i] != this.string[iter]) {
                return new CharIndex(this.string[iter], i);
            }
            iter = (iter - 1 < 0) ? size - 1 : iter - 1;
        }

        return new CharIndex('\u001a', absIndex - size);
    }
}
