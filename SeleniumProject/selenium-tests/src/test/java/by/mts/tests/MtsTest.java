package by.mts.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import by.mts.tests.pages.CardPaymentDialog;
import by.mts.tests.pages.MtsHomePage;
import java.net.URI;
import java.time.Duration;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

class MtsTest {
    private static final String PHONE = "297777777";
    private static final String AMOUNT = "10.00";

    private WebDriver driver;
    private MtsHomePage home;

    @BeforeEach
    void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        options.addArguments("--headless=new", "--window-size=1440,1000");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(45));
        home = new MtsHomePage(driver);
        home.open();
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void opensHomePageWithPaymentBlock() {
        assertTrue(home.pageTitle().contains("МТС"), "Заголовок страницы МТС");
        assertEquals("ОНЛАЙН ПОПОЛНЕНИЕ БЕЗ КОМИССИИ", home.paymentTitle());
    }

    @Test
    void displaysPaymentPartnerLogos() {
        List<String> logos = home.partnerLogos();
        assertTrue(logos.containsAll(List.of("Visa", "MasterCard", "Белкарт")),
                "Логотипы в блоке пополнения: " + logos);
    }

    @Test
    void opensServiceDetails() {
        URI details = URI.create(home.openServiceDetails());
        assertEquals("/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/", details.getPath());
    }

    @Test
    void mobileFormAppliesPhoneMaskAndExposesPaymentMethods() {
        home.enterPhone(PHONE);

        assertEquals("(29)777-77-77", home.enteredPhone());
        assertTrue(home.isAmountRequired(), "Сумма обязательна");
        assertEquals("КРОК", home.krokButtonLabel());
        assertEquals("БАНКОВСКАЯ КАРТА", home.cardButtonLabel());
    }

    @ParameterizedTest(name = "Подсказки полей: {0}")
    @CsvSource({
            "Услуги связи, Номер телефона",
            "Домашний интернет, Номер абонента",
            "Рассрочка, Номер счета на 44",
            "Задолженность, Номер счета на 2073"
    })
    void displaysPlaceholdersForEachService(String service, String firstPlaceholder) {
        home.selectService(service);

        List<String> expected = List.of(firstPlaceholder, "Сумма", "E-mail для отправки чека");
        assertEquals(expected, home.placeholders());
    }

    @Test
    void opensCardPaymentDialogWithEnteredPhoneAndAmount() {
        home.enterPhone(PHONE);
        home.enterAmount(AMOUNT);
        CardPaymentDialog dialog = home.continueToCardPayment();
        String expectedAmount = AMOUNT + " BYN";

        assertEquals(expectedAmount, dialog.amount());
        assertEquals("Оплатить " + expectedAmount, dialog.payButtonText());
        assertEquals("Оплата: Услуги связи Номер:375" + PHONE, dialog.paymentDescription());
        assertEquals(List.of("Номер карты", "Срок действия", "CVC", "Имя и фамилия на карте"),
                dialog.cardFieldLabels());
        assertEquals("ММ / ГГ", dialog.expiryPlaceholder());
        assertTrue(dialog.isPaymentSystemLogoVisible("visa"), "Иконка Visa");
        assertTrue(dialog.isPaymentSystemLogoVisible("mastercard"), "Иконка Mastercard");
        assertTrue(dialog.isPaymentSystemLogoVisible("belkart"), "Иконка Белкарт");
    }
}
