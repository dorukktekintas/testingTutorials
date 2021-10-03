import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class seleniumGrid {
    public static void main(String[] args) throws MalformedURLException {

        //DesiredCapabilities

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setBrowserName("chrome");
        desiredCapabilities.setPlatform(Platform.WINDOWS);


        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),desiredCapabilities);
        driver.get("https://google.com");




    }
}
