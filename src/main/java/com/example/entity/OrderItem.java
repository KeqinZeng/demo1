package com.example.entity;

public class OrderItem {
    private int id;
    private Product product;
    private int productOrderedAmount;
    private int orderNumber;

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getProductOrderedAmount() {
        return productOrderedAmount;
    }

    public void setProductOrderedAmount(int productOrderedAmount) {
        this.productOrderedAmount = productOrderedAmount;
    }
}
