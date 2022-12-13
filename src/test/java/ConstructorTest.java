import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.junit4.DisplayName;
import model.MainPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class ConstructorTest {
    protected WebDriver driver;
    MainPage mainPage;
    String ingredient;

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
        mainPage.open();
    }

    @Test
    @DisplayName("Переход к разделам соусы")
    public void checkSouseTest() {
        mainPage.clickSouseButton();
        ingredient = mainPage.bunClassGet();
        assertEquals("Ингридент не корректный", "Соусы", ingredient);
    }

    @Test
    @DisplayName("Переход к разделу начинки ")
    public void checkFillingTest() {
        mainPage.clickFillingButton();
        ingredient = mainPage.bunClassGet();
        assertEquals("Ингридент не корректный", "Начинки", ingredient);
    }

    @Test
    @DisplayName("Переход к разделу булки ")
    public void checkBunTest() {
        mainPage.clickFillingButton();
        mainPage.clickBunButton();
        ingredient = mainPage.bunClassGet();
        assertEquals("Ингридент не корректный", "Булки", ingredient);
    }

    @After
    public void tearDown() {
        // Закрой браузер
        driver.quit();
    }
}
