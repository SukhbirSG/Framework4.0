package pages.PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
    WebDriver driver;
    public DashboardPage(WebDriver driver){
        this.driver=driver;
    }

    private By usernameOnDashboard= By.cssSelector("[data-qa=\"lufexuloga\"]");

    public String loggedinUsername(){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return driver.findElement(usernameOnDashboard).getText();
    }
}
