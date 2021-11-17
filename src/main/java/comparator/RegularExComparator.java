package comparator;

import argument.ArgumentList;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExComparator extends AbstractComparator {
    Pattern pattern;

    public RegularExComparator(ArgumentList argumentList) {
        super(argumentList);
    }

    @Override
    public void start() {
        pattern = Pattern.compile(argumentList.getMask());
    }

    @Override
    public boolean compare(String context) {
        Matcher matcher = pattern.matcher(context);
        return matcher.matches();
    }
}
