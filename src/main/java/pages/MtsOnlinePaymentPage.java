package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MtsOnlinePaymentPage extends BasePage {

    public MtsOnlinePaymentPage(WebDriver driver) {
        super(driver);
    }

    private String getElementText(String xpath) {
        return driver.findElement(By.xpath(xpath)).getText();
    }

    private void interactWithElement(String xpath, String value) {
        WebElement element = driver.findElement(By.xpath(xpath));
        if (value != null) {
            element.sendKeys(value);
        } else {
            element.click();
        }
    }
    public String getBlockTitle() {
        return getElementText(XpathSelectors.BLOCK_TITLE);
    }

    public int getPaymentSystemLogosCount() {
        return driver.findElements(By.xpath(XpathSelectors.PAYMENT_SYSTEM_LOGOS)).size();
    }

    public void clickDetailsLink() {
        interactWithElement(XpathSelectors.DETAILS_LINK, null);
    }

    public boolean isServiceDetailsOpened() {
        return driver.getCurrentUrl().contains("details");
    }

    public void fillPhoneNumberAndAmountAndContinue(String phoneNumber, String amount) {
        interactWithElement(XpathSelectors.PHONE_INPUT, phoneNumber);
        interactWithElement(XpathSelectors.AMOUNT_INPUT, amount);
        interactWithElement(XpathSelectors.CONTINUE_BUTTON, null);
    }

   // public boolean isConfirmationStepDisplayed() {
      // return !driver.findElements(By.xpath(XpathSelectors.CONFIRMATION_STEP)).isEmpty();
    }


