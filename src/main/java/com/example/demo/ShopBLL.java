package com.example.demo;

import java.util.List;

public class ShopBLL {
    private ShopDAO shopDAO;

    public ShopBLL() {
        shopDAO = new ShopDAO();
    }

    public List<Shop> findAllShops() {
        List<Shop> shopsList = shopDAO.findAll();
        return shopsList;
    }

    public void insertTrainer(Shop shop) {
        shopDAO.insert(shop);
    }
}
