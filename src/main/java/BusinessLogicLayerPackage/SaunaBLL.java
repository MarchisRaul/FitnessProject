package BusinessLogicLayerPackage;

import ModelsLayerPackage.Sauna;
import DAOlayerPackage.SaunaDAO;

import java.util.Iterator;
import java.util.List;

public class SaunaBLL {
    private SaunaDAO saunaDAO;

    public SaunaBLL(SaunaDAO saunaDAO) {
        this.saunaDAO = saunaDAO;
    }

    /**
     * @return all the saunas from the Sauna table
     */
    public List<Sauna> findAllSaunas() {
        List<Sauna> saunasList = saunaDAO.findAll();
        return saunasList;
    }

    /**
     * Inserts a certain sauna into Sauna table
     * @param sauna = the sauna that will be inserted
     */
    public void insertSauna(Sauna sauna) {
        saunaDAO.insert(sauna);
    }

    /**
     * Deletes a certain sauna from Sauna table
     * @param mySauna = the sauna that will be deleted
     */
    public void deleteSauna(Sauna mySauna) {
        saunaDAO.delete(mySauna);
    }

    /**
     * Updates a certain sauna from the table which has the id column value equal to the id received as a parameter
     * @param mySauna = the new sauna which will substitute the old sauna after the update
     * @param id = the id received as a parameter
     */
    public void updateSauna(Sauna mySauna, int id) {
        saunaDAO.update(mySauna, id);
    }

    /**
     * @param id = the id received as a parameter
     * @return the respective sauna from the Sauna table for which the id column is equal to the id received as a parameter
     */
    public Sauna findById(int id) {
        return saunaDAO.findById(id);
    }

    /**
     * @return the value of the greatest id column from the Sauna table
     */
    public int findBiggestSaunaId() {
        int maxId = 0;
        List<Sauna> myList = saunaDAO.findAll();
        Iterator<Sauna> myIt = myList.iterator();
        while (myIt.hasNext()) {
            Sauna sauna = myIt.next();
            if (sauna.getId_sauna() > maxId)
                maxId = sauna.getId_sauna();
        }

        return maxId;
    }
}
