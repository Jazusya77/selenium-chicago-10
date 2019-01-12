package testng;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class IFrame {
    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void automationFrame() throws InterruptedException {
        driver.get("http://automationpractice.com");
        Thread.sleep(3000);
        WebElement facebookFrame = driver.findElement(By.xpath("//div[@class='facebook-fanbox']//iframe"));
        driver.switchTo().frame(facebookFrame);
        WebElement ele = driver.findElement(By.xpath("//span[@id='u_0_6']"));
        System.out.println(ele.getText());
        driver.switchTo().defaultContent();
        System.out.println(driver.getTitle());
    }
}
