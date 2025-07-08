package pages.PageObjectModel;

import Utils.PropertiesReader;
import base.basePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageImproved extends basePage {

    //Page class

    WebDriver driver;

    public LoginPageImproved(WebDriver driver) {
        this.driver = driver;
    }
    //Page locators

    private By username = By.id("login-username");
    private By password = By.id("login-password");
    private By signButton = By.id("js-login-btn");
    private By errorMessage = By.id("js-notification-box-msg");


    //Page Actions

    public String loginwithInvalidcreds(String user, String pass) {
        //driver.get(PropertiesReader.readKey("url"));
        openvWoUrl();
        //driver.findElement(username).sendKeys(user);
        enterUser(username,user);
        // driver.findElement(password).sendKeys(pass);
        enterPassword(password,pass);
        //driver.findElement(signButton).click();
        clickButton(signButton);
        customWait();

        /*try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/
        presenceOfElement(errorMessage);
        //String error_message_text = driver.findElement(errorMessage).getText();
        return getText(errorMessage);

    }

    public void loginwithValidcreds(String user, String pass) {
        //driver.get(PropertiesReader.readKey("url"));
        openvWoUrl();
        //driver.findElement(username).sendKeys(user);
        enterUser(username,user);
        //driver.findElement(password).sendKeys(pass);
        enterPassword(password,pass);
        //driver.findElement(signButton).click();
        clickButton(signButton);
        /*try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/
        customWait();

    }
}
