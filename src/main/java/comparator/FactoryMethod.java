package comparator;

import argument.ArgumentList;
import constant.SearchType;

public class FactoryMethod {
    public AbstractComparator getComparator(SearchType type, ArgumentList argumentList) {
        switch (type) {
            case Full   -> { return new EmptyComparator(argumentList); }
            case Equals -> { return new EqualsComparator(argumentList);}
            case Mask   -> { return new MaskComparator(argumentList);  }
            case Regular-> { return new RegularExComparator(argumentList);}
            default -> throw new IllegalStateException("Unexpected value: " + type);
        }
    }
}
