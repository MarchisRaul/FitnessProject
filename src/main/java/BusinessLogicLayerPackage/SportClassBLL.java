package BusinessLogicLayerPackage;

import ModelsLayerPackage.SportClass;
import DAOlayerPackage.SportClassDAO;

import java.util.Iterator;
import java.util.List;

public class SportClassBLL {
    private SportClassDAO sportClassDAO;

    public SportClassBLL(SportClassDAO sportClassDAO) {
        this.sportClassDAO = sportClassDAO;
    }

    /**
     * @return all the sport classes from the SportClass table
     */
    public List<SportClass> findAllSportClasses() {
        List<SportClass> classesList = sportClassDAO.findAll();
        return classesList;
    }

    /**
     * Inserts a certain sport class into SportClass table
     * @param myClass = the sport class that will be inserted
     */
    public void insertSportClass(SportClass myClass) {
        sportClassDAO.insert(myClass);
    }

    /**
     * Deletes a certain sport class from SportClass table
     * @param mySportClass = the sport class that will be deleted
     */
    public void deleteSportClass(SportClass mySportClass) {
        sportClassDAO.delete(mySportClass);
    }

    /**
     * Updates a certain sport class from the table which has the id column value equal to the id received as a parameter
     * @param mySportClass = the new sport class which will substitute the old sport class after the update
     * @param id = the id received as a parameter
     */
    public void updateSportClass(SportClass mySportClass, int id) {
        sportClassDAO.update(mySportClass, id);
    }

    /**
     * @param id = the id received as a parameter
     * @return the respective sport class from the SportClass table for which the id column is equal to the id received as a parameter
     */
    public SportClass findById(int id) {
        return sportClassDAO.findById(id);
    }

    /**
     * @return the value of the greatest id column from the SportClass table
     */
    public int findBiggestSportClassId() {
        int maxId = 0;
        List<SportClass> myList = sportClassDAO.findAll();
        Iterator<SportClass> myIt = myList.iterator();
        while (myIt.hasNext()) {
            SportClass sportClass = myIt.next();
            if (sportClass.getId_class() > maxId)
                maxId = sportClass.getId_class();
        }

        return maxId;
    }
}
