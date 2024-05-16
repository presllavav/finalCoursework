package gui;

import com.skillo.POM.HomePage;
import gui.base.TestBase;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidationLoginTest extends TestBase {
    public static final int WAIT = 3333;

    @Test
    public void validateThereIsALoginButton() throws InterruptedException {

        HomePage homePage = new HomePage(super.driver, (Logger) log);

        System.out.println("Validate that login button is presented on home page");
        WebElement navLoginButton = driver.findElement(By.cssSelector("#nav-link-login"));
        boolean isNavLoginButtonShown = navLoginButton.isDisplayed();
        Assert.assertTrue(isNavLoginButtonShown);



        driver.quit();
    }




}
