package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SmartbearLoginPositive {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/ login.aspx");
        String loginTitle = driver.getTitle();
        if(loginTitle.equals("Web Orders Login")){
            System.out.println("Login title verification PASSED");
        }
        else{
            System.out.println("Login title verification FAILED");
        }
        WebElement username = driver.findElement(By.id("ctl00_MainContent_username"));
        WebElement password = driver.findElement(By.id("ctl00_MainContent_password"));
        WebElement loginBtn = driver.findElement(By.id("ctl00_MainContent_login_button"));
        username.sendKeys("Tester");
        password.sendKeys("test");
        loginBtn.click();
        String newTitle = driver.getTitle();
        if (newTitle.equals("Web Orders")){
            System.out.println("New title verification PASSED");
        }
        else {
            System.out.println("New title verification FAILED");
        }

        String url = driver.getCurrentUrl();
        if (url.equals("http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/")){
            System.out.println("URL verificaiton PASSED");
        }
        else {
            System.out.println("URL verification FAILED");
        }

        driver.findElement(By.linkText("Order")).click();
        WebElement product = driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct"));
        Select productDropdown = new Select(product);
        Thread.sleep(1500);
        productDropdown.selectByValue("FamilyAlbum");

    }
}
