package org.pom.contact;

import org.driver.manager.BaseDriver;
import org.fieldcontrols.WebElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;


import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.wait.WaitHandler;

public class ContactPage {

    public ContactPage() {
        PageFactory.initElements(BaseDriver.getDriver(), this);
    }

    @FindBy(id = "forename")
    @CacheLookup
    public WebElement forename_textfield;

    @FindBy(id = "surname")
    @CacheLookup
    public WebElement surname_textfield;

    @FindBy(id = "email")
    @CacheLookup
    public WebElement email_textfield;

    @FindBy(id = "telephone")
    @CacheLookup
    public WebElement telephone_textfield;

    @FindBy(id = "message")
    @CacheLookup
    public WebElement message_textarea;

    @FindBy(xpath = "//a[contains(text(),'Submit')]")
    @CacheLookup
    public WebElement submit_button;


    public void waitToLoad() {
        WebElement welcome = WaitHandler.Wait().until(driver -> driver.findElement(By.xpath("//strong[text()='We welcome your feedback']")));
    }

    public void clear() {
        this.forename_textfield.clear();
        this.surname_textfield.clear();
        this.email_textfield.clear();
        this.telephone_textfield.clear();
        this.message_textarea.clear();

    }
    public void verifyErrorMessages() {
        String actual = "";
        int errCtr = 0;


        if (this.forename_textfield.getAttribute("value").isEmpty()) {
            errCtr++;
            actual = BaseDriver.getDriver().findElement(By.id("forename-err")).getText().trim();
            Assert.assertEquals(actual, "Forename is required");
        } else {
            Assert.assertFalse(WebElementHelper.isElementPresent(By.id("forename-err")));
        }


        if (this.email_textfield.getAttribute("value").isEmpty()) {
            errCtr++;
            actual = BaseDriver.getDriver().findElement(By.id("email-err")).getText().trim();
            Assert.assertEquals(actual, "Email is required");
        } else {
            Assert.assertFalse(WebElementHelper.isElementPresent(By.id("email-err")));
        }


        if (this.message_textarea.getAttribute("value").isEmpty()) {
            errCtr++;
            actual = BaseDriver.getDriver().findElement(By.id("message-err")).getText().trim();
            Assert.assertEquals(actual, "Message is required");
        } else {
            Assert.assertFalse(WebElementHelper.isElementPresent(By.id("message-err")));
        }


        if (errCtr > 0) {
            actual = BaseDriver.getDriver().findElement(By.xpath("//div[contains(@class,'alert-error')]")).getText().trim();
            Assert.assertEquals(actual, "We welcome your feedback - but we won't get it unless you complete the form correctly.");
        } else {
            Assert.assertFalse(WebElementHelper.isElementPresent(By.xpath("//div[contains(@class,'alert-error')]")));
        }

    }



}
