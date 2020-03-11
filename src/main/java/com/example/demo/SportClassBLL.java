package com.example.demo;

import java.util.List;

public class SportClassBLL {
    private SportClassDAO classDAO;

    public SportClassBLL() {
        classDAO = new SportClassDAO();
    }

    public List<SportClass> findAllClasses() {
        List<SportClass> classesList = classDAO.findAll();
        return classesList;
    }

    public void insertClass(SportClass myClass) {
        classDAO.insert(myClass);
    }
}
