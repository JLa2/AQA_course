import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.support.ui.ExpectedCondition;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MtsTest {
    WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://mts.by");
    }



        @Test
        public void testOpenSite () {
            System.out.println("Заголовок страницы: " + driver.getTitle());
        }

        @AfterEach
        public void tearDown () {
            if (driver != null) {
                driver.quit();
            }
        }
        @Test
        public void testBlockTitle () {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.cssSelector("section.pay h2")));

            String actualText = title.getText().replaceAll("\\s+", " ").trim();
            assertEquals("ОНЛАЙН ПОПОЛНЕНИЕ БЕЗ КОМИССИИ", actualText);
        }
        @Test
        public void testPaymentLogo () {
            List<WebElement> logos = driver.findElements(By.xpath("//img[contains(@alt, 'Visa') or contains(@alt, 'Белкарт')]"));
            System.out.println("Найдено логотипов: " + logos.size());
            org.junit.jupiter.api.Assertions.assertTrue(logos.size() > 0, "Логотипы не найдены");
        }
        @Test
        public void testLink () {
            WebElement link = driver.findElement(By.linkText("Подробнее о сервисе"));
            link.click();
            String currentUrl = driver.getCurrentUrl();
            System.out.println("Открылся URL: " + currentUrl);
        }
        @Test
        public void testForm () {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.cssSelector("#pay-connection.opened")));

            WebElement phone = wait.until(ExpectedConditions.elementToBeClickable(
                    By.id("connection-phone")));

            String testPhone = "297777777";
            phone.sendKeys(testPhone);
            String actualPhone = phone.getDomProperty("value").replaceAll("\\D", "");
            assertEquals(testPhone, actualPhone);

            WebElement amount = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.id("connection-sum")));
            assertNotNull(amount.getDomAttribute("required"), "Сумма должна быть обязательной");
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.cssSelector("#pay-connection button[data-method='krok']")));
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.cssSelector("#pay-connection button[data-method='card']")));
        }
        }

