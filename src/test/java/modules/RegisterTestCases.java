package modules;

import objects.HomePage;
import objects.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import supports.CommonFunctions;

public class RegisterTestCases {
    private static WebDriver driver;

    @BeforeTest
    public static void access() {
        driver = CommonFunctions.callBrowser("Chrome");
        CommonFunctions.openPage(driver, "http://qa.demovn.kootoro.com/");
    }

    @Test
    public void accessRegisterSuccessful() throws InterruptedException {
        HomePage homepage = new HomePage(driver);
        homepage.clickRegister();
        Thread.sleep(5000);
    }

    @Test
    public void inputRegisterInfo() throws InterruptedException {
        RegisterPage registerpage = new RegisterPage(driver);
        registerpage.inputInfo("Nguyen");
        Thread.sleep(5000);
    }

    @Test
    public void registerNullInfo() throws InterruptedException {
        RegisterPage registerpage = new RegisterPage(driver);
        registerpage.submitRegister();
        Thread.sleep(5000);
        registerpage.checkRequiredWarning();
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }
}
