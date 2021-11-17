package comparator;

import constant.Constant;

import java.util.ArrayList;

public class ItemProcess {
    private ArrayList<String> dir = new ArrayList<>();
    private boolean isFile;

    public void storeItem(String inputData) {
        if (!isFile) {
            dir.add(dir.size() > 1 ? Constant.SPLIT_DIR + inputData : inputData);
        }
    }

    public void setIsFile(boolean isFile) {
        this.isFile = isFile;
    }

    public void printFile(String fileName) {
        if (isFile) {
            String path = getCurrentDirectory().length() > 1 ?
                    getCurrentDirectory() + Constant.SPLIT_DIR + fileName :
                    getCurrentDirectory() + fileName;

            System.out.println(path);
        }
    }

    public void closeDirectory() {
        dir.remove(dir.size() - 1);
    }

    private String getCurrentDirectory() {
        return String.join("", dir);
    }
}
