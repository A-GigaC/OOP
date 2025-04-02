package org.example;

/**
 * Quote.
 */
public class Quote extends Element {
    private final String text;

    /**
     * Constr.
     */
    private Quote(Builder builder) {
        this.text = builder.textBuilder.toString().trim();
    }

    /**
     * To String.
     */
    public String toString() {
        return "> " + text.replace("\n", "\n> ");
    }

    /**
     * Equals.
     */
    public boolean equals(Element element) {
        if (!(element instanceof Quote)) return false;
        Quote other = (Quote) element;
        return text.equals(other.text);
    }

    /**
     * Builder.
     */
    public static class Builder {
        private final StringBuilder textBuilder = new StringBuilder();

        /**
         * ADd line.
         */
        public Builder addLine(String line) {
            if (line != null && !line.isEmpty()) {
                if (textBuilder.length() > 0) {
                    textBuilder.append("\n");
                }
                textBuilder.append(line);
            }
            return this;
        }

        /**
         * Build.
         */
        public Quote build() {
            if (textBuilder.length() == 0) {
                throw new IllegalStateException("Quote must be non empty.");
            }
            return new Quote(this);
        }
    }
}