package base;

import Utils.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static driver.DriverManager.getDriver;

public class basePage {

    public basePage() {

    }

    //driver.findElement(username).sendKeys(user);
    public void enterUser(By by, String key) {
        getDriver().findElement(by).sendKeys(key);
    }

    //driver.findElement(password).sendKeys(pass);
    public void enterPassword(By by, String key) {
        getDriver().findElement(by).sendKeys(key);
    }

    //driver.findElement(signButton).click();
    public void clickButton(By by) {
        getDriver().findElement(by).click();
    }

    //driver.get(PropertiesReader.readKey("url"));
    public void openvWoUrl() {
        getDriver().get(PropertiesReader.readKey("url"));
    }

    //driver.findElement(errorMessage).getText();
    public String getText(By by) {
        return getDriver().findElement(by).getText();
    }

    public WebElement presenceOfElement(By element) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(5)).until(ExpectedConditions.presenceOfElementLocated(element));
    }

    public WebElement visibilityOfElement(By element) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(element));
    }
    public void customWait(){
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
