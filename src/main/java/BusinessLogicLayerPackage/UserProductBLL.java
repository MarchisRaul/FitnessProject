package BusinessLogicLayerPackage;

import DAOlayerPackage.UserDAO;
import DAOlayerPackage.UserProductDAO;
import ModelsLayerPackage.Sauna;
import DAOlayerPackage.SaunaDAO;
import ModelsLayerPackage.User;
import ModelsLayerPackage.UserProduct;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserProductBLL {
    private UserProductDAO userProductDAO;

    public UserProductBLL(UserProductDAO userProductDAO) {
        this.userProductDAO = userProductDAO;
    }

    /**
     * @return all the pairs of (user - product)
     */
    public List<UserProduct> findAllPairs() {
        List<UserProduct> pairs = userProductDAO.findAll();
        return pairs;
    }

    /**
     * Inserts a certain pair of (user - product) into UserProduct table
     * @param userProduct = the pair of (user - product) that will be inserted
     */
    public void insertPair(UserProduct userProduct) {
        userProductDAO.insert(userProduct);
    }

    /**
     * Deletes a certain pair of (user - product) from UserProduct table
     * @param myUserProduct = the pair of (user - product) that will be deleted
     */
    public void deletePair(UserProduct myUserProduct) {
        userProductDAO.delete(myUserProduct);
    }

    /**
     * Updates a certain pair of (user - product) from the table which has the id_user column value equal to the id received as a parameter
     * @param myUserProduct = the new pair of (user - product) which will substitute the old (user - product) after the update
     * @param id = the id received as a parameter
     */
    public void updatePair(UserProduct myUserProduct, int id) {
        userProductDAO.update(myUserProduct, id);
    }
}
