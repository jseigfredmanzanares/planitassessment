package org.pom.shop;

public class ProductHandler {

    private static ProductHandler productHandler = new ProductHandler();
    private static Product product;
    private ProductHandler () {

    }

    public static ProductHandler getInstance() { return productHandler; }

    public static Double getPrice(String productName) {
        if (product == null) product = new Product();

        return product.getProductList().get(productName);
    }

    public static boolean isProductExist(String productName) {
        if (product == null) product = new Product();

        return product.getProductList().containsKey(product);
    }
}
