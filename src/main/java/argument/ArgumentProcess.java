package argument;

import constant.Constant;
import constant.SearchType;

import java.io.File;


public class ArgumentProcess extends ArgumentList {

    public ArgumentProcess(String[] args) {
        validator(args);
        storeParams(args);
    }


    private void validator(String[] args) {
        if (args.length < 2) {
            throw new ArgumentException("Not enough arguments to start parsing");
        }
        if (!args[0].equals(Constant.KEY_INPUT_FILE)) {
            throw new ArgumentException("invalid key: " + args[0]);
        }
        if (args[1] == null || args[1].trim().equals("")) {
            throw new ArgumentException("Please input the file which you want to parse");
        }
        if (args.length == 2) {
            return;
        }
        if (args.length == 3) {
            throw new ArgumentException("The search parameter didn't find");
        }
        if (!(args[2].equals(Constant.KEY_MACK) || args[2].equals(Constant.KEY_MACK_REGULAR))) {
            throw new ArgumentException("invalid key: " + args[2]);
        }
    }

    private void storeParams(String[] args) {
        inputFileName = fileExists(args[1]);
        if (args.length == 2) {
            searchType = SearchType.Full;
        }
        if (args.length == 4) {
            mask = args[3];
            if (args[2].equals(Constant.KEY_MACK)) {
                if (mask.matches("\\*.+|\\?.+|.+\\*|.+\\?")) {
                    searchType = SearchType.Mask;
                } else {
                    searchType = SearchType.Equals;
                }
            }
            if (args[2].equals(Constant.KEY_MACK_REGULAR)) {
                searchType = SearchType.Regular;
            }
        }
    }

    private String fileExists(String fileName) {
        String path = System.getProperty("user.dir");
        File f = new File(path + File.separator + fileName);
        if (f.exists() && f.isFile()) {
            return f.getAbsolutePath();
        } else {
            throw new ArgumentException("input file doesn't exists");
        }

    }
}
