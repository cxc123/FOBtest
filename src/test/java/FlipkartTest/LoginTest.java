package FlipkartTest;

import Pages.HomePage;
import Pages.LoginPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

/**
 * Created by aakumar on 25/10/17.
 */
public class LoginTest extends BaseTest
{






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
