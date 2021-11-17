package comparator;

import argument.ArgumentList;

public class EqualsComparator extends AbstractComparator {
    public EqualsComparator(ArgumentList argumentList) {
        super(argumentList);
    }

    @Override
    public boolean compare(String context) {
        return context.equals(argumentList.getMask());
    }
}
