package com.example.demo;

import BusinessLogicLayerPackage.*;
import DAOlayerPackage.*;
import ModelsLayerPackage.*;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@RestController
public class SportClassRestController {
    SportClassDAO sportClassDAO = new SportClassDAO();
    SportClassBLL mySportClassBLL = new SportClassBLL(sportClassDAO);

    ////////////////// SportClass //////////////////
    @CrossOrigin(origins="*")
    @GetMapping("/getSportClasses")
    public List<SportClass> getSportClasses() {
        List<SportClass> mySportClasses =  mySportClassBLL.findAllSportClasses();

        return mySportClasses;
    }

    @CrossOrigin(origins="*")
    @GetMapping("/findSportClassById")
    public SportClass findSportClassByIdRequests(@RequestParam(value="id") int id){
        if (id > mySportClassBLL.findBiggestSportClassId()) {
            System.out.println("There is no sport class with id " + id);
            return new SportClass(-1, "", -1, -1, -1);
        }
        return mySportClassBLL.findById(id);
    }

    @CrossOrigin(origins="*")
    @GetMapping("/findSportClassByName")
    public SportClass findSportClassByNameRequests(@RequestParam(value="name") String name){
        return mySportClassBLL.findByName(name);
    }

    @CrossOrigin(origins="*")
    @RequestMapping(value={"/deleteSportClass", "/updateSportClass", "/insertSportClass"}, method = RequestMethod.POST)
    public String performSportClassPostRequest(@RequestBody SportClass sportClass, HttpServletRequest request) {
        if(request.getServletPath().equals("/deleteSportClass")) {
            if (mySportClassBLL.findById(sportClass.getId_class()) != null) {
                mySportClassBLL.deleteSportClass(new SportClass(sportClass.getId_class(), sportClass.getName(), sportClass.getId_trainer_fk(), sportClass.getMonth_price(), sportClass.getSize_number()));
                return "Sport class deleted succesfully";
            } else {
                return "Sport class with id " + sportClass.getId_class() + " was not found!";
            }
        } else if (request.getServletPath().equals("/updateSportClass")) {
            if (mySportClassBLL.findById(sportClass.getId_class()) != null) {
                mySportClassBLL.updateSportClass(new SportClass(sportClass.getId_class(), sportClass.getName(), sportClass.getId_trainer_fk(), sportClass.getMonth_price(), sportClass.getSize_number()), sportClass.getId_class());
                return "Sport class updated succesfully";
            } else {
                return "Sport class with id " + sportClass.getId_class() + " was not found!";
            }
        } else if (request.getServletPath().equals("/insertSportClass")) {
            int currentBiggestId = mySportClassBLL.findBiggestSportClassId();
            if (sportClass.getId_class() - 1 != currentBiggestId) {
                return "The {id_class} fields has to be consecutive(last id is " + currentBiggestId + ").";
            }
            mySportClassBLL.insertSportClass(new SportClass(sportClass.getId_class(), sportClass.getName(), sportClass.getId_trainer_fk(), sportClass.getMonth_price(), sportClass.getSize_number()));
            return "Sport class inserted successfuly!";
        }
        return "Request " + request.getServletPath() + " does not exist!";
    }
}
