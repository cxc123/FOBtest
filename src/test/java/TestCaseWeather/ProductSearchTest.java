package TestCaseWeather;

import BaseClass.GlobalSetup;
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
import org.testng.annotations.Test;

import java.net.URL;

/**
 * Created by aakumar on 26/10/17.
 */
public class ProductSearchTest
{
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

    }

    @Test
    public void ProductSearch() throws  Exception
    {
        String searchString="iphone";
        String username="aayushkumar08@gmail.com";
        String password="aayush123";
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loadLoginPage();
        HomePage homePage=loginPage.validlogin(username,password);
        homePage.loadHomePage();
        SearchPage searchPage = homePage.gotoSearchPage();
        searchPage.loadSearchPage();
        searchPage.setSearchString(searchString);
        searchPage.enterSearchString();
        SearchResultPage searchResultPage = searchPage.searchProduct();
        searchResultPage.loadSearchResultPage();
        System.out.print(searchResultPage.getQueryResult().getText());
        Thread.sleep(1000);
        Assert.assertTrue(searchResultPage.getQueryResult().getText().toLowerCase().contains(searchString),"Unable to successful searc");
        Assert.assertTrue(searchResultPage.getProductLayout().size() > 0,"No search results");
    }

    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }
}
