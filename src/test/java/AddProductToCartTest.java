import configuration.AllureConfiguration;
import helpers.ConfigProperties;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import page.*;

import static helpers.Const.*;

@ExtendWith(AllureConfiguration.class)

public class AddProductToCartTest extends BaseTest {

    @Description("Verify that user could add product to cart and values are correct")
    @TmsLink("ID-05")
    @Test
    public void addProductToCartTest() {
        SignInPage signInPage = homePage.navigateToSignInPage();
        signInPage.loginToAccount(ConfigProperties.getProperty("login"), ConfigProperties.getProperty("password"));
        homePage.getHeader().chooseCategoryMenu(WOMEN_CATEGORY, BOTTOMS_SUB_CATEGORY, PANTS_SUB_CATEGORY).selectRandomProduct().addProductToCart();
        homePage.getHeader().chooseCategoryMenu(MEN_CATEGORY, TOPS_SUB_CATEGORY, JACKETS_SUB_CATEGORY).selectRandomProduct().addProductToCart();
        homePage.getHeader().chooseCategoryMenu(WOMEN_CATEGORY, TOPS_SUB_CATEGORY, JACKETS_SUB_CATEGORY).selectRandomProduct().addProductToCart();
        CartPage cartPage = homePage.getHeader().clickCartButton();

        Assertions.assertAll(
                () -> Assertions.assertTrue(cartPage.isDisplayed(), "Element not found"),
                () -> Assertions.assertTrue(cartPage.checkOrderTotals(), "Values in order are wrong!")
        );
    }
}
