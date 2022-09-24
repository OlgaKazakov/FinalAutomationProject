package pageObjects.eribank;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;

public class ReportPage {
    private AppiumDriver mobileDriver;

    public ReportPage(AppiumDriver mobileDriver) {
        this.mobileDriver = mobileDriver;
        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver, Duration.ofSeconds(5)), this);
    }

    @AndroidFindBy(id = "addButton")
    public MobileElement btn_add;

    @AndroidFindBy(id = "backButton")
    public MobileElement btn_back;

    @AndroidFindBy(id = "titleTextView")
    public List<MobileElement> reports;
}
