package org.cart;

public class CheckoutProduct {

    private String item;
    private double price;
    private int qty;
    private double subtotal;

    public CheckoutProduct(String item, double price, int qty, double subtotal) {
        this.item = item;
        this.price = price;
        this.qty = qty;
        this.subtotal = subtotal;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
}
