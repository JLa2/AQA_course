package by.mts.tests.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class MtsHomePage {
    private static final String URL = "https://www.mts.by/";
    private static final By COOKIE_REJECT = By.cssSelector(".cookie__cancel");
    private static final By TITLE = By.cssSelector("section.pay h2");
    private static final By SERVICE_MENU = By.cssSelector("section.pay .select__header");
    private static final By SELECTED_SERVICE = By.cssSelector("section.pay .select__now");
    private static final By ACTIVE_FORM = By.cssSelector("section.pay form.opened");
    private static final By PARTNER_LOGOS = By.cssSelector("section.pay .pay__partners img");
    private static final By SERVICE_DETAILS = By.cssSelector("section.pay a[href^='/help/']");
    private static final By PHONE = By.id("connection-phone");
    private static final By AMOUNT = By.id("connection-sum");
    private static final By KROK_BUTTON = By.cssSelector("#pay-connection [data-method='krok']");
    private static final By CARD_BUTTON = By.cssSelector("#pay-connection [data-method='card']");

    private final WebDriver driver;
    private final WebDriverWait wait;

    public MtsHomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void open() {
        driver.get(URL);
        visible(ACTIVE_FORM);
        if (!driver.findElements(COOKIE_REJECT).isEmpty()) {
            clickable(COOKIE_REJECT).click();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(COOKIE_REJECT));
        }
    }

    public String pageTitle() {
        return driver.getTitle();
    }

    public String paymentTitle() {
        return visible(TITLE).getText().replaceAll("\\s+", " ").trim();
    }

    public List<String> partnerLogos() {
        List<WebElement> logos = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(PARTNER_LOGOS));
        List<String> names = new ArrayList<>();
        for (WebElement logo : logos) {
            names.add(logo.getDomAttribute("alt"));
        }
        return names;
    }

    public String openServiceDetails() {
        String homeUrl = driver.getCurrentUrl();
        clickable(SERVICE_DETAILS).click();
        wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(homeUrl)));
        return driver.getCurrentUrl();
    }

    public void selectService(String service) {
        clickable(SERVICE_MENU).click();
        By option = By.xpath("//section[@class='pay']//p[@class='select__option' and normalize-space(.)='"
                + service + "']");
        clickable(option).click();
        wait.until(ExpectedConditions.textToBe(SELECTED_SERVICE, service));
    }

    public List<String> placeholders() {
        WebElement form = visible(ACTIVE_FORM);
        List<String> placeholders = new ArrayList<>();
        for (WebElement field : form.findElements(By.cssSelector("input[placeholder]"))) {
            if (field.isDisplayed()) {
                placeholders.add(field.getDomAttribute("placeholder"));
            }
        }
        return placeholders;
    }

    public void enterPhone(String phone) {
        clickable(PHONE).sendKeys(phone);
    }

    public String enteredPhone() {
        return visible(PHONE).getDomProperty("value");
    }

    public boolean isAmountRequired() {
        return visible(AMOUNT).getDomAttribute("required") != null;
    }

    public String krokButtonLabel() {
        return visible(KROK_BUTTON).findElement(By.tagName("img")).getDomAttribute("alt");
    }

    public String cardButtonLabel() {
        return visible(CARD_BUTTON).getText().replaceAll("\\s+", " ").trim();
    }

    public void enterAmount(String amount) {
        clickable(AMOUNT).sendKeys(amount);
    }

    public CardPaymentDialog continueToCardPayment() {
        clickable(CARD_BUTTON).click();
        return new CardPaymentDialog(driver);
    }

    private WebElement visible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private WebElement clickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
}
