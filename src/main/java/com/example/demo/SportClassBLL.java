package com.example.demo;

import java.util.Iterator;
import java.util.List;

public class SportClassBLL {
    private SportClassDAO sportClassDAO;

    public SportClassBLL() {
        sportClassDAO = new SportClassDAO();
    }

    public List<SportClass> findAllSportClasses() {
        List<SportClass> classesList = sportClassDAO.findAll();
        return classesList;
    }

    public void insertSportClass(SportClass myClass) {
        sportClassDAO.insert(myClass);
    }

    /**
     * se va sterge clientul primit ca parametru din tabela Client
     *
     * @param mySportClass reprezinta un client
     */
    public void deleteSportClass(SportClass mySportClass) {
        sportClassDAO.delete(mySportClass);
    }

    /**
     * metoda va face update pe clientul din tabel care are id_client egal cu id-ul
     * primit ca parametru
     *
     * @param mySportClass reprezinta un client din tabela Client
     * @param id       reprezinta un id
     */
    public void updateSportClass(SportClass mySportClass, int id) {
        sportClassDAO.update(mySportClass, id);
    }

    /**
     *
     * @param id reprezinta un id
     * @return clientul din tabela Client care are id_client egal cu id-ul primit ca
     *         parametru
     */
    public SportClass findById(int id) {
        return sportClassDAO.findById(id);
    }

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
