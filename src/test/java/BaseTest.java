import configuration.Driver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import page.HomePage;

public class BaseTest {

    protected HomePage homePage;
    protected WebDriver driver;

    public BaseTest() {
        driver = Driver.getDriver();
    }

    @AfterAll
    public static void closeBrowser() {
        Driver.tearDown();
    }

    @BeforeEach
    public void startBrowser() {
        homePage = new HomePage(driver);
        homePage.navigateTo();
    }

}