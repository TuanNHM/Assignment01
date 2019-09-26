package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class CartPage {
    public WebDriver driver;

    public CartPage(WebDriver driver) {
        // Wait for element is loaded, define timeWaitForElement as below
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 60);
        PageFactory.initElements(factory, this);
    }

    @FindBy(xpath=".//a[@class='btn_action checkout_button']")
    public WebElement checkoutBtn;
    public void displayCheckoutBtn(){
        checkoutBtn.isDisplayed();
    }

    @FindBy(xpath=".//a[@class='btn_secondary']")
    public WebElement continueBtn;
    public void clickContinueBtn(){
        continueBtn.click();
    }
}
