package Pages;

import Config.GlobalSetup;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.NoSuchElementException;

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
    }


    public boolean searchMenuVisible() throws ElementNotVisibleException
    {
        try {
            return this.searchMenu.isDisplayed();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return  false;
        }
    }

    public SearchPage gotoSearchPage() throws TimeoutException,NoSuchElementException
    {
        try {
            this.searchMenu.click();
            return new SearchPage(webDriver);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return  null;
        }

    }
}
