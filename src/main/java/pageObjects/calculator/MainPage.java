package pageObjects.calculator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utilities.CommonOps;

public class MainPage extends CommonOps {
    @FindBy(how = How.XPATH, using = "//*[@AutomationId ='num1Button']")
    private WebElement btn_num1;
    public WebElement getNumber1 () {return btn_num1;}

    @FindBy(how = How.XPATH, using = "//*[@AutomationId ='num2Button']")
    private WebElement btn_num2;
    public WebElement getNumber2 () {
        return btn_num2;
    }

    @FindBy(how = How.XPATH, using = "//*[@AutomationId ='num3Button']")
    private WebElement btn_num3;
    public WebElement getNumber3 () {
        return btn_num3;
    }

    @FindBy(how = How.XPATH, using = "//*[@AutomationId ='num4Button']")
    private WebElement btn_num4;
    public WebElement getNumber4 () {
        return btn_num4;
    }

    @FindBy(how = How.XPATH, using = "//*[@AutomationId ='num5Button']")
    private WebElement btn_num5;
    public WebElement getNumber5 () {
        return btn_num5;
    }

    @FindBy(how = How.XPATH, using = "//*[@AutomationId ='num6Button']")
    private WebElement btn_num6;
    public WebElement getNumber6 () {
        return btn_num6;
    }

    @FindBy(how = How.XPATH, using = "//*[@AutomationId ='num7Button']")
    private WebElement btn_num7;
    public WebElement getNumber7 () {
        return btn_num7;
    }

    @FindBy(how = How.XPATH, using = "//*[@AutomationId ='num8Button']")
    private WebElement btn_num8;
    public WebElement getNumber8 () {
        return btn_num8;
    }

    @FindBy(how = How.XPATH, using = "//*[@AutomationId ='num9Button']")
    private WebElement btn_num9;
    public WebElement getNumber9 () {
        return btn_num9;
    }

    @FindBy(how = How.XPATH, using = "//*[@AutomationId ='plusButton']")
    private WebElement btn_plus;
    public WebElement get_plus () {
        return btn_plus;
    }

    @FindBy(how = How.XPATH, using = "//*[@AutomationId ='minusButton']")
    private WebElement btn_minus;
    public WebElement get_minus () {
        return btn_minus;
    }

    @FindBy(how = How.XPATH, using = "//*[@AutomationId ='multiplyButton']")
    private WebElement btn_multiply;
    public WebElement get_multiply () {
        return btn_multiply;
    }

    @FindBy(how = How.XPATH, using = "//*[@AutomationId ='divideButton']")
    private WebElement btn_divide;
    public WebElement get_divide () {
        return btn_divide;
    }

    @FindBy(how = How.XPATH, using = "//*[@AutomationId ='equalButton']")
    private WebElement btn_equal;
    public WebElement get_equal () {
        return btn_equal;
    }

    @FindBy(how = How.XPATH, using = "//*[@AutomationId ='clearButton']")
    private WebElement btn_clear;
    public WebElement get_clear () {
        return btn_clear;
    }

    @FindBy(how = How.XPATH, using = "//*[@AutomationId ='MemPlus']")
    private WebElement btn_memPlus;
    public WebElement get_memPlus () {
        return btn_memPlus;
    }

    @FindBy(how = How.XPATH, using = "//*[@AutomationId ='MemRecall']")
    private WebElement btn_memRecall;
    public WebElement get_memRecall () {
        return btn_memRecall;
    }


    @FindBy(how = How.XPATH, using = "//*[@AutomationId ='CalculatorResults']")
    private WebElement txt_result;
    public WebElement get_result () {
        return txt_result;
    }

}
