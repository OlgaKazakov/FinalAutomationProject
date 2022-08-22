package workflows;

import com.google.common.util.concurrent.Uninterruptibles;
import extensions.UIActions;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import utilities.Base;
import utilities.CommonOps;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebFlows extends CommonOps {

    @Step ("Business Flow: Login")
    public static void loginWeb(String user, String pass) {
        UIActions.updateText(Base.loginSaucedemo.getUserName(), user);
        UIActions.updateText(Base.loginSaucedemo.getPassword(), pass);
        UIActions.click(Base.loginSaucedemo.getBtnLogin());
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        //Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
    }

//    public static void clearLogin(WebElement el1, WebElement el2){
//        UIActions.clearText(el1);
//        UIActions.clearText(el2);
//        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
//    }
//
//    public static void loginClear (List <WebElement> list) {
//        for (WebElement elem: list){
//            UIActions.click(elem);
//        }
//    }

    @Step ("Business Flow: Add at a Product to Cart")
    public static void addToCart (WebElement elem) {
        UIActions.click(elem);
    }

    @Step ("Business Flow: Switching to Cart Container")
    public static void goToCartContainer (WebElement elem) {
        UIActions.click(elem);
    }

    @Step ("Business Flow: Payment")
    public static void payment (WebElement elem, String firstname, String lastname, String postcode){
        UIActions.click(elem);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        //Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        UIActions.updateText(checoutSaucedemo.getTxt_firstName(), firstname);
        UIActions.updateText(checoutSaucedemo.getTxt_lastName(), lastname);
        UIActions.updateText(checoutSaucedemo.getTxt_postalCode(), postcode);
        UIActions.click(checoutSaucedemo.getBtn_continue());
    }

}
