package comparator;

import argument.ArgumentProcess;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static constant.ConstantsTest.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ComparatorTest {
    private final FactoryMethod factoryMethod = new FactoryMethod();

    @DisplayName("empty input comparator test")
    @Test
    public void emptyComparatorTest() {
        ArgumentProcess argumentProcess = new ArgumentProcess(NO_SEARCH_INPUT);
        AbstractComparator comparator = factoryMethod.getComparator(argumentProcess.getSearchType(), argumentProcess);
        assertTrue(comparator instanceof EmptyComparator);
    }

    @DisplayName("equals input comparator test")
    @Test
    public void equalsComparatorTest() {
        ArgumentProcess argumentProcess = new ArgumentProcess(EQUALS_SEARCH_INPUT);
        AbstractComparator comparator = factoryMethod.getComparator(argumentProcess.getSearchType(), argumentProcess);
        assertTrue(comparator instanceof EqualsComparator);
    }

    @DisplayName("simple input comparator test")
    @Test
    public void maskComparatorTest() {
        ArgumentProcess argumentProcess = new ArgumentProcess(SIMPLE_SEARCH_INPUT);
        AbstractComparator comparator = factoryMethod.getComparator(argumentProcess.getSearchType(), argumentProcess);
        assertTrue(comparator instanceof MaskComparator);
    }

    @DisplayName("extend input comparator test")
    @Test
    public void regularExComparatorTest() {
        ArgumentProcess argumentProcess = new ArgumentProcess(EXTENDED_SEARCH_INPUT);
        AbstractComparator comparator = factoryMethod.getComparator(argumentProcess.getSearchType(), argumentProcess);
        assertTrue(comparator instanceof RegularExComparator);
    }
}
