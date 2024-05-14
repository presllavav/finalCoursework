package com.skillo.POM;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;


public class Iskilo {
    final String BASE_URL = "http://training.skillo-bg.com:4200/";
    WebDriver driver;
    WebDriverWait wait;
    Logger log;

    public Iskilo(WebDriver driver,Logger log) {
        this.driver = driver;
        this.log = log;
        wait = new WebDriverWait(driver, Duration.ofSeconds(7));
    }




    public void waitAndClickOnWebElement(WebElement elm) {
        wait.until(ExpectedConditions.visibilityOf(elm));
        wait.until(ExpectedConditions.elementToBeClickable(elm));
        elm .click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("return document.readyState").equals("complete");

    }

    public void waitAndTypeTextInField(WebElement textField, String inputText){
        wait.until(ExpectedConditions.visibilityOf(textField));
        textField.clear();
        textField.sendKeys(inputText);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("return document.readyState").equals("complete");
    }

    public String requestedUrl(String pageSufix ) {
        return BASE_URL+pageSufix;
    }
    public void navigateTo(String pageURLsufix){
        String currentURL = BASE_URL + pageURLsufix; //for better debug

        driver.get(currentURL);
        log.info("CONFIRM # The user has navigating to : " +currentURL);

        waitPageTobeFullLoaded();
    }

    public boolean isUrlLoaded(String pageURL) {
        waitPageTobeFullLoaded();
        return wait.until(ExpectedConditions.urlContains(pageURL));
    }

    public void waitPageTobeFullLoaded(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("return document.readyState").equals("complete");
    }
}
