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
        //Login successful
        homepage.inputUsername("standard_user");
        homepage.inputPassword("secret_sauce");
        homepage.clickLogin();
        Thread.sleep(5000);
        System.out.println("Login Successful: Pass");
        ProductPage productpage = new ProductPage(driver);
        //Verify accessing on Product page
        productpage.displayProductLabel();
        System.out.println("You are on Product page: Pass");
        //Verify accessing on Cart page
        productpage.clickCartBtn();
        Thread.sleep(5000);
        CartPage cartpage = new CartPage(driver);
        cartpage.displayCheckoutBtn();
        System.out.println("You are on Cart page: Pass");
        //Back to Product page
        cartpage.clickContinueBtn();
        Thread.sleep(5000);
        productpage.displayProductLabel();
        System.out.println("You are back to Product page: Pass");
    }

    @AfterTest
    public void closeAll() {
        driver.quit();
    }
}
