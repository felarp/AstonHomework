package pages;

import io.qameta.allure.Step;
import locators.MtsPaymentLocators;
import org.openqa.selenium.*;
import testdata.MtsPaymentTestData;

import static locators.MtsPaymentLocators.IFRAME_LOCATOR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class MtsServicePage extends BasePage {
    public MtsServicePage(WebDriver driver) {
        super(driver);
    }

    @Step("Заполнение полей и нажание на кнопку 'Продолжить'")
    public MtsServicePage fillFieldsAndSubmit(String phoneNumber, String amount) {
        fillField(MtsPaymentLocators.PHONE_INPUT, phoneNumber);
        fillField(MtsPaymentLocators.AMOUNT_INPUT, amount);
        clickAndWaitForModal(MtsPaymentLocators.CONTINUE_BUTTON);
        return this;
    }

    @Step("Нажатие на кнопку и ожидание появления модального окна")
    private void clickAndWaitForModal(By locator) {
        wait.until(elementToBeClickable(locator)).click();
    }

    @Step("Проверка деталей платежной страницы")
    public MtsServicePage verifyPaymentDetails() {
        switchToIframe();

        String expectedAmount = String.format("Оплатить %.2f BYN", Double.parseDouble(MtsPaymentTestData.AMOUNT)).replace(",", ".");
        String actualAmount = wait.until(visibilityOfElementLocated(MtsPaymentLocators.PAY_BUTTON)).getText().replace(",", ".");

        assertThat(actualAmount).as("Кнопка оплаты должна отображать правильную сумму").isEqualTo(expectedAmount);
        verifyElement(MtsPaymentLocators.PHONE_MODAL, "text", MtsPaymentTestData.PHONE_NUMBER, "Номер телефона в модальном окне");
        verifyInputPlaceholders();
        verifyElementsPresence(MtsPaymentLocators.PAYMENT_ICONS, "Иконки платёжных систем");

        return this;
    }


    @Step("Проверка текстовых значений в полях ввода")
    private void verifyInputPlaceholders() {
        getInputValue(MtsPaymentLocators.CARD_NUMBER_INPUT, "placeholder", MtsPaymentTestData.CARD_NUMBER_PLACEHOLDER);
        getInputValue(MtsPaymentLocators.EXPIRY_DATE_INPUT, "placeholder", MtsPaymentTestData.EXPIRY_DATE_PLACEHOLDER);
        getInputValue(MtsPaymentLocators.CVC_INPUT, "placeholder", MtsPaymentTestData.CVC_PLACEHOLDER);
        getInputValue(MtsPaymentLocators.CARDHOLDER_NAME_INPUT, "placeholder", MtsPaymentTestData.CARDHOLDER_NAME_PLACEHOLDER);
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




