package helper;

import com.google.common.util.concurrent.Uninterruptibles;
import extensions.UIActions;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.CommonOps;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

public class tempAPIOpenWeather extends CommonOps {
    public RequestSpecification request; //.
    public Response response; //.

    public String url ="https://api.openweathermap.org/data/2.5/weather";
    public String city = "haifa,il";
    public String key = "e6960be38c61e98ba47ddc49c6b1e2e4";
    public String units ="metric";
    public String valueHumidityAPI;
    public String valueHumidityWeb;

    @Test
    public void test01(){
        RestAssured.baseURI = url;
        request = RestAssured.given();

        response =request.get("?q=" + city + "&appid=" + key + "&units=" + units);
        response.getBody().prettyPrint();
        assertTrue(response.getBody().asString().contains("IL"));

        JsonPath jp = response.jsonPath();
        //humidityAPI = jp.get("main.humidity").toString();
        valueHumidityAPI = jp.getString("main.humidity");
        //System.out.println("humidityAPI is " + humidityAPI);
    }

    @Test
    public void test02_HumidityFromWeb(){
        driver.get("https://openweathermap.org/");
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[placeholder='Search city']")));
        WebElement text_citySearch = driver.findElement(By.cssSelector("input[placeholder='Search city']"));
        text_citySearch.sendKeys(city);
        text_citySearch.sendKeys(Keys.RETURN);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='search-container']/ul/li")));
        WebElement row = driver.findElement(By.xpath("//div[@class='search-container']/ul/li"));
        row.click();
        // get Temperature
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[class='heading']")));
//        System.out.println(driver.findElement(By.cssSelector("span[class='heading']")).getText());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='weather-widget']/div[2]/div/div/div[2]/ul/li[3]")));
        WebElement humidityWeb = driver.findElement(By.xpath("//div[@id='weather-widget']/div[2]/div/div/div[2]/ul/li[3]"));
        valueHumidityWeb = humidityWeb.getText().split("\\n")[1];
        System.out.println("Humidity is " +valueHumidityWeb);
        Assert.assertEquals(valueHumidityAPI+"%", valueHumidityWeb);
    }

}
