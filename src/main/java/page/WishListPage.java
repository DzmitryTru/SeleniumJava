package page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends BasePage {

    @FindBy(xpath = "//div[@class='message-success success message']")
    private WebElement wishListMessage;

    @FindBy(xpath = "//a[@class='product-item-link']")
    private WebElement itemName;

    public WishListPage (WebDriver driver) {
        super(driver);
    }

    @Step("Wait Wishlist success message")
    public boolean isDisplayed() {
        waitForElementLocated(wishListMessage);
        return isDisplayed(wishListMessage);
    }

    public String getItemName() {
        return itemName.getText();
    }

}
