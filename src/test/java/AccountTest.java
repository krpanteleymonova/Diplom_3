import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import model.LoginPage;
import model.MainPage;
import model.ProfilePage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static model.LoginPage.ENTER_HEADER;
import static model.LoginPage.LOGIN_BUTTON;
import static model.MainPage.INGREDIENTS;
import static model.MainPage.LOGIN;
import static model.ProfilePage.CONSTRUCTOR_BUTTON;
import static model.ProfilePage.EXIT_BUTTON;
import static model.ProfilePage.LOGO;
import static model.ProfilePage.MENU;


public class AccountTest {
    protected WebDriver driver;
    MainPage mainPage;
    LoginPage loginPage;
    ProfilePage profilePage;

    @Before
    public void setUp() {
//Запуск тестов с помощью Google Chrome
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //Запуск тестов с помощью yandex
        //  System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\yandexdriver.exe");
        // ChromeOptions options=new ChromeOptions();
        // options.setBinary("C:\\Users\\Name\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
        //  driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
    }

    @Test
    @DisplayName("Переход в личный кабинет по кнопке «Личный кабинет» на главной странице")
    public void loginButtonCheckTest() {
        loginButtonCheck();
        profilePage.assertURLMainPage();
    }

    @Test
    @DisplayName("Выход из личного кабинета по кнопке «Выход»")
    public void ExitButtonCheckTest() {
        loginButtonCheck();
        profilePage.clickButton(EXIT_BUTTON);
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(ENTER_HEADER));
        loginPage.assertURLLogin();
    }

    @Test
    @DisplayName("Переход из личного кабинета по клику на «Конструктор» ")
    public void ConstructorButtonCheckTest() {
        loginButtonCheck();
        profilePage.clickButton(CONSTRUCTOR_BUTTON);
        mainPage.assertURLMainPage();
        mainPage.buttonIsDisplayed(INGREDIENTS);


    }

    @Test
    @DisplayName("Переход из личного кабинета по клику на логотип ")
    public void logoButtonCheckTest() {
        loginButtonCheck();
        profilePage.clickButton(LOGO);
        mainPage.assertURLMainPage();
        mainPage.buttonIsDisplayed(INGREDIENTS);


    }


    @Step("Переход в личный кабинет авторизированного пользователя")
    public void loginButtonCheck() {
        loginPage.open();
        loginPage.enterEmail(UserGenerator.defaultEmail);
        loginPage.enterPassword(UserGenerator.defaultPassword);
        loginPage.clickButton(LOGIN_BUTTON);
        mainPage.clickLoginButton(LOGIN);

        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(MENU));
        profilePage.assertURLMainPage();
    }

    @After
    public void tearDown() {
        // Закрой браузер
        driver.quit();
    }
}



