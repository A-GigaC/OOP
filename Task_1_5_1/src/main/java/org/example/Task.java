package org.example;

public class Task extends Element {
    private final String description;
    private final boolean isCompleted;


    private Task(Builder builder) {
        this.description = builder.description;
        this.isCompleted = builder.isCompleted;
    }

    public String toString() {
        return (isCompleted ? "- [x] " : "- [ ] ") + description;
    }

    public boolean equals(Element element) {
        if (!(element instanceof Task)) return false;
        Task other = (Task) element;

        return description.equals(other.description) && isCompleted == other.isCompleted;
    }

    public static class Builder {
        private String description;
        private boolean isCompleted;

        public Builder setDescription(String description) {
            if (description == null || description.isEmpty()) {
                throw new IllegalArgumentException("Task description must be non empty.");
            }
            this.description = description;
            return this;
        }

        public Builder setCompleted(boolean isCompleted) {
            this.isCompleted = isCompleted;
            return this;
        }

        public Task build() {
            if (description == null || description.isEmpty()) {
                throw new IllegalStateException("Task description must be non empty.");
            }
            return new Task(this);
        }
    }
}