package testdata;

import java.util.Map;

public class MtsPaymentTestData {
    public static final Map<String, String> EXPECTED_PLACEHOLDERS = Map.of(
            "Услуги связи", "Номер телефона",
            "Домашний интернет", "Номер абонента",
            "Рассрочка", "Номер счета на 44",
            "Задолженность", "Номер счета на 2073",
            "Email", "E-mail для отправки чека",
            "Сумма", "Сумма"
    );
}
