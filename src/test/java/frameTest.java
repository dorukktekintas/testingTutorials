import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class frameTest {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\dteki\\Desktop\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/demos/droppable");
        driver.switchTo().frame(driver.findElement(By.cssSelector("body.jquery-ui.page.page-id-27.page-template-default.page-slug-droppable.single-author.singular:nth-child(2) div:nth-child(2) div.clearfix.row:nth-child(3) div.content-right.twelve.columns div:nth-child(1) > iframe.demo-frame:nth-child(5)")));
        driver.findElement(By.id("draggable")).click();
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        Actions a = new Actions(driver);
        a.dragAndDrop(source,target).build().perform();
        //exit frame
        driver.switchTo().defaultContent();
    }
}
