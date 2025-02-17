package locators;

import org.openqa.selenium.By;
import java.util.Map;

public class MtsOnlinePaymentLocators {

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

    public static final Map<String, String> EXPECTED_PLACEHOLDERS = Map.of(
            "Услуги связи", "Номер телефона",
            "Домашний интернет", "Номер абонента",
            "Рассрочка", "Номер счета на 44",
            "Задолженность", "Номер счета на 2073",
            "Email", "E-mail для отправки чека",
            "Сумма", "Сумма"
    );
}