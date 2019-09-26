package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class RegisterPage {
    public WebDriver driver;

    public RegisterPage(WebDriver driver) {
        // Wait for element is loaded, define timeWaitForElement as below
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 60);
        PageFactory.initElements(factory, this);
    }

    @FindBy(xpath = "//li[@class='infor-member last_name_member']")
    public WebElement lastNameField;

    public void inputInfo(String lastName) {
        lastNameField.sendKeys(lastName);
    }

    @FindBy(xpath = ".//button[@type='button']")
    public WebElement registerBtn;

    public void submitRegister() {
        registerBtn.click();
    }

    @FindBy(xpath = ".//span[@class='help-block']")
    public WebElement requiredWarning;

    public void checkRequiredWarning() {
        requiredWarning.isDisplayed();
    }

}
