package TestCaseWeather;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.List;

/**
 * Created by aakumar on 05/05/17.
 */
public class SignUpAndSignIn {


    public static void main(String args[]) throws  Exception{

        AndroidDriver driver;
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("device", " Nexus 4 (Google)");
        dc.setCapability("deviceName","Nexus_4_API_22");
        dc.setCapability("platformName","Android");
        dc.setCapability("appPackage","com.flipkart.android");
        dc.setCapability("appActivity","activity.HomeFragmentHolderActivity");
//        dc.setCapability("newCommandTimeout",10000);
        driver =  new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), dc);
        //driver.manage().timeouts().implicitlyWait();
//        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        //String app_package_name = "/";
//       By id2 = By.id("com.flipkart.android:id/btn_skip");
//        driver.findElement(id2).click();
       By x1 = By.id("com.flipkart.android:id/user_id");
       driver.findElement(x1).sendKeys("aayushkumar08@gmail.com");
       By x2 = By.id("com.flipkart.android:id/user_password");
        driver.findElement(x2).sendKeys("aayush123");
        By x3 = By.id("com.flipkart.android:id/btn_login");
        driver.findElement(x3).click();
//        By id1 = By.id("com.flipkart.android:id/menu_cart");
//        System.out.print(driver.findElement(id1).isDisplayed());
//       //System.out.print(driver.getWindowHandle());
//        By id = By.id("com.flipkart.android:id/menu_search");
//        System.out.print(driver.findElement(id).isDisplayed());
//        driver.findElement(id).click();
//        By id22 = By.id("com.flipkart.android:id/autoCompleteTextView");
//        driver.findElement(id22).sendKeys("redmi");
//        By id33 = By.id("com.flipkart.android:id/text");
//        driver.findElement(id33).click();
//        List<WebElement> webElements = driver.findElements(By.id("com.flipkart.android:id/product_list_product_item_layout"));
//        System.out.print(webElements.size());
//        driver.findElement(By.className("android.widget.LinearLayout")).click();
//        driver.findElement(By.id("com.flipkart.android:id/product_list_product_item_layout")).click();
//        driver.findElement(By.id("com.flipkart.android:id/product_page_image_layout_image_view")).click();
//
//        //driver.quit();


    }



    //    String url;
//    WebDriver webDriver;
//
//    @BeforeClass
//    public void setUp() throws InterruptedException, WebDriverException {
//        url = "https://openweathermap.org/";
//        webDriver = new ChromeDriver();
//        webDriver.get(url);
//        Thread.sleep(2000);
//        webDriver.manage().window().maximize();
//
//
//    }
//
//    @AfterClass
//    public void tearUp() throws  WebDriverException {
//        webDriver.quit();
//    }
//
//
//    @Test
//    public void test()
//    {
//        SearchPage homePage = new SearchPage(webDriver);
//        LoginPage loginPage=homePage.ClickSignIn();
//        loginPage.enterUsername("aayush");
//        loginPage.enterPassword("aayush");
//        loginPage.tickRememberme();
//        UserPage userPage=loginPage.Submit();
//        System.out.print(userPage.getMessage());
//
//    }
//
//    //@Test
//    public void signinClickable() throws NoSuchElementException, TimeoutException, NoSuchWindowException {
//        SoftAssert softAssert = new SoftAssert();
//        WebElement sigin = webDriver.findElement(By.cssSelector("i.fa.fa-sign-in"));
//        softAssert.assertTrue(sigin.isDisplayed(), "SignIn button not present");
//        softAssert.assertTrue(sigin.isEnabled(), "SignIn button not enabled");
//        sigin.click();
//        System.out.print(webDriver.getCurrentUrl());
//        softAssert.assertTrue(webDriver.getCurrentUrl().equalsIgnoreCase("https://home.openweathermap.org/users/sign_in"));
//        softAssert.assertAll();
//    }
//
//    //@Test
//    public void signupClickable() throws NoSuchElementException, TimeoutException, NoSuchWindowException {
//        SoftAssert softAssert = new SoftAssert();
//        WebElement signup = webDriver.findElement(By.cssSelector("i.fa.fa-arrow-circle-down"));
//        softAssert.assertTrue(signup.isDisplayed(), "SignIn button not present");
//        softAssert.assertTrue(signup.isEnabled(), "SignIn button not enabled");
//        signup.click();
//        System.out.print(webDriver.getCurrentUrl());
//        softAssert.assertTrue(webDriver.getCurrentUrl().equalsIgnoreCase("https://home.openweathermap.org/users/sign_up"));
//        softAssert.assertAll();
//
//
//    }
//
//    //@Test(dependsOnMethods = { "signupClickable" },dataProvider="signUpData")
//    public void checkSignUp(String username, String email, String password, String repeatPassword) throws NoSuchElementException, TimeoutException, NoSuchWindowException {
//       // System.out.print("Aaa");
//        WebElement signup = webDriver.findElement(By.cssSelector("i.fa.fa-arrow-circle-down"));
//        signup.click();
//        webDriver.findElement(By.id("user_username")).sendKeys(username);
//       webDriver.findElement(By.id("user_email")).sendKeys(email);
//       webDriver.findElement(By.id("user_password")).sendKeys(password);
//       webDriver.findElement(By.id("user_password_confirmation")).sendKeys(repeatPassword);
//        webDriver.findElement(By.id("user_agreement")).click();
//       // webDriver.findElement(By.cssSelector("div.recaptcha-checkbox-checkmark")).click();
//       webDriver.findElement(By.cssSelector("input.btn.btn-default.btn-color")).submit();
//       String  message = webDriver.findElement(By.cssSelector("h3.primary-font")).getText();
//       Assert.assertTrue(message.equalsIgnoreCase("My Home"));
//    }
//
//
//
//    //@Test(dependsOnMethods = { "signinClickable" },dataProvider="signInData")
//    public void checkSignIn(String username, String password) throws NoSuchElementException, TimeoutException, NoSuchWindowException {
//        WebElement sigin = webDriver.findElement(By.cssSelector("i.fa.fa-sign-in"));
//        sigin.click();
//        webDriver.findElement(By.id("user_email")).sendKeys(username);
//        webDriver.findElement(By.id("user_password")).sendKeys(password);
//        webDriver.findElement(By.cssSelector("input.btn.btn-default.btn-color")).submit();
//        String messageLogin = webDriver.findElement(By.cssSelector("div.panel-body")).getText();
//        System.out.print(messageLogin);
//        Assert.assertTrue(messageLogin.equalsIgnoreCase("Signed in successfully."));
//    }
//
//
//
//    @DataProvider(name = "SignupData")
//
//    public static Object[][] signUpData()
//    {
//
//        return new Object[][]{{"abc", "a@123","aaayush","aaaaa"}, {"abc123","Test@123","asss","aass"}};
//
//
//    }
//
//    @DataProvider(name = "SignInData")
//
//    public static Object[][] signInData()
//    {
//
//        return new Object[][]{{"abc@122", "a@123"}, {"abc123","Test@123"},{"aayushkumar08@gmail.com","aayush123"}};
//
//
//    }
}

