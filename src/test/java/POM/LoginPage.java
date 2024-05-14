package com.skillo.POM;


import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends Iskilo{

    //const
    public static final String LOGIN_PAGE_URL = "http://training.skillo-bg.com:4300/users/login";

    //WebElements or other  UI Map
    @FindBy (css = "p.h4")
    private WebElement loginPageHeaderTitle;
    @FindBy (id = "defaultLoginFormUsername")
    private WebElement usernameInputField;
    @FindBy (id = "defaultLoginFormPassword")
    private WebElement passwordInputField;

    @FindBy (xpath = "//input[contains(@formcontrolname,'username')]")
    private  WebElement usernameInputFieldRegistration;
    @FindBy (xpath = "//input[contains(@formcontrolname,'email')]")
    private  WebElement emailInputFieldRegistration;

    @FindBy (xpath = "//input[contains(@formcontrolname,'password')]")
    private  WebElement passwordInputFieldRegistration;

    @FindBy (xpath = "//input[contains(@formcontrolname,'confirmPassword')]")
    private  WebElement confirmPasswordInputFieldRegistration;

    @FindBy (xpath = "//span[contains(text(),'Remember me')]")
    private WebElement rememberMeLabelText;
    @FindBy (xpath = "//input[contains(@formcontrolname,'rememberMe')]")
    private WebElement rememberMeCheckBox;
    @FindBy (css = "#sign-in-button")
    private WebElement loginFormSubmitButton;
    @FindBy (id = "sign-in-button")
    private WebElement signInFormSubmitButton;
    @FindBy (xpath = "//a[contains(.,'Register')]")
    private WebElement loginFormRegistrationLink;

    //Create a constructor
    public LoginPage (WebDriver driver, Logger log) {
        super(driver,log);
        PageFactory.initElements(driver,this);
    }

    //User Actions
    public void  provideUserName(String userName) {
        waitAndTypeTextInField(usernameInputField,userName);
    }

    public void providePassword(String userPassword){
        waitAndTypeTextInField(passwordInputField,userPassword);
    }
    public void provideUsernameRegistration(String userUsernameRegistration){
        waitAndTypeTextInField(usernameInputFieldRegistration,userUsernameRegistration);
    }
    public void provideEmailRegistration(String userEmail){
        waitAndTypeTextInField(emailInputFieldRegistration,userEmail);
    }
    public void providePasswordRegistration(String userPassword){
        waitAndTypeTextInField(passwordInputFieldRegistration,userPassword);
    }
    public void provideConfirmPasswordRegistration(String userConfirmPassword){
        waitAndTypeTextInField(confirmPasswordInputFieldRegistration,userConfirmPassword);
    }


    public void clickOnLoginSubmitButton(){
        waitAndClickOnWebElement(loginFormSubmitButton);
    }
    public void clickOnSignInSubmitButton(){
        waitAndClickOnWebElement(signInFormSubmitButton);
    }

    public void loginWithUSerAndPassword(String userName, String password) {
        provideUserName(userName);
        providePassword(password);
        clickOnLoginSubmitButton();
    }

    //getters
    public  String getUserNamePlaceHolder () {
        wait.until(ExpectedConditions.visibilityOf(usernameInputField));
        return usernameInputField.getAttribute("value");
    }

    public boolean isUserNamePlaceHolderCorrect(String expectedUserNamePlaceHolder) {
        boolean isPerRequirments = false;
        try {
            String actualUserNamePlaceHolder = getUserNamePlaceHolder();
            isPerRequirments = expectedUserNamePlaceHolder.equals(actualUserNamePlaceHolder);

        }catch (NoSuchElementException e){
            log.error("ERROR ! The username placeHolder is not correct");
            isPerRequirments = false;
        }
        return isPerRequirments;
    }

}