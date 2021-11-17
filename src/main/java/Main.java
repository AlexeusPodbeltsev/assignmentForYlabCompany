import argument.ArgumentException;
import argument.ArgumentList;
import argument.ArgumentProcess;
import comparator.AbstractComparator;
import comparator.FactoryMethod;
import org.xml.sax.SAXException;
import parser.SaxParser;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {

            ArgumentList arguments = new ArgumentProcess(args);
            FactoryMethod factoryMethod = new FactoryMethod();
            AbstractComparator comparator = factoryMethod.getComparator(arguments.getSearchType(), arguments);
            new SaxParser(comparator, arguments.getInputFileName());
        } catch (ParserConfigurationException | SAXException | IOException | ArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
