package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.OrangeHomepage;
import pages.OrangeLoginPage;
import utilities.Config;
import utilities.Driver;
import utilities.TestBase;

import java.util.List;

public class OrangeAdmin extends TestBase {

    @Ignore
    @Test
    public void login(){
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("admin123");
        driver.findElement(By.id("btnLogin")).click();
        WebElement admin = driver.findElement(By.id("welcome"));
        Assert.assertTrue(admin.isDisplayed());
    }

    @Ignore
    @Test
    public void loginVerification(){
        driver.get("https://opensource-demo.orangehrmlive.com/");
        OrangeLoginPage olp = new OrangeLoginPage();

        olp.login("Admin", "admin123");

        OrangeHomepage ohp = new OrangeHomepage(driver);
        Assert.assertTrue(ohp.welcomeAdmin.isDisplayed());
        ohp.welcomeAdmin.click();
        ohp.aboutLink.click();
        Assert.assertTrue(ohp.companyInfo.getText().contains("OrangeHRM"));
    }
    @Ignore
    @Test
    public void jobTitleVerification(){
        driver.get("https://opensource-demo.orangehrmlive.com/");
        OrangeLoginPage olp = new OrangeLoginPage();
        olp.login("Admin", "admin123");
        OrangeHomepage ohp = new OrangeHomepage(driver);
        Actions actions = new Actions(driver);
        actions.moveToElement(ohp.performance).perform();
        actions.moveToElement(ohp.configure).perform();
        ohp.kpis.click();
        Select jobTitle = new Select(ohp.jobTitleDropdown);
        List<WebElement> options = jobTitle.getOptions();
        boolean found = false;
        for(WebElement option: options){
            System.out.println(option.getText());
            if(option.getText().equals("CEO")){
                found = true;
                break;
            }
        }
        Assert.assertTrue(found);
    }

    @Test
    public void negativeLogin(){
        Driver.getDriver().get(Config.getProperty("url"));


    }


}
