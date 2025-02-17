package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    private static final By COOKIE_ACCEPT_BUTTON = By.id("cookie-agree");

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void acceptCookiesIfPresent() {
        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(COOKIE_ACCEPT_BUTTON));
        button.click();
    }
}