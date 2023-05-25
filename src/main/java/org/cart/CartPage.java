package org.cart;

import org.driver.manager.BaseDriver;
import org.fieldcontrols.Table;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pom.shop.ProductHandler;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CartPage {

    Table table;
    List<CheckoutProduct> checkoutProducts;
    double expected;
    public CartPage() {
        WebDriverWait wait = new WebDriverWait(BaseDriver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class='cart-msg']")));
        init();
    }

    public void validateProductPrice() {
        if (checkoutProducts.isEmpty()) throw new IllegalStateException(String.format("No Products were displayed!"));

        for (CheckoutProduct actual : checkoutProducts) {
            Assert.assertEquals(actual.getPrice(),
                    ProductHandler.getPrice(actual.getItem()),
                    String.format("Wrong Price displayed for %s", actual.getItem()));
        }
    }

    public void validateProductSubtotal() {
        if (checkoutProducts.isEmpty()) throw new IllegalStateException(String.format("No Products were displayed!"));

        for (CheckoutProduct actual : checkoutProducts) {
            double e = ProductHandler.getPrice(actual.getItem()) * actual.getQty();
            double a = actual.getSubtotal();
            Assert.assertEquals(a, e, String.format("Wrong subtotal for %s", actual.getItem()));
        }
    }

    public void validateTotal() {
        String tempActual = BaseDriver.getDriver().findElement(By.xpath("//strong[contains(text(),'Total')]")).getText().trim();
        tempActual = tempActual.substring(6);
        double actual = Double.parseDouble(tempActual);
        Assert.assertEquals(actual, expected, "Wrong Total Price");

    }

    private void init() {
        this.table = new Table(BaseDriver.getDriver().findElement(By.xpath("//table")));
        checkoutProducts = new ArrayList<>();

        if (!this.table.isEmpty()) {
            for(WebElement row : this.table.getRowElements()) {
                checkoutProducts.add(new CheckoutProduct(getItem(row),
                                                         getPrice(row),
                                                         getQuantity(row),
                                                         getSubtotal(row))
                );
            }
        }

        expected = 0;
        for (CheckoutProduct a : checkoutProducts) {
            expected += ProductHandler.getPrice(a.getItem()) * a.getQty();
        }
    }

    private String getItem(WebElement row) {
        int column = this.table.getColumnIndexOf("Item");
        String xpath = "./td[" + (column + 1) + "]";
        return row.findElement(By.xpath(xpath)).getText().trim();
    }

    private double getPrice(WebElement row) {
        int column = this.table.getColumnIndexOf("Price");
        String xpath = "./td[" + (column + 1) + "]";
        String text = row.findElement(By.xpath(xpath)).getText().trim();
        return Double.parseDouble(text.substring(1));
    }

    private int getQuantity(WebElement row) {
        int column = this.table.getColumnIndexOf("Quantity");
        String xpath = "./td[" + (column + 1) + "]/input";
        String text = row.findElement(By.xpath(xpath)).getAttribute("value").trim();
        return Integer.parseInt(text);
    }

    private double getSubtotal(WebElement row) {
        int column = this.table.getColumnIndexOf("Subtotal");
        String xpath = "./td[" + (column + 1) + "]";
        String text = row.findElement(By.xpath(xpath)).getText().trim();
        return Double.parseDouble(text.substring(1));
    }


}
