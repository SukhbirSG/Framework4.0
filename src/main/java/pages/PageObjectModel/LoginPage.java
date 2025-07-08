package pages.PageObjectModel;

import Utils.PropertiesReader;
import base.basePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends basePage {

    //Page class

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    //Page locators

    private By username = By.id("login-username");
    private By password = By.id("login-password");
    private By signButton = By.id("js-login-btn");
    private By errorMessage = By.id("js-notification-box-msg");


    //Page Actions

    public String loginwithInvalidcreds(String user, String pass) {
        driver.get(PropertiesReader.readKey("url"));
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(signButton).click();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String error_message_text = driver.findElement(errorMessage).getText();
        return error_message_text;
    }

    public void loginwithValidcreds(String user, String pass) {
        driver.get(PropertiesReader.readKey("url"));
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(signButton).click();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
