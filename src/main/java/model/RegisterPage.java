package model;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class RegisterPage {
    private static final String REGISTER_PAGE_URL = "https://stellarburgers.nomoreparties.site/register";
    private static final By NAME = By.xpath(".//fieldset[1]/div/div/input");
    private static final By EMAIL = By.xpath(".//fieldset[2]/div/div/input");
    private static final By PASSWORD = By.name("Пароль");
    private static final By REGISTER = By.xpath(".//button[text()='Зарегистрироваться']");
    private static final By PASSWORD_ERROR = By.xpath(".//fieldset[3]/div/p");
    private static final By ENTER = By.className("Auth_link__1fOlj");
    private final WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открытие страницы")
    public void open() {
        driver.get(REGISTER_PAGE_URL);
    }

    @Step("Вводим 'Имя'")
    public void enterName(String name) {
        driver.findElement(NAME).sendKeys(name);
    }

    @Step("Вводим 'Email'")
    public void enterEmail(String email) {
        driver.findElement(EMAIL).sendKeys(email);
    }

    @Step("Вводим 'Пароль'")
    public void enterPassword(String password) {
        driver.findElement(PASSWORD).sendKeys(password);
    }

    @Step("Нажатие на кнопку 'Зарегистрироваться'")
    public void clickButtonRegister() {
        driver.findElement(REGISTER).click();
    }

    @Step("Нажатие на кнопку 'Вход'")
    public void clickButtonEnter() {
        driver.findElement(ENTER).click();
    }

    @Step("Получебние сообщения об ошибке")
    public void assertRegisterError() {
        String actualString = driver.findElement(PASSWORD_ERROR).getText();
        System.out.println(actualString);
        assertTrue(actualString.contains("Некорректный пароль"));
    }
}
