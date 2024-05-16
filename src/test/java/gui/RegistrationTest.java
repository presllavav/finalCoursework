package gui;

import com.skillo.POM.HomePage;
import com.skillo.POM.LoginPage;
import gui.base.TestBase;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase {
    public static final int WAIT = 3333;

    @Test
    public void verifyUserCanNavigateToRegisterPageViaNavigationLoginButton() throws InterruptedException {

        final String USERNAME = "testingDemos";
        final String EMAIL = "testingDemos@abv.bg";
        final String PASSWORD = "testing";
        final String CONFIRMPASSWORD = "testing";

        HomePage homePage = new HomePage(super.driver, (Logger) log);

        log.info("STEP 1: Not logged in user has open the ISkilo HomePage.");
        homePage.openHomePage();
        boolean isLogOutButtonShown = homePage.isLogOutButtonShown();
        Assert.assertFalse(isLogOutButtonShown);

        log.info("STEP 2: The user has navigated to ISkilo LoginPage");
        homePage.navigateToLoginPageViaClickOnNavigationLoginButton();

        log.info("STEP 3: The user has navigated to ISkillo RegisterPage ");
        homePage.navigateToRegisterPageViaClickOnRegisterButton();

        log.info("STEP 4: The user has provided a username");
        LoginPage.provideUsernameRegistration(USERNAME);

        log.info("STEP 5: The user has provided a email");
        LoginPage.provideEmailRegistration(EMAIL);

        log.info("STEP 6: The user has provided a password");
        LoginPage.providePasswordRegistration(PASSWORD);

        log.info("STEP 7: The user has provided a confirmation password");
        LoginPage.provideConfirmPasswordRegistration(CONFIRMPASSWORD);

        log.info("STEP 8: The user has clicked on sign in submit button");
        LoginPage.clickOnSignInSubmitButton();


    }



}
