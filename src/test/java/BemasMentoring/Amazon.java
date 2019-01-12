package BemasMentoring;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utilities.TestBase;

public class Amazon extends TestBase {
    //public static void main(String[] args) {
        //WebDriverManager.chromedriver().setup();
        //WebDriver driver=new ChromeDriver();


    @Test
            public void Task() {

        driver.get("http://amazon.com");
        WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
        search.sendKeys("Selenium Cookbook" + Keys.ENTER);
    }
        @Test
                public void EachTitle () {
            for(int i=0;i<=10;i++){
                WebElement  result=driver.findElement(By.id("//li[@id='result_"+i+"']//a[@class='a-link-normal s-access-detail-page  s-color-twister-title-link a-text-normal']"));
String BookTitle=result.getText();

            }

        }


    }

