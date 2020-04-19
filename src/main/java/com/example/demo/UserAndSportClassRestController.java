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

        List<UserSportclass> pairs = userSportClassBLL.findAllPairs();
        Set<String> sportClassesForUser = new HashSet<String>();
        for (UserSportclass currentPair : pairs) {
            if (currentPair.getId_user_fk() == user.getId_user()) {
                sportClassesForUser.add(sportClassBLL.findById(currentPair.getId_sportclass_fk()).getName());
            }
        }

        if (sportClassesForUser == null || sportClassesForUser.size() == 0) {
            return "The user " + nameOfUser + " did not join any of our gym sport classes!";
        }

        String stringToBeReturned = "User " + nameOfUser + " did join the following classes: \n";
        for (String currentClassString : sportClassesForUser) {
            stringToBeReturned += currentClassString + "\n";
        }

        return stringToBeReturned;
    }

    @GetMapping("/getUsersForSportClass")
    public String getUsersForSportClassRequest(@RequestBody String nameOfSportClass) {
        SportClass sportClass = sportClassBLL.findByName(nameOfSportClass);
        if (sportClass == null) {
            return "Sorry but the sport class " + nameOfSportClass + " does not exist at our gym!";
        }

        List<UserSportclass> pairs = userSportClassBLL.findAllPairs();
        Set<String> users = new HashSet<>();
        for (UserSportclass currentPair : pairs) {
            if (currentPair.getId_sportclass_fk() == sportClass.getId_class()) {
                users.add(myUserBLL.findById(currentPair.getId_user_fk()).getName());
            }
        }

        if (users == null || users.size() == 0) {
            return "For the moment nobody joined class " + nameOfSportClass;
        }

        String stringToBeReturned = "The users who joined sport-class " + nameOfSportClass + " are: \n";
        for (String userName : users) {
            stringToBeReturned += userName + "\n";
        }

        return stringToBeReturned;
    }

    @RequestMapping(value={"/joinSportClassForUser"}, method = RequestMethod.POST)
    public String joinSportClassForUserRequest(@RequestParam(value="nameOfUser") String nameOfUser, @RequestParam(value="nameOfSportClasses") List<String> nameOfSportClasses, HttpServletRequest request) {
        User user = myUserBLL.findByName(nameOfUser);
        if (user == null) {
            return "Something went wrong because your name was not found in the database!";
        }

        List<UserSportclass> allPairs = userSportClassBLL.findAllPairs();
        Set<Integer> sportClassesIds = new HashSet<>();
        for (UserSportclass currentPair : allPairs) {
            if (currentPair.getId_user_fk() == user.getId_user()) {
                sportClassesIds.add(currentPair.getId_sportclass_fk());
            }
        }

        List<SportClass> sportClassesNeededByUser = new ArrayList<SportClass>();
        int totalPrice = 0;
        for (String currentSportClassName : nameOfSportClasses) {
            SportClass sportClass = sportClassBLL.findByName(currentSportClassName);
            if (sportClass == null) {
                return "Sorry dear " + nameOfUser + " but sport class " + currentSportClassName + " does not exist ar our gym!";
            }
            if (sportClassesIds.contains(sportClass.getId_class())) {
                return "Sorry dear " + nameOfUser + " but for the current month it seems like you've already joined class " + sportClass.getName();
            }

            if (sportClass.getSize_number() >= 20) {
                return "Sorry dear " + nameOfUser + " but sport class " + sportClass.getName() + " is full for the moment!";
            }

            totalPrice += sportClass.getMonth_price();
            sportClass.incrementSizeNumber();
            sportClassesNeededByUser.add(sportClass);
        }

        if (user.getMoney_card() < totalPrice) {
            return "Sorry dear " + nameOfUser + " but you don't have enough money on the gym card in order to join all the classes you specified!";
        }

        user.setMoney_card(user.getMoney_card() - totalPrice);
        myUserBLL.updateClient(user, user.getId_user());

        for (SportClass currentSportClassNeeded : sportClassesNeededByUser) {
            sportClassBLL.updateSportClass(currentSportClassNeeded, currentSportClassNeeded.getId_class());
            userSportClassBLL.insertPair(new UserSportclass(user.getId_user(), currentSportClassNeeded.getId_class()));
        }

        return "We hope you'll enjoy training at our gym sport classes!";
    }
}
