package com.example.entity;

public class CartItem {
    private int id;
    private Product product;
    private int productAmount;
    private int cartId;

    public CartItem() {
    }

    public CartItem(int id, Product product, int productAmount, int cartId) {
        this.id = id;
        this.product = product;
        this.productAmount = productAmount;
        this.cartId = cartId;
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

    public int getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(int productAmount) {
        this.productAmount = productAmount;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    @Override
    public String toString() {
        return "ID =" + this.id + " Product = " + this.product + " productAmount =" + this.productAmount;
    }
}
