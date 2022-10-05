package extensions;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.CommonOps;

public class UIActions extends CommonOps {

    @Step ("Click on Element")
    public static void click(WebElement elem) {
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        elem.click();
    }

    @Step ("Updating Text Field")
    public static void updateText (WebElement elem, String text) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.sendKeys(text);
    }

    @Step ("Updating Text Field")
    public static void insertKey (WebElement elem, Keys value) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.sendKeys(value);
    }

    @Step ("Getting Text From Element")
    public static String gettingTextFromElement(WebElement elem){
        wait.until(ExpectedConditions.visibilityOf(elem));
        return elem.getText();
    }

    @Step ("Refreshing Page")
    public static void refreshPage() {
        driver.get(getData("url"));
    }

    @Step ("Mouse Hover Element")
    public static void mouseHover(WebElement elem1, WebElement elem2) {
        wait.until(ExpectedConditions.visibilityOf(elem1));
        wait.until(ExpectedConditions.visibilityOf(elem2));
        action.moveToElement(elem1).moveToElement(elem2).click().build().perform();
    }

}
