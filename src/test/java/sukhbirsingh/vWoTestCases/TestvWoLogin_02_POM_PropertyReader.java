package sukhbirsingh.vWoTestCases;

import Utils.PropertiesReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PageObjectModel.DashboardPage;
import pages.PageObjectModel.LoginPage;

import static org.assertj.core.api.Assertions.assertThat;

public class TestvWoLogin_02_POM_PropertyReader {

    @Owner("Sukhbir")
    @Description("Verify the error message from invalid login")
    @Test
    public void testLoginNegativevWo(){
        WebDriver driver=new ChromeDriver();
        LoginPage loginPage=new LoginPage(driver);
        String error_text=loginPage.loginwithInvalidcreds(PropertiesReader.readKey("invalid_username"),PropertiesReader.readKey("invalid_password"));
        assertThat(error_text).isNotBlank().isNotBlank().isNotEmpty();
        Assert.assertEquals(error_text,PropertiesReader.readKey("error_message"));

    }

    @Owner("Sukhbir")
    @Description("Check with valid credentials whether the valid username is loaded")
    @Test
    public void testLoginPostivevWo(){
        WebDriver driver=new ChromeDriver();
        LoginPage loginPage=new LoginPage(driver);
        loginPage.loginwithValidcreds(PropertiesReader.readKey("username"),PropertiesReader.readKey("password"));
        DashboardPage dashboardPage=new DashboardPage(driver);
        String usernameLoggedIN=dashboardPage.loggedinUsername();

        assertThat(usernameLoggedIN).isNotEmpty().isNotBlank();
        Assert.assertEquals(usernameLoggedIN,PropertiesReader.readKey("expected_username"));

    }

}