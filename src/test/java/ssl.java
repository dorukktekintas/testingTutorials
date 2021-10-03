import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ssl {
    public static void main(String[] args) {


        //ssl ser
        //desired capabilities
        DesiredCapabilities ch = DesiredCapabilities.chrome();
        //ch.acceptInsecureCerts();& one way
        ch.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
        ch.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.merge(ch);
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\dteki\\Desktop\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(chromeOptions);
    }
}
