package com.example.demo;

public class Product {
    private String name;
    private int id_shop_fk;
    private String utility;
    private int price;
    private int quantity;

    public Product(String name, int id_shop_fk, String utility, int price, int quantity) {
        this.name = name;
        this.id_shop_fk = id_shop_fk;
        this.utility = utility;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId_shop_fk() {
        return id_shop_fk;
    }

    public void setId_shop_fk(int id_shop_fk) {
        this.id_shop_fk = id_shop_fk;
    }

    public String getUtility() {
        return utility;
    }

    public void setUtility(String utility) {
        this.utility = utility;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
