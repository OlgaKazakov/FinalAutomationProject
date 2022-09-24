package workflows;

import com.google.common.util.concurrent.Uninterruptibles;
import extensions.UIActions;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import utilities.CommonOps;

import java.util.concurrent.TimeUnit;

public class ElectronFlows extends CommonOps {
    @Step("Business Flow: Add New Task to List")
    public static void addNewTask (String taskName) {
        UIActions.updateText(mainToDo.get_createTask(), taskName);
        UIActions.insertKey(mainToDo.get_createTask(), Keys.RETURN);
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
    }

    @Step("Business Flow: Add New Task to List")
    public static int CountNumberOfTasks () {
        return mainToDo.get_listOfTasks().size();
    }

    @Step("Business Flow: Marking Task As Completed")
    public static void MarkingTaskAsCompleted (int num) {
        mainToDo.get_listTaskSymbols().get(num).click();
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
    }

    @Step("Business Flow: ")
    public static void list () {
        for (int i = 0; i<mainToDo.get_listTaskDelBtn().size(); i++) {
            System.out.println(mainToDo.get_listTaskDelBtn().get(i));
        }
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
    }


}
