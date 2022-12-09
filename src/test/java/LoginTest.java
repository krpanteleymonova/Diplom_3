import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.junit4.DisplayName;
import model.ForgotPasswordPage;
import model.LoginPage;
import model.MainPage;
import model.RegisterPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static model.ForgotPasswordPage.ENTER_BUTTON;
import static model.LoginPage.LOGIN_BUTTON;
import static model.MainPage.GET_ORDER;
import static model.MainPage.LOGIN;
import static model.MainPage.LOGIN_TO_ACCOUNT_BUTTON;
import static model.RegisterPage.ENTER;


public class LoginTest {
    protected WebDriver driver;
    MainPage mainPage;
    LoginPage loginPage;
    RegisterPage registerPage;
    ForgotPasswordPage forgotPasswordPage;

    @Before
    public void setUp() {
        //Запуск тестов с помощью Google Chrome
        // WebDriverManager.chromedriver().setup();
        // driver = new ChromeDriver();
        //Запуск тестов с помощью yandex
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\yandexdriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Users\\Name\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        registerPage = new RegisterPage(driver);
    }

    @Test
    @DisplayName("Вход  в личный кабинет по кнопке «Войти в аккаунт» на главной странице")
    public void loginButtonCheckTest() {
        mainPage.open();
        mainPage.clickLoginButton(LOGIN_TO_ACCOUNT_BUTTON);
        loginPage.enterEmail(UserGenerator.defaultEmail);
        loginPage.enterPassword(UserGenerator.defaultPassword);
        loginPage.clickButton(LOGIN_BUTTON);
        mainPage.assertURLMainPage();
        mainPage.buttonIsDisplayed(GET_ORDER);
    }

    @Test
    @DisplayName("Вход  в личный кабинет по кнопке «Личный кабинет» на главной странице")
    public void loginCheckTest() {
        mainPage.open();
        mainPage.clickLoginButton(LOGIN);
        loginPage.enterEmail(UserGenerator.defaultEmail);
        loginPage.enterPassword(UserGenerator.defaultPassword);
        loginPage.clickButton(LOGIN_BUTTON);
        mainPage.assertURLMainPage();
        mainPage.buttonIsDisplayed(GET_ORDER);
    }

    @Test
    @DisplayName("Вход  в личный кабинет  через кнопку «Вход» в форме регистрации")
    public void loginRegisterPageCheckTest() {
        registerPage.open();
        registerPage.clickButton(ENTER);
        loginPage.enterEmail(UserGenerator.defaultEmail);
        loginPage.enterPassword(UserGenerator.defaultPassword);
        loginPage.clickButton(LOGIN_BUTTON);
        mainPage.assertURLMainPage();
        mainPage.buttonIsDisplayed(GET_ORDER);
    }

    @Test
    @DisplayName("Вход  в личный кабинет  через кнопку «Вход» в форме восстановления пароля")
    public void forgotPasswordPageloginCheckTest() {
        forgotPasswordPage = new ForgotPasswordPage(driver);
        forgotPasswordPage.open();
        forgotPasswordPage.clickButton(ENTER_BUTTON);
        loginPage.enterEmail(UserGenerator.defaultEmail);
        loginPage.enterPassword(UserGenerator.defaultPassword);
        loginPage.clickButton(LOGIN_BUTTON);
        mainPage.assertURLMainPage();
        mainPage.buttonIsDisplayed(GET_ORDER);

    }

    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}

