package FlipkartTest;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.SearchPage;
import Pages.SearchResultPage;
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
 * Created by aakumar on 26/10/17.
 */
public class ProductSearchTest
{
    AndroidDriver driver;
    private String deviceName;
    private String device;
    private String platformName;
    private String appiumUrl;
    private String appiumPort;

    @org.testng.annotations.Factory(dataProvider = "parallelDp")
    public ProductSearchTest(String device,String deviceName,String platformName,String appiumUrl,String appiumPort) {
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

    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }





    /**
     * <p>
     * Verify Successful logged in User is able to search for  product in search page
     * </p>
     *
     * <pre>
     * This TC will cover following steps
     * 1. Open flipkart app
     * 2. Enter UserEmail and Userpassword
     * 3. Click Signin Button
     * 4. From home Page enter product to search in search bar
     * 5. Verify User gets List of product for which he/she has searched
     * </pre>
     */

    @Test
    public void ProductSearch() throws  Exception {
        try {
            String searchString = "iphone";
            String username = "aayushkumar08@gmail.com";
            String password = "aayush123";
            LoginPage loginPage = new LoginPage(driver);
            loginPage.loadLoginPage();
            HomePage homePage = loginPage.validlogin(username, password);
            homePage.loadHomePage();
            SearchPage searchPage = homePage.gotoSearchPage();
            searchPage.loadSearchPage();
            searchPage.setSearchString(searchString);
            searchPage.enterSearchString();
            SearchResultPage searchResultPage = searchPage.searchProduct();
            searchResultPage.loadSearchResultPage();
            System.out.print(searchResultPage.getQueryResult().getText());
            Thread.sleep(1000);
            Assert.assertTrue(searchResultPage.getQueryResult().getText().toLowerCase().contains(searchString), "Unable to successful searc");
            Assert.assertTrue(searchResultPage.getProductLayout().size() > 0, "No search results");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.print("Exception Errored test cant be run");
        }
    }



}
