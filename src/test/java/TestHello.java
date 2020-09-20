import holamundo.Hello;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestHello {

  @Test
  public void testHelloWorld() {
    PrintStream originalOut = System.out;
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    System.setOut(new PrintStream(bos));

    // action
    Hello.main(null);

    // assertion
    assertEquals("Hello world!\n", bos.toString());

    // undo the binding in System
    System.setOut(originalOut);
  }
}
