import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class calendar {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\dteki\\Desktop\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.path2usa.com/travel-companions");
        //September 23
        //select day
        driver.findElement(By.xpath("//input[@id='travel_date']")).click();




        //month select
        while (!driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText().contains("November")){
            driver.findElement(By.cssSelector("[class='datepicker-days'] th[class='next']")).click();
        }

        List <WebElement> calendar = driver.findElements(By.className("day"));

        int count  = driver.findElements(By.className("day")).size();

        for (int i= 0; i< count ; i++){
            String text = driver.findElements(By.className("day")).get(i).getText();
            if (text.equalsIgnoreCase("23")){
                driver.findElements(By.className("day")).get(i).click();
                break;
            }

        }


    }
}
