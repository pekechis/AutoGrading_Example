import holamundo.Hello;
import holamundo.Main;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestAssignment {

  @Test
  public void testAssignment() {
    PrintStream originalOut = System.out;
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    System.setOut(new PrintStream(bos));

    // assertion File checking
    File fileHello = new File("src/main/java/holamundo/Hello.java");
    File fileMain = new File("src/main/java/holamundo/Main.java");

    String s1 = fileHello.getAbsolutePath();
    String s2 = fileMain.getAbsolutePath();

    assertTrue(fileHello.exists());
    assertTrue(fileMain.exists());


    // action
    Hello.main(null);

    // assertion. Checkoutput
    assertEquals("Hello world!\n", bos.toString());

    //action
    Main.main(null);

    // assertion. Checkoutput
    assertEquals("Hello world!\n", bos.toString());

    // undo the binding in System
    System.setOut(originalOut);
  }
}
