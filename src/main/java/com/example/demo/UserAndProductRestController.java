package com.example.demo;

import BusinessLogicLayerPackage.*;
import DAOlayerPackage.*;
import ModelsLayerPackage.*;
import ModelsLayerPackage.GymCardPackage.DiscountForSubscriptionStrategy;
import ModelsLayerPackage.GymCardPackage.SubscriptionManagerFactory;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class UserAndProductRestController {
    UserDAO userDAO = new UserDAO();
    UserBLL myUserBLL = new UserBLL(userDAO);

    ProductDAO productDAO = new ProductDAO();
    ProductBLL myProductBLL = new ProductBLL(productDAO);

    UserProductDAO userProductDAO = new UserProductDAO();
    UserProductBLL userProductBLL = new UserProductBLL(userProductDAO);

    ShopDAO shopDAO = new ShopDAO();
    ShopBLL shopBLL = new ShopBLL(shopDAO);

    @GetMapping("/getProductsForUser")
    public String getProductsForUserRequest(@RequestBody String nameOfUser) {
        User user = myUserBLL.findByName(nameOfUser);

        if (user == null) {
            return "Something went wrong because your name was not found in the database!";
        }

        List<UserProduct> userProducts = userProductBLL.findAllPairs();
        if (userProducts == null) {
            return "Dear user " + nameOfUser + " your shopping history is empty!";
        }

        Map<String, Integer> mapToBeReturned = new HashMap<String, Integer>();

        for (UserProduct currentPair : userProducts) {
            if (currentPair.getId_user() == user.getId_user()) {
                String product = myProductBLL.findById(currentPair.getId_product()).getName();
                if (mapToBeReturned.containsKey(product)) {
                    mapToBeReturned.put(product, mapToBeReturned.get(product) + 1);
                } else {
                    mapToBeReturned.put(product, 1);
                }
            }
        }

        String stringToBeReturned = "Dear " + nameOfUser + ", the products you bought in the past are: \n";
        for (Map.Entry<String, Integer> currentEntry : mapToBeReturned.entrySet()) {
            stringToBeReturned += currentEntry.getValue() + " x " + currentEntry.getKey() + "\n";
        }
        return stringToBeReturned;
    }

    @GetMapping("/getUsersForProduct")
    public String getUsersForProductRequest(@RequestBody String nameOfProduct) {
        Product product = myProductBLL.findByName(nameOfProduct);

        if (product == null) {
            return "Sorry but the product " + nameOfProduct + " does not exist in the database!";
        }

        List<UserProduct> userProductPairs = userProductBLL.findAllPairs();
        Set<String> users = new HashSet<String>();
        for (UserProduct currentPair : userProductPairs) {
            if (currentPair.getId_product() == product.getId_product()) {
                users.add(myUserBLL.findById(currentPair.getId_user()).getName());
            }
        }

        if (users == null || users.size() == 0) {
            return "Sorry but the product " + nameOfProduct + " was not bought by anyone till present!";
        }

        String stringToBeReturned = "Users who bought the product " + nameOfProduct + " in the past are: \n";
        for (String currentUserName : users) {
            stringToBeReturned += currentUserName + "\n";
        }

        return stringToBeReturned;
    }

    @RequestMapping(value={"/buyProductsForUser"}, method = RequestMethod.POST)
    public String buyProductForUser(@RequestParam(value="nameOfUser") String nameOfUser, @RequestParam(value="nameOfProducts") List<String> nameOfProducts, HttpServletRequest request) {

        User user = myUserBLL.findByName(nameOfUser);
        if (user == null) {
            return "Something went wrong because your name was not found in the database!";
        }

        int totalPriceOfProducts = 0;
        List<Product> listOfBoughtProducts = new ArrayList<Product>();
        for (String nameOfProduct : nameOfProducts) {
            Product product = myProductBLL.findByName(nameOfProduct);
            if (product == null) {
                return "Sorry dear " + user.getName() + " but the product " + nameOfProduct + " was not found in the database!";
            }
            if (product.getQuantity() == 0) {
                return "Sorry dear " + user.getName() + " but the product " + nameOfProduct + " is out of stock for the moment!";
            }

            product.setQuantity(product.getQuantity() - 1);
            listOfBoughtProducts.add(product);
            totalPriceOfProducts += product.getPrice();
        }

        List<Shop> allGymShops = shopBLL.findAllShops();
        for (Shop currentShop : allGymShops) {
            if (currentShop.getId_shop() == listOfBoughtProducts.get(0).getId_shop_fk() && currentShop.getDiscount_mode() == 1) {
                totalPriceOfProducts -= 0.1 * totalPriceOfProducts;
                break;
            }
        }

        SubscriptionManagerFactory subscriptionManagerFactory = new SubscriptionManagerFactory();
        DiscountForSubscriptionStrategy subscriptionStrategy = subscriptionManagerFactory.getSubscriptionManager(user.getCard_type());
        int finalPriceOfProducts = subscriptionStrategy.computeFinalPrice(totalPriceOfProducts);

        if (user.getMoney_card() < finalPriceOfProducts) {
            return "Sorry dear " + user.getName() + " but you don't have enough money to buy all the products you selected!";
        }

        user.setMoney_card(user.getMoney_card() - finalPriceOfProducts);
        myUserBLL.updateClient(user, user.getId_user());

        for (Product product : listOfBoughtProducts) {
            myProductBLL.updateProduct(product, product.getId_product());
            userProductBLL.insertPair(new UserProduct(user.getId_user(), product.getId_product()));
        }

        return "We hope you enjoyed buying from our online shopping! The products are going to arrive to you soon.";
    }
}
