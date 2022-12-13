package model;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class LoginPage {
    private static final String LOGIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/login";
    private static final By REGISTER_BUTTON = By.xpath(".//a[text()='Зарегистрироваться']");
    private static final By ENTER_HEADER = By.xpath(".//h2[text()='Вход']");
    private static final By EMAIL = By.name("name");
    private static final By PASSWORD = By.name("Пароль");
    private static final By LOGIN_BUTTON = By.xpath(".//button[text()='Войти']");
    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Ожидание")
    public void waitVisibilityOfElementLocated() {
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(ENTER_HEADER));
    }

    @Step("Открытие страницы")
    public void open() {
        driver.get(LOGIN_PAGE_URL);
    }

    @Step("Вводим email")
    public void enterEmail(String email) {
        driver.findElement(EMAIL).sendKeys(email);
    }

    @Step("Вводим пароль")
    public void enterPassword(String password) {
        driver.findElement(PASSWORD).sendKeys(password);
    }

    @Step("Нажатие на кнопку")
    public void loginClickButton() {
        driver.findElement(LOGIN_BUTTON).click();
    }

    @Step("Проверка правильности URL")
    public void assertURLLogin() {
        String currentURL = driver.getCurrentUrl();
        System.out.println(currentURL);
        assertTrue(currentURL.contains(LOGIN_PAGE_URL));
    }
}
