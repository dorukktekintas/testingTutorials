import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class windows {


    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\dteki\\Desktop\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/#/");
        driver.findElement(By.cssSelector("body:nth-child(2) > a.blinkingText:nth-child(1)")).click();

        //change tab
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentId = it.next();
        String childId = it.next();

        //driver artık bu tabda
        driver.switchTo().window(childId);
        String email = driver.findElement(By.cssSelector("div.page-wrapper div.container div.row div.col-md-8:nth-child(2) p.im-para.red:nth-child(2) strong:nth-child(1) > a:nth-child(1)")).getText();
        driver.switchTo().window(parentId);
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys(email);
        System.out.println(email);

    }
}
