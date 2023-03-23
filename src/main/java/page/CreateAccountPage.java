package page;

import dto.CustomerAccount;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountPage extends BasePage {

    @FindBy(id = "firstname")
    private WebElement customerFirstNameField;

    @FindBy(id = "lastname")
    private WebElement customerLastNameField;

    @FindBy(id = "email_address")
    private WebElement customerEmailField;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement customerPassField;

    @FindBy(id = "password-confirmation")
    private WebElement customerConfirmPassField;

    @FindBy(xpath = "//button[@class='action submit primary']")
    private WebElement createAccountButton;

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    @Step("Add new account")
    public void finishRegistration(CustomerAccount customer) {
        customerFirstNameField.sendKeys(customer.getFirstName());
        customerLastNameField.sendKeys(customer.getLastName());
        customerEmailField.sendKeys(customer.getEmail());
        customerPassField.sendKeys(customer.getPassword());
        customerConfirmPassField.sendKeys(customer.getPassword());
        createAccountButton.click();
        new AccountPage(driver);
    }
}
