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
import java.util.Map;

class NameWrapper {
    List<String> products;

    public List<String> getProducts() {
        return products;
    }

    public void setProducts(List<String> products) {
        this.products = products;
    }
}

@RestController
public class UserAndProductRestController {
    UserDAO userDAO = new UserDAO();
    UserBLL myUserBLL = new UserBLL(userDAO);

    ProductDAO productDAO = new ProductDAO();
    ProductBLL myProductBLL = new ProductBLL(productDAO);

    UserProductDAO userProductDAO = new UserProductDAO();
    UserProductBLL userProductBLL = new UserProductBLL(userProductDAO);

    @GetMapping("/getPairsUserProduct")
    public List<UserProduct> findAllUserProductPairs() {
        List<UserProduct> userProducts = userProductBLL.findAllPairs();

        return userProducts;
    }

    @RequestMapping(value={"/buyProductsForUser"}, method = RequestMethod.POST)
    public String buyProductForUser(@RequestBody String nameOfUser, @RequestBody NameWrapper nameOfProductss, HttpServletRequest request) {
//        String nameOfUser = "";
        List<String> nameOfProducts = new ArrayList<String>();
        nameOfProducts = nameOfProductss.getProducts();
//
//        for (Map.Entry<String, List<String>> entry : json.entrySet()) {
//            nameOfUser = entry.getKey();
//            nameOfProducts = entry.getValue();
//        }

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

        if (user.getMoney_card() < totalPriceOfProducts) {
            return "Sorry dear " + user.getName() + " but you don't have enough money to buy all the products you selected!";
        }

        user.setMoney_card(user.getMoney_card() - totalPriceOfProducts);
        myUserBLL.updateClient(user, user.getId_user());

        for (Product product : listOfBoughtProducts) {
            myProductBLL.updateProduct(product, product.getId_product());
            userProductBLL.insertPair(new UserProduct(user.getId_user(), product.getId_product()));
        }

        return "We hope you enjoyed buying from our online shopping! The products are going to arrive to you soon.";
    }
}
