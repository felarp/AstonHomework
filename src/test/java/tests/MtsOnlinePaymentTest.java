package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



public class MtsOnlinePaymentTest extends BaseTest {
    @Test
    @DisplayName("Проверка отображения полей и их надписей для услуги 'Услуги связи'")
    void shouldCheckFieldsForCommunicationService() {
        paymentPage.checkFieldsForService("Услуги связи");
    }

    @Test
    @DisplayName("Проверка отображения полей и их надписей для услуги 'Домашний интернет'")
    void shouldCheckFieldsForHomeInternetService() {
        paymentPage.checkFieldsForService("Домашний интернет");
    }

    @Test
    @DisplayName("Проверка отображения полей и их надписей для услуги 'Рассрочка'")
    void shouldCheckFieldsForInstalmentService() {
        paymentPage.checkFieldsForService("Рассрочка");
    }

    @Test
    @DisplayName("Проверка отображения полей и их надписей для услуги 'Задолженность'")
    void shouldCheckFieldsForArrearsService() {
        paymentPage.checkFieldsForService("Задолженность");
    }
}