package gui;

import com.skillo.POM.HomePage;
import gui.base.TestBase;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ValidationLayoutTest extends TestBase {

    public static final int WAIT = 3333;

    @Test
    public void validateThereIsAHomeIconInHomePageLayout() throws InterruptedException {

        HomePage homePage = new HomePage(super.driver, (Logger) log);
        homePage.openHomePage();


        WebElement element = driver.findElement(By.id("homeIcon"));
        if(element.isDisplayed() && element.getSize().getWidth() == 126 && element.getSize().getHeight() == 50) {
            System.out.println("Layout validation successful");
        } else {
            System.out.println("Layout validation failed");
        }
        driver.quit();

    }


}
