package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class LoginPage {
    public static final String LOGIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/login";
    public static final By REGISTER_BUTTON = By.xpath(".//a[text()='Зарегистрироваться']");
    public static final By ENTER_HEADER = By.xpath(".//h2[text()='Вход']");
    public static final By EMAIL = By.name("name");
    public static final By PASSWORD = By.name("Пароль");
    public static final By LOGIN_BUTTON = By.xpath(".//button[text()='Войти']");
    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(LOGIN_PAGE_URL);
    }

    public void enterEmail(String email) {
        driver.findElement(EMAIL).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(PASSWORD).sendKeys(password);
    }

    public void clickButton(By selector) {
        driver.findElement(selector).click();
    }

    public void assertURLLogin() {
        String currentURL = driver.getCurrentUrl();
        System.out.println(currentURL);
        assertTrue(currentURL.contains(LOGIN_PAGE_URL));
    }
}
