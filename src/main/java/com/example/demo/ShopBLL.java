package com.example.demo;

import java.util.Iterator;
import java.util.List;

public class ShopBLL {
    private ShopDAO shopDAO;

    public ShopBLL(ShopDAO shopDAO) {
        this.shopDAO = shopDAO;
    }

    public List<Shop> findAllShops() {
        List<Shop> shopsList = shopDAO.findAll();
        return shopsList;
    }

    public void insertShop(Shop shop) {
        shopDAO.insert(shop);
    }

    /**
     * se va sterge clientul primit ca parametru din tabela Client
     *
     * @param myShop reprezinta un client
     */
    public void deleteShop(Shop myShop) {
        shopDAO.delete(myShop);
    }

    /**
     * metoda va face update pe clientul din tabel care are id_client egal cu id-ul
     * primit ca parametru
     *
     * @param myShop reprezinta un client din tabela Client
     * @param id       reprezinta un id
     */
    public void updateShop(Shop myShop, int id) {
        shopDAO.update(myShop, id);
    }

    /**
     *
     * @param id reprezinta un id
     * @return clientul din tabela Client care are id_client egal cu id-ul primit ca
     *         parametru
     */
    public Shop findById(int id) {
        return shopDAO.findById(id);
    }

    public int findBiggestShopId() {
        int maxId = 0;
        List<Shop> myList = shopDAO.findAll();
        Iterator<Shop> myIt = myList.iterator();
        while (myIt.hasNext()) {
            Shop shop = myIt.next();
            if (shop.getId_shop() > maxId)
                maxId = shop.getId_shop();
        }

        return maxId;
    }
}
