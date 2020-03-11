package com.example.demo;

public class Sauna {
    private int id_shop;
    private boolean discount_mode;

    public Sauna(int id_shop, boolean discount_mode) {
        this.id_shop = id_shop;
        this.discount_mode = discount_mode;
    }

    public int getId_shop() {
        return id_shop;
    }

    public void setId_shop(int id_shop) {
        this.id_shop = id_shop;
    }

    public boolean isDiscount_mode() {
        return discount_mode;
    }

    public void setDiscount_mode(boolean discount_mode) {
        this.discount_mode = discount_mode;
    }
}
