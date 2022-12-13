package model;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class ProfilePage {
    private static final String PROFILE_URL = "https://stellarburgers.nomoreparties.site/account/profile";
    private static final By MENU = By.className("Account_nav__Lgali");
    private static final By EXIT_BUTTON = By.xpath(".//button[text()='Выход']");
    private static final By CONSTRUCTOR_BUTTON = By.xpath(".//p[text()='Конструктор']");
    private static final By LOGO = By.className("AppHeader_header__logo__2D0X2");

    private final WebDriver driver;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Проверка правильности URL")
    public void assertURLMainPage() {
        String currentURL = driver.getCurrentUrl();
        System.out.println(currentURL);
        assertTrue(currentURL.contains(PROFILE_URL));
    }

    @Step("Ожидание")
    public void waitVisibilityOfElementLocated() {
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(MENU));
    }

    @Step("Нажатие на кнопку 'Выход'")
    public void exitClickButton() {
        driver.findElement(EXIT_BUTTON).click();
    }

    @Step("Нажатие на кнопку 'Конструктор'")
    public void constructorClickButton() {
        driver.findElement(CONSTRUCTOR_BUTTON).click();
    }

    @Step("Нажатие на логотип")
    public void logoClickButton() {
        driver.findElement(LOGO).click();
    }
}
