package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

public class ProductPage {
    public WebDriver driver;

    public ProductPage(WebDriver driver) {
        // Wait for element is loaded, define timeWaitForElement as below
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 60);
        PageFactory.initElements(factory, this);
    }

    @FindBy(xpath = ".//a[@href=\'./cart.html\']")
    public WebElement cartBtn;
    @FindBy(xpath = ".//div[@class='product_label']")
    public WebElement productLabel;
    @FindBy(xpath = ".//button[.='Open Menu']")
    public WebElement openMenu;
    @FindBy(xpath=".//div[@class='product_label']")
    public WebElement productText;
    @FindBy(xpath = ".//button[@class='btn_primary btn_inventory']")
    public List<WebElement> addToCartBtn;

    public void displayCartBtn() {
        cartBtn.isDisplayed();
    }

    public void clickCartBtn() {
        cartBtn.click();
    }

    public void displayProductLabel() {
        productLabel.isDisplayed();
    }

    public boolean checkOpenMenuIsDisplayed() {
        return openMenu.isEnabled();
    }

    public boolean checkCartIconIsDisplayed(){
        return cartBtn.isEnabled();
    }

    public String getProductText(){
        return productText.getText();
    }

    public void clickAddToCartBtn(int whichButton){
        addToCartBtn.get(whichButton).click();
    }
}
