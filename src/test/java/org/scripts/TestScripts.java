package org.scripts;

import org.cart.CartPage;
import org.driver.manager.BaseDriver;
import org.fieldcontrols.Navigation;
import org.pom.contact.ContactPage;
import org.pom.contact.ContactSuccessPage;
import org.pom.shop.ShopPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestScripts {

    @BeforeTest
    public void setup() {
        BaseDriver.initialize("Chrome");
        BaseDriver.getDriver().get("http://jupiter.cloud.planittesting.com");
    }

    @Test(description = "Validate error messages")
    public void testcase1() {
        Navigation.Navigate("Contact");
        ContactPage contactPage = new ContactPage();
        contactPage.waitToLoad();
        contactPage.submit_button.click();
        contactPage.verifyErrorMessages();
        contactPage.forename_textfield.sendKeys("Test Name");
        contactPage.email_textfield.sendKeys("test@email.com");
        contactPage.message_textarea.sendKeys("This is a test for Message textbox");
        contactPage.verifyErrorMessages();
        contactPage.clear();

    }

    @Test(description = "Validate if user can submit from Contact Page", invocationCount = 5)
    public void testcase2() {
        Navigation.Navigate("Contact");
        ContactPage contactPage = new ContactPage();
        contactPage.waitToLoad();
        contactPage.forename_textfield.sendKeys("Test Name");
        contactPage.email_textfield.sendKeys("test@email.com");
        contactPage.message_textarea.sendKeys("This is a test for Message textbox");
        contactPage.submit_button.click();

        ContactSuccessPage successPage = new ContactSuccessPage();
        successPage.validateSuccessMessage("Test Name");
        successPage.back_button.click();

    }

    @Test(description = "Vaidate if the prices are correct")
    public void testcase3() {
        Navigation.Navigate("Shop");
        ShopPage shopPage = new ShopPage();
        shopPage.select("Stuffed Frog", 2)
                .select("Fluffy Bunny", 5)
                .select("Valentine Bear", 3);

        Navigation.Navigate("Cart");
        CartPage cartPage = new CartPage();
        cartPage.validateProductPrice();
        cartPage.validateProductSubtotal();
        cartPage.validateTotal();

    }

    @AfterTest
    public void teardown() {
        BaseDriver.stop();
    }
}
