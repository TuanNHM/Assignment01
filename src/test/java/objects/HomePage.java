package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HomePage {
    public WebDriver driver;

    public HomePage(WebDriver driver) {
        // Wait for element is loaded, define timeWaitForElement as below
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 60);
        PageFactory.initElements(factory, this);
    }

    @FindBy(xpath = ".//input[@type='text']")
    public WebElement usernameField;
    @FindBy(xpath = ".//input[@type='password']")
    public WebElement passwordField;
    @FindBy(xpath = ".//input[@type=\'submit\']")
    public WebElement loginBtn;

    public void inputUsername(String username) {
        usernameField.sendKeys(username);
    }

    public void inputPassword(String password) {

        passwordField.sendKeys(password);
    }

    public void clickLogin() {

        loginBtn.click();
    }
}
