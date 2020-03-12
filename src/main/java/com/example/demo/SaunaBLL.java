package com.example.demo;

import java.util.List;

public class SaunaBLL {
    private SaunaDAO saunaDAO;

    public SaunaBLL() {
        saunaDAO = new SaunaDAO();
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
}
