package com.example.demo;

import java.util.Iterator;
import java.util.List;

public class ShopBLL {
    private ShopDAO shopDAO;

    public ShopBLL(ShopDAO shopDAO) {
        this.shopDAO = shopDAO;
    }

    /**
     * @return all the shops from the Shop table
     */
    public List<Shop> findAllShops() {
        List<Shop> shopsList = shopDAO.findAll();
        return shopsList;
    }

    /**
     * Inserts a certain shop into Shop table
     * @param shop = the shop that will be inserted
     */
    public void insertShop(Shop shop) {
        shopDAO.insert(shop);
    }

    /**
     * Deletes a certain shop from Shop table
     * @param myShop = the shop that will be deleted
     */
    public void deleteShop(Shop myShop) {
        shopDAO.delete(myShop);
    }

    /**
     * Updates a certain shop from the table which has the id column value equal to the id received as a parameter
     * @param myShop = the new shop which will substitute the old shop after the update
     * @param id = the id received as a parameter
     */
    public void updateShop(Shop myShop, int id) {
        shopDAO.update(myShop, id);
    }

    /**
     * @param id = the id received as a parameter
     * @return the respective shop from the Shop table for which the id column is equal to the id received as a parameter
     */
    public Shop findById(int id) {
        return shopDAO.findById(id);
    }

    /**
     * @return the value of the greatest id column from the Shop table
     */
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
