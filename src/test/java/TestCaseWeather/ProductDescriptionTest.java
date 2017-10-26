package TestCaseWeather;

import BaseClass.GlobalSetup;
import Pages.*;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by aakumar on 26/10/17.
 */
public class ProductDescriptionTest {
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
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);


    }

    @org.testng.annotations.Test
    public void testProductDescription() throws  Exception
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
        ProductPage productPage=searchResultPage.goToProductPage();
        productPage.loadProductPage();
        productPage.clickTip();
        productPage.loadProductPage();
        Assert.assertTrue(productPage.getProductPrice().toLowerCase().contains("Rs".toLowerCase()),"Product Price not coming");
        Assert.assertTrue(productPage.getProductTitle().toLowerCase().contains(searchString),"Product title not coming");


    }

}
