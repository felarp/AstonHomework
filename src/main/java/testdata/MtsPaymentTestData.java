package testdata;

import java.util.Map;

public class MtsPaymentTestData {
    public static final String CARD_NUMBER_PLACEHOLDER = "Номер карты";
    public static final String EXPIRY_DATE_PLACEHOLDER = "Срок действия";
    public static final String CVC_PLACEHOLDER = "CVC";
    public static final String PHONE_NUMBER = "375297777777";
    public static final String AMOUNT = "10.00";
    public static final String CARDHOLDER_NAME_PLACEHOLDER = "Имя держателя";

    public static final Map<String, String> EXPECTED_PLACEHOLDERS = Map.of(
            "Услуги связи", "Номер телефона",
            "Домашний интернет", "Номер абонента",
            "Рассрочка", "Номер счета на 44",
            "Задолженность", "Номер счета на 2073",
            "Email", "E-mail для отправки чека",
            "Сумма", "Сумма"
    );
}
