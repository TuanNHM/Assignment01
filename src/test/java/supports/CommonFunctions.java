package supports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class CommonFunctions {
    public static WebDriver callBrowser(String browserName) {
        WebDriver driver = null;
        if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
            FirefoxOptions options = new FirefoxOptions();
            options.setCapability("marionette", false);
            driver = new FirefoxDriver(options);
        } else if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", "./Drivers/MicrosoftWebDriver.exe");
            driver = new EdgeDriver();
        } else System.err.println("Cannot open browser");
        return driver;
    }

    public static void openPage(WebDriver driver, String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }
}
