package gui;

import com.skillo.POM.HomePage;
import com.skillo.POM.LoginPage;
import gui.base.TestBase;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase {


    @Test
    public void verifyUserCanNavigateToRegisterPageViaNavigationLoginButton() throws InterruptedException {

        final String USERNAME = "Preslavaa";
        final String EMAIL = "Preslavaa@abv.bg";
        final String PASSWORD = "presi2345";
        final String CONFIRMPASSWORD = "presi2345";




        HomePage homePage = new HomePage(super.driver, (Logger) log);

        log.info("STEP 1: Not logged in user has open the ISkilo HomePage.");
        homePage.openHomePage();
        boolean isLogOutButtonShown = homePage.isLogOutButtonShown();
        Assert.assertFalse(isLogOutButtonShown);


        log.info("STEP 2: The user has navigated to ISkilo LoginPage");
        homePage.navigateToLoginPageViaClickOnNavigationLoginButton();

        log.info("STEP 3: The user has verified that the LoginPage is open as per requirements ");
        LoginPage loginPage = new LoginPage(super.driver, (Logger) log);


        log.info("STEP 4: The user has navigated to ISkillo RegisterPage ");
        homePage.navigateToRegisterPageViaClickOnNavigationRegisterButton();


        log.info("STEP 5: The user has provided a username");
        LoginPage.provideUsernameRegistration(USERNAME);
        Thread.sleep(20);

        log.info("STEP 6: The user has provided a email");
        LoginPage.provideEmailRegistration(EMAIL);
        Thread.sleep(20);



        log.info("STEP 7: The user has provided a password");
        LoginPage.providePasswordRegistration(PASSWORD);
        Thread.sleep(20);


        log.info("STEP 8: The user has provided a confirmation password");
        LoginPage.provideConfirmPasswordRegistration(CONFIRMPASSWORD);
        Thread.sleep(20);


        log.info("STEP 9: The user has clicked on sign in submit button");
        LoginPage.clickOnSignInSubmitButton();


    }



}
