package Pages;

import BaseClass.GlobalSetup;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by aakumar on 25/10/17.
 */
public class HomePage {

    @AndroidFindBy(id="com.flipkart.android:id/menu_search")
    public WebElement searchMenu;

    public HomePage(AndroidDriver webDriver) {
        this.webDriver = webDriver;
    }

    private AndroidDriver webDriver;
    public void loadHomePage()
    {
        if(GlobalSetup.getPlatform().equalsIgnoreCase("Mobile"))
        {

            PageFactory.initElements(new AppiumFieldDecorator(webDriver),this);
        }
        else
        {

        }
    }


    public boolean searchMenuVisible()
    {
        return  this.searchMenu.isDisplayed();
    }

    public SearchPage gotoSearchPage()
    {
        this.searchMenu.click();
        return  new SearchPage(webDriver);

    }
}
