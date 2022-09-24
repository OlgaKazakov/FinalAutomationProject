package sanity;

import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.MobileFlows;

@Listeners(utilities.Listeners.class)
public class EribankMobile extends CommonOps {

    @Test(description = "Test01 - Verifies at Title of Mainpage after Login")
    @Description("This test logins and verifies a title of mainpage")
    public void test01_loginAndVerify() {
        MobileFlows.login("company", "company");
        Verifications.verifyElementDisplayed(mainEribank.wid_eribank);
        MobileFlows.logout();
    }

    @Test(description = "Test02 - Verifies at Payment")
    @Description("This test does payment and verifies a title")
    public void test02_verifyPayment() {
        MobileFlows.login("company", "company");
        MobileFlows.toPaymentPage();
        MobileFlows.makePayment("1234567", "John", "1");
        Verifications.verifyElementDisplayed(mainEribank.wid_eribank);
        MobileFlows.logout();
    }

    @Test(description = "Test03 - Verifies Adding Report to Page")
    @Description("This test adds report and verifies it")
    public void test03_addingReportAndVerify() {
        MobileFlows.login("company", "company");
        MobileFlows.toReportPage();
        int before = reportEribank.reports.size();
        MobileFlows.addReport();
        Verifications.verifyNumberWithNumber(reportEribank.reports.size(), before+1);
        System.out.println("Adding report: It was "+ before + " reports, and it's "+ reportEribank.reports.size() + " reports now.");
        UIActions.click(reportEribank.btn_back);
        MobileFlows.logout();
    }

    @Test(description = "Test04 - Verifies Deleting Report from Page")
    @Description("This test deletes report and verifies it")
    public void test04_deletingReportAndVerify() {
        MobileFlows.login("company", "company");
        MobileFlows.toReportPage();
        int before = reportEribank.reports.size();
        MobileFlows.deleteReport();
        Verifications.verifyNumberWithNumber(reportEribank.reports.size(), before-1);
        System.out.println("Deleting Report: It was "+ before + " reports, and it's "+ reportEribank.reports.size() + " reports now.");
        UIActions.click(reportEribank.btn_back);
        MobileFlows.logout();
    }
}
