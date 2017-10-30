package Pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by aakumar on 25/10/17.
 */
public class SearchResultPage
{

    public WebElement getQueryResult() {
        return queryResult;
    }

    public void setQueryResult(WebElement queryResult) {
        this.queryResult = queryResult;
    }

    @AndroidFindBy(id="com.flipkart.android:id/product_list_query_text")
    private WebElement queryResult;

    public List<WebElement> getProductLayout() {
        return productLayout;
    }

    public void setProductLayout(List<WebElement> productLayout) {
        this.productLayout = productLayout;
    }

    @AndroidFindBy(id="com.flipkart.android:id/product_list_product_item_layout")
    private List<WebElement> productLayout;
    public SearchResultPage(AndroidDriver webDriver) {
        this.webDriver = webDriver;
    }

    private AndroidDriver webDriver;
    public void loadSearchResultPage()
    {

            PageFactory.initElements(new AppiumFieldDecorator(webDriver),this);


    }


    public ProductPage goToProductPage() throws TimeoutException,NoSuchElementException {
        try {
            productLayout.get(0).click();
            productLayout.get(0).click();
            return new ProductPage(webDriver);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
