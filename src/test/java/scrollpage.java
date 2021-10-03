import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class scrollpage {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\dteki\\Desktop\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("https:qaclickacademy.com/practice.php");
        //complete page scroll
        js.executeScript("window.scrollBy(0,900)");
        //scroll specific element
        Thread.sleep(5000L);
        js.executeScript("document.querySelector('.tableFixHead').scrollTop = 5000");


        List<WebElement> valeus = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
        int sum = 0;

        for (int i =0 ; i <valeus.size(); i++){
            sum = sum + Integer.parseInt(valeus.get(i).getText());

        }
        System.out.println(sum);
        String[] compare = driver.findElement(By.cssSelector(".totalAmount")).getText().split(": ");
        System.out.println(compare[1]);
        int compareInt = Integer.parseInt(compare[1]);
        System.out.println(compareInt);
        Assert.assertEquals(sum,compareInt);

    }
}
