package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @FindBy(id = "cookie-agree") WebElement cookieAcceptButton;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void acceptCookiesIfPresent() {
        try {
            if (cookieAcceptButton.isDisplayed()) {
                cookieAcceptButton.click();
            }
        } catch (Exception ignored) {}
    }
}