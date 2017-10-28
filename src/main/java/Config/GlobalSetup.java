package Config;

import com.sun.javafx.runtime.SystemProperties;

/**
 * Created by aakumar on 25/10/17.
 */
public class GlobalSetup
{
    public static String getPlatform() {
        return platform;
    }

    public static  String platform= System.getProperty("platform")!=null? SystemProperties.getProperty("platform"):"Mobile";

}
