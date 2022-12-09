import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.junit4.DisplayName;
import model.LoginPage;
import model.RegisterPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static model.LoginPage.ENTER_HEADER;

import static model.RegisterPage.REGISTER;

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
        registerPage.enterName(UserGenerator.name);
        registerPage.enterEmail(UserGenerator.email);
        registerPage.enterPassword(UserGenerator.password);
        registerPage.clickButton(REGISTER);
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(ENTER_HEADER));
        loginPage.assertURLLogin();
    }

    @Test
    @DisplayName("Ошибка при регистрации клиента, пароль меньше 6 знаков")
    public void registerPasswordErrorCheckTest() {
        registerPage.enterName(UserGenerator.name);
        registerPage.enterEmail(UserGenerator.email);
        registerPage.enterPassword(UserGenerator.passwordError);
        registerPage.clickButton(REGISTER);
        registerPage.assertRegisterError();
    }

    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}

