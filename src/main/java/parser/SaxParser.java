package parser;


import comparator.AbstractComparator;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class SaxParser {
    AbstractComparator comparator;
    String pathToFile;

    public SaxParser(AbstractComparator comparator, String pathToFile) throws ParserConfigurationException, SAXException, IOException {
        this.comparator = comparator;
        this.pathToFile = pathToFile;
        startParse(comparator, pathToFile);
    }

    private void startParse(AbstractComparator comparator, String pathToFile) throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        saxParserFactory.setValidating(true);
        saxParserFactory.setNamespaceAware(false);
        SAXParser parser = saxParserFactory.newSAXParser();
        NodeParser nodeParser = new NodeParser(comparator);
        parser.parse(pathToFile, nodeParser);
    }


}

