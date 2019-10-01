package modules;

import config.TestBase;
import constants.AccountsInfo;
import constants.AllMessages;
import objects.CartPage;
import objects.HomePage;
import objects.ProductPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import supports.CommonFunctions;

public class LoginTcs extends TestBase {


    @Test
    public static void submitLogin() throws InterruptedException {
        HomePage homepage = new HomePage(driver);
        ProductPage productpage = new ProductPage(driver);

        //Login successful
        homepage.inputUsername(AccountsInfo.USERNAME);
        homepage.inputPassword(AccountsInfo.PASSWORD);
        homepage.clickLogin();
        Thread.sleep(5000);
    }


    @Test
    public static void loginSuccessful() throws InterruptedException {
        HomePage homepage = new HomePage(driver);
        ProductPage productpage = new ProductPage(driver);

        //Login successful
        homepage.inputUsername(AccountsInfo.USERNAME);
        homepage.inputPassword(AccountsInfo.PASSWORD);
        homepage.clickLogin();
        Thread.sleep(5000);

        productpage.clickAddToCartBtn(3);

        Assert.assertTrue(productpage.checkOpenMenuIsDisplayed());
        Assert.assertEquals(productpage.getProductText(), AllMessages.PRODUCT_TEXT);
    }


}
