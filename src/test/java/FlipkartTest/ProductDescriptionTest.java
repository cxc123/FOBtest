package FlipkartTest;

import Pages.*;
import gherkin.lexer.Ca;
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
public class ProductDescriptionTest extends BaseTest
{





    /**
     * <p>
     * Verify Successful logged in User is able to search for product and able to see product details once he/she navigate to Product Detail page by clicking on product in search page
     * </p>
     *
     * <pre>
     * This TC will cover following steps
     * 1. Open flipkart app
     * 2. Enter UserEmail and Userpassword
     * 3. Click Signin Button
     * 4. From home Page enter product to search in search bar
     * 5. User gets List of product for which he/she has searched
     * 6. From List click first product which is displayed
     * 7. Verify User is able to navigate to Product Page
     * 8. Verify User is able to see Price,Detail of product
     * </pre>
     */

    @org.testng.annotations.Test
    public void testProductDescription() {
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
            ProductPage productPage = searchResultPage.goToProductPage();
            productPage.loadProductPage();
            productPage.clickTip();
            productPage.loadProductPage();
            Assert.assertTrue(productPage.getProductPrice().toLowerCase().contains("Rs".toLowerCase()), "Product Price not coming");
            Assert.assertTrue(productPage.getProductTitle().toLowerCase().contains(searchString), "Product title not coming");


        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.print("Exception Errored test cant be run");
        }
    }


}
