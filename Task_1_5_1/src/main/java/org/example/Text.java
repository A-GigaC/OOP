package org.example;

/**
 * Text.
 */
public class Text extends Element {
    private final String text;

    /**
     * Text const.
     */
    private Text(Builder builder) {
        this.text = builder.builder.toString();
    }

    /**
     * To string.
     */
    public String toString() {
        return text;
    }

    /**
     * Equals.
     */
    public boolean equals(Element element) {
        if (!(element instanceof Text)) return false;

        return text.equals(((Text) element).text);
    }

    /**
     * Builder.
     */
    public static class Builder {
        private final StringBuilder builder;

        /**
         * Builder constr.
         */
        public Builder() {
            this.builder = new StringBuilder();
        }

        /**
         * Set next.
         */
        public Builder setText(String text) {
            this.builder.setLength(0);
            this.builder.append(text);
            return this;
        }

        /**
         * Bold text.
         */
        public Builder bold() {
            applyFormat("**");
            return this;
        }

        /**
         * Italic.
         */
        public Builder italic() {
            applyFormat("*");
            return this;
        }

        /**
         * AAAA.
         */
        public Builder strikethrough() {
            applyFormat("~~");
            return this;
        }

        /**
         * AAAA.
         */
        public Builder code() {
            applyFormat("`");
            return this;
        }

        /**
         * AAAA.
         */
        private void applyFormat(String modifier) {
            builder.insert(0, modifier);
            builder.append(modifier);
        }

        /**
         * AAAA.
         */
        public Builder append(String text) {
            this.builder.append(text);
            return this;
        }

        /**
         * AAAA.
         */
        public Text build() {
            if (builder.length() == 0) {
                throw new IllegalStateException("Empty text is not allowed.");
            }
            return new Text(this);
        }
    }
}