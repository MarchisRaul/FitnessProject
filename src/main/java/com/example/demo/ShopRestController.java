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
public class ShopRestController {
    ShopDAO shopDAO = new ShopDAO();
    ShopBLL myShopBLL = new ShopBLL(shopDAO);

    ////////////////// Shop //////////////////
    @CrossOrigin(origins="*")
    @GetMapping("/getShops")
    public List<Shop> getShops() {
        List<Shop> myShops = myShopBLL.findAllShops();

        return myShops;
    }

    @GetMapping("/findShopById")
    public Shop findShopByIdRequest(@RequestBody int id){
        if (id > myShopBLL.findBiggestShopId()) {
            System.out.println("There is no user with id " + id);
            return new Shop(-1, -1);
        }
        return myShopBLL.findById(id);
    }

    @RequestMapping(value={"/deleteShop", "/updateShop", "/insertShop"}, method = RequestMethod.POST)
    public String performShopPostRequests(@RequestBody Shop shop, HttpServletRequest request) {
        if(request.getServletPath().equals("/deleteShop")) {
            if (myShopBLL.findById(shop.getId_shop()) != null) {
                myShopBLL.deleteShop(new Shop(shop.getId_shop(), shop.getDiscount_mode()));
                return "Shop deleted succesfully";
            } else {
                return "Shop with id " + shop.getId_shop() + " was not found!";
            }
        } else if (request.getServletPath().equals("/updateShop")) {
            if (myShopBLL.findById(shop.getId_shop()) != null) {
                myShopBLL.updateShop(new Shop(shop.getId_shop(), shop.getDiscount_mode()), shop.getId_shop());
                return "Shop updated succesfully";
            } else {
                return "Shop with id " + shop.getId_shop() + " was not found!";
            }
        } else if (request.getServletPath().equals("/insertShop")) {
            int currentBiggestId = myShopBLL.findBiggestShopId();
            if (shop.getId_shop() - 1 != currentBiggestId) {
                return "The {id_shop} fields has to be consecutive(last id is " + currentBiggestId + ").";
            }
            myShopBLL.insertShop(new Shop(shop.getId_shop(), shop.getDiscount_mode()));
            return "Shop inserted successfuly!";
        }
        return "Request " + request.getServletPath() + " does not exist!";
    }

}
