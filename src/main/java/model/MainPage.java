package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.assertTrue;

public class MainPage {

    public static final String MAIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/";
    public static final By LOGIN_TO_ACCOUNT_BUTTON = By.xpath(".//button[text()='Войти в аккаунт']");
    public static final By LOGIN = By.xpath(".//p[text()='Личный Кабинет']");
    public static final By GET_ORDER = By.xpath(".//button[text()='Оформить заказ']");
    public static final By INGREDIENTS = By.className("BurgerIngredients_ingredients__1N8v2");
    public static final By SOUSE_BUTTON = By.xpath(".//span[text()='Соусы']");
    public static final By FILLING_BUTTON = By.xpath(".//span[text()='Начинки']");
    public static final By BUN_BUTTON = By.xpath(".//span[text()='Булки']");
    public static final By BUN = By.xpath(".//section[1]/div[1]/div[1][@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']");
    public static final By SOUSE = By.xpath(".//section[1]/div[1]/div[2][@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']");
    public static final By FILLING = By.xpath(".//section[1]/div[1]/div[3][@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']");

    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(MAIN_PAGE_URL);
    }

    public void clickLoginButton(By selector) {
        driver.findElement(selector).click();
    }

    public void assertURLMainPage() {
        String currentURL = driver.getCurrentUrl();
        System.out.println(currentURL);
        assertTrue(currentURL.contains(MAIN_PAGE_URL));
    }

    public void buttonIsDisplayed(By selector) {
        assertTrue(driver.findElement(selector).isDisplayed());
    }
}
