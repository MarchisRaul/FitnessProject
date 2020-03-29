package com.example.demo;

import BusinessLogicLayerPackage.*;
import DAOlayerPackage.*;
import ModelsLayerPackage.*;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RestController
public class SaunaRestController {
    SaunaDAO saunaDAO = new SaunaDAO();
    SaunaBLL mySaunaBLL = new SaunaBLL(saunaDAO);

    ////////////////// Sauna //////////////////
    @GetMapping("/getSaunas")
    public List<Sauna> getSaunas() {
        List<Sauna> mySaunas = mySaunaBLL.findAllSaunas();

        return mySaunas;
    }

    @GetMapping("/findSaunaById")
    public Sauna findSaunaByIdRequest(@RequestBody int id) throws ParseException {
        if (id > mySaunaBLL.findBiggestSaunaId()) {
            System.out.println("There is no sauna with id " + id);
            return new Sauna(-1, -1, new java.sql.Time(1, 45, 0), -1);
        }
        return mySaunaBLL.findById(id);
    }

    @GetMapping("/testObserver")
    public void testObserver() {
        SaunaBLL saunaBLL = new SaunaBLL(new SaunaDAO());
        UserBLL userBLL = new UserBLL(new UserDAO());
        List<User> users = userBLL.findAllClients();
        for (User currentUser : users) {
            saunaBLL.addObserver(currentUser);
        }
    }

    @RequestMapping(value={"/deleteSauna", "/updateSauna", "/insertSauna"}, method = RequestMethod.POST)
    public String performSaunaPostRequests(@RequestBody Sauna sauna, HttpServletRequest request) {
        if(request.getServletPath().equals("/deleteSauna")) {
            if (mySaunaBLL.findById(sauna.getId_sauna()) != null) {
                mySaunaBLL.deleteSauna(new Sauna(sauna.getId_sauna(), sauna.getOccupied(), sauna.getSession_time(), sauna.getSize_number()));
                return "Sauna deleted succesfully";
            } else {
                return "Sauna with id " + sauna.getId_sauna() + " was not found!";
            }
        } else if (request.getServletPath().equals("/updateSauna")) {
            if (mySaunaBLL.findById(sauna.getId_sauna()) != null) {
                mySaunaBLL.updateSauna(new Sauna(sauna.getId_sauna(), sauna.getOccupied(), sauna.getSession_time(), sauna.getSize_number()), sauna.getId_sauna());
                return "Sauna updated succesfully";
            } else {
                return "Sauna with id " + sauna.getId_sauna() + " was not found!";
            }
        } else if (request.getServletPath().equals("/insertSauna")) {
            int currentBiggestId = mySaunaBLL.findBiggestSaunaId();
            if (sauna.getId_sauna() - 1 != currentBiggestId) {
                return "The {id_sauna} fields has to be consecutive(last id is " + currentBiggestId + ").";
            }
            System.out.println(sauna.getSession_time());
            mySaunaBLL.insertSauna(new Sauna(sauna.getId_sauna(), sauna.getOccupied(), sauna.getSession_time(), sauna.getSize_number()));
            return "Sauna inserted successfuly!";
        }
        return "Request " + request.getServletPath() + " does not exist!";
    }

}
