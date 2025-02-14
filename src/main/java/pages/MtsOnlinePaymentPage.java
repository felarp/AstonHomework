package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class MtsOnlinePaymentPage extends BasePage {

    private final By BLOCK_TITLE = By.xpath("//h2[contains(text(),'Онлайн пополнение')]");
    private final By PAYMENT_SYSTEM_LOGOS = By.cssSelector(".pay__partners");
    private final By DETAILS_LINK = By.cssSelector("a[href*='help'][href*='platezhey']");
    private final By PHONE_INPUT = By.id("connection-phone");
    private final By AMOUNT_INPUT = By.cssSelector("input.total_rub");
    private final By CONTINUE_BUTTON = By.xpath("//button[text()='Продолжить']");
    private final By MODAL_WINDOW = By.cssSelector(".payment-page__container");

    public MtsOnlinePaymentPage(WebDriver driver) {
        super(driver);
    }

    @Step("Получение заголовка блока")
    public String getBlockTitle() {
        String title = wait.until(ExpectedConditions.visibilityOfElementLocated(BLOCK_TITLE))
                .getText()
                .replace("\n", " ")
                .trim();
        assertThat(title).as("Заголовок блока должен быть 'Онлайн пополнение'").contains("Онлайн пополнение");
        return title;
    }

    @Step("Проверка наличия логотипов платёжных систем")
    public boolean hasPaymentSystemLogos() {
        List<WebElement> logos = driver.findElements(PAYMENT_SYSTEM_LOGOS);
        assertThat(logos).as("Логотипы платежных систем должны отображаться").isNotEmpty();
        return !logos.isEmpty();
    }

    @Step("Клик по ссылке 'Подробнее о сервисе' и проверка открытия деталей")
    public void clickAndVerifyServiceDetails() {
        wait.until(ExpectedConditions.elementToBeClickable(DETAILS_LINK)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(DETAILS_LINK));
        driver.navigate().back();
    }

    @Step("Заполнение номера телефона: {phoneNumber}")
    public void fillPhoneNumber(String phoneNumber) {
        WebElement phoneInput = wait.until(ExpectedConditions.visibilityOfElementLocated(PHONE_INPUT));
        phoneInput.clear();
        phoneInput.sendKeys(phoneNumber);
        assertThat(phoneInput.getAttribute("value")).as("Поле телефона должно содержать введенное значение").isEqualTo(phoneNumber);
    }

    @Step("Заполнение суммы: {amount}")
    public void fillAmount(String amount) {
        WebElement amountInput = wait.until(ExpectedConditions.visibilityOfElementLocated(AMOUNT_INPUT));
        amountInput.clear();
        amountInput.sendKeys(amount);
        assertThat(amountInput.getAttribute("value")).as("Поле суммы должно содержать введенное значение").isEqualTo(amount);
    }

    @Step("Нажатие на кнопку 'Продолжить' и ожидание появления модального окна")
    public void clickContinueAndWaitForModal() {
        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(CONTINUE_BUTTON));
        continueButton.click();
        WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(MODAL_WINDOW));
        assertThat(modal.isDisplayed()).as("Модальное окно должно появиться").isTrue();
    }
}



