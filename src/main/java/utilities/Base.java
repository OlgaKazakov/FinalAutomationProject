package utilities;

import io.appium.java_client.AppiumDriver;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.asserts.SoftAssert;
import pageObjects.toDoList.MainPage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Base {
    //General
    protected static WebDriverWait wait;
    protected static Actions action;
    protected static Screen screen;
    protected static SoftAssert softAssert;

    //Web
    protected static WebDriver driver;
    protected static String platformname;

    //Mobile
    protected static AppiumDriver mobileDriver;
    protected static DesiredCapabilities capabilities = new DesiredCapabilities();

    //RestAPI
    protected static RequestSpecification request;
    protected static Response response;
    protected static JsonPath jp;
    protected static JSONObject params = new JSONObject();

    //Electron
    protected static ChromeOptions options;

    //DataBase
    protected static Connection con;
    protected static Statement statement;
    protected static ResultSet resultSet;

    // Page Objects Web
    protected static pageObjects.sauceDemo.LoginPage loginSaucedemo;
    protected static pageObjects.sauceDemo.MainPage mainSaucedemo;
    protected static pageObjects.sauceDemo.CartPage cartSaucedemo;
    protected static pageObjects.sauceDemo.CheckoutPage checoutSaucedemo;
    protected static pageObjects.sauceDemo.ChOverviewPage overviewSaucedemo;

    // Page Objects APIWeb
    protected static pageObjects.openWeather.MainPageOpenWeather mainOpenWeather;
    protected static pageObjects.openWeather.WeatherForecastPage forecastOpenWeather;
    public static String humidityWeb;
    public static String humidityAPI;

    //Page Objects Mobile
    protected static pageObjects.eribank.LoginPage loginEribank;
    protected static pageObjects.eribank.MainPage mainEribank;
    protected static pageObjects.eribank.PaymentPage paymentEribank;
    protected static pageObjects.eribank.ReportPage reportEribank;

    //Page Objects Electron
    protected static MainPage mainToDo;

    //Page Objects Desktop
    protected static pageObjects.calculator.MainPage mainCalculator;

}
