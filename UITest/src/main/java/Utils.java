import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Utils {

    public static void myFindElementById(WebDriver driver, String name, String value)
    {

        WebElement element=driver.findElement(By.id(name));
        if(value.equals("false"))
        {
            element.click();
        }
        else
        {
            element.sendKeys(value);
        }

    }
    public static void myFindElementByClassName(WebDriver driver, String name, String value)
    {

        WebElement element=driver.findElement(By.className(name));
        if(value.equals("false"))
        {
            element.click();
        }
        else
        {
            element.sendKeys(value);
        }

    }

    public static void myFindElementByXpath(WebDriver driver, String name, String value)
    {
        WebElement element= ((ChromeDriver) driver).findElementByXPath(name);
      //  element.click();
      //  WebElement element=driver.findElement(By.className(name));
        if(value.equals("false"))
        {
            element.click();
        }
        else
        {
            element.sendKeys(value);
        }

    }

    public static void myFindElementByName(WebDriver driver, String name, String value)
    {
        WebElement element =  ((ChromeDriver) driver).findElementByName(name);
        if(value.equals("false"))
        {
            element.click();
        }
        else
        {
            element.sendKeys(value);
        }

    }
    public static  void mySleep(int time){   try {
        //页面等待
        Thread.sleep(time);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    }
    public  static boolean isContentAppeared(WebDriver driver,String content) {
        boolean status = false;
        try {
            driver.findElement(By.xpath("//*[contains(.,'" + content + "')]"));
            System.out.println(content + " is appeard!");
            status = true;
        } catch (NoSuchElementException e) {
            status = false;
            System.out.println( content + " doesn't exist!");
        }
        return status;
    }


}
