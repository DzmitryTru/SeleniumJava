package page;

import helpers.ConfigProperties;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "(//li[@class='authorization-link']//a)[1]")
    private WebElement signInButton;

    @FindBy(xpath = "(//li//a[contains(@href,'/create/')])[1]")
    private WebElement createAccountButton;

    @FindBy(xpath = "(//button[@data-action='customer-menu-toggle'])[1]")
    private WebElement customerMenuButton;

    @FindBy(xpath = "(//li//a[contains(@href,'/account/')])[1]")
    private WebElement myAccountButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public Header getHeader() {
        return new Header(driver);
    }

    @Step("Navigate to Home Page")
    public void navigateTo() {
        driver.get(ConfigProperties.getProperty("home.page-url"));
    }

    @Step("Navigate to Sign In Page")
    public SignInPage navigateToSignInPage() {
        signInButton.click();
        return new SignInPage(driver);
    }

    @Step("Navigate to Create Account Page")
    public CreateAccountPage navigateToCreateAccountPage() {
        createAccountButton.click();
        return new CreateAccountPage(driver);
    }

    @Step("Navigate to Account Page")
    public AccountPage navigateToAccountPage() {
        customerMenuButton.click();
        myAccountButton.click();
        return new AccountPage(driver);
    }
}
