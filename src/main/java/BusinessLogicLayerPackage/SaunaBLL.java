package BusinessLogicLayerPackage;

import DAOlayerPackage.UserDAO;
import ModelsLayerPackage.Sauna;
import DAOlayerPackage.SaunaDAO;
import ModelsLayerPackage.User;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SaunaBLL {
    private SaunaDAO saunaDAO;
    private List<ObserverChannel> channels = new ArrayList<>();

    public SaunaBLL(SaunaDAO saunaDAO) {
        this.saunaDAO = saunaDAO;
        ObserverChannel userObservers = new UserBLL(new UserDAO());
        this.addObserver(userObservers);
    }

    /**
     * Adds an observer to the current observers
     * @param channel = the observer that is going to be added
     */
    public void addObserver(ObserverChannel channel) {
        this.channels.add(channel);
    }

    /**
     * Removes an observer from the currentObservers
     * @param channel = the observer that is going to be removed
     */
    public void removeObserver(ObserverChannel channel) {
        this.channels.remove(channel);
    }

    /**
     * After inserting a new sauna or updating an existing one, the method will be called in order to notify all the observers about the new free saunas
     */
    public void checkForFreeSauna() {
        List<Sauna> saunasList = this.findAllSaunas();
        List<Integer> freeSaunasIdList = new ArrayList<>();
        for (Sauna currentSauna : saunasList) {
            if (currentSauna.getOccupied() == 0) {
                freeSaunasIdList.add(currentSauna.getId_sauna());
            }
        }

        if (freeSaunasIdList.size() == 0) {
            return;
        }

        String saunasIdString = "";
        for (Integer currentId : freeSaunasIdList) {
            saunasIdString = saunasIdString + currentId + ", ";
        }
        for (ObserverChannel currentChannel : channels) {
            currentChannel.update("Free sauna ids: " + saunasIdString + " HURRY UP!");
        }
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
        this.checkForFreeSauna();
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
        this.checkForFreeSauna();
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
