package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * List of elements.
 */
public class ListOfElements extends Element {
    private final List<String> elements;
    private final boolean isOrdered;

    /**
     * Constr.
     */
    private ListOfElements(Builder builder) {
        this.elements = builder.elements;
        this.isOrdered = builder.isOrdered;
    }

    /**
     * To string.
     */
    public String toString() {
        StringBuilder serialized = new StringBuilder();
        for (int i = 0; i < elements.size(); i++) {
            if (isOrdered) {
                serialized.append((i + 1)).append(". ").append(elements.get(i));
            } else {
                serialized.append("- ").append(elements.get(i));
            }
            if (i < elements.size() - 1) {
                serialized.append("\n");
            }
        }

        return serialized.toString();
    }

    /**
     * Equals.
     */
    public boolean equals(Element element) {
        if (!(element instanceof ListOfElements)) return false;
        ListOfElements other = (ListOfElements) element;
        return isOrdered == other.isOrdered && elements.equals(other.elements);
    }

    /**
     * Builder.
     */
    public static class Builder {
        private final List<String> elements = new ArrayList<>();
        private boolean isOrdered;

        /**
         * Is oredered.
         */
        public Builder setOrdered(boolean isOrdered) {
            this.isOrdered = isOrdered;
            return this;
        }

        /**
         * Add element to list.
         */
        public Builder addElement(String element) {
            this.elements.add(element);
            return this;
        }

        /**
         * Build.
         */
        public ListOfElements build() {
            if (elements.isEmpty()) {
                throw new IllegalStateException("No any elements were added.");
            }
            return new ListOfElements(this);
        }
    }
}
