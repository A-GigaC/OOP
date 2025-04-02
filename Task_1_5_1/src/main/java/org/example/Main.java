package org.example;

/**
 * Main.
 */
public class Main {
    /**
     * Main.
     */
    public static void main() {
        Table.Builder tableBuilder = new Table.Builder()
                .withAlignments(Align.ALIGN_RIGHT, Align.ALIGN_LEFT)
                .withRowLimit(8)
                .addRow(
                        new Text.Builder().setText("Index").build(),
                        new Text.Builder().setText("Random").build()
                );

        for (int i = 0; i < 5; i++) {
            final var value = (int) (Math.random() * 10);
            if (value > 5) {
                tableBuilder.addRow(new Text.Builder()
                            .setText("" + i)
                            .build(),
                        new Text.Builder()
                            .setText("**" + String.valueOf(value) + "**")
                            .build()
                );
            } else {
                tableBuilder.addRow(new Text.Builder()
                                .setText("" + i)
                                .build(),
                        new Text.Builder()
                                .setText("" + (int) (Math.random() * 10))
                                .build()
                );
            }
        }
        System.out.println(tableBuilder.build());
    }
}
