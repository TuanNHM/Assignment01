package config;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import supports.CommonFunctions;

public class TestBase {
    public static WebDriver driver;
    @BeforeMethod
    public static void callURL() {
        driver = CommonFunctions.callBrowser("Chrome");
        CommonFunctions.openPage(driver, "https://www.saucedemo.com/index.html");
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}
