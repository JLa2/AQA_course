import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class PaymentPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By blockTitle = By.xpath("//h2[contains(text(), 'ОНЛАЙН ПОПОЛНЕНИЕ')]");
    private By phoneInput = By.id("connection-phone");
    private By continueButton = By.xpath("//button[contains(text(), 'Продолжить')]");
    private By amountInput = By.id("connection-sum");
    private By emailInput = By.id("connection-email");

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getBlockTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(blockTitle)).getText();
    }
    public PaymentPage fillPhoneNumber(String phone) {
        WebElement input=wait.until(ExpectedConditions.elementToBeClickable(By.id("connection-phone")));
        input.click();
        input.sendKeys(phone);
        return this;
    }
    public boolean arePaymentsMethodsVisible() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#pay-connection button[data-method='krok']")));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#pay-connection button[data-method='card']")));
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    public void clickContinue() {
        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
    }

    public String getAmountPlaceholder() {
        return driver.findElement(amountInput).getAttribute("placeholder");
    }

    public String getEmailPlaceholder() {
        return driver.findElement(emailInput).getAttribute("placeholder");
    }
    public int countPaymentLogos() {
        List<WebElement> logos = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.xpath("//img[contains(@alt, 'Visa') or contains(@alt, 'Mastercard') or contains(@alt, 'Белкарт') or contains(@alt, 'КРОК')]")
        ));
        return logos.size();
    }
    public PaymentPage fillAmount(String amount) {
        WebElement input=wait.until(ExpectedConditions.elementToBeClickable(amountInput));
        input.click();
        input.sendKeys(amount);
        return this;
    }
    public PaymentPage fillEmail(String email) {
        WebElement input=wait.until(ExpectedConditions.elementToBeClickable(emailInput));
        input.click();
        input.sendKeys(email);
        return this;
    }
    public void selectService(String serviceName) {
        WebElement dropdown=wait.until(ExpectedConditions.elementToBeClickable(By.id("connection-service")));
        org.openqa.selenium.support.ui.Select select=new org.openqa.selenium.support.ui.Select(dropdown);
        select.selectByVisibleText(serviceName);
    }
    public String getModalPhoneText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'payment')]//span[contains(text(), '+375')]"))).getText();
    }
    public String getModalAmountText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'payment')]//span[contains(text(), 'BYN')or contains(text(), 'руб')]"))).getText();
    }
}
