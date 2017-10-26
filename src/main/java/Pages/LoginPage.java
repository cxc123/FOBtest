package Pages;

import BaseClass.GlobalSetup;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.*;
import io.appium.java_client.pagefactory.*;

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
        if(GlobalSetup.getPlatform().equalsIgnoreCase("Mobile"))
        {
            PageFactory.initElements(new AppiumFieldDecorator(webDriver),this);
        }
        else
        {

        }
    }
    public HomePage validlogin(String username,String password) throws Exception
    {
        email.sendKeys(username);
        this.password.sendKeys(password);
        login.click();
        return new HomePage(webDriver);
    }

    public LoginPage invalidLogin(String username,String password) throws Exception
    {
        email.sendKeys(username);
        this.password.sendKeys(password);
        login.click();
        return this;
    }

    public boolean isLoginDisplayed() throws  Exception
    {
        return login.isDisplayed();
    }

}
