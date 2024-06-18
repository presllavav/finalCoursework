package gui;

import com.skillo.POM.HomePage;
import gui.base.TestBase;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidationLayoutTest extends TestBase {
    @Test
    public void validateThereIsANavigationLinkHomeButtonInHomePageLayout() {

        HomePage homePage = new HomePage(super.driver, (Logger) log);
        log.info("STEP 1: Not logged in user has open the ISkilo HomePage.");
        homePage.openHomePage();
        boolean isLogOutButtonShown = homePage.isLogOutButtonShown();
        Assert.assertFalse(isLogOutButtonShown);


        WebElement layoutElement = driver.findElement(By.id("nav-link-home"));
        Assert.assertTrue(layoutElement.isDisplayed(), "Layout is not displayed on the page");
        String expectedLayout = "Home";
        String actualLayout = layoutElement.getText();

        Assert.assertEquals(actualLayout, expectedLayout, "Layout is not as expected");


        driver.quit();

    }


}
