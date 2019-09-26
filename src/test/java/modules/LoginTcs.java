package modules;

import objects.CartPage;
import objects.HomePage;
import objects.ProductPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import supports.CommonFunctions;

public class LoginTcs {
    private static WebDriver driver;

    @BeforeTest
    public static void setup() {
        driver = CommonFunctions.callBrowser("Chrome");
        CommonFunctions.openPage(driver, "https://www.saucedemo.com/index.html");
    }

    @Test
    public static void loginSuccessful() throws InterruptedException {
        HomePage homepage = new HomePage(driver);
        homepage.inputUsername("standard_user");
        homepage.inputPassword("secret_sauce");
        homepage.clickLogin();
        Thread.sleep(5000);
        ProductPage productpage = new ProductPage(driver);
        productpage.displayProductLabel();
    }

    @Test
    public static void navigateCartPage() throws InterruptedException{
        ProductPage productpage = new ProductPage(driver);
        productpage.clickCartBtn();

        CartPage cartpage = new CartPage(driver);
        cartpage.displayCheckoutBtn();
        Thread.sleep(5000);
    }

    @Test
    public static void navigateProductPage() throws InterruptedException{
        CartPage cartpage = new CartPage(driver);
        cartpage.clickContinueBtn();
        Thread.sleep(5000);

        ProductPage productpage = new ProductPage(driver);
        productpage.displayProductLabel();
    }

    @AfterTest
    public void closeAll() {
        driver.quit();
    }
}
