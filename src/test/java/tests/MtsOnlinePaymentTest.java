package tests;

import locators.MtsPaymentLocators;
import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.MtsServicePage;



public class MtsOnlinePaymentTest extends BaseTest {
    @ParameterizedTest
    @ValueSource(strings = {"Услуги связи", "Домашний интернет", "Рассрочка", "Задолженность"})
    @DisplayName("Проверка отображения полей и их надписей для услуги")
    void shouldCheckFieldsForService(String serviceType) {
        paymentPage.checkFieldsForService(serviceType);
    }


    @ParameterizedTest
    @CsvSource({
            "(29)777-77-77, 10",
    })
    @DisplayName("Проверка заполнения телефона, суммы и появления модального окна")
    public void testMtsServicePage(String phoneNumber, String amount) {
        new MtsServicePage(driver)
                .fillFieldsAndSubmit(phoneNumber,amount)
                .verifyPaymentDetails();


    }
}


