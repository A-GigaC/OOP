package org.example;

/**
 * Header.
 */
public class Header extends Element {
    private final int level;
    private final String text;

    /**
     * Constructor.
     */
    private Header(Builder builder) {
        if (builder.level < 1 || builder.level > 6) {
            throw new IllegalArgumentException("Heading level must be between 1 and 6.");
        }
        this.level = builder.level;
        this.text = builder.text;
    }

    /**
     * To string.
     */
    public String toString() {
        return "#".repeat(level) + " " + text;
    }

    /**
     * Two headers equitation.
     */
    public boolean equals(Element element) {
        if (!(element instanceof Header)) return false;
        Header other = (Header) element;
        return level == other.level && text.equals(other.text);
    }

    /**
     * Builder.
     */
    public static class Builder {
        private int level = 1;
        private String text = "";

        /**
         * Set header level.
         */
        public Builder setLevel(int level) {
            if (level < 1 || level > 6)
                throw new IllegalArgumentException("Level must be between 1 and 6.");

            this.level = level;
            return this;
        }

        /**
         * Sets header's text.
         */
        public Builder setText(String text) {
            this.text = text;
            return this;
        }

        /**
         * Build.
         */
        public Header build() {
            if (text == null || text.isEmpty()) {
                throw new IllegalStateException("Heading text cannot be null or empty.");
            }
            return new Header(this);
        }
    }
}