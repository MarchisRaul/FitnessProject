package BusinessLogicLayerPackage;

import ModelsLayerPackage.Product;
import DAOlayerPackage.ProductDAO;

import java.util.Iterator;
import java.util.List;

public class ProductBLL {
    private ProductDAO productDAO;

    public ProductBLL(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    /**
     * @return all the products from the Product table
     */
    public List<Product> findAllProducts() {
        List<Product> productsList = productDAO.findAll();
        return productsList;
    }

    /**
     * Inserts a certain product into Product table
     * @param product = the product that will be inserted
     */
    public void insertProduct(Product product) {
        productDAO.insert(product);
    }

    /**
     * Deletes a certain product from Product table
     * @param myProduct = the product that will be deleted
     */
    public void deleteProduct(Product myProduct) {
        productDAO.delete(myProduct);
    }

    /**
     * Updates a certain product from the table which has the id column value equal to the id received as a parameter
     * @param myProduct = the new product which will substitute the old product after the update
     * @param id = the id received as a parameter
     */
    public void updateProduct(Product myProduct, int id) {
        productDAO.update(myProduct, id);
    }

    /**
     * @param id = the id received as a parameter
     * @return the respective product from the Product table for which the id column is equal to the id received as a parameter
     */
    public Product findById(int id) {
        return productDAO.findById(id);
    }

    /**
     * @param name = the name received as a parameter
     * @return the respective product from the Product table for which the name column is equal to the name received as a parameter
     */
    public Product findByName(String name) {
        return productDAO.findByName(name);
    }

    /**
     * @return the value of the greatest id column from the Product table
     */
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
