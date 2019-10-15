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

    public static void submitLogin() throws InterruptedException {
        HomePage homepage = new HomePage(driver);

        homepage.inputUsername(AccountsInfo.USERNAME);
        homepage.inputPassword(AccountsInfo.PASSWORD);
        homepage.clickLogin();
        Thread.sleep(5000);
    }


    //Assignment 01
    @Test(priority = 1)
    public static void clickAdd2CartSuccessful() throws InterruptedException {
        submitLogin();
        ProductPage productpage = new ProductPage(driver);
        productpage.clickAddToCartBtn(3);
        Thread.sleep(5000);
        Assert.assertEquals(productpage.getRemoveBtnText(), AllMessages.REMOVE_TEXT);
    }

    //Assignment 02
    @Test(priority = 2)
    public static void logInOutSuccessful() throws InterruptedException {

        HomePage homepage = new HomePage(driver);
        ProductPage productpage = new ProductPage(driver);

        //Verify standing on Login page
        Assert.assertTrue(homepage.checkLoginBtnIsDisplayed());

        //Login successful
        submitLogin();
        Assert.assertTrue(productpage.checkOpenMenuIsDisplayed());
        Assert.assertEquals(productpage.getProductText(), AllMessages.PRODUCT_TEXT);

        //Logout successful
        productpage.clickOpenMenu();
        Thread.sleep(5000);
        productpage.clickLogoutBtn();
        Thread.sleep(5000);
        Assert.assertTrue(homepage.checkLoginBtnIsDisplayed());
    }

    //Assignment 03
    @Test
    public static void add2CartSuccessful() throws InterruptedException {
        ProductPage productpage = new ProductPage(driver);
        submitLogin();

        productpage.clickAddToCartBtn(0);
        productpage.clickAddToCartBtn(4);
        Assert.assertEquals(productpage.getCartTotalText(), AllMessages.CARTNUMBER_TEXT);
    }
}
