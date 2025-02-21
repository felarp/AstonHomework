package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import testdata.MtsPaymentTestData;
import static org.assertj.core.api.Assertions.assertThat;

public class MtsServicePage extends BasePage {

    @FindBy(id = "connection-phone") WebElement phoneInput;
    @FindBy(css = "input.total_rub") WebElement amountInput;
    @FindBy(xpath = "//div[@class='pay__form']//button[text()='Продолжить']") WebElement continueButton;
    @FindBy(xpath = "//button[contains(@class, 'colored')]") WebElement payButton;
    @FindBy(xpath = "//span[contains(text(),'Оплата')]") WebElement phoneModal;
    @FindBy(xpath = "//div[@class='icons-container ng-tns-c46-1']") WebElement paymentIcons;
    @FindBy(xpath = "//input[@formcontrolname='holder']") WebElement cardholderNameInput;
    @FindBy(xpath = "//input[@formcontrolname='creditCard']") WebElement cardNumberInput;
    @FindBy(xpath = "//input[@formcontrolname='expirationDate']") WebElement expiryDateInput;
    @FindBy(xpath = "//input[@name='verification_value' and @formcontrolname='cvc']") WebElement cvcInput;
    @FindBy(xpath = "//iframe[@allowpaymentrequest and @class='bepaid-iframe']") WebElement iframe;

    public MtsServicePage(WebDriver driver) {
        super(driver);
    }
    @Step("Заполнение полей телефона: {phoneNumber} и суммы: {amount}, затем нажатие на кнопку 'Продолжить'")
    public MtsServicePage fillFieldsAndSubmit(String phoneNumber, String amount) {
        fillField(phoneInput, phoneNumber);
        fillField(amountInput, amount);
        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
        return this;
    }
    @Step("Проверка деталей платежа")
    public MtsServicePage verifyPaymentDetails() {
        switchToIframe();
        String expectedAmount = String.format("Оплатить %.2f BYN", Double.parseDouble(MtsPaymentTestData.AMOUNT)).replace(",", ".");
        String actualAmount = wait.until(ExpectedConditions.visibilityOf(payButton)).getText().replace(",", ".");
        assertThat(actualAmount).as("Кнопка оплаты должна отображать правильную сумму").isEqualTo(expectedAmount);
        verifyElement(phoneModal, "text", MtsPaymentTestData.PHONE_NUMBER, "Номер телефона в модальном окне");
        verifyInputPlaceholders();
        verifyElementsPresence(paymentIcons, "Иконки платёжных систем");

        return this;
    }
    @Step("Проверка плейсхолдеров полей ввода")
    private void verifyInputPlaceholders() {
        getInputValue(cardNumberInput, "placeholder", MtsPaymentTestData.CARD_NUMBER_PLACEHOLDER);
        getInputValue(expiryDateInput, "placeholder", MtsPaymentTestData.EXPIRY_DATE_PLACEHOLDER);
        getInputValue(cvcInput, "placeholder", MtsPaymentTestData.CVC_PLACEHOLDER);
        getInputValue(cardholderNameInput, "placeholder", MtsPaymentTestData.CARDHOLDER_NAME_PLACEHOLDER);
    }
    @Step("Заполнение поля {input} значением {value}")
    private void fillField(WebElement input, String value) {
        input.clear();
        input.sendKeys(value);
        assertThat(input.getAttribute("value"))
                .as("Поле должно содержать введенное значение")
                .isEqualTo(value);
    }
    @Step("Переключение в iframe для ввода данных платежа")
    private void switchToIframe() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframe));
    }
    @Step("Проверка элемента {element}")
    private void verifyElement(WebElement element, String attribute, String expectedValue, String description) {
        String actualValue = "text".equals(attribute) ? element.getText() : element.getAttribute(attribute);
        assertThat(actualValue)
                .as(description)
                .contains(expectedValue);
    }
    @Step("Получение значения из поля ввода {input}")
    private String getInputValue(WebElement input, String attribute, String description) {
        String value = input.getAttribute(attribute);
        assertThat(value)
                .as(description)
                .isNotNull();
        return value;
    }
    @Step("Проверка наличия элемента {element}")
    private void verifyElementsPresence(WebElement element, String description) {
        assertThat(element.isDisplayed())
                .as(description)
                .isTrue();
    }
}




