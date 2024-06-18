package com.skillo.POM;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProfilePage extends Iskilo{


    @FindBy (css = ".fas.fa-trash-alt")
    private WebElement deleteButton;

    @FindBy (css = "img[src='https://i.imgur.com/Yb3icBJ.jpeg']")
    private WebElement photoForDelete;

    @FindBy(xpath = "//button[normalize-space()='Yes']")
    private WebElement declarationButtonForDelete;

    @FindBy(css = "#nav-link-profile")
    private WebElement navLinkProfile;

    public ProfilePage (WebDriver driver, Logger log) {
        super(driver,log);
        PageFactory.initElements(driver,this);
    }

    public void openProfilePage () {
        wait.until(ExpectedConditions.visibilityOf(navLinkProfile));
        navLinkProfile.click();

    }
    public void clickPost() {
        wait.until(ExpectedConditions.visibilityOf(photoForDelete));
        photoForDelete.click();

    }

    public void deletePost() {
        wait.until(ExpectedConditions.visibilityOf(deleteButton));
        deleteButton.click();
    }
    public void areYouSureDeclaration() {
        wait.until(ExpectedConditions.visibilityOf(declarationButtonForDelete));
        declarationButtonForDelete.click();

    }

}
