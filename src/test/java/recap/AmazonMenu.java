package recap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import utilities.TestBase;

public class AmazonMenu extends TestBase {
    @Ignore
    @Test
    public void amazonTitle() throws InterruptedException {
        driver.get("http://amazon.com");
        Actions action = new Actions(driver);
        WebElement nav = driver.findElement(By.id("icp-nav-flyout"));
        action.moveToElement(nav).perform();
        Thread.sleep(10000);
    }
    @Ignore
    @Test
    public void doubleClick() throws InterruptedException{
        driver.get("https://www.primefaces.org/showcase/ui/misc/effect.xhtml");
        WebElement fold = driver.findElement(By.id("fold_header"));
        Actions action = new Actions(driver);
        action.doubleClick(fold).perform();
        Thread.sleep(3000);
        WebElement footer = driver.findElement(By.className("footer-info-left"));
        action.moveToElement(footer).perform();
        Thread.sleep(6000);

    }
    @Ignore
    @Test
    public void dragAndDrop() throws InterruptedException{
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        Actions actions = new Actions(driver);
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droptarget"));
//        actions.dragAndDrop(source,target).perform();
        actions.clickAndHold(source).moveToElement(target).perform();
        Thread.sleep(3000);
    }

    @Test
    public void upload() throws InterruptedException{
        driver.get("http://the-internet.herokuapp.com/upload");
        WebElement fileUpload = driver.findElement(By.id("file-upload"));
        Thread.sleep(4000);
        fileUpload.sendKeys("/Users/cybertekchicago-1/Desktop/test.txt");
        Thread.sleep(4000);
        driver.findElement(By.id("file-submit")).click();
        Thread.sleep(10000);
    }

}
