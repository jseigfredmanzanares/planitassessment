package org.pom.contact;

import org.driver.manager.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.wait.WaitHandler;

public class ContactSuccessPage {

    public ContactSuccessPage() {
        PageFactory.initElements(BaseDriver.getDriver(), this);
    }

    @FindBy(xpath = "//a[contains(text(),'Back')]")
    @CacheLookup
    public WebElement back_button;

    public void validateSuccessMessage(String name) {
        String actual = WaitHandler.Wait().until(driver -> driver.findElement(By.xpath("//div[contains(@class,'alert-success')]"))).getText().trim();
        Assert.assertEquals(actual, String.format("Thanks %s, we appreciate your feedback.", name));
    }


}
