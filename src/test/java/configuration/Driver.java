package configuration;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.api.internal.StringUtils;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class Driver {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private static final String BROWSER = System.getProperty("browser", "chrome");
    private static final String REMOTE = System.getProperty("remote");

    private static final String URL = "https://dmitrytrunevsky:6a8d9e10-2ce0-462a-827b-b4df3602db6c@ondemand.eu-central-1.saucelabs.com:443/wd/hub";

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            driver.set(createDriver());
        }
        return driver.get();
    }

    private static WebDriver createDriver() {
        if (!StringUtils.isNullOrEmpty(REMOTE)) {
            return createRemote();
        }
        return createLocalDriver();
    }

    private static WebDriver createLocalDriver() {
        WebDriver webDriver;
        switch (BROWSER) {
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver();
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                webDriver = new FirefoxDriver();
            }
            default -> throw new RuntimeException("Please check your browser name");
        }
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        webDriver.manage().window().maximize();
        return webDriver;
    }

    private static WebDriver createRemote() {
        try {
            return new RemoteWebDriver(new URL(URL), getRemoteCapabilities());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private static MutableCapabilities getRemoteCapabilities() {
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setCapability("platformName", "Windows 10");
        browserOptions.setCapability("browserVersion", "105");
        Map<String, Object> sauceOptions = new HashMap<>();
        browserOptions.setCapability("sauce:options", sauceOptions);

        return browserOptions;
    }

    public static void tearDown() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
