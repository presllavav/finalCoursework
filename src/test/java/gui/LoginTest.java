package gui;

import com.skillo.POM.HomePage;
import com.skillo.POM.LoginPage;
import gui.base.TestBase;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {


    @Test
    public void declareViaNavigationLoginButtonUserCanNavigateToLoginPage() throws InterruptedException {

        final String USERNAME = "Preslavaa";
        final String PASSWORD = "presi2345";

        HomePage homePage = new HomePage(super.driver, (Logger) log);

        homePage.openHomePage();
        boolean isLogOutButtonShown = homePage.isLogOutButtonShown();
        Assert.assertFalse(isLogOutButtonShown);

        homePage.navigateToLoginPageViaClickOnNavigationLoginButton();

        LoginPage loginPage = new LoginPage(super.driver, (Logger) log);

        loginPage.provideUserName(USERNAME);
        Thread.sleep(30);

        loginPage.providePassword(PASSWORD);
        Thread.sleep(30);

        loginPage.clickOnRememberMeCheckBox();
        Thread.sleep(30);

        loginPage.clickOnLoginSubmitButton();
        Thread.sleep(30);
    }
}