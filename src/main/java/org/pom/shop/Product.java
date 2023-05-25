package org.pom.shop;

import java.util.HashMap;
import java.util.Map;

public class Product {

    private Map<String, Double> productList;

    public Product() {
        productList = new HashMap<>();
        productList.put("Teddy Bear", 12.99);
        productList.put("Stuffed Frog", 10.99);
        productList.put("Handmade Doll", 10.99);
        productList.put("Fluffy Bunny", 9.99);
        productList.put("Smiley Bear", 14.99);
        productList.put("Funny Cow", 10.99);
        productList.put("Valentine Bear", 14.99);
        productList.put("Smiley Face", 9.99);
    }

    public Map<String, Double> getProductList() {
        return productList;
    }

}
