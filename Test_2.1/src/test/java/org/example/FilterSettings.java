package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class FilterSettings {

    // конструктор класса, занимающийся инициализацией полей класса
    public WebDriver driver;

    public FilterSettings(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    // Определение локатора марки "toyota"
    @FindBy(xpath = "//a[contains(text(),'Toyota')]")
    private static WebElement toyotabrand;

    // Определение локатора модели "Harrier"
    @FindBy(xpath = "// a[contains(text(), 'Harrier')]")
    private static WebElement harriermodel;

    // Определение локатора кнопки "Расширенный поиск"
    @FindBy(xpath = "//span[contains(text(),'Расширенный поиск')]")
    private static WebElement advancedsearch;

    // Определение локатора выпадающего списка "Топливо"
    @FindBy(xpath = "//button[text()='Топливо']")
    private static WebElement carfuel;

    // Определение локатора типа топлива "гибрид"
    @FindBy(xpath = "//div[text()='Гибрид']")
    private static WebElement hybridfuel;

    // Определение локатора чекбокса "Непроданные"
    @FindBy(xpath = "//label[text()='Непроданные']")
    private static WebElement unsold;

    // Определение локатора выпадающего списка "Год"
    @FindBy(xpath = "//button[text()='Год от']")
    private static WebElement caryear;

    // Определение локатора выбора определенного года
    @FindBy(xpath = "//div[text()='2007']")
    private static WebElement caryear2007;

    // Опеределение локатора минимального пробега
    @FindBy(xpath = "//input[@placeholder='от, км']")
    private static WebElement mileage;

    // Определение локатора кнопки "показать"
    @FindBy(xpath = "//div[text()='Показать']")
    private static WebElement show;

    // Определение локатора перехода на вторую страницу
    @FindBy(xpath = "//a[@class='css-5k0bl6 e24vrp30']")
    private static WebElement SecondPage;



    // методы

    // метод нажатия кнопки "Расширенный поиск"
    public static void clickAdvancedSearch() {
        advancedsearch.click();
    }

    // метод нажатия на пункт "toyota"
    public static void clicktoyotabrand() {
        toyotabrand.click();
    }

    // метод нажатия на модель
    public static void clickharriermodel() {
        harriermodel.click();
    }

    // метод нажатия выпадающий список "Топливо"
    public static void clickcarfuel() {
        carfuel.click();
    }

    // метод нажатия на тип топлива "гибрид"
    public static void clickhybridfuel() {
        hybridfuel.click();
    }

    // метод нажатия на чекбокс "Непроданные"
    public static void clickunsold() {
        unsold.click();
    }

    // метод нажатия на выпадающий список "Год"
    public static void clickcaryear() {
        caryear.click();
    }

    // метод нажатия на определенный год
    public static void clickcaryear2007() {
        caryear2007.click();
    }

    // метод ввода минимального пробега
    public static void inputmileage(String km) {
        mileage.sendKeys(km);
    }

    // метод нажатия на кнопку применения фильтров
    public static void clickshow() {
        show.click();
    }

    // метод нажатия на кнопку перехода на вторую страницу
    public static void clickSecondPage() {
        SecondPage.click();
    }

    }

