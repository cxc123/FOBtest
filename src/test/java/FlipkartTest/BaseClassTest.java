package FlipkartTest;

import Config.AppiumExecution;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.hamcrest.Factory;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by aakumar on 27/10/17.
 */

public class BaseClassTest
{
    AndroidDriver driver;
    private String deviceName;
    private String device;
    private String platformName;
    private String appiumUrl;
    private String appiumPort;

    @org.testng.annotations.Factory(dataProvider = "parallelDp")
    public BaseClassTest(String device,String deviceName,String platformName,String appiumUrl,String appiumPort) {
        this.device=device;
        this.deviceName=deviceName;
        this.appiumUrl=appiumUrl;
        this.appiumPort=appiumPort;
        this.platformName=platformName;
    }


    @DataProvider(name = "parallelDp")
    public static Object[][] parallelDp()
    {

        return new Object[][]
                {

                {"Nexus 4 (Google)","Nexus_4_API_22","Android","http://127.0.0.1","4723"}
        };
    }

    @BeforeClass
    public void setup() throws Exception
    {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("device", device);
        dc.setCapability("deviceName",device);
        dc.setCapability("platformName",platformName);
        dc.setCapability("appPackage","com.flipkart.android");
        dc.setCapability("appActivity","activity.HomeFragmentHolderActivity");
        dc.setCapability("newCommandTimeout",100);
        driver =  new AndroidDriver<MobileElement>(new URL(appiumUrl+":"+appiumPort+"/wd/hub"),dc);
        driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);

    }

    @Test
    public  void test()
    {
        System.out.print("aa");
    }
    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }


}
