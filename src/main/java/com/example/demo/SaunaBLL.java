package com.example.demo;

import java.util.Iterator;
import java.util.List;

// SaunaBLL va fi defapt ObserverChannel
public class SaunaBLL {
    private SaunaDAO saunaDAO;

    public SaunaBLL(SaunaDAO saunaDAO) {
        this.saunaDAO = saunaDAO;
    }

    public List<Sauna> findAllSaunas() {
        List<Sauna> saunasList = saunaDAO.findAll();
        return saunasList;
    }

    public void insertSauna(Sauna sauna) {
        saunaDAO.insert(sauna);
    }

    /**
     * se va sterge clientul primit ca parametru din tabela Client
     *
     * @param mySauna reprezinta un client
     */
    public void deleteSauna(Sauna mySauna) {
        saunaDAO.delete(mySauna);
    }

    /**
     * metoda va face update pe clientul din tabel care are id_client egal cu id-ul
     * primit ca parametru
     *
     * @param mySauna reprezinta un client din tabela Client
     * @param id       reprezinta un id
     */
    public void updateSauna(Sauna mySauna, int id) {
        saunaDAO.update(mySauna, id);
    }

    /**
     *
     * @param id reprezinta un id
     * @return clientul din tabela Client care are id_client egal cu id-ul primit ca
     *         parametru
     */
    public Sauna findById(int id) {
        return saunaDAO.findById(id);
    }

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
