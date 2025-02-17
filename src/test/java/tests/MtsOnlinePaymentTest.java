package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class MtsOnlinePaymentTest extends BaseTest {
    @ParameterizedTest
    @ValueSource(strings = {"Услуги связи", "Домашний интернет", "Рассрочка", "Задолженность"})
    @DisplayName("Проверка отображения полей и их надписей для услуги")
    void shouldCheckFieldsForService(String serviceType) {
        paymentPage.checkFieldsForService(serviceType);
    }
}