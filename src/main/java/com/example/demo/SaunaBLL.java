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
}
