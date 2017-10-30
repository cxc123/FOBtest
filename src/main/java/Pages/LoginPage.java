package Pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.*;
import io.appium.java_client.pagefactory.*;

import java.util.NoSuchElementException;

/**
 * Created by aakumar on 26/06/17.
 */
public class LoginPage {

    @AndroidFindBy(id="com.flipkart.android:id/user_id")
    private WebElement email;
    @AndroidFindBy(id="com.flipkart.android:id/user_password")
    private WebElement password;
    @AndroidFindBy(id="com.flipkart.android:id/btn_login")
    private WebElement login;

    public LoginPage(AndroidDriver webDriver) {
        this.webDriver = webDriver;
    }

    private AndroidDriver webDriver;
    public void loadLoginPage()
    {

            PageFactory.initElements(new AppiumFieldDecorator(webDriver),this);


    }
    public HomePage validlogin(String username,String password) throws TimeoutException,NoSuchElementException
    {
        try {
            email.click();
            webDriver.getKeyboard();
            email.sendKeys(username);
            Thread.sleep(10000);
            this.password.click();
            webDriver.getKeyboard();
            this.password.sendKeys(password);
            login.click();
            return new HomePage(webDriver);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return  null;
        }
    }

    public LoginPage invalidLogin(String username,String password) throws TimeoutException,NoSuchElementException
    {
        try {
            email.click();
            webDriver.getKeyboard();
            email.sendKeys(username);
            this.password.click();
            webDriver.getKeyboard();
            this.password.sendKeys(password);
            login.click();
            return this;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return  null;
        }
    }

    public boolean isLoginDisplayed()   throws TimeoutException,NoSuchElementException
    {
        try {


            return login.isDisplayed();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return  false;
        }
    }

}
