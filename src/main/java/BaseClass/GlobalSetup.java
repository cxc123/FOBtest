package BaseClass;

/**
 * Created by aakumar on 25/10/17.
 */
public class GlobalSetup {
    public static String getPlatform() {
        return platform;
    }

    public static void setPlatform(String platform) {
        GlobalSetup.platform = platform;
    }

    public static  String platform;

}
