package comparator;

import argument.ArgumentList;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MaskComparator extends AbstractComparator {
    public MaskComparator(ArgumentList argumentList) {
        super(argumentList);
    }

    private Pattern pattern;

    @Override
    public void start() {
        String newMask = processingMask(argumentList.getMask());
        pattern = Pattern.compile(newMask);
    }

    private String processingMask(String mask) {
        StringBuilder newMask = new StringBuilder();
        char[] chars = mask.toCharArray();
        for (char ch : chars) {
            switch (ch) {
                case '.' -> newMask.append("\\.");
                case '?' -> newMask.append(".");
                case '*' -> newMask.append(".*");
                default -> newMask.append(ch);
            }
        }
        return newMask.toString();
    }

    @Override
    public boolean compare(String context) {
        Matcher matcher = pattern.matcher(context);
        return matcher.matches();
    }
}
