package com.example.entity;

public class Product {
    private int id;
    private String productName;
    private String productInfo;
    private float productPrice;

    public Product(int id, String productName, String productInfo, float productPrice) {
        this.id = id;
        this.productName = productName;
        this.productInfo = productInfo;
        this.productPrice = productPrice;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(String productInfo) {
        this.productInfo = productInfo;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public String toString(){
        return "productId =" + this.id + " ProductName = " + this.productName + " Info =" + this.productInfo + " perPrice = " + this.productPrice ;
    }
}
