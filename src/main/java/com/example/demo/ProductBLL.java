package com.example.demo;

import java.util.List;

public class ProductBLL {
    private ProductDAO productDAO;

    public ProductBLL() {
        productDAO = new ProductDAO();
    }

    public List<Product> findAllProducts() {
        List<Product> productsList = productDAO.findAll();
        return productsList;
    }

    public void insertProduct(Product product) {
        productDAO.insert(product);
    }
}
