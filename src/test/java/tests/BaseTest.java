package tests;

import configuration.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    protected WebDriver driver;

    @BeforeAll
    static void setUpClass() {
        WebDriverManager.setup();
    }

    @BeforeEach
    void setUp() {
        driver = WebDriverManager.getDriver();
        driver.get("https://mts.by");
    }
}

