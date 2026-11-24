import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class MtsTest {
    WebDriver driver;
    PaymentPage paymentPage;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://mts.by");

        try {
            driver.findElement(org.openqa.selenium.By.xpath("//button[contains(text(), 'ПРИНЯТЬ')]")).click();
        } catch (Exception e) {}

        paymentPage = new PaymentPage(driver);
    }

    @Test
    public void testBlockTitle() {
        String actualText = paymentPage.getBlockTitle();
        org.junit.jupiter.api.Assertions.assertEquals("ОНЛАЙН ПОПОЛНЕНИЕ БЕЗ КОМИССИИ", actualText);
    }

    @ParameterizedTest
    @CsvSource({
            "Услуги связи, Сумма",
            "Домашний интернет, Сумма",
            "Рассрочка, Сумма",
            "Задолженность, Сумма"
    })
    public void testPlaceholdersForAllServices(String serviceName, String expectedPlaceholder) {
        paymentPage.selectService(serviceName);

        String actualPlaceholder = paymentPage.getAmountPlaceholder();
        System.out.println("Услуга: " + serviceName + " | Плейсхолдер: " + actualPlaceholder);
        org.junit.jupiter.api.Assertions.assertEquals(expectedPlaceholder, actualPlaceholder);
    }


    @Test
    public void testForm() {
        paymentPage.fillPhoneNumber("297777777");
        paymentPage.fillAmount("100");
        paymentPage.fillEmail("test@test.com");

        paymentPage.clickContinue();

        boolean isVisible = paymentPage.arePaymentsMethodsVisible();
        org.junit.jupiter.api.Assertions.assertTrue(isVisible, "Кнопки оплаты не появились!");

        System.out.println("Телефон в окне: " + paymentPage.getModalPhoneText());
        System.out.println("Сумма в окне: " + paymentPage.getModalAmountText());

        int logosCount = paymentPage.countPaymentLogos();
        System.out.println("Найдено логотипов: " + logosCount);
        org.junit.jupiter.api.Assertions.assertTrue(logosCount > 0, "Логотипы не найдены!");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}