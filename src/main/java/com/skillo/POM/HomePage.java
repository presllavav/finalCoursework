package com.skillo.POM;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends Iskilo {
    public static final String HOME_PAGE_URL = "posts/all";

    @FindBy (id = "nav-link-login")
    private WebElement navigationLoginButton;

    @FindBy (xpath = "//ul[contains(@class,'navbar-nav my-ml d-none d-md-block')]")
    private WebElement navigationLogOutButton;

    @FindBy (linkText = "Register")
    private WebElement navigationRegisterButton;

    @FindBy(xpath = "//div[3]//app-post-detail[1]//div[1]//div[2]//div[1]//div[1]//i[1]")
    private WebElement likeButton;

    public HomePage (WebDriver driver, Logger log)  {
        super(driver,log);

        PageFactory.initElements(driver,this);
    }

    public void openHomePage () {
        navigateTo(HOME_PAGE_URL);
    }

    public void navigateToLoginPageViaClickOnNavigationLoginButton(){
        waitAndClickOnWebElement(navigationLoginButton);
    }

    public void navigateToRegisterPageViaClickOnNavigationRegisterButton(){
        waitAndClickOnWebElement(navigationRegisterButton);
    }
    public void likeButton() {
        waitAndClickOnWebElement(likeButton);

    }
    public boolean isLogOutButtonShown(){
        boolean isBUttonShown = false;
        log.info(" ACTION @ The user is verifying if the navigation log out button is presented");
        try {
            wait.until(ExpectedConditions.visibilityOf(navigationLogOutButton));
            log.info("CONFIRM # Navigation logout button is presented to the user");
            isBUttonShown= true;
        } catch ( TimeoutException e) {
            log.error("ERROR ! The navigation logout button was not presented to the user");
            isBUttonShown = false;
        }

        return isBUttonShown;
    }
}