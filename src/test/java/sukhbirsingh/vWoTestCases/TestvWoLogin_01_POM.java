package sukhbirsingh.vWoTestCases;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PageObjectModel.DashboardPage;
import pages.PageObjectModel.LoginPage;
import static org.assertj.core.api.Assertions.*;

public class TestvWoLogin_01_POM {

    @Owner("Sukhbir")
    @Description("Verify the error message from invalid login")
    @Test
    public void testLoginNegativevWo(){
        WebDriver driver=new ChromeDriver();
        LoginPage loginPage=new LoginPage(driver);
        String error_text=loginPage.loginwithInvalidcreds("invalid@gmail.com","incorrectpassword");
        assertThat(error_text).isNotBlank().isNotBlank().isNotEmpty();
        Assert.assertEquals(error_text,"Your email, password, IP address or location did not match");

    }

    @Owner("Sukhbir")
    @Description("Check with valid credentials whether the valid username is loaded")
    @Test
    public void testLoginPostivevWo(){
        WebDriver driver=new ChromeDriver();
        LoginPage loginPage=new LoginPage(driver);
        loginPage.loginwithValidcreds("contact+aug@thetestingacademy.com","TtxkgQ!s$rJBk85");
        DashboardPage dashboardPage=new DashboardPage(driver);
        String usernameLoggedIN=dashboardPage.loggedinUsername();

        assertThat(usernameLoggedIN).isNotEmpty().isNotBlank();
        Assert.assertEquals(usernameLoggedIN,"Aman");

    }

}