package sanity;

import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.ElectronFlows;

@Listeners(utilities.Listeners.class)
public class ToDoElectron extends CommonOps {
    @Test(description = "Test01 - Verifies a New Task after Adding")
    @Description("This test adds new task and verifies")
    public void test01_addingNewTaskAndVerify() {
        int before = ElectronFlows.CountNumberOfTasks();
        ElectronFlows.addNewTask("To read the book");
        Verifications.verifyNumberWithNumber(ElectronFlows.CountNumberOfTasks(), before+1);
    }

    @Test(description = "Test02 - Marking Task as Completed")
    @Description("This test marks task as completed")
    public void test02_markingAsComplete() {
        ElectronFlows.MarkingTaskAsCompleted(0);
    }

    @Test(description = "Test03 - Adding Tasks with Data Driven Testing", dataProvider = "data-provider-tasks", dataProviderClass = utilities.ManageDDTList.class)
    @Description("This test verifies adding different tasks, using Data Driven Testing")
    public void test03_addTaskDDTAndVerify(String taskName) {
        int before = ElectronFlows.CountNumberOfTasks();
        ElectronFlows.addNewTask(taskName);
        Verifications.verifyNumberWithNumber(ElectronFlows.CountNumberOfTasks(), before+1);
    }

}
