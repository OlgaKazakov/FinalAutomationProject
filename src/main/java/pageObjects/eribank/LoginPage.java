package pageObjects.eribank;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utilities.CommonOps;

import java.time.Duration;


public class LoginPage extends CommonOps {

    private AppiumDriver mobileDriver;

    public LoginPage(AppiumDriver mobileDriver) {
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver, Duration.ofSeconds(5)), this);
    }

    @AndroidFindBy(xpath="//*[@id='usernameTextField']")
    public MobileElement txt_username;

    @AndroidFindBy(xpath="//*[@id='passwordTextField']")
    public MobileElement txt_password;

    @AndroidFindBy(xpath="//*[@text='Login']")
    public MobileElement btn_login;

}
