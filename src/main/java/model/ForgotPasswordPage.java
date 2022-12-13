package model;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {

    private static final String FORGOT_PASSWORD_URL = "https://stellarburgers.nomoreparties.site/forgot-password";
    private static final By ENTER_BUTTON = By.className("Auth_link__1fOlj");

    private final WebDriver driver;

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открытие страницы")
    public void open() {
        driver.get(FORGOT_PASSWORD_URL);
    }

    @Step("Нажатие на кнопку 'Вход'")
    public void clickButton() {
        driver.findElement(ENTER_BUTTON).click();
    }
}
