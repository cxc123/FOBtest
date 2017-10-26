package FlipkartTest;

import BaseClass.GlobalSetup;
import Pages.HomePage;
import Pages.LoginPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URL;

/**
 * Created by aakumar on 25/10/17.
 */
public class LoginTest {

    AndroidDriver driver;

    @BeforeClass
    public void setup() throws Exception
    {

        GlobalSetup.setPlatform("Mobile");
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("device", " Nexus 4 (Google)");
        dc.setCapability("deviceName","Nexus_4_API_22");
        dc.setCapability("platformName","Android");
        dc.setCapability("appPackage","com.flipkart.android");
        dc.setCapability("appActivity","activity.HomeFragmentHolderActivity");
        driver =  new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),dc);
        //driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);

    }

    @Test
    public void loginTest_pass() throws  Exception
    {
        String username="aayushkumar08@gmail.com";
        String password="aayush123";
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loadLoginPage();
        HomePage homePage=loginPage.validlogin(username,password);
        homePage.loadHomePage();
        Assert.assertTrue(homePage.searchMenuVisible()==true,"User not able to search menu after loggedin");
    }

    @Test
    public void loginTest_fail() throws  Exception
    {
        String username="aayushkumar08@gmail.com";
        String password="aayush1233";
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loadLoginPage();
        LoginPage loginPage1=loginPage.invalidLogin(username,password);
        loginPage1.loadLoginPage();
        Assert.assertTrue(loginPage1.isLoginDisplayed()==true,"With wrong cred user is able to log");

        //Assert.assertTrue(homePage.searchMenuVisible()==true,"User not able to search menu after loggedin");
    }
    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }
}
