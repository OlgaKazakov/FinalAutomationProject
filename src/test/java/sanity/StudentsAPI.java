package sanity;

import extensions.APIActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.APIFlows;


@Listeners(utilities.Listeners.class)
public class StudentsAPI extends CommonOps {

    @Test(description = "Test01 - Creates New Student and Verify")
    @Description("This test creates new student using API and verifies")
    public void test01_createStudentAndVerify() {
        APIFlows.postStudent("John", "Snow", "snow@gmail.com", "Computer Science");
        Verifications.verifyNumberWithNumber(response.getStatusCode(), 201);
    }

    @Test(description = "Test02 - Updates Data of Student and Verify")
    @Description("This test updates data of student using API and verifies")
    public void test02_updateStudentAndVerify() {
        APIFlows.updateStudent("John", "Snow", "snow@gmail.com", "Automation", "101");
        Verifications.verifyNumberWithNumber(response.getStatusCode(), 200);
    }

    @Test(description = "Test03 - Delete Student and Verify")
    @Description("This test deletes data of student using API and verifies")
    public void test03_deleteStudentAndVerify() {
        APIActions.delete("/student/101");
        Verifications.verifyNumberWithNumber(response.getStatusCode(), 204);
    }

}
