package Pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.NoSuchElementException;

/**
 * Created by aakumar on 25/10/17.
 */
public class SearchPage {

    @AndroidFindBy(id="com.flipkart.android:id/autoCompleteTextView")
    private WebElement textEnter;

    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }

    private String searchString;
    @AndroidFindBy(id="com.flipkart.android:id/text")
    private WebElement clickSearch;
    public SearchPage(AndroidDriver webDriver) {
        this.webDriver = webDriver;
    }

    private AndroidDriver webDriver;
    public void loadSearchPage()
    {

            PageFactory.initElements(new AppiumFieldDecorator(webDriver),this);


    }

    public  void enterSearchString() throws TimeoutException,NoSuchElementException
    {
        try {


            textEnter.click();
            webDriver.getKeyboard();

            textEnter.sendKeys(this.searchString);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public  SearchResultPage searchProduct() throws TimeoutException,NoSuchElementException
    {
        try {
            clickSearch.click();

            return new SearchResultPage(webDriver);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return  null;
        }
    }
}
