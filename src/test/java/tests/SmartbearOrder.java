package tests;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SmartbearOrder {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/ login.aspx");
        driver.manage().window().maximize();
        loginToSmartbear(driver);
        driver.findElement(By.linkText("Order")).click();
        WebElement product = driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct"));
        Select productDropdown = new Select(product);
        productDropdown.selectByVisibleText("FamilyAlbum");
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).sendKeys("2");
        Faker faker = new Faker();
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName")).sendKeys(faker.name().fullName());
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2")).sendKeys(faker.address().streetName());
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3")).sendKeys(faker.address().city());
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4")).sendKeys(faker.address().state());
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).sendKeys(faker.address().zipCode().replace("-",""));
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0")).click();
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys(faker.finance().creditCard().replace("-", ""));
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1")).sendKeys("12/28");
//        driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();
        WebElement message = driver.findElement(By.xpath("//div[@class='buttons_process']//strong"));
        String messageText = message.getText();
        if(messageText.equals("New order has been successfully added.")){
            System.out.println("Order verification PASSED");
        }
        else{
            System.out.println("Order verification FAILED");
        }
        System.out.println(message.isDisplayed());

    }

    public static void loginToSmartbear(WebDriver driver){
        WebElement username = driver.findElement(By.id("ctl00_MainContent_username"));
        WebElement password = driver.findElement(By.id("ctl00_MainContent_password"));
        WebElement loginBtn = driver.findElement(By.id("ctl00_MainContent_login_button"));
        username.sendKeys("Tester");
        password.sendKeys("test");
        loginBtn.click();
    }
}









