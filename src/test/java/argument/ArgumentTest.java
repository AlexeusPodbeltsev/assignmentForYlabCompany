package argument;


import constant.SearchType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static constant.ConstantsTest.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArgumentTest {


    @DisplayName("Validator Test")
    @Test
    public void validatorTest() {
        assertThrows(ArgumentException.class, () -> new ArgumentProcess(new String[]{"-d, ahah"}));
        assertThrows(ArgumentException.class, () -> new ArgumentProcess(new String[]{"-d, ahah", ""}));
        assertThrows(ArgumentException.class, () -> new ArgumentProcess(new String[]{"-f", "path", "-t"}));
    }

    @DisplayName("Store Parameters Test")
    @Test
    public void storeParamTest() {
        ArgumentProcess argumentProcess = new ArgumentProcess(SIMPLE_SEARCH_INPUT);

        File f = new File(System.getProperty("user.dir") + File.separator + PATH_TO_XML_FILE);
        String expectedInputFileName = f.getAbsolutePath();
        String expectedMask = "*.java";
        SearchType expectedSearchType = SearchType.Mask;

        assertEquals(expectedInputFileName, argumentProcess.getInputFileName());
        assertEquals(expectedMask, argumentProcess.getMask());
        assertEquals(expectedSearchType, argumentProcess.getSearchType());

    }
}
