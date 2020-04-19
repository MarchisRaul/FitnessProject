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
public class UserAndTrainerRestController {
    UserDAO userDAO = new UserDAO();
    UserBLL myUserBLL = new UserBLL(userDAO);

    TrainerDAO trainerDAO = new TrainerDAO();
    TrainerBLL myTrainerBLL = new TrainerBLL(trainerDAO);

    @GetMapping("/getUsersForTrainer")
    public String getUsersForProductRequest(@RequestBody String nameOfTrainer) {
        Trainer trainer = myTrainerBLL.findByName(nameOfTrainer);
        if (trainer == null) {
            return "Something went wrong because the trainer name was not found in the database!";
        }

        String returnedString = "Trainer " + nameOfTrainer + " works with the following clients: \n";
        List<User> listOfUsers = myUserBLL.findAllClients();
        boolean trainerHasClients = false;
        for (User user : listOfUsers) {
            if (user.getId_trainer_fkk() == trainer.getId_trainer_pk()) {
                returnedString += user.getName() + "\n";
                trainerHasClients = true;
            }
        }

        if (!trainerHasClients) {
            return "Trainer " + nameOfTrainer + " does not work with any client of the gym!";
        }
        return returnedString;
    }

}
