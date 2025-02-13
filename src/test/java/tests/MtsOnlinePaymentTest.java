package tests;

import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MtsOnlinePaymentTest extends BaseTest {
    @Test
    @DisplayName("Проверка блока 'Онлайн пополнение без комиссии'")
    @Story("Проверка функциональности блока")

    public void testOnlinePaymentBlock() {

        String blockTitle = paymentPage.getBlockTitle();
        assertThat(blockTitle).as("Название блока должно быть 'Онлайн пополнение'").isEqualTo("Онлайн пополнение без комиссии");


        boolean hasLogos = paymentPage.hasPaymentSystemLogos();
        assertThat(hasLogos).as("Логотипы платежных систем должны быть отображены").isTrue();


        paymentPage.clickAndVerifyServiceDetails(driver);
        assertThat(driver.getCurrentUrl()).as (("После клика по ссылке, должно быть возвращение на главную страницу"));


        //paymentPage.selectService("Услуги связи");


        paymentPage.fillPhoneNumber("(29)777-77-77");
        paymentPage.fillAmount("10");
        paymentPage.checkContinueButtonState();
    }
}
