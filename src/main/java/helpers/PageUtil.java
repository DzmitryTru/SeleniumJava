package helpers;

import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PageUtil {

    public static String extractNumberFromString(String value) {
        Pattern pattern = Pattern.compile("\\d+\\.?\\d{0,2}");
        Matcher matcher = pattern.matcher(value);
        if (matcher.find()) {
            return matcher.group();
        }
        return "";
    }

    public static boolean isDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception ignored) {
            return false;
        }
    }

    public static void clickRandomElement(List<WebElement> elements) {
        int countElements = elements.size();
        Random random = new Random();
        int randomElement = random.nextInt(countElements);
        WebElement webElement = elements.get(randomElement);
        if(isDisplayed(webElement)) {
            webElement.click();
        }
    }

}
