package page;

import helpers.PageUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {

    @FindBy(id = "form-validate")
    private WebElement cartForm;

    @FindBy(xpath = "//td[@data-th='Discount'] //span//span")
    private WebElement orderDiscountField;

    @FindBy(xpath = "//td//strong//span[@data-bind]")
    private WebElement orderTotalField;

    @FindBy(xpath = "//td[@class='col subtotal']//span[@class='price']")
    private List<WebElement> itemSubtotalField;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isDisplayed() {
        waitForElementLocated(cartForm);
        return isDisplayed(cartForm);
    }

    public double getItemSubtotalsTotalSum() {
        return itemSubtotalField.stream().map(WebElement::getText)
                .mapToDouble(value -> Double.parseDouble(PageUtil.extractNumberFromString(value))).sum();
    }

    public String getOrderTotal() {
        waitForElementLocated(orderTotalField);
        return PageUtil.extractNumberFromString(orderTotalField.getText());
    }

    public boolean checkOrderTotals() {
        double subtotalSum = getItemSubtotalsTotalSum();
        double total = Double.parseDouble(getOrderTotal());
        double discount = getDiscountValue().isEmpty() ? 0.0 : Double.parseDouble(getDiscountValue());
        return subtotalSum - discount == total;
    }

    public String getDiscountValue() {
        return PageUtil.isDisplayed(orderDiscountField) ? PageUtil.extractNumberFromString(orderDiscountField.getText()) : "";
    }
}
