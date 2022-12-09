package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {

    public static final String FORGOT_PASSWORD_URL = "https://stellarburgers.nomoreparties.site/forgot-password";
    public static final By ENTER_BUTTON = By.className("Auth_link__1fOlj");

    private final WebDriver driver;

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(FORGOT_PASSWORD_URL);
    }

    public void clickButton(By selector) {
        driver.findElement(selector).click();
    }
}
