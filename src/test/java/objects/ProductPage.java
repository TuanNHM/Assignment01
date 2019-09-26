package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class ProductPage {
    public WebDriver driver;

    public ProductPage(WebDriver driver) {
        // Wait for element is loaded, define timeWaitForElement as below
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 60);
        PageFactory.initElements(factory, this);
    }

    @FindBy(xpath = ".//a[@href=\'./cart.html\']")
    public WebElement cartBtn;

    public void displayCartBtn() {
        cartBtn.isDisplayed();
    }

    public void clickCartBtn() {
        cartBtn.click();
    }

    @FindBy(xpath = ".//div[@class='product_label']")
    public WebElement productLabel;

    public void displayProductLabel() {
        productLabel.isDisplayed();
    }
}
