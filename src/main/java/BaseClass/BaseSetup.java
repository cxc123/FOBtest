package BaseClass;

import gherkin.lexer.De;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.*;

import java.net.URL;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * Created by aakumar on 25/10/17.
 */
public class BaseSetup
{

    public String appActivity;

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public  WebDriver webDriver;

    public String getAppPackage() {
        return appPackage;
    }

    public void setAppPackage(String appPackage) {
        this.appPackage = appPackage;
    }

    public String appPackage;
    public String device;
    public String deviceName;
    public String platformName;
    public String serverIp;
    public String port;
    public String url =serverIp+":"+port+"/wd/hub";

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String platform;



    public WebDriver setWebDriver() throws Exception
    {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        if(GlobalSetup.getPlatform().equalsIgnoreCase("mobile"))
        {
            desiredCapabilities.setCapability("device",device);
            desiredCapabilities.setCapability("deviceName",deviceName);
            desiredCapabilities.setCapability("platformName",platformName);
            desiredCapabilities.setCapability("appPackage",appPackage);
            desiredCapabilities.setCapability("appActivity",appActivity);
            webDriver = new AndroidDriver<MobileElement>(new URL(url),desiredCapabilities);


        }
        if(GlobalSetup.getPlatform().equalsIgnoreCase("web"))
        {

        }

        webDriver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(100,TimeUnit.SECONDS);

        return  this.webDriver=webDriver;


    }

}
