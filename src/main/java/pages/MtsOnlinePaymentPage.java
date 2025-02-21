package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import testdata.MtsPaymentTestData;

import static org.assertj.core.api.Assertions.assertThat;

public class MtsOnlinePaymentPage extends BasePage{

    @FindBy(css = "button.select__header") WebElement dropdownButton;
    @FindBy(xpath = "//option[@data-open='pay-connection']") WebElement connectionOption;
    @FindBy(xpath = "//option[@data-open='pay-internet']") WebElement internetOption;
    @FindBy(xpath = "//option[@data-open='pay-instalment']")  WebElement instalmentOption;
    @FindBy(xpath = "//option[@data-open='pay-arrears']") WebElement arrearsOption;
    @FindBy(id = "connection-phone") WebElement connectionPhoneInput;
    @FindBy(id = "connection-sum") WebElement connectionSumInput;
    @FindBy(id = "connection-email") WebElement connectionEmailInput;
    @FindBy(id = "internet-phone") WebElement internetPhoneInput;
    @FindBy(id = "internet-sum") WebElement internetSumInput;
    @FindBy(id = "internet-email") WebElement internetEmailInput;
    @FindBy(id = "score-instalment") WebElement instalmentPhoneInput;
    @FindBy(id = "instalment-sum") WebElement instalmentSumInput;
    @FindBy(id = "instalment-email") WebElement instalmentEmailInput;
    @FindBy(id = "score-arrears") WebElement arrearsPhoneInput;
    @FindBy(id = "arrears-sum") WebElement arrearsSumInput;
    @FindBy(id = "arrears-email") WebElement arrearsEmailInput;

    public MtsOnlinePaymentPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("Выбор услуги: {serviceType}")
    public void selectServiceType(String serviceType) {
        wait.until(ExpectedConditions.elementToBeClickable(dropdownButton)).click();

        switch (serviceType) {
            case "Услуги связи":
                wait.until(ExpectedConditions.elementToBeClickable(connectionOption)).click();
                break;
            case "Домашний интернет":
                wait.until(ExpectedConditions.elementToBeClickable(internetOption)).click();
                break;
            case "Рассрочка":
                wait.until(ExpectedConditions.elementToBeClickable(instalmentOption)).click();
                break;
            case "Задолженность":
                wait.until(ExpectedConditions.elementToBeClickable(arrearsOption)).click();
                break;
            default:
                throw new NoSuchElementException("Опция '" + serviceType + "' не найдена!");
        }
    }

    @Step("Проверка полей и их надписей для услуги: {serviceType}")
    public void checkFieldsForService(String serviceType) {
        selectServiceType(serviceType);

        switch (serviceType) {
            case "Услуги связи":
                assertField(connectionPhoneInput, MtsPaymentTestData.EXPECTED_PLACEHOLDERS.get("Услуги связи"));
                assertField(connectionEmailInput, MtsPaymentTestData.EXPECTED_PLACEHOLDERS.get("Email"));
                assertField(connectionSumInput, MtsPaymentTestData.EXPECTED_PLACEHOLDERS.get("Сумма"));
                break;
            case "Домашний интернет":
                assertField(internetPhoneInput, MtsPaymentTestData.EXPECTED_PLACEHOLDERS.get("Домашний интернет"));
                assertField(internetEmailInput, MtsPaymentTestData.EXPECTED_PLACEHOLDERS.get("Email"));
                assertField(internetSumInput, MtsPaymentTestData.EXPECTED_PLACEHOLDERS.get("Сумма"));
                break;
            case "Рассрочка":
                assertField(instalmentPhoneInput, MtsPaymentTestData.EXPECTED_PLACEHOLDERS.get("Рассрочка"));
                assertField(instalmentEmailInput, MtsPaymentTestData.EXPECTED_PLACEHOLDERS.get("Email"));
                assertField(instalmentSumInput, MtsPaymentTestData.EXPECTED_PLACEHOLDERS.get("Сумма"));
                break;
            case "Задолженность":
                assertField(arrearsPhoneInput, MtsPaymentTestData.EXPECTED_PLACEHOLDERS.get("Задолженность"));
                assertField(arrearsEmailInput, MtsPaymentTestData.EXPECTED_PLACEHOLDERS.get("Email"));
                assertField(arrearsSumInput, MtsPaymentTestData.EXPECTED_PLACEHOLDERS.get("Сумма"));
                break;
            default:
                throw new IllegalArgumentException("Неизвестный тип услуги: " + serviceType);
        }
    }
    @Step("Проверка placeholder для поля")
    private void assertField(WebElement element, String expectedPlaceholder) {
        assertThat(element.getAttribute("placeholder"))
                .as("Некорректный placeholder для " + element)
                .isEqualTo(expectedPlaceholder);
    }
}









