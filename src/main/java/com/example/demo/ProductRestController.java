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
public class ProductRestController {
    ProductDAO productDAO = new ProductDAO();
    ProductBLL myProductBLL = new ProductBLL(productDAO);

    ////////////////// Product //////////////////
    @GetMapping("/getProducts")
    public List<Product> getProducts() {
        List<Product> myProducts = myProductBLL.findAllProducts();

        return myProducts;
    }

    @GetMapping("/findProductById")
    public Product findProductByIdRequest(@RequestBody int id){
        if (id > myProductBLL.findBiggestProductId()) {
            System.out.println("There is no product with id " + id);
            return new Product(-1, "", -1, "", -1, -1);
        }
        return myProductBLL.findById(id);
    }

    @GetMapping("/findProductByName")
    public Product findProductByNameRequest(@RequestBody String name) {
        return myProductBLL.findByName(name);
    }

    @RequestMapping(value={"/deleteProduct", "/updateProduct", "/insertProduct"}, method = RequestMethod.POST)
    public String performProductPostRequests(@RequestBody Product product, HttpServletRequest request) {
        if(request.getServletPath().equals("/deleteProduct")) {
            if (myProductBLL.findById(product.getId_product()) != null) {
                myProductBLL.deleteProduct(new Product(product.getId_product(), product.getName(), product.getId_shop_fk(), product.getUtility(), product.getPrice(), product.getQuantity()));
                return "Product deleted succesfully";
            } else {
                return "Product with id " + product.getId_product() + " was not found!";
            }
        } else if (request.getServletPath().equals("/updateProduct")) {
            if (myProductBLL.findById(product.getId_product()) != null) {
                myProductBLL.updateProduct(new Product(product.getId_product(), product.getName(), product.getId_shop_fk(), product.getUtility(), product.getPrice(), product.getQuantity()), product.getId_product());
                return "Product updated succesfully";
            } else {
                return "Product with id " + product.getId_product() + " was not found!";
            }
        } else if (request.getServletPath().equals("/insertProduct")) {
            int currentBiggestId = myProductBLL.findBiggestProductId();
            if (product.getId_product() - 1 != currentBiggestId) {
                return "The {id_product} fields has to be consecutive(last id is " + currentBiggestId + ").";
            }
            myProductBLL.insertProduct(new Product(product.getId_product(), product.getName(), product.getId_shop_fk(), product.getUtility(), product.getPrice(), product.getQuantity()));
            return "Product inserted successfuly!";
        }
        return "Request " + request.getServletPath() + " does not exist!";
    }

}
