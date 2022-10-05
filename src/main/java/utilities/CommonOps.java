package utilities;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.windows.WindowsDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import workflows.DesktopFlows;

public class CommonOps extends Base{

    public static String getData(String nodeName) {
        File fXmlFile;
        DocumentBuilderFactory dbFactory;
        DocumentBuilder dBuilder;
        Document doc = null;
        try {
            fXmlFile = new File("./Configuration/DataConfig.xml");
            dbFactory = DocumentBuilderFactory.newInstance();
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
        } catch (Exception e) {
            System.out.println("Error reading XML file: " + e);
        } finally {
            return doc.getElementsByTagName(nodeName).item(0).getTextContent();
        }
    }

    public static void initBrowser(String browserType) {
        if(browserType.equalsIgnoreCase("chrome")) {
            initChromeBrowser();
        }
        else if(browserType.equalsIgnoreCase("firefox")) {
            initFirefoxBrowser();
        }
        else if(browserType.equalsIgnoreCase("ie")) {
            initIEBrowser();
        }
        else {
            throw new RuntimeException("Invalid Browser Type");
        }
        wait = new WebDriverWait(driver,Long.parseLong(getData("Timeout")));
        action = new Actions(driver);
        if(platformname.equalsIgnoreCase("web")){
            driver.get(getData("url"));
            ManagePages.initSaucedemo();
        } else if(platformname.equalsIgnoreCase("apiAndWeb")){
            driver.get(getData("urlWeb"));
            ManagePages.initOpenWeather();
        } else {
            System.out.println("Invalid Platform Name for Using Browser");
        }
        driver.manage().window().maximize();
    }

    public static void initMobile(){
        capabilities.setCapability(MobileCapabilityType.UDID, getData("UDID"));
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, getData("AppPackage"));
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, getData("AppActivity"));
        try {
            mobileDriver = new AndroidDriver<>(new URL(getData("AppiumServer")), capabilities);
        } catch (Exception e) {
            System.out.println("Can not connect to Appium Server: " +e);
        }
        ManagePages.initEribank();
        mobileDriver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(mobileDriver, Long.parseLong(getData("Timeout")));
        action = new Actions(mobileDriver);
    }

    public static void initAPI() {
        String url = getData("urlAPI");
        RestAssured.baseURI = url;
        request = RestAssured.given();
    }

    public static void initAPIandWEB(String browserType) {
        initAPI();
        initBrowser(browserType);
    }

    public static void initElectron() {
        System.setProperty("webdriver.chrome.driver", getData("ElectronDriverPath"));
        options = new ChromeOptions();
        options.setBinary(getData("ElectronAppPath"));
        capabilities.setCapability("chromeOptions", options);
        capabilities.setBrowserName("chrome");
        options.merge(capabilities);
        driver = new ChromeDriver(options);

        ManagePages.initToDoList();
        driver.manage().timeouts().implicitlyWait(Long.parseLong((getData("Timeout"))), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Long.parseLong(getData("Timeout")));
        action = new Actions(driver);
    }

    public static void initDesktop(){
        capabilities.setCapability("app", getData("CalculatorApp"));
        try {
            driver = new WindowsDriver(new URL(getData("AppiumDesktopServerURL")), capabilities);
        } catch (Exception e) {
            System.out.println("Can not connect to Appium Server: " + e);
        }
        wait = new WebDriverWait(driver, Long.parseLong(getData("Timeout")));
        ManagePages.initCalculator();
    }

    public static WebDriver initChromeBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        return driver;
    }

    public static WebDriver initFirefoxBrowser(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        return driver;
    }

    public static WebDriver initIEBrowser(){
        WebDriverManager.iedriver().setup();
        driver = new InternetExplorerDriver();
        return driver;
    }


    @BeforeClass
    @Parameters ({"PlatformName"})
    public void startSession(String PlatformName) {

        platformname = PlatformName;
        if (platformname.equalsIgnoreCase("web")) {
            initBrowser(getData("BrowserName"));
        }
        else if (platformname.equalsIgnoreCase("mobile")) {
            initMobile();
        }
        else if (platformname.equalsIgnoreCase("apiAndWeb")) {
             initAPIandWEB(getData("BrowserNameForApiAndWeb"));
        }
        else if (platformname.equalsIgnoreCase("electron")) {
            initElectron();
        }
        else if (platformname.equalsIgnoreCase("desktop")) {
            initDesktop();
        }
        else {
            throw new RuntimeException("Invalid platformname");
        }

        ManageDataBase.openConnection(getData("DataBaseURL"), getData("DBUser"), getData("DBPassword"));
        softAssert = new SoftAssert();
        screen = new Screen();
    }

    @AfterClass
    public void closeSession(){
        if (!platformname.equalsIgnoreCase("mobile")) {
            driver.quit();
        } else {
            mobileDriver.quit();
        }
        ManageDataBase.closeConnection();
    }

    @BeforeMethod
    public void beforeMethod(Method method) {
        try {
            MScreenRecorder.startRecord(method.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(platformname.equalsIgnoreCase("desktop")) {
            DesktopFlows.deleting();
        }
    }
    
}
