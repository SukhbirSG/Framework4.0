package sukhbirsingh.vWoTestCases;

import Utils.PropertiesReader;
import driver.DriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PageObjectModel.DashboardPage;
import pages.PageObjectModel.DashboardPageImproved;
import pages.PageObjectModel.LoginPage;
import pages.PageObjectModel.LoginPageImproved;
import sukhbirsingh.base.BaseTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static org.assertj.core.api.Assertions.assertThat;

public class TestvWoLogin_04_POM_PropertyReader_DriverManagerimproved extends BaseTest {

    private static final Logger logger= LogManager.getLogger(TestvWoLogin_04_POM_PropertyReader_DriverManagerimproved.class);

    @Owner("Sukhbir")
    @Description("Verify the error message from invalid login")
    @Test
    public void testLoginNegativevWo(){

        logger.info("Starting the Negative login scenario");
        LoginPageImproved loginPageImproved=new LoginPageImproved(DriverManager.getDriver());
        String error_text=loginPageImproved.loginwithInvalidcreds(PropertiesReader.readKey("invalid_username"),PropertiesReader.readKey("invalid_password"));
        //AssertJ Assertion
        logger.info("End of Test case and assertions check is below ");
        assertThat(error_text).isNotNull().isNotBlank().isNotEmpty();

        //Assert TestNG Assertion

        Assert.assertEquals(error_text,PropertiesReader.readKey("error_message"));

    }

    @Owner("Sukhbir")
    @Description("Check with valid credentials whether the valid username is loaded")
    @Test
    public void testLoginPostivevWo(){

        logger.info("Starting the Testcases |  Verify that valid creds dashboard page is loaded");
        LoginPageImproved loginPageImproved=new LoginPageImproved(DriverManager.getDriver());
        loginPageImproved.loginwithValidcreds(PropertiesReader.readKey("username"),PropertiesReader.readKey("password"));
        DashboardPageImproved dashboardPageImproved=new DashboardPageImproved(DriverManager.getDriver());
        String usernameLoggedIN=dashboardPageImproved.loggedinUsername();
        //AssertJ Assertion

        logger.info("End and Asserting testLoginPositiveVWO");

        assertThat(usernameLoggedIN).isNotEmpty().isNotBlank();

        //Assert TestNG Assertion
        Assert.assertEquals(usernameLoggedIN,PropertiesReader.readKey("expected_username"));

    }

}