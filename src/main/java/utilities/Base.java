package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.asserts.SoftAssert;

public class Base {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static Actions action;
    protected static Screen screen;
    protected static SoftAssert softAssert;
    protected static String platformname;

    // Page Objects
    protected static pageObjects.sauceDemo.LoginPage loginSaucedemo;
    protected static pageObjects.sauceDemo.MainPage mainSaucedemo;
    protected static pageObjects.sauceDemo.CartPage cartSaucedemo;
    protected static pageObjects.sauceDemo.CheckoutPage checoutSaucedemo;
    protected static pageObjects.sauceDemo.ChOverviewPage overviewSaucedemo;

}
