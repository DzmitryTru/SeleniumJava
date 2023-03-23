package page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage {

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(xpath = "//input[@name='login[password]']")
    private WebElement passField;

    @FindBy(xpath = "//button[@class='action login primary']")
    private WebElement signInButton;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    @Step("Login to account")
    public HomePage loginToAccount(String email, String password) {
        emailField.sendKeys(email);
        passField.sendKeys(password);
        signInButton.click();
        return new HomePage(driver);
    }



}
