package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Instagram {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();


        driver.get("https://www.instagram.com/accounts/login/?source=auth_switcher");
        driver.manage().window().maximize();

        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));

        username.sendKeys("fgzn_2");
        password.sendKeys("testtesttest"+ Keys.ENTER);


        Thread.sleep(1000);


       WebElement notNow = driver.findElement(By.xpath("//button[@class='aOOlW   HoLwm ']"));
       notNow.click();

       WebElement profile = driver.findElement(By.linkText("Profile"));

       profile.click();

       Thread.sleep(1000);

       WebElement followers = driver.findElement(By.xpath("//a[@href='fgzn_2/followers/']/span"));

       followers.click();

       Thread.sleep(1000);

       WebElement explore = driver.findElement(By.xpath("//a[@href = '/explore/people']"));

       explore.click();

       Thread.sleep(1000);


       for(int j=0; j<10000; j++) {

           for (int i = 0; i < 65; i++) {
               WebElement follow = driver.findElement(By.xpath("//button[@class='_0mzm- sqdOP  L3NKy       ']"));
               follow.click();

           }
           Thread.sleep(300000);
           driver.close();
       }


    }
}
