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

//    @Step("Business Flow: ")
//    public static void GettingTextFromTasks () {
//        for (int i=0; i<mainToDo.get_listOfTasks().size(); i++) {
//            System.out.println(mainToDo.get_listOfTasks().get(i).getText());
//        }
//    }

    @Step("Business Flow: Finding Task By Name")
    public static int FindingTaskByName (String taskCompleted) {
        int number=-1;
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        for (int i=0; i<mainToDo.get_listOfTasks().size(); i++) {
            if(mainToDo.get_listOfTasks().get(i).getText().equalsIgnoreCase(taskCompleted)) {
                System.out.println("Completed Task is: " + mainToDo.get_listOfTasks().get(i).getText());
                number = i;
                System.out.println(number);
                break;
            }
        }
        if(number==-1) {
            throw new RuntimeException("Invalid Task Name");
        }
        return number;
    }

    @Step("Business Flow: Marking Task As Completed")
    public static void MarkingTaskAsCompleted (int num) {
        mainToDo.get_listTaskSymbols().get(num).click();
        //UIActions.mouseHover(mainToDo.get_listTaskSymbols().get(num));
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
    }

    @Step("Business Flow: Deleting Task")
    public static void DeletingTask (int num) {
        UIActions.mouseHover(mainToDo.get_listOfTasks().get(num), mainToDo.get_listTaskDeleteBtn().get(num));
        //mainToDo.get_listTaskDeleteBtn().get(num).click();
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
    }

    @Step("Business Flow: ")
    public static void list () {
        for (int i = 0; i<mainToDo.get_listTaskDelBtn().size(); i++) {
            System.out.println(mainToDo.get_listTaskDelBtn().get(i));
        }
        //mainToDo.get_listTaskDeleteBtn().get(num).click();
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
    }


}
