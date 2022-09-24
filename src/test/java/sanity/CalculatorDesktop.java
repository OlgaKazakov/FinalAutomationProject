package sanity;

import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.DesktopFlows;

@Listeners(utilities.Listeners.class)
public class CalculatorDesktop extends CommonOps {

    @Test(description = "Test01 - Verifies Adding Action")
    @Description("This test adds two numbers and verifies at result")
    public static void test01_verifyAdding(){
        DesktopFlows.adding(mainCalculator.getNumber1(), mainCalculator.getNumber6());
        Verifications.verifyText(mainCalculator.get_result().getText().split(" ")[2], "7");
    }

    @Test(description = "Test02- Verifies Subtraction Action")
    @Description("This test subtracts one number from another and verifies at result")
    public static void test02_verifySubtraction(){
        DesktopFlows.subtraction(mainCalculator.getNumber9(), mainCalculator.getNumber5());
        Verifications.verifyText(mainCalculator.get_result().getText().split(" ")[2], "4");
    }

    @Test(description = "Test03 - Verifies Multiplying Action")
    @Description("This test multiplies two numbers and verifies at result")
    public static void test03_verifyMultiplying(){
        DesktopFlows.multiplying(mainCalculator.getNumber2(), mainCalculator.getNumber7());
        Verifications.verifyText(mainCalculator.get_result().getText().split(" ")[2], "14");
    }

    @Test(description = "Test04 - Verifies Dividing Action")
    @Description("This test divides one number by another and verifies at result")
    public static void test04_verifyDividing(){
        DesktopFlows.dividing(mainCalculator.getNumber8(), mainCalculator.getNumber4());
        Verifications.verifyText(mainCalculator.get_result().getText().split(" ")[2], "2");
    }

    @Test(description = "Test05 - Verifies Deleting Action")
    @Description("This test deletes number and verifies at result")
    public static void test05_verifyDeleting(){
        UIActions.click(mainCalculator.getNumber3());
        DesktopFlows.deleting();
        Verifications.verifyText(mainCalculator.get_result().getText().split(" ")[2], "0");
    }

    @Test(description = "Test06 - Verifies Inserting Multi-digit Number")
    @Description("This test verifies inserting multi-digit number")
    public static void test06_verifyMultiDigitNumber(){
        DesktopFlows.multiDigitNumber(mainCalculator.getNumber2(), mainCalculator.getNumber3());
        Verifications.verifyText(mainCalculator.get_result().getText().split(" ")[2], "23");
    }

    @Test(description = "Test07 - Verifies Using Memory Buttons")
    @Description("This test verifies using memory buttons")
    public static void test07_verifyMemory(){
        DesktopFlows.memoryAddingAndRecall(mainCalculator.getNumber7(), mainCalculator.getNumber9());
        Verifications.verifyText(mainCalculator.get_result().getText().split(" ")[2], "16");
    }


}
