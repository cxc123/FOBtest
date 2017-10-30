package FlipkartTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by aakumar on 30/10/17.
 */
public class BaseTest {

    AndroidDriver driver;
    @BeforeClass
    public void setup() throws Exception
    {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("device", "Android");
        dc.setCapability("deviceName","Android");
        dc.setCapability("platformName", "Android");
        dc.setCapability("resetKeyboard", true);
        dc.setCapability("unicodeKeyboard", true);
        dc.setCapability("udid","emulator-5556");
        dc.setCapability("appPackage","com.flipkart.android");
        dc.setCapability("appActivity","activity.HomeFragmentHolderActivity");
        dc.setCapability("newCommandTimeout",100);
        driver =  new AndroidDriver<MobileElement>(new URL("http://127.0.0.1"+":"+"4723"+"/wd/hub"),dc);
        driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);

    }


    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }
}
