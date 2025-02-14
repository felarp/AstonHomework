package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MtsOnlinePaymentTest extends BaseTest {
    @Test
    @DisplayName("Проверка блока 'Онлайн пополнение без комиссии'")
    public void testOnlinePaymentBlock() {
        assertThat(paymentPage.getBlockTitle()).isEqualTo("Онлайн пополнение без комиссии");
        assertThat(paymentPage.hasPaymentSystemLogos()).isTrue();
        paymentPage.clickAndVerifyServiceDetails();
        paymentPage.fillPhoneNumber("(29)777-77-77");
        paymentPage.fillAmount("10");
        paymentPage.clickContinueAndWaitForModal();
    }
}
