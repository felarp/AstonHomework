package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.MtsOnlinePaymentPage;

import static org.assertj.core.api.Assertions.assertThat;

public class MtsOnlinePaymentTest extends BaseTest {

    private MtsOnlinePaymentPage paymentPage;

    @BeforeEach
    void setUp() {
        paymentPage = new MtsOnlinePaymentPage(driver);
    }

    @Test
    void shouldHaveCorrectBlockTitle() {
        assertThat(paymentPage.getBlockTitle()).isEqualTo("Онлайн пополнение без комиссии");
    }

    @Test
    void shouldDisplayPaymentSystemLogos() {
        assertThat(paymentPage.getPaymentSystemLogosCount()).isGreaterThan(0);
    }

    @Test
    void shouldOpenServiceDetailsLink() {
        paymentPage.clickDetailsLink();
        assertThat(paymentPage.isServiceDetailsOpened()).isTrue();
    }

    @Test
    void shouldProceedWithValidPhoneNumber() {
        paymentPage.fillPhoneNumberAndAmountAndContinue("297777777", "5");
        assertThat(paymentPage.isConfirmationStepDisplayed()).isTrue();
    }
}


