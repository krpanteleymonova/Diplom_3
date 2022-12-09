package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class RegisterPage {
    public static final String REGISTER_PAGE_URL = "https://stellarburgers.nomoreparties.site/register";
    public static final By NAME = By.xpath(".//fieldset[1]/div/div/input");
    public static final By EMAIL = By.xpath(".//fieldset[2]/div/div/input");
    public static final By PASSWORD = By.name("Пароль");
    public static final By REGISTER = By.xpath(".//button[text()='Зарегистрироваться']");
    public static final By PASSWORD_ERROR = By.xpath(".//fieldset[3]/div/p");
    public static final By ENTER = By.className("Auth_link__1fOlj");
    private final WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(REGISTER_PAGE_URL);
    }

    public void enterName(String name) {
        driver.findElement(NAME).sendKeys(name);
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

    public void assertRegisterError() {
        String actualString = driver.findElement(PASSWORD_ERROR).getText();
        System.out.println(actualString);
        assertTrue(actualString.contains("Некорректный пароль"));
    }
}
