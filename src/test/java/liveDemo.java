import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class liveDemo {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\dteki\\Desktop\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");





        //click om col
        driver.findElement(By.xpath("//thead/tr[1]/th[1]")).click();
        //capture all values into list
        List<WebElement> elementList = driver.findElements(By.xpath("//tr/td[1]"));
        //capture text of all elements into new original list
        List<String> originalList = elementList.stream().map(s -> s.getText()).collect(Collectors.toList());

        //sort in the list of step 3
        List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());



        //compare lists

        Assert.assertTrue(originalList.equals(sortedList));



        //scan the name colomn with gettext -> rice print price of that veggie

        List<String> price;

        do {



            List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
            price = rows.stream().filter(s->s.getText().contains("Rice")).map(s->getPriceVeggie(s)).collect(Collectors.toList());

        if ((price.size())<1){

            driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/ul[1]/li[7]/a[1]")).click();


        }

        }while (price.size()<1);






    }

    private static String getPriceVeggie(WebElement s) {


        String pricevalue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
        System.out.println(pricevalue);


        return null;
    }

}
