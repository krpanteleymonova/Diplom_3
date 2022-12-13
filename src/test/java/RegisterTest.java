import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import model.LoginPage;
import model.RegisterPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class RegisterTest {
    protected WebDriver driver;
    LoginPage loginPage;
    RegisterPage registerPage;

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
        registerPage = new RegisterPage(driver);
        loginPage = new LoginPage(driver);
        registerPage.open();
    }

    @Test
    @DisplayName("Успешная регистрация клиента")
    public void registerCheckTest() {
        registerParameterFill();
        loginPage.waitVisibilityOfElementLocated();
        loginPage.assertURLLogin();
    }

    @Test
    @DisplayName("Ошибка при регистрации клиента, пароль меньше 6 знаков")
    public void registerPasswordErrorCheckTest() {
        registerParameterErrorFill();
        registerPage.assertRegisterError();
    }

    @Step("Заполнение полей для успешной регистрации клиента регистрации клиента")
    public void registerParameterFill() {
        registerPage.enterName(UserGenerator.name);
        registerPage.enterEmail(UserGenerator.email);
        registerPage.enterPassword(UserGenerator.password);
        registerPage.clickButtonRegister();
    }

    @Step("Заполнение полей клиента регистрации клиента")
    public void registerParameterErrorFill() {
        registerPage.enterName(UserGenerator.name);
        registerPage.enterEmail(UserGenerator.email);
        registerPage.enterPassword(UserGenerator.passwordError);
        registerPage.clickButtonRegister();
    }

    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}

