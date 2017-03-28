package org.wso2.is.portal.user.test.ui;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.wso2.carbon.iam.userportal.actionobject.LoginPageAction;

/**
 * UI test for Sign in Test.
 */
public class SignInTest extends SelectDriver {

    private static LoginPageAction loginPageAction;

    private static WebDriver driver;
    private static String loginPage = "https://" + System.getProperty("home") + ":" +
            System.getProperty("port") + "/user-portal/login";
    private static String adminPage = "https://" + System.getProperty("home") + ":" +
            System.getProperty("port") + "/user-portal/";
    private static String usernameRecoveryPage = "https://" + System.getProperty("home") + ":" +
            System.getProperty("port") + "/user-portal/recovery/username";
    private static String passwordRecoveryPage = "https://" + System.getProperty("home") + ":" +
            System.getProperty("port") + "/user-portal/recovery/password";

    @BeforeClass
    public void init() {
        driver = selectDriver(System.getProperty("driver"));
        loginPageAction = new LoginPageAction(driver);
    }

    @Test(groups = "signInTest")
    public void loadLoginPage() throws Exception {

        driver.get(loginPage);
        Assert.assertEquals(driver.getCurrentUrl(), loginPage,
                "This current page is not the login page.");
    }

    @Test(groups = "signInTest", dependsOnMethods = "loadLoginPage")
    public void testLogin() throws Exception {
        String username = System.getProperty("username");
        String password = System.getProperty("password");
        boolean logged = loginPageAction.login(username, password);
        Assert.assertTrue(logged, "Loggin failed.");
        Assert.assertEquals(driver.getCurrentUrl(), adminPage,
                "This current page is not the admin user page.");

    }
    @AfterClass
    public void close() {
        driver.quit();
    }
}
