package workflows;

import extensions.UIActions;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import utilities.CommonOps;


public class DesktopFlows extends CommonOps {

    @Step("Business Flow: Multi-DigitNumber")
    public static void multiDigitNumber(WebElement elem1, WebElement elem2) {
        UIActions.click(elem1);
        UIActions.click(elem2);
    }

    @Step("Business Flow: Adding")
    public static void adding(WebElement elem1, WebElement elem2) {
        UIActions.click(elem1);
        UIActions.click(mainCalculator.get_plus());
        UIActions.click(elem2);
        UIActions.click(mainCalculator.get_equal());
    }

    @Step("Business Flow: Subtraction")
    public static void subtraction(WebElement elem1, WebElement elem2) {
        UIActions.click(elem1);
        UIActions.click(mainCalculator.get_minus());
        UIActions.click(elem2);
        UIActions.click(mainCalculator.get_equal());
    }

    @Step("Business Flow: Multiplying")
    public static void multiplying(WebElement elem1, WebElement elem2) {
        UIActions.click(elem1);
        UIActions.click(mainCalculator.get_multiply());
        UIActions.click(elem2);
        UIActions.click(mainCalculator.get_equal());
    }

    @Step("Business Flow: Dividing")
    public static void dividing(WebElement elem1, WebElement elem2) {
        UIActions.click(elem1);
        UIActions.click(mainCalculator.get_divide());
        UIActions.click(elem2);
        UIActions.click(mainCalculator.get_equal());
    }

    @Step("Business Flow: Deleting Number")
    public static void deleting () {
        UIActions.click(mainCalculator.get_clear());
    }

    @Step("Business Flow: Memory Adding And Recall Button")
    public static void memoryAddingAndRecall (WebElement elem1, WebElement elem2) {
        UIActions.click(elem1);
        UIActions.click(mainCalculator.get_memPlus());
        UIActions.click(elem2);
        UIActions.click(mainCalculator.get_memPlus());
        UIActions.click(mainCalculator.get_memRecall());
    }

}
