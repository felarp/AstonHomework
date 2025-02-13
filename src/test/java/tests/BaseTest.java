package tests;

import configuration.WebDriverUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import pages.MtsOnlinePaymentPage;


public class BaseTest {
    protected WebDriver driver;
    protected MtsOnlinePaymentPage paymentPage;

    @BeforeEach
    void setUp() {
        driver = WebDriverUtil.createDriver();
        driver.get("https://mts.by");
        paymentPage = new MtsOnlinePaymentPage(driver);
        paymentPage.acceptCookiesIfPresent();
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
