package com.example.demo;

import BusinessLogicLayerPackage.*;
import DAOlayerPackage.*;
import ModelsLayerPackage.*;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class UserAndSportClassRestController {
    UserDAO userDAO = new UserDAO();
    UserBLL myUserBLL = new UserBLL(userDAO);

    SportClassDAO sportClassDAO = new SportClassDAO();
    SportClassBLL sportClassBLL = new SportClassBLL(sportClassDAO);

    UserSportclassDAO userSportClassDAO = new UserSportclassDAO();
    UserSportclassBLL userSportClassBLL = new UserSportclassBLL(userSportClassDAO);

    @GetMapping("/getSportClassesForUser")
    public String getSportClassesForUserRequest(@RequestBody String nameOfUser) {
        User user = myUserBLL.findByName(nameOfUser);

        if (user == null) {
            return "Something went wrong because your name was not found in the database!";
        }


    }

    @GetMapping("/getUsersForSportClass")
    public String getUsersForSportClassRequest(@RequestBody String nameOfSportClass) {

    }

    @RequestMapping(value={"/joinSportClassForUser"}, method = RequestMethod.POST)
    public String joinSportClassForUserRequest(@RequestParam(value="nameOfUser") String nameOfUser, @RequestParam(value="nameOfProducts") List<String> nameOfProducts, HttpServletRequest request) {

    }
}
