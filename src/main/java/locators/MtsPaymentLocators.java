package locators;

import org.openqa.selenium.By;
import java.util.Map;

public class MtsPaymentLocators {

    public static final By PHONE_INPUT = By.id("connection-phone");
    public static final By AMOUNT_INPUT = By.cssSelector("input.total_rub");
    public static final By CONTINUE_BUTTON = By.xpath("//div[@class='pay__form']//button[text()='Продолжить']");
    public static final By PAY_BUTTON = By.xpath("//button[contains(@class, 'colored')]");
    public static final By PHONE_MODAL = By.xpath("//span[contains(text(),'Оплата')]");
    public static final By PAYMENT_ICONS = By.xpath("//div[@class='icons-container ng-tns-c46-1']");
    public static final By CARDHOLDER_NAME_INPUT = By.xpath("//input[@formcontrolname='holder']");
    public static final By CARD_NUMBER_INPUT = By.xpath("//input[@formcontrolname='creditCard']");
    public static final By EXPIRY_DATE_INPUT = By.xpath("//input[@formcontrolname='expirationDate']");
    public static final By CVC_INPUT = By.xpath("//input[@name='verification_value' and @formcontrolname='cvc']");
    public static final By IFRAME_LOCATOR = By.xpath("//iframe[@allowpaymentrequest and @class='bepaid-iframe']");


    public static final Map<String, By> SERVICE_FIELDS = Map.of(
            "Услуги связи", By.id("connection-phone"),
            "Домашний интернет", By.id("internet-phone"),
            "Рассрочка", By.id("score-instalment"),
            "Задолженность", By.id("score-arrears")
    );

    public static final Map<String, By> EMAIL_FIELDS = Map.of(
            "Услуги связи", By.id("connection-email"),
            "Домашний интернет", By.id("internet-email"),
            "Рассрочка", By.id("instalment-email"),
            "Задолженность", By.id("arrears-email")
    );

    public static final Map<String, By> AMOUNT_FIELDS = Map.of(
            "Услуги связи", By.id("connection-sum"),
            "Домашний интернет", By.id("internet-sum"),
            "Рассрочка", By.id("instalment-sum"),
            "Задолженность", By.id("arrears-sum")
    );

}