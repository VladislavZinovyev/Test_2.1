package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class CheckParameters {

    // конструктор класса, занимающийся инициализацией полей класса
    public WebDriver driver;
    public CheckParameters(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

     // определение локатора заголовка объявлений
    @FindBy(xpath = "//span[@data-ftid='bull_title']")
    private List<WebElement> titlecar;

     // определение локатора  блока информации об автомобиле
    @FindBy(xpath = "//div[@class='css-wsa6w e727yh30']")
    private List<WebElement> infocar;


    // проверка наличия блока пробега авто
    public  String CheckTheMileage(int i){
        String Element;
        Element = infocar.get(i).getAttribute("textContent");
        if (!Element.contains("тыс. км")){
            return "неверный пробег";
        }
        return "test pas";
    }

    // Проверка соответствия года выпуска
    public String CheckYear(int year, int i){
        String Element;
        Element = infocar.get(i).getAttribute("textContent");
        int index = Element.indexOf(" ", 8);
        String s = Element.substring(index+1, index+5);
        if (Integer.parseInt(s)<year) {
            return "неверный год";
        }
        return "test pas";
    }

    // Проверка на наличие проданных
    public String SoldCar(int i){
        String status;
        status = titlecar.get(i).getAttribute("outerHTML");
        if (status.indexOf("data-crossed-bull")!=-1) return "есть проданные авто";
        return "test pas";
    }
}
