package page;

import helpers.PageUtil;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//div[@class='swatch-option text']")
    public List<WebElement> productSizeButton;

    @FindBy(xpath = "//div[@class='swatch-option color']")
    public List<WebElement> productColorButton;

    @FindBy(xpath = "//a[@class='action towishlist']")
    private WebElement addToWishListButton;

    @FindBy(id = "product-addtocart-button")
    private WebElement addToCartButton;

    @FindBy(xpath = "//div[@data-ui-id='message-success']")
    private WebElement successMessage;

    @FindBy(xpath = "//span[@itemprop='name']")
    private WebElement itemName;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public String getItemName() {
        return itemName.getText();
    }

    @Step("Add product to cart")
    public void addProductToCart() {
        selectProductAttribute();
        addToCartButton.click();
        waitForElementLocated(successMessage);
    }

    @Step("Add product to Wishlist")
    public WishListPage addProductToWishList() {
        selectProductAttribute();
        addToWishListButton.click();
        return new WishListPage(driver);
    }

    public void selectProductAttribute() {
        PageUtil.clickRandomElement(productSizeButton);
        PageUtil.clickRandomElement(productColorButton);
    }
}
