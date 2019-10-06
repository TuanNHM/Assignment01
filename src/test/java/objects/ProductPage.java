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
    @FindBy(xpath = ".//a[@href='./index.html']")
    public WebElement logoutBtn;
    @FindBy(xpath = ".//div[@class='product_label']")
    public WebElement productText;
    @FindBy(xpath = ".//button[@class='btn_primary btn_inventory']")
    public List<WebElement> addToCartBtn;
    @FindBy(xpath = ".//button[@class='btn_secondary btn_inventory']")
    public WebElement removeBtn;

    public boolean checkOpenMenuIsDisplayed() {
        return openMenu.isEnabled();
    }

    public void clickOpenMenu() {
        openMenu.click();
    }

    public void clickLogoutBtn() {
        logoutBtn.click();
    }

    public String getProductText() {
        return productText.getText();
    }

    public void clickAddToCartBtn(int whichButton) {
        addToCartBtn.get(whichButton).click();
    }

    public String getRemoveBtnText() {
        return removeBtn.getText();
    }
}
