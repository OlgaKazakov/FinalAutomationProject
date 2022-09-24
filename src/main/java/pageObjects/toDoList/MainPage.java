package pageObjects.toDoList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class MainPage {

    @FindBy(how = How.CSS, using = "input[placeholder='Create a task']")
    private WebElement txt_createTask;
    public WebElement get_createTask() {
        return txt_createTask;
    }

    @FindBy(how = How.CSS, using = "label[class='label_5i8SP']")
    private List <WebElement> listOfTasks;
    public List <WebElement> get_listOfTasks() {
        return listOfTasks;
    }

    @FindBy(how = How.CLASS_NAME, using = "toggleIconsWrapper_2kpi8")
    private List <WebElement> list_taskSymbols;
    public List <WebElement> get_listTaskSymbols() {
        return list_taskSymbols;
    }

    @FindBy(how = How.CLASS_NAME, using = "tag_3u4he")
    private List <WebElement> list_taskDeleteBtn;
    public List <WebElement> get_listTaskDeleteBtn() {
        return list_taskDeleteBtn;
    }

    @FindBy(how = How.CSS, using = "svg[class='destroy_19w1q']")
    private List <WebElement> list_taskDelBtn;
    public List <WebElement> get_listTaskDelBtn() {
        return list_taskDelBtn;
    }

}
