package sanity;

import extensions.DBActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.WebFromDBFlows;

@Listeners (utilities.Listeners.class)
public class SausedemoDataBase extends CommonOps {

    @Test(description = "Test01 - Finds correct credentials in database and verifies it")
    @Description("This test finds correct credentials in database and verifies it")
    public void test01_verifyCorrectLogin() {
        WebFromDBFlows.loginDB ("SELECT * FROM SauseDemoUsers WHERE Details = 'correct'");
        Verifications.verifyTextInElement(mainSaucedemo.getTitleMainPage(), "PRODUCTS");
    }

    @Test(description = "Test02 - Delete uncorrect credentials in database and verifies it")
    @Description("This test deletes uncorrect credentials in database and verifies it")
    public void test02_deleteUncorrectAndVerify() {
        int before = DBActions.getNumberOfRowsInDB("SELECT COUNT(*) AS Username FROM SauseDemoUsers");
        int num = DBActions.getNumberOfRowsInDB("SELECT COUNT(*) AS Username FROM SauseDemoUsers WHERE Details = 'uncorrect'");
        DBActions.deleteRowsFromDB("DELETE FROM SauseDemoUsers WHERE Details = 'uncorrect'");
        int actual = DBActions.getNumberOfRowsInDB("SELECT COUNT(*) AS Username FROM SauseDemoUsers");
        Verifications.verifyNumberWithNumber(actual, before-num);
    }

    @Test (description = "Test03 - Adding new correct credentials in database and verifies it")
    @Description("This test inserts new correct credentials in database and verifies it")
    public void test03_insertRowAndVerify() {
        int before = DBActions.getNumberOfRowsInDB("SELECT COUNT(*) AS Username FROM SauseDemoUsers");
        DBActions.insertRowsIntoDB("VALUES('performance_glitch_user', 'secret_sauce', 'new')");
        int actual = DBActions.getNumberOfRowsInDB("SELECT COUNT(*) AS Username FROM SauseDemoUsers");
        Verifications.verifyNumberWithNumber(actual, before+1);
    }

    @Test (description = "Test04 - Verifies at new added credentials")
    @Description("This test verifies login with new credentials")
    public void test04_verifyNewUser() {
        WebFromDBFlows.loginDB ("SELECT * FROM SauseDemoUsers WHERE Details =  'new'");
        Verifications.verifyTextInElement(mainSaucedemo.getTitleMainPage(), "PRODUCTS");
    }

 /** Tests 05 and 06 exist to return rows in Database to initial state **/
    @Test(description = "Test05 - Adding Deleted in test02 Row in database and verifies it")
    @Description("This test adds row deleted in test02 in database and verifies it")
    public void test05_insertDeletedRowAndVerify() {
        int before = DBActions.getNumberOfRowsInDB("SELECT COUNT(*) AS Username FROM SauseDemoUsers");
        DBActions.insertRowsIntoDB("VALUES('mistake', 'mistPass', 'uncorrect')");
        int actual = DBActions.getNumberOfRowsInDB("SELECT COUNT(*) AS Username FROM SauseDemoUsers");
        Verifications.verifyNumberWithNumber(actual, before+1);
    }

    @Test(description = "Test06 - Delete new added in test03 credentials in database and verifies it")
    @Description("This test deletes new added in test03 credentials in database and verifies it")
    public void test06_deleteNewAndVerify() {
        int before = DBActions.getNumberOfRowsInDB("SELECT COUNT(*) AS Username FROM SauseDemoUsers");
        int num = DBActions.getNumberOfRowsInDB("SELECT COUNT(*) AS Username FROM SauseDemoUsers WHERE Details = 'new'");
        DBActions.deleteRowsFromDB("DELETE FROM SauseDemoUsers WHERE Details = 'new'");
        int actual = DBActions.getNumberOfRowsInDB("SELECT COUNT(*) AS Username FROM SauseDemoUsers");
        Verifications.verifyNumberWithNumber(actual, before-num);
    }

}
