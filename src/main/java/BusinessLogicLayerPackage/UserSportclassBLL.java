package BusinessLogicLayerPackage;

import DAOlayerPackage.UserDAO;
import DAOlayerPackage.UserProductDAO;
import DAOlayerPackage.UserSportclassDAO;
import ModelsLayerPackage.Sauna;
import DAOlayerPackage.SaunaDAO;
import ModelsLayerPackage.User;
import ModelsLayerPackage.UserProduct;
import ModelsLayerPackage.UserSportclass;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserSportclassBLL {
    private UserSportclassDAO userSportclassDAO;

    public UserSportclassBLL(UserSportclassDAO userSportclassDAO) {
        this.userSportclassDAO = userSportclassDAO;
    }

    /**
     * @return all the pairs of (user - sportclass)
     */
    public List<UserSportclass> findAllPairs() {
        List<UserSportclass> pairs = userSportclassDAO.findAll();
        return pairs;
    }

    /**
     * Inserts a certain pair of (user - sportclass) into UserSportclass table
     * @param userSportclass = the pair of (user - sportclass) that will be inserted
     */
    public void insertPair(UserSportclass userSportclass) {
        userSportclassDAO.insert(userSportclass);
    }

    /**
     * Deletes a certain pair of (user - sportclass) from UserSportclass table
     * @param myUserSportclass = the pair of (user - product) that will be deleted
     */
    public void deletePair(UserSportclass myUserSportclass) {
        userSportclassDAO.delete(myUserSportclass);
    }

    /**
     * Updates a certain pair of (user - sportclass) from the table which has the id_user column value equal to the id received as a parameter
     * @param myUserSportClass = the new pair of (user - sportclass) which will substitute the old (user - sportclass) after the update
     * @param id = the id received as a parameter
     */
    public void updatePair(UserSportclass myUserSportClass, int id) {
        userSportclassDAO.update(myUserSportClass, id);
    }
}
