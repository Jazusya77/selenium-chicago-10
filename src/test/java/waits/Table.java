package waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.concurrent.TimeUnit;

public class Table extends TestBase {

    @Ignore
    @Test
    public void amazonTest(){
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.get("http://amazon.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement w =  driver.findElement(By.id("whatever"));
        System.out.println(w.getText());
        driver.findElement(By.name("some name"));
//      Every time you use findElement or findElements
//      driver tries to find element within given timeframe.

    }

    @Test
    public void waitExplicit() throws InterruptedException{
        driver.get("http://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.xpath("//button[.='Start']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[.='Hello World!']")));

        System.out.println("message: " + message.getText());
    }

}
