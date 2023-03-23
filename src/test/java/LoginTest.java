import configuration.AllureConfiguration;
import helpers.ConfigProperties;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import page.AccountPage;
import page.SignInPage;

@ExtendWith(AllureConfiguration.class)

public class LoginTest extends BaseTest {

    @Description("Verify that user could login to account")
    @TmsLink("ID-01")
    @Test
    public void loginCustomerTest() {
        SignInPage signInPage = homePage.navigateToSignInPage();
        signInPage.loginToAccount(ConfigProperties.getProperty("login"), ConfigProperties.getProperty("password"));
        homePage.navigateToAccountPage();
        AccountPage accountPage = new AccountPage(driver);

        Assertions.assertTrue(accountPage.isDisplayed(), "Authorization failed!");
    }
}
