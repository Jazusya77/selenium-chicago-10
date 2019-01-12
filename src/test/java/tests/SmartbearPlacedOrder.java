package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SmartbearPlacedOrder {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/ login.aspx");
        driver.manage().window().maximize();
        SmartbearOrder.loginToSmartbear(driver);
        WebElement susanDate = driver.findElement(By.xpath("//td[.='Susan McLaren']/../td[5]"));
        if(susanDate.getText().equals("01/05/2010")){
            System.out.println("Susan McLaren order date verification PASSED");
        }
        else{
            System.out.println("Susan McLaren order date verification failed");
        }
        verifyOrder(driver, "Bob");
    }

    public static void verifyOrder(WebDriver driver, String orderName){
        List<WebElement> names = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[2]"));
        for (WebElement name: names){
            if (name.getText().equals(orderName)){
                System.out.println("Order name verification PASSED");
                return;
            }
        }
        System.out.println("Order name verification FAILED");
    }
}
