package locators;

import org.openqa.selenium.By;
import java.util.Map;

public class MtsPaymentLocators {

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