package Pages;

import BaseClass.GlobalSetup;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

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
        if(GlobalSetup.getPlatform().equalsIgnoreCase("Mobile"))
        {
            PageFactory.initElements(new AppiumFieldDecorator(webDriver),this);
        }
        else
        {

        }
    }

    public void clickTip()
    {
        producttipspullout.click();
    }
    public String getProductPrice()
    {
        return price.getText();
    }
    public String getProductTitle()
    {
        return title.getText();
    }


}
