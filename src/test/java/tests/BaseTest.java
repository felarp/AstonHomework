package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MtsOnlinePaymentPage;


public class BaseTest {
    protected WebDriver driver;
    protected MtsOnlinePaymentPage paymentPage;

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mts.by");
        paymentPage = new MtsOnlinePaymentPage(driver);
        paymentPage.acceptCookiesIfPresent();
    }

    @AfterEach
    void tearDown() {
        if (driver != null) driver.quit();
    }
}
