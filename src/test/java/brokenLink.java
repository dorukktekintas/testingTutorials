import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class brokenLink  {

    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\dteki\\Desktop\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //broken url
        //step 1 get all urls
        //java method will call url and their status codes check 200 or 404
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        SoftAssert a = new SoftAssert();


        List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
        for (WebElement link: links){
            String url = link.getAttribute("href");

            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("HEAD");
            connection.connect();
            int responseCode = connection.getResponseCode();
            System.out.println(responseCode);

            //soft assert
            a.assertTrue(responseCode<400,"the link with text"+link.getText()+" is broken with code "+ responseCode);



        }
        a.assertAll();



    }
}
