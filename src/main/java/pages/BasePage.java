package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    private static final String COOKIE_ACCEPT_BUTTON = "//button[@id='cookie-agree']";

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void acceptCookiesIfPresent() {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);

        try {
            wait.until(driver -> {
                List<WebElement> cookieButtons = driver.findElements(By.xpath(COOKIE_ACCEPT_BUTTON));
                if (!cookieButtons.isEmpty() && cookieButtons.get(0).isDisplayed()) {
                    cookieButtons.get(0).click();
                    return true;
                }
                return false;
            });
        } catch (TimeoutException e) {

            System.out.println("Окно с куками не появилось.");
        }
    }
}




