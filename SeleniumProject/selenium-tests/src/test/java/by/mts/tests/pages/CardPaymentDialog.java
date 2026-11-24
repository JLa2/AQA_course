package by.mts.tests.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class CardPaymentDialog {
    private static final By FRAME = By.cssSelector("iframe.payment-widget-iframe");
    private static final By AMOUNT = By.cssSelector(".pay-description__cost");
    private static final By DESCRIPTION = By.cssSelector(".pay-description__text");
    private static final By PAY_BUTTON = By.cssSelector("button.colored");
    private static final By FIELD_LABELS = By.cssSelector("app-card-input app-input label");
    private static final By EXPIRY = By.cssSelector("app-card-input input.date-input");

    private final WebDriverWait wait;

    CardPaymentDialog(WebDriver driver) {
        WebDriverWait widgetLoad = new WebDriverWait(driver, Duration.ofSeconds(90));
        widgetLoad.withMessage("Виджет bePaid должен открыть форму банковской карты");
        widgetLoad.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(FRAME));
        widgetLoad.until(ExpectedConditions.visibilityOfElementLocated(PAY_BUTTON));
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public String amount() {
        return textOf(AMOUNT);
    }

    public String payButtonText() {
        return textOf(PAY_BUTTON);
    }

    public String paymentDescription() {
        return textOf(DESCRIPTION);
    }

    public List<String> cardFieldLabels() {
        List<WebElement> labels = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(FIELD_LABELS));
        List<String> texts = new ArrayList<>();
        for (WebElement label : labels) {
            texts.add(label.getText());
        }
        return texts;
    }

    public String expiryPlaceholder() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(EXPIRY))
                .getDomAttribute("placeholder");
    }

    public boolean isPaymentSystemLogoVisible(String system) {
        By locator = By.cssSelector("app-card-input img[src$='/" + system + "-system.svg']");
        WebElement logo = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return wait.until(driver -> Integer.parseInt(logo.getDomProperty("naturalWidth")) > 0);
    }

    private String textOf(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator))
                .getText().replace('\u00a0', ' ').replaceAll("\\s+", " ").trim();
    }
}
