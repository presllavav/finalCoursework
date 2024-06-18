package com.skillo.POM;


import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Iskilo{



    @FindBy (id = "defaultLoginFormUsername")
    private WebElement usernameInputField;
    @FindBy (id = "defaultLoginFormPassword")
    private WebElement passwordInputField;

    @FindBy (css = "input[placeholder= 'Username']")
    private static WebElement usernameInputFieldRegistration;
    @FindBy (css = "input[placeholder = 'email']")
    private static WebElement emailInputFieldRegistration;

    @FindBy (id = "defaultRegisterFormPassword")
    private static WebElement passwordInputFieldRegistration;

    @FindBy (id = "defaultRegisterPhonePassword")
    private static WebElement confirmPasswordInputFieldRegistration;
    @FindBy (css = "input[type='checkbox']")
    private WebElement rememberMeCheckBox;
    @FindBy (css = "#sign-in-button")
    private WebElement loginFormSubmitButton;
    @FindBy (id = "sign-in-button")
    private static WebElement signInFormSubmitButton;


    public LoginPage (WebDriver driver, Logger log) {
        super(driver,log);
        PageFactory.initElements(driver,this);
    }


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

    public void clickOnRememberMeCheckBox() {
        waitAndClickOnWebElement(rememberMeCheckBox);
    }

    public void loginWithUSerAndPassword(String userName, String password) {
        provideUserName(userName);
        providePassword(password);
        clickOnLoginSubmitButton();
    }



    }

