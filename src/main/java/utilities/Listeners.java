package utilities;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

public class Listeners extends CommonOps implements ITestListener {
    public void onStart (ITestContext execution) {
        System.out.println("------Starting execution-----");
    }
    public void onFinish (ITestContext execution) {
        System.out.println("-----Execution finished-----");
    }
    public void onTestFailedButWithinSuccessPercentage (ITestResult test) {
        //System.out.println("Test Failed But Within Success Percentage");
    }
    public void onTestStart (ITestResult test) {
        System.out.println("----- Starting test: " + test.getName()+" ------");
    }
    public void onTestSuccess (ITestResult test) {
        System.out.println("------ Test: " + test.getName() + " passed -----");

        //stop recording
        if(!platformname.equalsIgnoreCase("api")) {
            try {
                MScreenRecorder.stopRecord();
            } catch (Exception e) {
                e.printStackTrace();
            }

            //delete recorded file
            File file = new File("./test-recordings/" + test.getName() + ".avi");
            if (file.delete())
                System.out.println("File deleted successfully");
            else
                System.out.println("Failed to delete file");
        }
    }
    public void onTestFailure (ITestResult test) {
        System.out.println("----- Test: " + test.getName() + " failed ------");
        saveScreenshot();
        if(!platformname.equalsIgnoreCase("api")) {
            //stop recording
            try {
                MScreenRecorder.stopRecord();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public void onTestSkipped(ITestResult test){
        System.out.println("----- Skipping test: " + test.getName() +" ------");
    }

    @Attachment(value = "Page Screen-Shot", type = "image/png")
    public byte[] saveScreenshot() {
        //       return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        if (!platformname.equalsIgnoreCase("mobile"))
            return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        else
            return ((TakesScreenshot)mobileDriver).getScreenshotAs(OutputType.BYTES);
    }
}

