import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static constant.ConstantsTest.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExtendedXMLParserTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @DisplayName("No search input test")
    @Test
    public void noSearchInputTest() {
        executeJarFile(NO_SEARCH_INPUT);
        String expectedResult = "/file-776194140.xml\n" +
                "/dir-880176375/file-1073842118.java\n" +
                "/dir-880176375/dir-2145307015/file-1498940214.xhtml\n";
        assertEquals(expectedResult, outContent.toString());
    }

    @DisplayName("exact input test")
    @Test
    public void exactSearchInputTest() {
        executeJarFile(EQUALS_SEARCH_INPUT);
        String expectedResult = "/dir-880176375/dir-2145307015/file-1498940214.xhtml\n";
        assertEquals(expectedResult, outContent.toString());
    }

    @DisplayName("simple input test")
    @Test
    public void simpleSearchInputTest() {
        executeJarFile(SIMPLE_SEARCH_INPUT);
        String expectedResult = "/dir-880176375/file-1073842118.java\n";
        assertEquals(expectedResult, outContent.toString());
    }

    @DisplayName("extend input test")
    @Test
    public void extendedSearchInputTest() {
        executeJarFile(EXTENDED_SEARCH_INPUT);
        String expectedResult = "/file-776194140.xml\n" +
                "/dir-880176375/file-1073842118.java\n" +
                "/dir-880176375/dir-2145307015/file-1498940214.xhtml\n";
        assertEquals(expectedResult, outContent.toString());
    }

    private void executeJarFile(String[] userInput) {

        try {
            Process ps = Runtime.getRuntime().exec("java -jar assignment.jar " + String.join(" ", userInput));
            ps.waitFor();
            java.io.InputStream is = ps.getInputStream();
            byte[] b = new byte[is.available()];
            is.read(b, 0, b.length);
            System.out.print(new String(b));

        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
