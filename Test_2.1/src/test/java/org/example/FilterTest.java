package org.example;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class FilterTest {

    public static FilterSettings filterSettings;
    public static WebDriver driver;
    public static CheckParameters checkParameters;



    @BeforeClass
    public static void setup () {

        System.setProperty("webdriver.chrome.driver", "C:\\usr\\bin\\chromedriver.exe");
        driver = new ChromeDriver();
        filterSettings = new FilterSettings(driver);
        checkParameters = new CheckParameters(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(ConfProperties.getProperty("filter_page"));;
        driver.manage().window().maximize();

    }

    @Test
    public void filterTest() {

        // настройки фильтров

        //выбираем марку
        FilterSettings.clicktoyotabrand();

        //выбираем модель
        FilterSettings.clickharriermodel();

        //Расширенный поиск
        FilterSettings.clickAdvancedSearch();

        //Выбираем тип топлива
        FilterSettings.clickcarfuel();
        FilterSettings.clickhybridfuel();

        //Отмечаем флаг "Непроданные"
        FilterSettings.clickunsold();

        //Выбираем год
        FilterSettings.clickcaryear();
        FilterSettings.clickcaryear2007();

        //Вводим пробег
        FilterSettings.inputmileage("1");

        // Применяем настройки
        FilterSettings.clickshow();



        // Проверка результатов
        int PagesCount = 2;
        while (PagesCount>0){

            for (int i=0; i<20; i++){
                Assert.assertEquals(ConfProperties.getProperty("selected_parameter"),
                        checkParameters.CheckYear(Integer.parseInt(ConfProperties.getProperty("year")), i));
                Assert.assertEquals(ConfProperties.getProperty("selected_parameter"), checkParameters.CheckTheMileage(i));
                Assert.assertEquals(ConfProperties.getProperty("selected_parameter"), checkParameters.SoldCar(i));
            }
            FilterSettings.clickSecondPage();
            PagesCount -= 1;
        }
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

}