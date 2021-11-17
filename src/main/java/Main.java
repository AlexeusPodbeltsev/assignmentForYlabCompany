import argument.ArgumentException;
import argument.ArgumentList;
import argument.ArgumentProcess;
import comparator.AbstractComparator;
import comparator.FactoryMethod;
import lombok.extern.slf4j.Slf4j;
import parser.SaxParser;

import java.io.IOException;

@Slf4j
public class Main {
    public static void main(String[] args) {
        try {

            ArgumentList arguments = new ArgumentProcess(args);
            FactoryMethod factoryMethod = new FactoryMethod();
            AbstractComparator comparator = factoryMethod.getComparator(arguments.getSearchType(), arguments);
            new SaxParser(comparator, arguments.getInputFileName());

        } catch (IOException e) {
            log.warn(e.getMessage());
            return;
        } catch (ArgumentException e) {
            log.info(e.getMessage());
            return;
        } catch (Exception e) {
            log.error(e.getMessage());
        }

    }
}
