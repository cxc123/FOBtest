package FlipkartTest;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.SearchPage;
import Pages.SearchResultPage;
import com.fasterxml.jackson.databind.deser.Deserializers;
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
public class ProductSearchTest extends BaseTest
{


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
