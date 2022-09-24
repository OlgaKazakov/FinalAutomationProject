package extensions;

import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.sikuli.script.FindFailed;
import utilities.CommonOps;
import workflows.WebFlows;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.FileAssert.fail;

public class Verifications extends CommonOps {

    @Step ("Verify Text in Element")
    public static void verifyTextInElement(WebElement elem, String expected) {
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        assertEquals(elem.getText(), expected);
    }

    @Step ("Verify Text in Mobile Element")
    public static void verifyTextInMobileElement(MobileElement elem, String expected) {
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        assertEquals(elem.getText(), expected);
    }

    @Step ("Verify Number of Elements")
    public static void verifyNumberOfElements(List<WebElement> list, int expected) {
        wait.until(ExpectedConditions.elementToBeClickable(list.get(list.size()-1)));
        assertEquals(list.size(), expected);
    }

    @Step ("Verify Element Visually")
    public static void verifyElementVisually (String expectedImageName){
        try {
            screen.find(getData("ImageRepo")+ expectedImageName +".png");
        } catch (FindFailed e) {
            fail("Error Comparing Image File" + e);
        }
    }

    @Step ("Verify Text in Element (SoftAssertion)")
    public static void verifyTextInElementSoftAssertion(String user, String pass, WebElement element, String expectedTitle, String expectedError) {
        WebFlows.loginWeb(user, pass);
        if (user.equalsIgnoreCase("locked_out_user")) {
            Verifications.verifyTextInElement(loginSaucedemo.getMessage_ErrorLogin(), expectedError);
        }
        else {
            softAssert.assertEquals(element.getText(), expectedTitle, "Sorry, name " + user + " or password " + pass + " are wrong");
        }
        softAssert.assertAll("Some names or passwords are wrong");
    }

    @Step("Verify Text With Text")
    public static void verifyText (String actual, String expected){
        assertEquals(actual, expected);
    }

    @Step("Verify Number With Number")
    public static void verifyNumberWithNumber (int actual, int expected){
        assertEquals(actual, expected);
    }

    @Step("Verify API Response Contains Word")
    public static void verifyAPIResponseContainsWord (Response response, String country){
        assertTrue(response.getBody().asString().contains(country));
    }

    @Step("Verify Element Displayed")
    public static void verifyElementDisplayed (MobileElement elem){
        elem.isDisplayed();
    }


}
