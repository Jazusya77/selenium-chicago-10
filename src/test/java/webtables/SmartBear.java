package webtables;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.List;

public class SmartBear extends TestBase {

    @Test
    public void orderTables(){
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test" + Keys.ENTER);

        WebElement orderTable = driver.findElement(By.id("ctl00_MainContent_orderGrid"));

        int rowSize = orderTable.findElements(By.tagName("tr")).size();
        System.out.println(rowSize);

        List<WebElement> rows = orderTable.findElements(By.tagName("tr"));
//        for(WebElement row: rows){
//            List<WebElement> columns = row.findElements(By.tagName("td"));
//            for(WebElement column: columns){
//                System.out.print(column.getText() + " | ");
//            }
//            System.out.println();
//            System.out.println("---------------------------");
//        }

        printData2(1,1);
        printData2(4,1);
        printData2(6,3);
    }

    public void printData(int row, int column){
        String xpath = "//table[@id='ctl00_MainContent_orderGrid']//tr[" + (row+1) + "]/td[" + (column+1) + "]";
        WebElement targetElement = driver.findElement(By.xpath(xpath));
        System.out.println(targetElement.getText());
    }

    public void printData2(int row, int column){
        WebElement orderTable = driver.findElement(By.id("ctl00_MainContent_orderGrid"));
        List<WebElement> rows = orderTable.findElements(By.tagName("tr"));
        List<WebElement> columns = rows.get(row).findElements(By.tagName("td"));
        WebElement target = columns.get(column);
        System.out.println(target.getText());
    }

}
