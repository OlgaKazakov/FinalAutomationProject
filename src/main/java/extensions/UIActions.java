package extensions;

import com.google.common.util.concurrent.Uninterruptibles;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.CommonOps;

import java.util.concurrent.TimeUnit;

public class UIActions extends CommonOps {

    @Step ("Click on Element")
    public static void click(WebElement elem) {
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        elem.click();
    }

    @Step ("Updating Text Field")
    public static void updateText (WebElement elem, String text) {
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        elem.sendKeys(text);
    }

    @Step ("Updating Text Field")
    public static void insertKey (WebElement elem, Keys value) {
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        elem.sendKeys(value);
    }

    @Step ("Updating Text Field And Sending ENTER Key")
    public static void updateTextAndSendKeysReturn (WebElement elem, String text) {
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        elem.sendKeys(text);
        elem.sendKeys(Keys.RETURN);
    }

    @Step ("Getting Text From Element")
    public static String gettingTextFromElement(WebElement elem){
        wait.until(ExpectedConditions.visibilityOf(elem));
        return elem.getText();
    }

    @Step ("Refreshing Page")
    public static void refreshPage() {
        driver.get(getData("url"));
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
    }

    @Step ("Mouse Hover Element")
    public static void mouseHover(WebElement elem1, WebElement elem2) {
        wait.until(ExpectedConditions.elementToBeClickable(elem1));
        wait.until(ExpectedConditions.elementToBeClickable(elem2));
        action.moveToElement(elem1).moveToElement(elem2).click().build().perform();
    }

}
