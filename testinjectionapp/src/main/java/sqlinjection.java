/**
 * Created by thanos-imac on 23/6/18.
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class sqlinjection {
    @Test
    public void test() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/thanos-imac/IdeaProjects/testinjectionapp/src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://automation-test-attacks.000webhostapp.com/login.php");

        //TC01
        driver.findElement(By.name("username")).sendKeys("abcd");
        driver.findElement(By.name("password")).sendKeys("anything' or 'x'='x");
        Thread.sleep(2000);
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("password")).clear();

        //TC02
        driver.findElement(By.name("username")).sendKeys("abcd");
        driver.findElement(By.name("password")).sendKeys("'; drop table xyz");
        Thread.sleep(2000);
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("password")).clear();

        //TC03
        driver.findElement(By.name("username")).sendKeys("' UNION SELECT * FROM emp_details --");
        driver.findElement(By.name("password")).sendKeys("abcd");
        Thread.sleep(2000);
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("password")).clear();

        //TC04
        driver.findElement(By.name("username")).sendKeys("';SHUTDOWN; -- ");
        driver.findElement(By.name("password")).sendKeys("abcd");
        Thread.sleep(2000);
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("password")).clear();

        //TC05
        driver.findElement(By.name("username")).sendKeys("'or'1'='1");
        driver.findElement(By.name("password")).sendKeys("'or'1'='1");
        Thread.sleep(2000);
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("password")).clear();

        //TC06
        driver.findElement(By.name("username")).sendKeys("'or'a'='a");
        driver.findElement(By.name("password")).sendKeys("'or'a'='a");
        Thread.sleep(2000);
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("password")).clear();

        //TC07
        driver.findElement(By.name("username")).sendKeys("'or'1'='1 and firstname <> 'Thanos");
        driver.findElement(By.name("password")).sendKeys("'or'1'='1 and firstname <> 'Thanos");
        Thread.sleep(2000);
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("password")).clear();

        //TC08
        driver.findElement(By.name("username")).sendKeys("'or'1'='1 and firstname <> 'Thanos and firstname <> 'Nikos");
        driver.findElement(By.name("password")).sendKeys("'or'1'='1 and firstname <> 'Thanos and firstname <> 'Nikos");
        Thread.sleep(2000);
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("password")).clear();

        //driver.findElement(By.name("Submit")).click();
        //Thread.sleep(2000);
        driver.close();
        driver.quit();
    }
}
