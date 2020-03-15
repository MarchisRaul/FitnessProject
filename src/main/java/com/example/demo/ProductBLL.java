package com.example.demo;

import java.util.Iterator;
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

    /**
     * se va sterge clientul primit ca parametru din tabela Client
     *
     * @param myProduct reprezinta un client
     */
    public void deleteProduct(Product myProduct) {
        productDAO.delete(myProduct);
    }

    /**
     * metoda va face update pe clientul din tabel care are id_client egal cu id-ul
     * primit ca parametru
     *
     * @param myProduct reprezinta un client din tabela Client
     * @param id       reprezinta un id
     */
    public void updateProduct(Product myProduct, int id) {
        productDAO.update(myProduct, id);
    }

    /**
     *
     * @param id reprezinta un id
     * @return clientul din tabela Client care are id_client egal cu id-ul primit ca
     *         parametru
     */
    public Product findById(int id) {
        return productDAO.findById(id);
    }

    public int findBiggestProductId() {
        int maxId = 0;
        List<Product> myList = productDAO.findAll();
        Iterator<Product> myIt = myList.iterator();
        while (myIt.hasNext()) {
            Product product = myIt.next();
            if (product.getId_product() > maxId)
                maxId = product.getId_product();
        }

        return maxId;
    }
}
