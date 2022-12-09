import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.junit4.DisplayName;
import model.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;



public class ConstructorTest {
    protected WebDriver driver;
    MainPage mainPage;

    @Before

    public void startUp() {
        //Запуск тестов с помощью Google Chrome
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //Запуск тестов с помощью yandex
        // System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\yandexdriver.exe");
        // ChromeOptions options=new ChromeOptions();
        // options.setBinary("C:\\Users\\Name\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
        //  driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        mainPage = new MainPage(driver);
    }

    @Test
    @DisplayName("Переход к разделам соусы")
    public void CheckSouseTest() {
        mainPage.open();
        mainPage.clickLoginButton(MainPage.SOUSE_BUTTON);
        mainPage.buttonIsDisplayed(MainPage.SOUSE);
    }

    @Test
    @DisplayName("Переход к разделу начинки ")
    public void CheckFillingTest() {
        mainPage.open();
        mainPage.clickLoginButton(MainPage.FILLING_BUTTON);
        mainPage.buttonIsDisplayed(MainPage.FILLING);
    }

    @Test
    @DisplayName("Переход к разделу булки ")
    public void CheckBunTest() {
        mainPage.open();
        mainPage.clickLoginButton(MainPage.FILLING_BUTTON);
        mainPage.clickLoginButton(MainPage.BUN_BUTTON);
        mainPage.buttonIsDisplayed(MainPage.BUN);
    }

    @After
    public void tearDown() {
        // Закрой браузер
        driver.quit();
    }
}
