package com.example.demo;

import java.util.List;

public class ClassBLL {
    private ClassDAO classDAO;

    public ClassBLL() {
        classDAO = new ClassDAO();
    }

    public List<Class> findAllClasses() {
        List<Class> classesList = classDAO.findAll();
        return classesList;
    }

    public void insertClass(Class myClass) {
        classDAO.insert(myClass);
    }
}
