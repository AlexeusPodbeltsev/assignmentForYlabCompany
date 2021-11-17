package comparator;


import argument.ArgumentList;

public class EmptyComparator extends AbstractComparator {
    public EmptyComparator(ArgumentList argumentList) {
        super(argumentList);
    }

    @Override
    public boolean compare(String context) {
        return true;
    }
}
