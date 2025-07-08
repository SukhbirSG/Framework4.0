package sukhbirsingh.base;

import driver.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    @BeforeMethod
    public static void starttheBrowser(){
        DriverManager.init();
    }

    @AfterMethod
    public static void tearDown(){
        DriverManager.down();
    }
}
