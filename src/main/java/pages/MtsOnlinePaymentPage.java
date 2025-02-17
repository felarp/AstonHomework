package pages;

import io.qameta.allure.Step;
import locators.MtsOnlinePaymentLocators;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MtsOnlinePaymentPage extends BasePage{
    public MtsOnlinePaymentPage(WebDriver driver) {
        super(driver);
    }
    @Step("Выбор услуги: {serviceType}")
    public void selectServiceType(String serviceType) {

        WebElement dropdownButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("button.select__header")
        ));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dropdownButton);
        dropdownButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul.select__list")));

        List<WebElement> options = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.cssSelector("ul.select__list li")
        ));
        for (WebElement option : options) {
            if (option.getText().trim().equals(serviceType)) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", option);
                option.click();
                return;
            }
        }
        throw new NoSuchElementException("Опция '" + serviceType + "' не найдена!");
    }

    @Step("Проверка полей и их надписей для услуги: {serviceType}")
    public void checkFieldsForService(String serviceType) {
        selectServiceType(serviceType);

        checkField(MtsOnlinePaymentLocators.SERVICE_FIELDS.get(serviceType), MtsOnlinePaymentLocators.EXPECTED_PLACEHOLDERS.get(serviceType));
        checkField(MtsOnlinePaymentLocators.EMAIL_FIELDS.get(serviceType), MtsOnlinePaymentLocators.EXPECTED_PLACEHOLDERS.get("Email"));
        checkField(MtsOnlinePaymentLocators.AMOUNT_FIELDS.get(serviceType), MtsOnlinePaymentLocators.EXPECTED_PLACEHOLDERS.get("Сумма"));
    }

    private void checkField(By locator, String expectedPlaceholder) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        assertThat(element.isDisplayed()).as("Поле " + locator + " не отображается").isTrue();
        assertThat(element.getAttribute("placeholder")).as("Некорректный placeholder для " + locator).isEqualTo(expectedPlaceholder);
    }
}


