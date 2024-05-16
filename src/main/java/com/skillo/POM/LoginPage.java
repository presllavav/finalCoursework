package com.skillo.POM;


import org.apache.logging.log4j.Logger;
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
    private static WebElement usernameInputFieldRegistration;
    @FindBy (xpath = "//input[contains(@formcontrolname,'email')]")
    private static WebElement emailInputFieldRegistration;

    @FindBy (xpath = "//input[contains(@formcontrolname,'password')]")
    private static WebElement passwordInputFieldRegistration;

    @FindBy (xpath = "//input[contains(@formcontrolname,'confirmPassword')]")
    private static WebElement confirmPasswordInputFieldRegistration;

    @FindBy (xpath = "//span[contains(text(),'Remember me')]")
    private WebElement rememberMeLabelText;
    @FindBy (xpath = "//input[contains(@formcontrolname,'rememberMe')]")
    private WebElement rememberMeCheckBox;
    @FindBy (css = "#sign-in-button")
    private WebElement loginFormSubmitButton;
    @FindBy (id = "sign-in-button")
    private static WebElement signInFormSubmitButton;
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
    public static void provideUsernameRegistration(String userUsernameRegistration){
        waitAndTypeTextInField(usernameInputFieldRegistration,userUsernameRegistration);
    }
    public static void provideEmailRegistration(String userEmail){
        waitAndTypeTextInField(emailInputFieldRegistration,userEmail);
    }
    public static void providePasswordRegistration(String userPassword){
        waitAndTypeTextInField(passwordInputFieldRegistration,userPassword);
    }
    public static void provideConfirmPasswordRegistration(String userConfirmPassword){
        waitAndTypeTextInField(confirmPasswordInputFieldRegistration,userConfirmPassword);
    }


    public void clickOnLoginSubmitButton(){
        waitAndClickOnWebElement(loginFormSubmitButton);
    }
    public static void clickOnSignInSubmitButton(){
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