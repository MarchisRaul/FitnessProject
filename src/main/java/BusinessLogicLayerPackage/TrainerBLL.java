package BusinessLogicLayerPackage;

import ModelsLayerPackage.Trainer;
import DAOlayerPackage.TrainerDAO;

import java.util.Iterator;
import java.util.List;

public class TrainerBLL {
    private TrainerDAO trainerDAO;

    public TrainerBLL(TrainerDAO trainerDAO) {
        this.trainerDAO = trainerDAO;
    }

    /**
     * @return all the trainers from the Trainer table
     */
    public List<Trainer> findAllTrainers() {
        List<Trainer> trainersList = trainerDAO.findAll();
        return trainersList;
    }

    /**
     * Inserts a certain trainer into Trainer table
     * @param trainer = the trainer that will be inserted
     */
    public void insertTrainer(Trainer trainer) {
        trainerDAO.insert(trainer);
    }

    /**
     * Deletes a certain trainer from Trainer table
     * @param myTrainer = the trainer that will be deleted
     */
    public void deleteTrainer(Trainer myTrainer) {
        trainerDAO.delete(myTrainer);
    }

    /**
     * Updates a certain trainer from the table which has the id column value equal to the id received as a parameter
     * @param myTrainer = the new trainer which will substitute the old trainer after the update
     * @param id = the id received as a parameter
     */
    public void updateTrainer(Trainer myTrainer, int id) {
        trainerDAO.update(myTrainer, id);
    }

    /**
     * @param id = the id received as a parameter
     * @return the respective trainer from the Trainer table for which the id column is equal to the id received as a parameter
     */
    public Trainer findById(int id) {
        return trainerDAO.findById(id);
    }

    /**
     * @param name = the name received as a parameter
     * @return the respective trainer from the Trainer table for which the name column is equal to the name received as a parameter
     */
    public Trainer findByName(String name) {
        return trainerDAO.findByName(name);
    }

    /**
     * @return the value of the greatest id column from the Trainer table
     */
    public int findBiggestTrainerId() {
        int maxId = 0;
        List<Trainer> myList = trainerDAO.findAll();
        Iterator<Trainer> myIt = myList.iterator();
        while (myIt.hasNext()) {
            Trainer trainer = myIt.next();
            if (trainer.getId_trainer_pk() > maxId)
                maxId = trainer.getId_trainer_pk();
        }

        return maxId;
    }
}
