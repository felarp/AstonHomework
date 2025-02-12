package pages;

public class XpathSelectors {
    static final String BLOCK_TITLE = "//h2[contains(text(),'Онлайн пополнение')]";
    static final String PAYMENT_SYSTEM_LOGOS = "//div[@class='pay__partners']";
    static final String DETAILS_LINK = "//a[text()='Подробнее о сервисе']";
    static final String PHONE_INPUT = "//input[@id='connection-phone']";
    static final String AMOUNT_INPUT = "//input[@class='total_rub']";
    static final String CONTINUE_BUTTON = "//button[text()='Продолжить']";
    // static final String CONFIRMATION_STEP = "//div[contains(@class, 'confirmation')]";
}
