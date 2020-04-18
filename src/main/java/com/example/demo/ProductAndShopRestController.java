package com.example.demo;

import BusinessLogicLayerPackage.*;
import DAOlayerPackage.*;
import ModelsLayerPackage.*;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductAndShopRestController {
    ProductDAO productDAO = new ProductDAO();
    ProductBLL myProductBLL = new ProductBLL(productDAO);

    ShopDAO shopDAO = new ShopDAO();
    ShopBLL myShopBLL = new ShopBLL(shopDAO);

    @GetMapping("/findProductsFromShop")
    public List<Product> findAllProductsFromShopId(@RequestBody int shopId) {
        List<Product> allProducts = myProductBLL.findAllProducts();
        List<Product> productsFromShop = new ArrayList<Product>();

        if (myShopBLL.findById(shopId) == null) {
            return new ArrayList<>();
        }

        for (Product currentProduct : allProducts) {
            if (currentProduct.getId_shop_fk() == shopId) {
                productsFromShop.add(currentProduct);
            }
        }

        return productsFromShop;
    }
}
