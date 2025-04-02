package org.example;

/**
 * Class image.
 */
public class Image extends Element{
    private String alternativeText;
    private String url;
    private String title;

    /**
     * Constr.
     */
    private Image(Builder builder) {
        this.alternativeText = builder.alternativeText;
        this.url = builder.url;
        this.title = builder.title;
    }

    /**
     * To string.
     */
    public String toString() {
        StringBuilder serialized = new StringBuilder();
        serialized.append("!["+ alternativeText + "](" + url);

        if (title != null && !title.isEmpty()) {
            serialized.append(" \"").append(title).append("\"");
        }
        serialized.append(")");

        return serialized.toString();
    }
    /**
     * Im so bored.
     */
    public boolean equals(Element element) {
        if (!(element instanceof Image)) return false;
        Image other = (Image) element;
        return alternativeText.equals(other.alternativeText)
                && url.equals(other.url)
                && (
                        (title == null && other.title == null)
                        || (title != null && title.equals(other.title))
                    );
    }

    /**
     * Builder.
     */
    public static class Builder {
        private String alternativeText;
        private String url;
        private String title;

        /**
         * Im so bored.
         */
        public Builder setAlternativeText(String alternativeText) {
            this.alternativeText = alternativeText;
            return this;
        }

        /**
         * Sets URL.
         */
        public Builder setUrl(String url) {
            this.url = url;
            return this;
        }

        /**
         * Sets title.
         */
        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        /**
         * Build.
         */
        public Image build() {
            if (url == null || url.isEmpty()) {
                throw new IllegalStateException("Image URL cannot be empty.");
            }
            return new Image(this);
        }
    }
}