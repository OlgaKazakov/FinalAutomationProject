package workflows;

import extensions.MobileActions;
import extensions.UIActions;
import io.qameta.allure.Step;
import utilities.Base;
import utilities.CommonOps;

public class MobileFlows extends CommonOps {

    @Step("Business Flow: Login to Application")
    public static void login (String name, String pass) {
        MobileActions.updateText(Base.loginEribank.txt_username, name);
        MobileActions.updateText(Base.loginEribank.txt_password, pass);
        UIActions.click(Base.loginEribank.btn_login);
    }

    @Step("Business Flow: Go to Payment Page")
    public static void toPaymentPage () {
        UIActions.click(Base.mainEribank.btn_payment);
    }

    @Step("Business Flow: MakePayment")
    public static void makePayment (String phone, String name, String amount) {
        MobileActions.updateText(Base.paymentEribank.txt_phone, phone);
        MobileActions.updateText(Base.paymentEribank.txt_name, name);
        MobileActions.updateText(Base.paymentEribank.txt_amount, amount);
        UIActions.click(Base.paymentEribank.btn_country);
        for (int i=0; i<4; i++){
            MobileActions.swipe(MobileActions.Direction.UP);
            if(Base.paymentEribank.countryMexico.isDisplayed()){
                UIActions.click(Base.paymentEribank.countryMexico);
                break;
            }
        }
        UIActions.click(Base.paymentEribank.btn_sendPayment);
        UIActions.click(Base.paymentEribank.btn_yes);
    }

    @Step("Business Flow: Go to Report Page")
    public static void toReportPage () {
        UIActions.click(Base.mainEribank.btn_expenseReport);
    }

    @Step("Business Flow: Adding Report")
    public static void addReport () {
        UIActions.click(Base.reportEribank.btn_add);
    }

    @Step("Business Flow: Deleting Report")
    public static void deleteReport () {
        UIActions.click(Base.reportEribank.reports.get(0));
    }

    @Step("Business Flow: Logout")
    public static void logout () {
        UIActions.click(mainEribank.btn_logout);
    }

}
