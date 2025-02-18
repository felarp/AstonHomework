package pages;

import io.qameta.allure.Step;
import locators.MtsPaymentLocators;
import org.openqa.selenium.*;
import testdata.MtsPaymentTestData;

import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class MtsServicePage extends BasePage{
    public MtsServicePage(WebDriver driver) {
        super(driver);
    }

    @Step("Заполнение номера телефона: {phoneNumber}")
    public MtsServicePage fillPhoneNumber(String phoneNumber) {
        fillField(MtsPaymentLocators.PHONE_INPUT, phoneNumber);
        return this;
    }

    @Step("Заполнение суммы: {amount}")
    public MtsServicePage fillAmount(String amount) {
        fillField(MtsPaymentLocators.AMOUNT_INPUT, amount);
        return this;
    }

    @Step("Нажатие на кнопку 'Продолжить' и ожидание появления модального окна")
    public MtsServicePage clickContinueAndWaitForModal() {
        wait.until(elementToBeClickable(MtsPaymentLocators.CONTINUE_BUTTON)).click();
        return this;
    }

    @Step("Проверка деталей платежной страницы")
    public MtsServicePage verifyPaymentDetails() {
        switchToIframe();

        String expectedAmount = "Оплатить " + String.format("%.2f", Double.parseDouble(MtsPaymentTestData.AMOUNT)) + " BYN";
        String actualAmount = wait.until(visibilityOfElementLocated(MtsPaymentLocators.PAY_BUTTON)).getText();

        expectedAmount = expectedAmount.replace(",", ".");
        actualAmount = actualAmount.replace(",", ".");

        assertThat(actualAmount)
                .as("Кнопка оплаты должна отображать правильную сумму")
                .isEqualTo(expectedAmount);

        verifyElement(MtsPaymentLocators.PHONE_MODAL, "text", MtsPaymentTestData.PHONE_NUMBER, "Номер телефона в модальном окне");
        getInputValue(MtsPaymentLocators.CARD_NUMBER_INPUT, "placeholder", MtsPaymentTestData.CARD_NUMBER_PLACEHOLDER);
        getInputValue(MtsPaymentLocators.EXPIRY_DATE_INPUT, "placeholder", MtsPaymentTestData.EXPIRY_DATE_PLACEHOLDER);
        getInputValue(MtsPaymentLocators.CVC_INPUT, "placeholder", MtsPaymentTestData.CVC_PLACEHOLDER);
        getInputValue(MtsPaymentLocators.CARDHOLDER_NAME_INPUT, "placeholder", MtsPaymentTestData.CARDHOLDER_NAME_PLACEHOLDER);
        verifyElementsPresence(MtsPaymentLocators.PAYMENT_ICONS, "Иконки платёжных систем");

        return this;
    }

    @Step("Заполнение поля: {value}")
    private void fillField(By locator, String value) {
        WebElement input = wait.until(presenceOfElementLocated(locator));
        input.clear();
        input.sendKeys(value);
        assertThat(input.getAttribute("value"))
                .as("Поле должно содержать введенное значение")
                .isEqualTo(value);
    }

    @Step("Переключение в iframe")
    private void switchToIframe() {
        By IFRAME_LOCATOR = By.xpath("//iframe[@allowpaymentrequest and @class='bepaid-iframe']");
        wait.until(frameToBeAvailableAndSwitchToIt(IFRAME_LOCATOR));
    }

    @Step("Проверка элемента: {description}")
    private void verifyElement(By locator, String attribute, String expectedValue, String description) {
        WebElement element = wait.until(visibilityOfElementLocated(locator));
        String actualValue = "text".equals(attribute) ? element.getText() : element.getAttribute(attribute);
        assertThat(actualValue)
                .as(description)
                .contains(expectedValue);
    }

    @Step("Считывание значения из поля: {description}")
    public String getInputValue(By locator, String attribute, String description) {
        WebElement input = wait.until(visibilityOfElementLocated(locator));
        String value = input.getAttribute(attribute);
        assertThat(value)
                .as(description)
                .isNotNull();
        return value;
    }

    @Step("Проверка наличия элементов")
    private void verifyElementsPresence(By locator, String description) {
        assertThat(wait.until(presenceOfAllElementsLocatedBy(locator)))
                .as(description)
                .isNotEmpty();
    }
}




