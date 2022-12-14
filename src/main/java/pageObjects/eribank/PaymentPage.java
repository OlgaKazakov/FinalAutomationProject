package pageObjects.eribank;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class PaymentPage {
    private AppiumDriver mobileDriver;

    public PaymentPage(AppiumDriver mobileDriver) {
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver, Duration.ofSeconds(5)), this);
    }

    @AndroidFindBy(id="phoneTextField")
    public MobileElement txt_phone;

    @AndroidFindBy(id="nameTextField")
    public MobileElement txt_name;

    @AndroidFindBy(id="amountTextField")
    public MobileElement txt_amount;

    @AndroidFindBy(id="countryButton")
    public MobileElement btn_country;

    @AndroidFindBy(id="sendPaymentButton")
    public MobileElement btn_sendPayment;

    @AndroidFindBy(id="button1")
    public MobileElement btn_yes;

    @AndroidFindBy(xpath="//*[@text='Mexico']")
    public MobileElement countryMexico;

}
