package pageObjects.eribank;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class MainPage {

    private AppiumDriver mobileDriver;

    public MainPage(AppiumDriver mobileDriver) {
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver, Duration.ofSeconds(5)), this);
    }

    @AndroidFindBy(xpath="//*[@class='android.widget.TextView']")
    public MobileElement wid_eribank;

    @AndroidFindBy(id = "makePaymentButton")
    public MobileElement btn_payment;

    @AndroidFindBy(id = "logoutButton")
    public MobileElement btn_logout;

    @AndroidFindBy(id = "expenseReportButton")
    public MobileElement btn_expenseReport;


}
