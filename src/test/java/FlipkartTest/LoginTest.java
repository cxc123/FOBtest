package FlipkartTest;

import Config.GlobalSetup;
import Pages.HomePage;
import Pages.LoginPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by aakumar on 25/10/17.
 */
public class LoginTest
{
    AndroidDriver driver;
    private String deviceName;
    private String device;
    private String platformName;
    private String appiumUrl;
    private String appiumPort;

    @org.testng.annotations.Factory(dataProvider = "parallelDp")
    public LoginTest(String device,String deviceName,String platformName,String appiumUrl,String appiumPort) {
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
        System.out.print(GlobalSetup.getPlatform());
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


    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }





    /**
     * <p>
     * Verify Login is successful to flipkart app and user navigate to Home Page
     * </p>
     *
     * <pre>
     * This TC will cover following steps
     * 1. Open flipkart app
     * 2. Enter UserEmail and Userpassword
     * 3. Click Signin Button
     * 4. Verify User is able to see his/her Home page
     * </pre>
     */

    @Test
    public void loginTest_pass() {
        try {
            String username = "aayushkumar08@gmail.com";
            String password = "aayush123";
            LoginPage loginPage = new LoginPage(driver);
            loginPage.loadLoginPage();
            HomePage homePage = loginPage.validlogin(username, password);
            homePage.loadHomePage();
            Assert.assertTrue(homePage.searchMenuVisible() == true, "User not able to search menu after loggedin");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.print("Exception Errored test cant be run");
        }
    }


    /**
     * <p>
     * Verify Login is unsuccessful to flipkart app and user not navigate to Home Page if user enters wrong creditianls
     * </p>
     *
     * <pre>
     * This TC will cover following steps
     * 1. Open flipkart app
     * 2. Enter UserEmail and Userpassword which is not registered with flipkart
     * 3. Click Signin Button
     * 4. Verify User is not able to see his/her Home page and  Getting Error "Invalid Login"
     * </pre>
     */

    @Test
    public void loginTest_fail()
    {
        try {
            String username = "aayushkumar08@gmail.com";
            String password = "aayush1233";
            LoginPage loginPage = new LoginPage(driver);
            loginPage.loadLoginPage();
            LoginPage loginPage1 = loginPage.invalidLogin(username, password);
            loginPage1.loadLoginPage();
            Assert.assertTrue(loginPage1.isLoginDisplayed() == true, "With wrong cred user is able to log");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.print("Exception Errored test cant be run");

        }

    }


}
