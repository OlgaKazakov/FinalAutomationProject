package workflows;

import extensions.DBActions;
import extensions.UIActions;
import io.qameta.allure.Step;
import utilities.Base;
import utilities.CommonOps;

import java.util.List;

public class WebFromDBFlows extends CommonOps {

    @Step("Business Flow: Login to SauseDemo with Credentials from DB")
    public static void loginDB (String query) {
        driver.get(getData("url"));
        List<String> cred = DBActions.getCredentials(query);
        UIActions.updateText(Base.loginSaucedemo.getUserName(), cred.get(0));
        UIActions.updateText(Base.loginSaucedemo.getPassword(), cred.get(1));
        UIActions.click(Base.loginSaucedemo.getBtnLogin());
    }

}
