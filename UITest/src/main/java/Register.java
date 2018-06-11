import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Register {

    @Test
    public  void  testRegister( )
    {
        System.setProperty("webdriver.chrome.driver", "D:\\driver\\chromedriver.exe");
        //引用火狐浏览器驱动
        WebDriver driver = new ChromeDriver();

        driver.get("https://epay.163.com");
        driver.manage().window().maximize();
        WebElement register=driver.findElement(By.className("btn-1"));
        register.click();
        WebElement userEmail=driver.findElement(By.id("useremail"));
        userEmail.sendKeys("yyn9test");
        WebElement loginPass=driver.findElement(By.id("loginPass"));
        loginPass.sendKeys("yangyang66*");
        WebElement reLoginPass=driver.findElement(By.id("reLoginPass"));
        reLoginPass.sendKeys("yangyang66*");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        WebElement submitBtn=driver.findElement(By.id("submitBtn"));
        submitBtn.click();
    }









        // driver.close();





}
