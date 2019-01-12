package testng;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class Alerts {

    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Ignore
    @Test
    public void warningAlert() throws InterruptedException{
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[.='Click for JS Alert']")).click();
        Thread.sleep(1000);
        Alert firstAlert = driver.switchTo().alert();
        firstAlert.accept();

    }
    @Ignore
    @Test
    public void confirmationAlert() throws InterruptedException{
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[.='Click for JS Confirm']")).click();
        Thread.sleep(1000);
        Alert secondAlert = driver.switchTo().alert();
        secondAlert.dismiss();
    }

    @Test
    public void promptAlert() throws InterruptedException{
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[.='Click for JS Prompt']")).click();
        Thread.sleep(1000);
        Alert thirdAlert = driver.switchTo().alert();
        thirdAlert.sendKeys("This is test");
        Thread.sleep(2000);
        thirdAlert.accept();
        Assert.fail("Purpose");
    }
}












