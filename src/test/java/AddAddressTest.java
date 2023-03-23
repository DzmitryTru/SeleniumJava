import configuration.AllureConfiguration;
import dto.CustomerAddress;
import helpers.ConfigProperties;
import helpers.TestUtil;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import page.AccountPage;
import page.AddressBookPage;
import page.SignInPage;

import static helpers.Const.MINSK_ADDRESS;

@ExtendWith(AllureConfiguration.class)

public class AddAddressTest extends BaseTest {

    @Description("Verify that user could add new address")
    @TmsLink("ID-03")
    @Test
    public void addCustomerAddressTest() {
        CustomerAddress customerAddress = TestUtil.getAddress(MINSK_ADDRESS);
        SignInPage signInPage = homePage.navigateToSignInPage();
        signInPage.loginToAccount(ConfigProperties.getProperty("login"), ConfigProperties.getProperty("password"));
        AccountPage accountPage = homePage.navigateToAccountPage();
        AddressBookPage addressBookPage = accountPage.navigateToAddressBookPage();
        addressBookPage.createNewAddress(customerAddress);

        Assertions.assertAll(
                () -> Assertions.assertTrue(addressBookPage.isDisplayed(), "Element not found"),
                () -> Assertions.assertEquals(customerAddress.getPhoneNumber(), addressBookPage.createdPhoneNumber()),
                () -> Assertions.assertEquals(customerAddress.getStreet(), addressBookPage.createdStreet()),
                () -> Assertions.assertEquals(customerAddress.getCity(), addressBookPage.createdCity()),
                () -> Assertions.assertEquals(customerAddress.getPostalCode(), addressBookPage.createdPostalCode()),
                () -> Assertions.assertEquals(customerAddress.getCountry(), addressBookPage.createdCountry())
        );
    }
}
