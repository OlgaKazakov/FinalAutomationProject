package sanity;

import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.WebFlows;


@Listeners (utilities.Listeners.class)
public class SaucedemoWeb extends CommonOps {

    @Test (description = "Test01 - Verifies at Title of Mainpage after Login")
    @Description ("This test logins and verifies a title of mainpage")
    public void test01_verifyTitle() {
        WebFlows.loginWeb("standard_user", "secret_sauce");
        Verifications.verifyTextInElement(mainSaucedemo.getTitleMainPage(), "PRODUCTS");
    }

    @Test (description = "Test02 - Verifies Amount of Products")
    @Description ("This test verifies amount of products in product list")
    public void test02_VerifyProductList() {
        Verifications.verifyNumberOfElements(mainSaucedemo.getProductsList(), 6);
    }

    @Test (description = "Test03 - Verifies Adding Product to Cart")
    @Description ("This test adds product to cart and verifies adding")
    public void test03_addToCartAndVerify (){
        WebFlows.addToCart(mainSaucedemo.getBtn_AddBackpack());
        WebFlows.goToCartContainer(mainSaucedemo.getBtn_CartContainer());
        Verifications.verifyTextInElement(cartSaucedemo.getInCart(), "Sauce Labs Backpack");
    }

    @Test (description = "Test04 - Verifies at Checkout")
    @Description ("This test does checkout and verifies at product name and price")
    public void test04_checkoutAndVerify() {
        WebFlows.payment(cartSaucedemo.get_btnCheckout(), "Olga", "K", "12345");
        Verifications.verifyTextInElement(overviewSaucedemo.get_inventName(), "Sauce Labs Backpack");
        Verifications.verifyTextInElement(overviewSaucedemo.get_totalSum(), "Total: $32.39");
    }

    /********
     * This test verifies at login of different users from .csv file using Data Driven Testing
     * and I expect that when username is "locked_out_user" an error message will appear
     ********/

    @Test(description = "Test05 - Login with Data Driven Testing", dataProvider = "data-provider-users", dataProviderClass = utilities.ManageDDT.class)
    @Description("This test verifies login with different users, using Data Driven Testing and SoftAsserts")
    public void test05_loginWithDDTAndVerify(String user, String password) {
        UIActions.refreshPage();
        Verifications.verifyTextInElementSoftAssertion(user, password, mainSaucedemo.getTitleMainPage(), "PRODUCTS", "Epic sadface: Sorry, this user has been locked out.");
    }

}
