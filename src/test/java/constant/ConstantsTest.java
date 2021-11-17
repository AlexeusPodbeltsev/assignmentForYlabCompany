package constant;

import java.io.File;

public class ConstantsTest {
    public static final String PATH_TO_TEST_FILES_XML_FILE = "src" + File.separator + "test" + File.separator + "resources" + File.separator + "test-files.xml";
    public static final String[] NO_SEARCH_INPUT = {"-f", PATH_TO_TEST_FILES_XML_FILE};
    public static final String[] EQUALS_SEARCH_INPUT = {"-f", PATH_TO_TEST_FILES_XML_FILE, "-s", "file-1498940214.xhtml"};
    public static final String[] SIMPLE_SEARCH_INPUT = {"-f", PATH_TO_TEST_FILES_XML_FILE, "-s", "*.java"};
    public static final String[] EXTENDED_SEARCH_INPUT = {"-f", PATH_TO_TEST_FILES_XML_FILE, "-S", ".*?[a-z]{4}-\\d+\\.[a-z]+"};
}
