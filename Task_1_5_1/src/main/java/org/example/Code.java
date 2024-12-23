package org.example;

/**
 * Code in markdown.
 */
public class Code extends Element {
    private final String content;
    private final String language;

    /**
     * Constr.
     */
    private Code(Builder builder) {
        this.content = builder.content;
        this.language = builder.language;
    }

    /**
     * To string.
     */
    public String toString() {
        StringBuilder serialized = new StringBuilder();
        serialized.append("```");
        if (language != null && !language.isEmpty()) serialized.append(language);

        serialized.append("\n")
                .append(content)
                .append("\n```");

        return serialized.toString();
    }

    /**
     * Check equals.
     */
    public boolean equals(Element element) {
        if (!(element instanceof Code)) return false;
        Code other = (Code) element;
        return content.equals(other.content)
                && (
                        (language == null && other.language == null)
                        || (language != null && language.equals(other.language))
        );
    }

    /**
     * Builder.
     */
    public static class Builder {
        private String content;
        private String language;

        /**
         * Set code (content).
         */
        public Builder setContent(String content) {
            if (content == null || content.isEmpty()) {
                throw new IllegalArgumentException("Code cannot be null or empty.");
            }
            this.content = content;
            return this;
        }

        /**
         * Language of code.
         */
        public Builder setLanguage(String language) {
            this.language = language;
            return this;
        }

        /**
         * Build method.
         */
        public Code build() {
            if (content == null || content.isEmpty()) {
                throw new IllegalStateException("Code cannot be null or empty.");
            }
            return new Code(this);
        }
    }
}