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

import java.util.concurrent.TimeUnit;

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
    public void exitButtonCheckTest() {
        loginButtonCheck();
        profilePage.exitClickButton();
        loginPage.waitVisibilityOfElementLocated();
        loginPage.assertURLLogin();
    }

    @Test
    @DisplayName("Переход из личного кабинета по клику на «Конструктор» ")
    public void constructorButtonCheckTest() {
        loginButtonCheck();
        profilePage.constructorClickButton();
        mainPage.assertURLMainPage();
        mainPage.ingrediensIsDisplayed();
    }

    @Test
    @DisplayName("Переход из личного кабинета по клику на логотип ")
    public void logoButtonCheckTest() {
        loginButtonCheck();
        profilePage.logoClickButton();
        mainPage.assertURLMainPage();
        mainPage.ingrediensIsDisplayed();
    }

    @Step("Переход в личный кабинет авторизированного пользователя")
    public void loginButtonCheck() {
        loginPage.open();
        loginPage.enterEmail(UserGenerator.defaultEmail);
        loginPage.enterPassword(UserGenerator.defaultPassword);
        loginPage.loginClickButton();
        mainPage.clickLoginButton();
        profilePage.waitVisibilityOfElementLocated();
        profilePage.assertURLMainPage();
    }

    @After
    public void tearDown() {
        // Закрой браузер
        driver.quit();
    }
}



