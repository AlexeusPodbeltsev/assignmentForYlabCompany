import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static constant.ConstantsTest.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Simple XML SaxParser Test")
public class SimpleXMLSaxParserTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @DisplayName("No search input test")
    @Test
    public void noSearchInputTest() {
        Main.main(NO_SEARCH_INPUT);
        String expectedResult = "/file-776194140.xml\n" +
                "/dir-880176375/file-1073842118.java\n" +
                "/dir-880176375/dir-2145307015/file-1498940214.xhtml\n";
        assertEquals(expectedResult, outContent.toString());
    }

    @DisplayName("exact input test")
    @Test
    public void exactSearchInputTest() {
        Main.main(EQUALS_SEARCH_INPUT);
        String expectedResult = "/dir-880176375/dir-2145307015/file-1498940214.xhtml\n";
        assertEquals(expectedResult, outContent.toString());
    }

    @DisplayName("simple input test")
    @Test
    public void simpleSearchInputTest() {
        Main.main(SIMPLE_SEARCH_INPUT);
        String expectedResult = "/dir-880176375/file-1073842118.java\n";
        assertEquals(expectedResult, outContent.toString());
    }

    @DisplayName("extend input test")
    @Test
    public void extendedSearchInputTest() {
        Main.main(EXTENDED_SEARCH_INPUT);
        String expectedResult = "/file-776194140.xml\n" +
                "/dir-880176375/file-1073842118.java\n" +
                "/dir-880176375/dir-2145307015/file-1498940214.xhtml\n";
        assertEquals(expectedResult, outContent.toString());
    }
}
