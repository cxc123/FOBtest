package Pages;

import BaseClass.GlobalSetup;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

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
        if(GlobalSetup.getPlatform().equalsIgnoreCase("Mobile"))
        {
            PageFactory.initElements(new AppiumFieldDecorator(webDriver),this);
        }
        else
        {

        }
    }

    public  void enterSearchString()
    {
        textEnter.sendKeys(this.searchString);

    }

    public  SearchResultPage searchProduct()
    {
        clickSearch.click();
        return  new SearchResultPage(webDriver);
    }
}
