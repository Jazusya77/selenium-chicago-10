package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeHomepage {

    WebDriver driver;

    public OrangeHomepage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "welcome")
    public WebElement welcomeAdmin;

    @FindBy(id = "aboutDisplayLink")
    public WebElement aboutLink;

    @FindBy(linkText = "Logout")
    public WebElement logoutLink;

    @FindBy(id = "companyInfo")
    public WebElement companyInfo;

    @FindBy(id = "menu__Performance")
    public WebElement performance;

    @FindBy(id = "menu_performance_Configure")
    public WebElement configure;

    @FindBy(id = "menu_performance_searchKpi")
    public WebElement kpis;

    @FindBy(id = "kpi360SearchForm_jobTitleCode")
    public WebElement jobTitleDropdown;

}
