package gui.base;

import com.skillo.POM.HomePage;
import com.skillo.POM.LoginPage;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    public static final int WAIT = 3333;

    @Test
    public void verifyUserCanNavigateToLoginPageViaNavigationLoginButton() throws InterruptedException {

        final String USERNAME = "testingDemos";
        final String PASSWORD = "testing";

        HomePage homePage = new HomePage(super.driver, (Logger) log);

        log.info("STEP 1: Not logged in user has open the ISkilo HomePage.");
        homePage.openHomePage();
        boolean isLogOutButtonShown = homePage.isLogOutButtonShown();
        Assert.assertFalse(isLogOutButtonShown);

        log.info("STEP 2: The user has navigated to ISkilo LoginPage");
        homePage.navigateToLoginPageViaClickOnNavigationLoginButton();

        log.info("STEP 3: The user has verified that the LoginPage is open as per requirements ");
        LoginPage loginPage = new LoginPage(super.driver, (Logger) log);

        log.info("STEP 5: The user has provided a valid username");
        loginPage.provideUserName(USERNAME);

        log.info("STEP 6: The user has provided a valid password");
        loginPage.providePassword(PASSWORD);

        log.info("STEP 7: The user has clicked on login submit button");
        loginPage.clickOnLoginSubmitButton();


    }
}