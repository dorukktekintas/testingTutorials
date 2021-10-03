import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class Try {







        public static void main (String[] args){

            System.setProperty("webdriver.chrome.driver", "C:\\Users\\dteki\\Desktop\\chromedriver\\chromedriver.exe");
            WebDriver driver =new ChromeDriver();
            WebDriverWait w = new WebDriverWait(driver,5);
            // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);//implicit wait fopr 5 seconds
            String[] veggies = {"Cucumber","Brocolli","Beetroot","Carrot"};
            driver.get("https://rahulshettyacademy.com/seleniumPractise/#/"); //URL in the browser

            testExec(driver,veggies);

            driver.findElement(By.cssSelector("div.container header:nth-child(1) div.container div.cart a.cart-icon:nth-child(5) > img:nth-child(1)")).click();



            driver.findElement(By.cssSelector("div.container div.container div.cart div.cart-preview.active:nth-child(6) div.action-block:nth-child(2) > button:nth-child(1)")).click();

            w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")));

            driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")).sendKeys("rahulshettyacademy");
            driver.findElement(By.cssSelector("div.container div.products-wrapper:nth-child(2) div.products div:nth-child(4) div.promoWrapper:nth-child(1) > button.promoBtn:nth-child(2)")).click();

            //explicit wait

            w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Code applied ..!')]")));

            System.out.println(driver.findElement(By.xpath("//span[contains(text(),'Code applied ..!')]")).getText());



            

        }

        public static void testExec(WebDriver driver, String[] veggies){
            List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
            for (int i = 0; i<products.size(); i++){
                String[] name = products.get(i).getText().split("-");
                String formattedName = name[0].trim();


                List itemsNeeded = Arrays.asList(veggies);
                if (itemsNeeded.contains(formattedName)){
                    driver.findElements(By.xpath("//div[@class='product-action']")).get(i).click();
                    //driver.findElement(By.xpath("//h4[contains(text(),'" + formattedName + "')]/following-sibling::div[@class='product-action']/button")).click();

                }


            }

        }
}
