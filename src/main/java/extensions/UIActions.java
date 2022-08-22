package extensions;

import com.google.common.util.concurrent.Uninterruptibles;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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

//    public static void clearText (WebElement elem) {
//        wait.until(ExpectedConditions.elementToBeClickable(elem));
//        elem.clear();
//    }

    @Step ("Refreshing Page")
    public static void refreshPage() {
        driver.get(getData("url"));
        //driver.navigate().refresh();
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
    }

    @Step ("Update DropDown")
    public static void updateDropDown (WebElement elem, String text) {
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        Select dropDown = new Select(elem);
        dropDown.selectByVisibleText(text);
    }

    @Step ("Mouse Hover Element")
    public static void mouseHover(WebElement elem1, WebElement elem2) {
        wait.until(ExpectedConditions.elementToBeClickable(elem1));
        wait.until(ExpectedConditions.elementToBeClickable(elem2));
        action.moveToElement(elem1).moveToElement(elem2).click().build().perform();
    }

}
