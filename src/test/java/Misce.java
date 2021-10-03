import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class Misce {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\dteki\\Desktop\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //maximize windows
        driver.manage().window().maximize();
        //deleting cooking
        driver.manage().deleteAllCookies();
        //delete one cookie
        driver.manage().deleteCookieNamed("sessionKey");

        driver.get("https://www.google.com");

        //take screenshot
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
      //  FileUtils.copyFile(src,new File("C://screenshot.png"));





    }
}
