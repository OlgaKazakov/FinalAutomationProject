package utilities;

import org.openqa.selenium.support.PageFactory;

public class ManagePages extends Base{

    public static void initSaucedemo() {
        loginSaucedemo = PageFactory.initElements(driver, pageObjects.sauceDemo.LoginPage.class);
        mainSaucedemo = PageFactory.initElements(driver,pageObjects.sauceDemo.MainPage.class);
        cartSaucedemo = PageFactory.initElements(driver, pageObjects.sauceDemo.CartPage.class);
        checoutSaucedemo = PageFactory.initElements(driver, pageObjects.sauceDemo.CheckoutPage.class);
        overviewSaucedemo = PageFactory.initElements(driver, pageObjects.sauceDemo.ChOverviewPage.class);
    }
}
