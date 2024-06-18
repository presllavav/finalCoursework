package gui;

import com.skillo.POM.HomePage;
import com.skillo.POM.LoginPage;
import gui.base.TestBase;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LikePostTest extends TestBase {
    @Test
    public void likePost(){
        final String USERNAME = "Preslavaa";
        final String PASSWORD = "presi2345";

        HomePage homePage = new HomePage(super.driver, (Logger) log);

        homePage.openHomePage();
        boolean isLogOutButtonShown = homePage.isLogOutButtonShown();
        Assert.assertFalse(isLogOutButtonShown);

        homePage.navigateToLoginPageViaClickOnNavigationLoginButton();

        LoginPage loginPage = new LoginPage(super.driver, (Logger) log);

        loginPage.provideUserName(USERNAME);

        loginPage.providePassword(PASSWORD);

        loginPage.clickOnRememberMeCheckBox();

        loginPage.clickOnLoginSubmitButton();

        homePage.likeButton();

    }

}
