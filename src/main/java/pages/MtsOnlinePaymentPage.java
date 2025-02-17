package pages;

import io.qameta.allure.Step;
import locators.MtsPaymentLocators;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import testdata.MtsPaymentTestData;

import java.util.List;


public class MtsOnlinePaymentPage extends BasePage{
    public MtsOnlinePaymentPage(WebDriver driver) {
        super(driver);
    }
    @Step("Выбор услуги: {serviceType}")
    public void selectServiceType(String serviceType) {
        WebElement dropdownButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.select__header")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dropdownButton);
        dropdownButton.click();

        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("ul.select__list li")));
        options.stream()
                .filter(option -> option.getText().trim().equals(serviceType))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Опция '" + serviceType + "' не найдена!"))
                .click();
    }
    @Step("Проверка полей и их надписей для услуги: {serviceType}")
    public void checkFieldsForService(String serviceType) {
        selectServiceType(serviceType);

        assertField(MtsPaymentLocators.SERVICE_FIELDS.get(serviceType), MtsPaymentTestData.EXPECTED_PLACEHOLDERS.get(serviceType));
        assertField(MtsPaymentLocators.EMAIL_FIELDS.get(serviceType), MtsPaymentTestData.EXPECTED_PLACEHOLDERS.get("Email"));
        assertField(MtsPaymentLocators.AMOUNT_FIELDS.get(serviceType), MtsPaymentTestData.EXPECTED_PLACEHOLDERS.get("Сумма"));
    }

    private void assertField(By locator, String expectedPlaceholder) {
        Assertions.assertThat(wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getAttribute("placeholder"))
                .as("Некорректный placeholder для " + locator)
                .isEqualTo(expectedPlaceholder);
    }
}


