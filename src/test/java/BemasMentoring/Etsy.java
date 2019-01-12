package BemasMentoring;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Etsy {
    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("http://etsy.com");
        WebElement search=driver.findElement(By.id("search-query"));
        search.sendKeys("Birthday gift"+ Keys.ENTER);
        WebElement anywhere=driver.findElement(By.xpath("//input[@aria-label='Anywhere']"));
        if(anywhere.isSelected()){
            System.out.println("Anywhere is selected");
        }else {
            System.out.println("Anywhere is not selected ");
        }

        WebElement usa=driver.findElement(By.xpath("//a[@href='https://www.etsy.com/search?q=Birthday+gift&explicit=1&locationQuery=6252001']"));
        if(usa.isSelected()){
            System.out.println("USA is selected");
        } else{
            System.out.println("USA is not selected");
        }

        Thread.sleep(2000);

usa.click();



    }
}
