package org.pom.shop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.wait.WaitHandler;

import java.util.ArrayList;
import java.util.List;

public class ShopPage {

    private  List<WebElement> productList;
    public ShopPage() {
        productList = new ArrayList<>();

        while (productList.isEmpty()) {
            productList = WaitHandler.Wait().until(driver -> driver.findElements(By.xpath("//div[contains(@class,'product')]//li")));
        }
    }

    public ShopPage select(String product, int qty) {
        for (WebElement actual : productList) {
            if (product.trim().equals(getProductName(actual))) {
                clickBuy(actual, qty);
                return this;
            }
        }

        throw new IllegalArgumentException(String.format("Product '%s' was not found in the list", product));
    }


    private  void clickBuy(WebElement root, int qty) {
        for (int x = 0; x < qty; x++) {
            root.findElement(By.xpath(".//a[contains(text(),'Buy')]")).click();
        }
    }

    private  String getProductName(WebElement root) {
        return root.findElement(By.xpath(".//h4")).getText().trim();
    }

}
