package BusinessLogicLayerPackage;

import DAOlayerPackage.PasswordDAO;
import ModelsLayerPackage.Password;
import ModelsLayerPackage.Product;
import DAOlayerPackage.ProductDAO;

import java.util.Iterator;
import java.util.List;

public class PasswordBLL {
    private PasswordDAO passwordDAO;

    public PasswordBLL(PasswordDAO passwordDAO) {
        this.passwordDAO = passwordDAO;
    }

    /**
     * @return all the private accounts settings from the Password table
     */
    public List<Password> findAllPasswords() {
        List<Password> passwordsList = passwordDAO.findAll();
        return passwordsList;
    }

    /**
     * Inserts a certain private account settings into Password table
     * @param password = the private account settings that will be inserted
     */
    public void insertAccountDetails(Password password) {
        passwordDAO.insert(password);
    }

    /**
     * Deletes a certain private account settings from Password table
     * @param myPassword = the private account settings that will be deleted
     */
    public void deleteAccountDetails(Password myPassword) {
        passwordDAO.delete(myPassword);
    }

    /**
     * Updates a certain private account settings from the table which has the id_user column value equal to the id received as a parameter
     * @param myPassword = the new private account settings which will substitute the old private account settings after the update
     * @param id = the id received as a parameter
     */
    public void updateAccountDetails(Password myPassword, int id) {
        passwordDAO.update(myPassword, id);
    }

    /**
     * @param id = the id received as a parameter
     * @return the respective product from the Product table for which the id column is equal to the id received as a parameter
     */
    public Password findById(int id) {
        return passwordDAO.findById(id);
    }

    /**
     * @param name = the name received as a parameter
     * @return the respective private account settings from the Password table for which the user-name (name) column is equal to the name received as a parameter
     */
    public Password findByName(String name) {
        return passwordDAO.findByName(name);
    }

    /**
     * @return the value of the greatest id column from the Product table
     */
    public int findBiggestPasswordId() {
        int maxId = 0;
        List<Password> myList = passwordDAO.findAll();
        Iterator<Password> myIt = myList.iterator();
        while (myIt.hasNext()) {
            Password password = myIt.next();
            if (password.getId_user() > maxId)
                maxId = password.getId_user();
        }

        return maxId;
    }
}
