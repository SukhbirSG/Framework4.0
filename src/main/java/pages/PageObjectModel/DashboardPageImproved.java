package pages.PageObjectModel;

import base.basePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPageImproved extends basePage {
    WebDriver driver;
    public DashboardPageImproved(WebDriver driver){
        this.driver=driver;
    }

    private By usernameOnDashboard= By.cssSelector("[data-qa=\"lufexuloga\"]");

    public String loggedinUsername(){

        customWait();
        //return driver.findElement(usernameOnDashboard).getText();
        return getText(usernameOnDashboard);
    }
}
