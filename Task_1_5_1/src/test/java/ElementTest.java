import org.example.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ElementTest {
    @Test
    public void codeTest() {
        Code code1 = new Code.Builder()
                .setContent("int prikol = 2;")
                .setLanguage("C")
                .build();

        Code code2 = new Code.Builder()
                .setLanguage("C")
                .setContent("int prikol = 2;")
                .build();

        Assertions.assertTrue(code1.equals(code2));
        Assertions.assertTrue(code2.equals(code1));
        Assertions.assertTrue(code1.toString().equals(code2.toString()));
        Assertions.assertTrue(code1.toString().equals("```C\nint prikol = 2;\n```"));
    }

    @Test
    public void headerTest() {
        Header header1 = new Header.Builder()
                .setText("Aboba")
                .setLevel(4)
                .build();

        Header header2 = new Header.Builder()
                .setLevel(4)
                .setText("Aboba")
                .build();

        Assertions.assertTrue(header1.equals(header2));
        Assertions.assertTrue(header2.equals(header1));
        Assertions.assertTrue(header1.toString().equals(header2.toString()));
        Assertions.assertTrue(header1.toString().equals("#### Aboba"));
    }

    @Test
    public void imageTest() {
        Image image1 = new Image.Builder()
                .setUrl("https://myhttp.fun/root/img.jpg")
                .setTitle("Really good image")
                .setAlternativeText("Alt text")
                .build();

        Image image2 = new Image.Builder()
                .setTitle("Really good image")
                .setAlternativeText("Alt text")
                .setUrl("https://myhttp.fun/root/img.jpg")
                .build();

        Assertions.assertTrue(image1.equals(image2));
        Assertions.assertTrue(image2.equals(image1));
        Assertions.assertTrue(image1.toString().equals(image2.toString()));
        Assertions.assertTrue(image1.toString().equals("![Alt text](https://myhttp.fun/root/img.jpg \"Really good image\")"));
    }

    @Test
    public void linkTest() {
        Link link1 = new Link.Builder()
                .setUrl("https://myhttp.fun/root/img.jpg")
                .setText("Really good link")
                .build();

        Link link2 = new Link.Builder()
                .setText("Really good link")
                .setUrl("https://myhttp.fun/root/img.jpg")
                .build();

        Assertions.assertTrue(link1.equals(link2));
        Assertions.assertTrue(link2.equals(link1));
        Assertions.assertTrue(link1.toString().equals(link2.toString()));
        Assertions.assertTrue(link1.toString().equals("[Really good link](https://myhttp.fun/root/img.jpg)"));
    }

    @Test
    public void listOfElementsTest() {
        ListOfElements l1 = new ListOfElements.Builder()
                .addElement("Aboba")
                .setOrdered(true)
                .build();
        ListOfElements l2 = new ListOfElements.Builder()
                .addElement("Aboba")
                .setOrdered(false)
                .build();

        Assertions.assertFalse(l1.equals(l2));
        Assertions.assertFalse(l2.equals(l1));
        Assertions.assertTrue(l1.toString().equals("1. Aboba"));
    }

    @Test
    public void quoteTest() {
        Quote q1 = new Quote.Builder()
                .addLine("Idea, lideo, sin DZYA E")
                .build();
        Quote q2 = new Quote.Builder()
                .addLine("Ivan Zolo")
                .build();

        Assertions.assertFalse(q1.equals(q2));
        Assertions.assertFalse(q2.equals(q1));
        Assertions.assertTrue(q2.toString().equals("> Ivan Zolo"));
    }

    @Test
    public void tableTest() {
        Table t1 = new Table.Builder()
                .withRowLimit(12)
                .withAlignments(Align.ALIGN_CENTER, Align.ALIGN_CENTER, Align.ALIGN_CENTER, Align.ALIGN_CENTER)
                .withColumns(4)
                .addRow(
                        new Quote.Builder().addLine("123").build(),
                        new Quote.Builder().addLine("456").build(),
                        new Header.Builder().setLevel(2).setText("Pipec").build(),
                        new Text.Builder().setText("Uaua").bold().build()
                ).build();

        System.out.println(t1.toString());
        Assertions.assertTrue(t1.equals(t1));
        Assertions.assertFalse(t1.equals(
                new Table.Builder()
                .withColumns(2)
                        .withAlignments(Align.ALIGN_CENTER, Align.ALIGN_CENTER)
                .addRow(
                    new Quote.Builder().addLine("123").build(),
                    new Quote.Builder().addLine("456").build()
                )
                .build()
                )
        );
    }

    @Test
    public void taskTest() {
        Task t1 = new Task.Builder()
                .setDescription("OOP 1.5.1")
                .setCompleted(true)
                .build();

        Task t2 = new Task.Builder()
                .setDescription("Dissertation")
                .setCompleted(false)
                .build();

        Assertions.assertFalse(t1.equals(t2));
        Assertions.assertFalse(t2.equals(t1));
        Assertions.assertTrue(t1.toString().equals("- [x] OOP 1.5.1"));
    }

    @Test
    public void textTest() {
        Text t1 = new Text.Builder()
                .setText("Anime")
                .strikethrough()
                .build();

        System.out.println(t1);
        Assertions.assertTrue(t1.equals(t1));
        Assertions.assertTrue(t1.toString().equals("~~Anime~~"));
    }
}
