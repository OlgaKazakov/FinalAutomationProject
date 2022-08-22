package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import org.w3c.dom.Document;
import workflows.WebFlows;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

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

    public static void initBrowser(String browtherType) {
        if(browtherType.equalsIgnoreCase("chrome")) {
            initChromeBrowser();
        }
        else if(browtherType.equalsIgnoreCase("firefox")) {
            initFirefoxBrowser();
        }
        else if(browtherType.equalsIgnoreCase("ie")) {
            initIEBrowser();
        }
        else {
            throw new RuntimeException("Invalid Browser Type");
        }
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(getData("url"));
        driver.manage().window().maximize();
        ManagePages.initSaucedemo();
        action = new Actions(driver);
        //Long.parseLong(getData("Timeout"))
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
//        else if (platformname.equalsIgnoreCase("mobile")) {
//            initMobile();
//        }
        else {
            throw new RuntimeException("Invalid platformname");
        }

        softAssert = new SoftAssert();
        screen = new Screen();
    }

    @AfterClass
    public void closeSession(){
        driver.quit();
    }

    @BeforeMethod
    public void beforeMethod(Method method) {
        try {
            MScreenRecorder.startRecord(method.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
