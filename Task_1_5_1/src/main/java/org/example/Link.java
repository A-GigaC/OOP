package org.example;

/**
 * Link.
 */
public class Link extends Element {
    private final String text;
    private final String url;

    /**
     * Constr.
     */
    private Link(Builder builder) {
        this.text = builder.text;
        this.url = builder.url;
    }

    /**
     * T s t.
     */
    public String toString() {
        return "[" + text + "](" + url + ")";
    }

    /**
     * Equals.
     */
    public boolean equals(Element element) {
        if (!(element instanceof Link)) return false;
        Link other = (Link) element;

        return text.equals(other.text) && url.equals(other.url);
    }

    /**
     * Builder.
     */
    public static class Builder {
        private String text;
        private String url;

        /**
         * Set text.
         */
        public Builder setText(String text) {
            this.text = text;
            return this;
        }

        /**
         * Set text.
         */
        public Builder setUrl(String url) {
            this.url = url;
            return this;
        }

        /**
         * Build.
         */
        public Link build() {
            if (text == null || text.isEmpty()) {
                throw new IllegalStateException("Link text cannot be null or empty.");
            }
            if (url == null || url.isEmpty()) {
                throw new IllegalStateException("Link URL cannot be null or empty.");
            }
            return new Link(this);
        }
    }
}