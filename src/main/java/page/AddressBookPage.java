package page;

import dto.CustomerAddress;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AddressBookPage extends BasePage {

    @FindBy(xpath = "//button[@class='action primary add']")
    private  WebElement addNewAddressButton;

    @FindBy(id = "telephone")
    private  WebElement phoneNumberField;

    @FindBy(id = "street_1")
    private  WebElement streetField;

    @FindBy(id = "city")
    private  WebElement cityField;

    @FindBy(id = "zip")
    private  WebElement postalCodeField;

    @FindBy(id = "country")
    private  WebElement countryDropdown;

    @FindBy(xpath = "//button[@class='action save primary']")
    private  WebElement saveAddressButton;

    @FindBy(xpath = "//div[@data-ui-id='message-success']")
    private  WebElement savedAddressMessage;

    @FindBy(xpath = "//td[@class='col streetaddress']")
    private  WebElement createdStreetField;

    @FindBy(xpath = "//td[@class='col city']")
    private  WebElement createdCityField;

    @FindBy(xpath = "//td[@class='col country']")
    private  WebElement createdCountryField;

    @FindBy(xpath = "//td[@class='col zip']")
    private  WebElement createdPostalCodeField;

    @FindBy(xpath = "//td[@class='col phone']")
    private  WebElement createdPhoneNumberField;

    public AddressBookPage(WebDriver driver) {
        super(driver);
    }

    @Step("Create new address")
    public void createNewAddress(CustomerAddress customer) {
        addNewAddressButton.click();
        selectCountry(customer.getCountry());
        phoneNumberField.sendKeys(customer.getPhoneNumber());
        streetField.sendKeys(customer.getStreet());
        cityField.sendKeys(customer.getCity());
        postalCodeField.sendKeys(customer.getPostalCode());
        saveAddressButton.click();
        new AddressBookPage(driver);
    }

    @Step("Wait address success message")
    public boolean isDisplayed() {
        waitForElementLocated(savedAddressMessage);
        return isDisplayed(savedAddressMessage);
    }

    private void selectCountry(String country) {
        Select stateSelect = new Select(countryDropdown);
        stateSelect.selectByVisibleText(country);
    }

    public String createdStreet() {
        return createdStreetField.getText();
    }

    public String createdCity() {
        return createdCityField.getText();
    }

    public String createdCountry() {
        return createdCountryField.getText();
    }

    public String createdPostalCode() {
        return createdPostalCodeField.getText();
    }

    public String createdPhoneNumber() {
        return createdPhoneNumberField.getText();
    }
}
