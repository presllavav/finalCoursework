package com.skillo.POM;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;

@SuppressWarnings("CallToPrintStackTrace")
public class PostPage extends Iskilo {

    @FindBy (css = "input[placeholder='dog2.jpg']")
    private WebElement imageTextElement;
    @FindBy (css = ".file[type='file']")
    private WebElement uploadField;
    @FindBy (id = "nav-link-new-post")
    private static WebElement navigationNewPostButton;

    @FindBy(css = ".image-preview")
    private WebElement imageForUpload;

   @FindBy (css = "input[placeholder='Enter you post caption here']")
   private WebElement captionField;

   @FindBy (id = "create-post")
   private WebElement submitButton;

   @FindBy (id = "toast-container")
   private WebElement postIsCreatedNotification;



    public PostPage (WebDriver driver, Logger log) {
        super(driver,log);
        PageFactory.initElements(driver,this);
    }
    public void providePostCaption(String caption) {
        wait.until(ExpectedConditions.visibilityOf(captionField));
        captionField.sendKeys(caption);
        log.info("CONFIRMATION # The user has provided caption text :"+caption);
    }

    public String getImageName() {
        String imageName = imageTextElement.getAttribute("placeholder");
        log.info("CONFIRMATION # The image name is: "+ imageName);
        return imageName;
    }


    public void clickOnButtonNewPost() {
        waitAndClickOnWebElement(navigationNewPostButton);
    }

    public void clickSubmitPostButton() {
        wait.until(ExpectedConditions.visibilityOf(submitButton));
        waitAndClickOnWebElement(submitButton);


    }

    public void uploadAPicture(File file) {
        uploadField.sendKeys(file.getAbsolutePath());
        log.info("CONFIRMATION # The file was successfully uploaded");
    }

    public void postIsCreated(){
        wait.until(ExpectedConditions.visibilityOf(postIsCreatedNotification));
    }
    public boolean isImageVisible() {
        boolean isVisible;

        try {
            isVisible = wait.until(ExpectedConditions.visibilityOf(imageForUpload)).isDisplayed();
            log.info("CONFIRMATION # The file is visible.");
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            log.error("ERROR : The file is not visible");
            isVisible = false;
        }
        return isVisible;

    }


    }




