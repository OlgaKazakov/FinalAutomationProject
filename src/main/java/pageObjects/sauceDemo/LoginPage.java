package pageObjects.sauceDemo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utilities.CommonOps;

import java.util.List;

public class LoginPage extends CommonOps {

    @FindBy (how = How.ID, using = "user-name")
    private WebElement txt_userName;

    public LoginPage() {
    }

    public WebElement getUserName() {
        return txt_userName;
    }

    @FindBy (how = How.ID, using = "password")
    private WebElement txt_password;

    public WebElement getPassword() {
        return txt_password;
    }

    @FindBy (how = How.ID, using = "login-button")
    private WebElement btn_login;

    public WebElement getBtnLogin() {
        return btn_login;
    }

    @FindBy (how = How.XPATH, using = "// h3[@data-test ='error']")
    private WebElement message_ErrorLogin;

    public WebElement getMessage_ErrorLogin() {
        return message_ErrorLogin;
    }

//    @FindBy (how = How.CLASS_NAME, using = "svg-inline--fa fa-times-circle fa-w-16 error_icon")
//    private List <WebElement> btn_clearList;

//    public List <WebElement> getBtn_clear() {
//        return btn_clearList;
//    }

}
