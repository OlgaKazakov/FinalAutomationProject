package utilities;

import org.openqa.selenium.support.PageFactory;
import pageObjects.toDoList.MainPage;

public class ManagePages extends Base{

    public static void initSaucedemo() {
        loginSaucedemo = PageFactory.initElements(driver, pageObjects.sauceDemo.LoginPage.class);
        mainSaucedemo = PageFactory.initElements(driver,pageObjects.sauceDemo.MainPage.class);
        cartSaucedemo = PageFactory.initElements(driver, pageObjects.sauceDemo.CartPage.class);
        checoutSaucedemo = PageFactory.initElements(driver, pageObjects.sauceDemo.CheckoutPage.class);
        overviewSaucedemo = PageFactory.initElements(driver, pageObjects.sauceDemo.ChOverviewPage.class);
    }

    public static void initOpenWeather() {
        mainOpenWeather = PageFactory.initElements(driver, pageObjects.openWeather.MainPageOpenWeather.class);
        forecastOpenWeather = PageFactory.initElements(driver, pageObjects.openWeather.WeatherForecastPage.class);
    }

    public static void initEribank(){
        loginEribank = new pageObjects.eribank.LoginPage(mobileDriver);
        mainEribank = new pageObjects.eribank.MainPage(mobileDriver);
        paymentEribank = new pageObjects.eribank.PaymentPage(mobileDriver);
        reportEribank = new pageObjects.eribank.ReportPage(mobileDriver);
    }

    public static void initToDoList() {
        mainToDo = PageFactory.initElements(driver, MainPage.class);
    }

    public static void initCalculator() {
        mainCalculator = PageFactory.initElements(driver, pageObjects.calculator.MainPage.class);
    }
}
