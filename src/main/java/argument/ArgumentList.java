package argument;

import constant.SearchType;

public class ArgumentList {
    protected String inputFileName;
    protected String mask;
    protected SearchType searchType;

    public String getInputFileName() {
        return inputFileName;
    }

    public String getMask() {
        return mask;
    }

    public SearchType getSearchType() {
        return searchType;
    }
}
