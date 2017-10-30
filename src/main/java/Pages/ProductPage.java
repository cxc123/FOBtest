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
public class ProductPage
{

    public WebElement getPrice() {
        return price;
    }

    public void setPrice(WebElement price) {
        this.price = price;
    }



    public WebElement getTitle() {
        return title;
    }

    public void setTitle(WebElement title) {
        this.title = title;
    }

    @AndroidFindBy(id="product_page_price_ratings_sp_text")
    private WebElement price;
    @AndroidFindBy(id="com.flipkart.android:id/product_page_title_main_title")
    private WebElement title;
    @AndroidFindBy(id="com.flipkart.android:id/product_page_cue_tips_pullout")
    private WebElement producttipspullout;
    public ProductPage(AndroidDriver webDriver) {
        this.webDriver = webDriver;
    }

    private AndroidDriver webDriver;
    public void loadProductPage()
    {

            PageFactory.initElements(new AppiumFieldDecorator(webDriver),this);


    }

    public void clickTip() throws TimeoutException,NoSuchElementException
    {
        try {
            producttipspullout.click();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public String getProductPrice()  throws TimeoutException,NoSuchElementException,NoSuchElementException

    {
        try {

            return price.getText();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return "";
        }
    }
    public String getProductTitle()throws TimeoutException,NoSuchElementException
    {
        try {
            return title.getText();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return "";
        }
    }


}
