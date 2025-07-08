package sukhbirsingh.vWoTestCases;

import Utils.PropertiesReader;
import driver.DriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PageObjectModel.DashboardPage;
import pages.PageObjectModel.LoginPage;
import sukhbirsingh.base.BaseTest;

import static org.assertj.core.api.Assertions.assertThat;

public class TestvWoLogin_03_POM_PropertyReader_DriverManager extends BaseTest {

    @Owner("Sukhbir")
    @Description("Verify the error message from invalid login")
    @Test
    public void testLoginNegativevWo(){
        LoginPage loginPage=new LoginPage(DriverManager.getDriver());
        String error_text=loginPage.loginwithInvalidcreds(PropertiesReader.readKey("invalid_username"),PropertiesReader.readKey("invalid_password"));
        //AssertJ Assertion
        assertThat(error_text).isNotBlank().isNotBlank().isNotEmpty();

        //Assert TestNG Assertion

        Assert.assertEquals(error_text,PropertiesReader.readKey("error_message"));

    }

    @Owner("Sukhbir")
    @Description("Check with valid credentials whether the valid username is loaded")
    @Test
    public void testLoginPostivevWo(){
        LoginPage loginPage=new LoginPage(DriverManager.getDriver());
        loginPage.loginwithValidcreds(PropertiesReader.readKey("username"),PropertiesReader.readKey("password"));
        DashboardPage dashboardPage=new DashboardPage(DriverManager.getDriver());
        String usernameLoggedIN=dashboardPage.loggedinUsername();
        //AssertJ Assertion
        assertThat(usernameLoggedIN).isNotEmpty().isNotBlank();

        //Assert TestNG Assertion
        Assert.assertEquals(usernameLoggedIN,PropertiesReader.readKey("expected_username"));

    }

}