package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class MtsOnlinePaymentPage extends BasePage {

    private final By BLOCK_TITLE = By.xpath("//h2[contains(text(),'Онлайн пополнение')]");
    private final By PAYMENT_SYSTEM_LOGOS = By.xpath("//div[@class='pay__partners']");
    private final By DETAILS_LINK = By.cssSelector("a[href*='help'][href*='platezhey']");
    private final By PHONE_INPUT = By.xpath("//input[@id='connection-phone']");
    private final By AMOUNT_INPUT = By.xpath("//input[@class='total_rub']");
    private final By CONTINUE_BUTTON = By.xpath("//button[text()='Продолжить']");
    private final By SUCCESS_ELEMENT_XPATH = By.xpath("//div[@class='payment-page__container']");

    public MtsOnlinePaymentPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Step("Получение текста элемента: {locator}")
    private String getElementText(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator))
                .getText()
                .replace("\n", " ")
                .trim();
    }

    @Step("Взаимодействие с элементом: {locator}")
    private void interactWithElement(By locator, String value) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        if (value != null) {
            element.clear();
            element.sendKeys(value);
            assertThat(element.getAttribute("value")).as("Поле ввода должно содержать введенное значение").isEqualTo(value);
        } else {
            element.click();
        }
    }

    @Step("Получение заголовка блока")
    public String getBlockTitle() {
        String title = getElementText(BLOCK_TITLE);
        assertThat(title).as("Заголовок блока должен быть не пустым").isNotEmpty();
        return title;
    }

    @Step("Проверка наличия логотипов платежных систем")
    public boolean hasPaymentSystemLogos() {
        List<WebElement> logos = driver.findElements(PAYMENT_SYSTEM_LOGOS);
        assertThat(logos).as("Логотипы платежных систем должны быть отображены").isNotEmpty();
        return !logos.isEmpty();
    }

    @Step("Клик по ссылке 'Подробнее о сервисе' и проверка открытия деталей")
    public void clickAndVerifyServiceDetails(WebDriver driver) {
        interactWithElement(DETAILS_LINK, null);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement detailsLink = driver.findElement(DETAILS_LINK);
        boolean isOpened = wait.until(ExpectedConditions.visibilityOf(detailsLink)).isDisplayed();
        if (isOpened) {
            driver.navigate().back();
        } else {
            throw new AssertionError("Детали сервиса не открылись.");
        }
    }

//    @Step("Проверка выбора услуги: {serviceName}")
//    public void selectService(String serviceName) {
//        WebElement selectedOption = wait.until(ExpectedConditions.visibilityOfElementLocated(SERVICE_DROPDOWN));
//        String selectedText = selectedOption.getText();
//        assertThat(selectedText)
//                .as("Выбранная услуга должна быть: " + serviceName)
//                .isEqualTo(serviceName);
//
//    }

    @Step("Заполнение номера телефона: {phoneNumber}")
    public void fillPhoneNumber(String phoneNumber) {
        interactWithElement(PHONE_INPUT, phoneNumber);
    }

    @Step("Заполнение суммы: {amount}")
    public void fillAmount(String amount) {
        interactWithElement(AMOUNT_INPUT, amount);
    }

    //
    @Step("Проверка активности кнопки 'Продолжить'")
    public void checkContinueButtonState() {
        WebElement continueButton = wait.until(ExpectedConditions.presenceOfElementLocated(CONTINUE_BUTTON));
        assertThat(continueButton.isEnabled())
                .as("Окно открылось")
                .isTrue();
    }
}




