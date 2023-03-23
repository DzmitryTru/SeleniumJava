import configuration.AllureConfiguration;
import helpers.ConfigProperties;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import page.IndexPage;
import page.ProductPage;
import page.SignInPage;
import page.WishListPage;

import static helpers.Const.*;

@ExtendWith(AllureConfiguration.class)

public class WishListTest extends BaseTest {

    @Description("Verify that user could add product to Wishlist")
    @TmsLink("ID-04")
    @Test
    public void addProductToWishListTest() {
        SignInPage signInPage = homePage.navigateToSignInPage();
        signInPage.loginToAccount(ConfigProperties.getProperty("login"), ConfigProperties.getProperty("password"));
        IndexPage indexPage = homePage.getHeader().chooseCategoryMenu(WOMEN_CATEGORY, BOTTOMS_SUB_CATEGORY, PANTS_SUB_CATEGORY);
        ProductPage productPage = indexPage.selectRandomProduct();
        String itemName = productPage.getItemName();
        WishListPage wishListPage = productPage.addProductToWishList();

        Assertions.assertAll(
                () -> Assertions.assertTrue(wishListPage.isDisplayed(), "WishList is not loaded"),
                () -> Assertions.assertEquals(itemName, wishListPage.getItemName(), "Item does not match the selected")
        );
    }

}
