import io.qameta.allure.Step;
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
        mainPage.open();
    }

    @Test
    @DisplayName("Вход  в личный кабинет по кнопке «Войти в аккаунт» на главной странице")
    public void loginButtonCheckTest() {
        buttonClickMainPage();
        registerParameterFill();
        mainPage.assertURLMainPage();
        mainPage.getOrderButtonIsDisplayed();
    }

    @Test
    @DisplayName("Вход  в личный кабинет по кнопке «Личный кабинет» на главной странице")
    public void loginCheckTest() {
        buttonClickLCMainPage();
        registerParameterFill();
        mainPage.assertURLMainPage();
        mainPage.getOrderButtonIsDisplayed();
    }

    @Test
    @DisplayName("Вход  в личный кабинет  через кнопку «Вход» в форме регистрации")
    public void loginRegisterPageCheckTest() {
        buttonClickRegisterPage();
        registerParameterFill();
        mainPage.assertURLMainPage();
        mainPage.getOrderButtonIsDisplayed();
    }

    @Test
    @DisplayName("Вход  в личный кабинет  через кнопку «Вход» в форме восстановления пароля")
    public void forgotPasswordPageLoginCheckTest() {
        buttonClickPasswordPage();
        registerParameterFill();
        mainPage.assertURLMainPage();
        mainPage.getOrderButtonIsDisplayed();
    }

    @Step("Заполнение полей для входа  в личный кабинет")
    public void registerParameterFill() {
        loginPage.enterEmail(UserGenerator.defaultEmail);
        loginPage.enterPassword(UserGenerator.defaultPassword);
        loginPage.loginClickButton();
    }

    @Step("Клик по кнопке «Войти в аккаунт» на главной странице")
    public void buttonClickMainPage() {
        mainPage.clickLoginToAccountButton();
    }

    @Step("Клик по кнопке «Личный кабинет» на главной странице")
    public void buttonClickLCMainPage() {
        mainPage.clickLoginButton();
    }

    @Step("Клик по кнопке «Вход» в форме регистрации")
    public void buttonClickRegisterPage() {
        registerPage.open();
        registerPage.clickButtonEnter();
    }

    @Step("Клик по кнопке «Вход» в форме восстановления пароля")
    public void buttonClickPasswordPage() {
        forgotPasswordPage = new ForgotPasswordPage(driver);
        forgotPasswordPage.open();
        forgotPasswordPage.clickButton();
    }

    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}

