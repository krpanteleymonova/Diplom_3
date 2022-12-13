package model;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class MainPage {

    private static final String MAIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/";
    private static final By LOGIN_TO_ACCOUNT_BUTTON = By.xpath(".//button[text()='Войти в аккаунт']");
    private static final By LOGIN = By.xpath(".//p[text()='Личный Кабинет']");
    private static final By GET_ORDER = By.xpath(".//button[text()='Оформить заказ']");
    private static final By INGREDIENTS = By.className("BurgerIngredients_ingredients__1N8v2");
    private static final By SOUSE_BUTTON = By.xpath(".//span[text()='Соусы']");
    private static final By FILLING_BUTTON = By.xpath(".//span[text()='Начинки']");
    private static final By BUN_BUTTON = By.xpath(".//span[text()='Булки']");
    private static final By INGREDIENT_GET = By.xpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']");

    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Извлекаем название ингридиента")
    public String bunClassGet() {
        System.out.println(driver.findElement(INGREDIENT_GET).getText());
        return driver.findElement(INGREDIENT_GET).getText();
    }

    @Step("Открытие страницы")
    public void open() {
        driver.get(MAIN_PAGE_URL);
    }

    @Step("Нажатие на кнопку 'Личный кабинет'")
    public void clickLoginButton() {
        driver.findElement(LOGIN).click();
    }

    @Step("Нажатие на кнопку 'Соусы'")
    public void clickSouseButton() {
        driver.findElement(SOUSE_BUTTON).click();
    }

    @Step("Нажатие на кнопку 'Начинки'")
    public void clickFillingButton() {
        driver.findElement(FILLING_BUTTON).click();
    }

    @Step("Нажатие на кнопку 'Булки'")
    public void clickBunButton() {
        driver.findElement(BUN_BUTTON).click();
    }

    @Step("Нажатие на кнопку 'Войти в аккаунт'")
    public void clickLoginToAccountButton() {
        driver.findElement(LOGIN_TO_ACCOUNT_BUTTON).click();
    }

    @Step("Проверка правильности URL")
    public void assertURLMainPage() {
        String currentURL = driver.getCurrentUrl();
        System.out.println(currentURL);
        assertTrue(currentURL.contains(MAIN_PAGE_URL));
    }

    @Step("Элемент  'оформить заказ' видимый")
    public void getOrderButtonIsDisplayed() {
        assertTrue(driver.findElement(GET_ORDER).isDisplayed());
    }

    @Step("Элемент видимый")
    public void ingrediensIsDisplayed() {
        assertTrue(driver.findElement(INGREDIENTS).isDisplayed());
    }
}
