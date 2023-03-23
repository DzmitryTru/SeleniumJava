package page;

import helpers.PageUtil;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class IndexPage extends BasePage {

    @FindBy(xpath = "//li[@class='item product product-item']")
    private List<WebElement> productButton;

    public IndexPage(WebDriver driver) {
        super(driver);
    }

    @Step("Select random product")
    public ProductPage selectRandomProduct() {
        PageUtil.clickRandomElement(productButton);
        return new ProductPage(driver);
    }
}
