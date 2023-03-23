import configuration.AllureConfiguration;
import dto.CustomerAccount;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import page.AccountPage;
import page.CreateAccountPage;

@ExtendWith(AllureConfiguration.class)

public class CreateAccountTest extends BaseTest {

    private CustomerAccount randomUserAccount;

    @BeforeEach
    public void getData() {
        randomUserAccount = new CustomerAccount().createFakeAccount();
    }

    @Description("Verify that user could create new account")
    @TmsLink("ID-02")
    @Test
    public void createNewAccountTest() {
        CreateAccountPage createAccountPage = homePage.navigateToCreateAccountPage();
        createAccountPage.finishRegistration(randomUserAccount);
        AccountPage accountPage = new AccountPage(driver);

        Assertions.assertTrue(accountPage.isDisplayed(), "Authorization failed");
    }
}
