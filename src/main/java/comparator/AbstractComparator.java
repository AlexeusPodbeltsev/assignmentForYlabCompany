package comparator;

import argument.ArgumentList;

public abstract class AbstractComparator extends ItemProcess {
    protected ArgumentList argumentList;

    public AbstractComparator(ArgumentList argumentList) {
        this.argumentList = argumentList;
    }

    public abstract boolean compare(String context);

    public void start() {
    }
}
