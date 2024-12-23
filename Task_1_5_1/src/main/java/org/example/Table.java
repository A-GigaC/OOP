package org.example;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Table.
 */
public class Table extends Element {
    private ArrayList<ArrayList<String>> contents;
    private final ArrayList<Align> alignments;
    private final int numColumns;
    private final int rowsNum;

    /**
     * Constructor.
     */
    public Table(Builder builder) {
        this.contents = builder.contents;
        this.alignments = builder.alignments;
        this.numColumns = builder.numColumns;
        this.rowsNum = builder.rowsNum;
    }

    /**
     * To String.
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < numColumns; i++) {
            builder.append("| ").append(contents.get(0).get(i).toString()).append(" ");
        }
        builder.append("|\n");
        builder.append("+");
        for (int i = 0; i < numColumns; i++) {
            String header = contents.get(0).get(i).toString();
            int headerLength = header.length();
            if (alignments.get(i) == Align.ALIGN_LEFT) {
                builder.append(":").append("-".repeat(headerLength)).append(" |");
            } else if (alignments.get(i) == Align.ALIGN_RIGHT) {
                builder.append(" " + "-".repeat(headerLength)).append(":|");
            } else if (alignments.get(i) == Align.ALIGN_CENTER) {
                builder.append("-".repeat(headerLength + 2)).append("+");
            }
        }
        builder.append("\n");
        for (int rowIndex = 1; rowIndex < contents.size(); rowIndex++) {
            builder.append("| ");
            for (int colIndex = 0; colIndex < numColumns; colIndex++) {
                String text = contents.get(rowIndex).get(colIndex).toString();
                String header = contents.get(0).get(colIndex).toString();
                int headerLength = header.length();
                int textLength = text.length();

                if (alignments.get(colIndex) == Align.ALIGN_LEFT) {
                    builder.append(text).append(" ".repeat(headerLength - textLength))
                            .append(" |");
                } else if (alignments.get(colIndex) == Align.ALIGN_RIGHT) {
                    builder.append(" ".repeat(headerLength - textLength + 1))
                            .append(text)
                            .append(" |");
                } else if (alignments.get(colIndex) == Align.ALIGN_CENTER) {
                    int totalPadding = headerLength - textLength;
                    int leftPadding = totalPadding / 2;
                    int rightPadding = totalPadding - leftPadding;

                    builder.append(
                            " "
                                    .repeat(leftPadding + 1))
                            .append(text).
                            append(" ".repeat(rightPadding - 1)).append("  |");
                }
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    /**
     * Equals.
     */
    public boolean equals(Element element) {
        if (this == element) return true;
        if (element == null || getClass() != element.getClass()) return false;

        Table table = (Table) element;

        return numColumns == table.numColumns 
                && rowsNum == table.rowsNum 
                && alignments.equals(table.alignments) 
                && contents.equals(table.contents);
    }

    /**
     * Builder.
     */
    public static class Builder {
        private ArrayList<ArrayList<String>> contents = new ArrayList<>();
        private ArrayList<Align> alignments;
        private int numColumns;
        private int rowsNum;
        private int rowLimit = Integer.MAX_VALUE;

        /**
         * Bebebe.
         */
        public Builder withAlignments(Align... alignments) {
            this.alignments = new ArrayList<>(Arrays.asList(alignments));
            return this;
        }

        /**
         * Add raw.
         */
        public Builder addRow(Element... cells) {
            if (contents.size() >= rowLimit) {
                throw new IllegalStateException("Row limit exceeded.");
            }
            if (cells.length != numColumns) {
                throw new IllegalArgumentException("Number of cells in row must match the number of columns.");
            }

            ArrayList<String> row = new ArrayList<>();
            for (Object cell : cells) {
                if (cell instanceof Element) {
                    row.add(cell.toString());
                }
            }
            contents.add(row);
            rowsNum++;

            return this;
        }

        /**
         * With.
         */
        public Builder withColumns(int numColumns) {
            this.numColumns = numColumns;
            return this;
        }

        /**
         * With.
         */
        public Builder withRowLimit(int rowLimit) {
            this.rowLimit = rowLimit;
            return this;
        }

        /**
         * Build.
         */
        public Table build() {
            if (numColumns <= 0) {
                throw new IllegalStateException("Number of columns must be greater than zero.");
            }
            if (alignments == null || alignments.size() != numColumns) {
                throw new IllegalStateException("Alignments must be specified for each column.");
            }
            return new Table(this);
        }
    }
}
