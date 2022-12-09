package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class ProfilePage {
    public static final String PROFILE_URL = "https://stellarburgers.nomoreparties.site/account/profile";
    public static final By MENU = By.className("Account_nav__Lgali");
    public static final By EXIT_BUTTON = By.xpath(".//button[text()='Выход']");
    public static final By CONSTRUCTOR_BUTTON = By.xpath(".//p[text()='Конструктор']");
    public static final By LOGO = By.className("AppHeader_header__logo__2D0X2");

    private final WebDriver driver;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public void assertURLMainPage() {
        String currentURL = driver.getCurrentUrl();
        System.out.println(currentURL);
        assertTrue(currentURL.contains(PROFILE_URL));
    }

    public void clickButton(By selector) {
        driver.findElement(selector).click();

    }
}
