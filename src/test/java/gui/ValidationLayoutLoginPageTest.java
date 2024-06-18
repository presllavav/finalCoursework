package gui;

import com.skillo.POM.HomePage;
import gui.base.TestBase;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidationLayoutLoginPageTest extends TestBase {
    public static final int WAIT = 3333;

    @Test
    public void validateThereIsALayoutInLoginPage() throws InterruptedException {

        HomePage homePage = new HomePage(super.driver, (Logger) log);

        log.info("STEP 1: Not logged in user has open the ISkilo HomePage.");
        homePage.openHomePage();
        boolean isLogOutButtonShown = homePage.isLogOutButtonShown();
        Assert.assertFalse(isLogOutButtonShown);

        log.info("STEP 2: The user has navigated to ISkilo LoginPage");
        homePage.navigateToLoginPageViaClickOnNavigationLoginButton();



        System.out.println("Validation that there is a layout in login page");

        WebElement element = driver.findElement(By.xpath("/html/body/app-root/div[2]/app-login/div/div/form"));
        boolean isElementShown = element.isDisplayed();
        Assert.assertTrue(isElementShown);

        driver.quit();

    }


}

