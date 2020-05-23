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
public class TrainerRestController {
    TrainerDAO trainerDAO = new TrainerDAO();
    TrainerBLL myTrainerBLL = new TrainerBLL(trainerDAO);

    ////////////////// Trainer //////////////////
    @CrossOrigin(origins="*")
    @GetMapping("/getTrainers")
    public List<Trainer> getTrainers() {
        List<Trainer> myTrainers = myTrainerBLL.findAllTrainers();

        return myTrainers;
    }

    @CrossOrigin(origins="*")
    @GetMapping("/findTrainerById")
    public Trainer findTrainersByIdRequest(@RequestParam(value="id") int id) {
        if (id > myTrainerBLL.findBiggestTrainerId()) {
            System.out.println("There is no trainer with id " + id);
            return new Trainer(-1, "",-1,-1);
        }
        return myTrainerBLL.findById(id);
    }

    @CrossOrigin(origins="*")
    @GetMapping("/findTrainerByName")
    public Trainer findTrainersByNameRequest(@RequestParam(value="name") String name) {
        return myTrainerBLL.findByName(name);
    }

    @CrossOrigin(origins="*")
    @RequestMapping(value={"/deleteTrainer", "/updateTrainer", "/insertTrainer"}, method = RequestMethod.POST)
    public String performTrainerPostRequests(@RequestBody Trainer trainer, HttpServletRequest request) {
        if(request.getServletPath().equals("/deleteTrainer")) {
            if (myTrainerBLL.findById(trainer.getId_trainer_pk()) != null) {
                myTrainerBLL.deleteTrainer(new Trainer(trainer.getId_trainer_pk(), trainer.getName(), trainer.getUniversity_diploma(), trainer.getTraining_price()));
                return "Trainer deleted succesfully";
            } else {
                return "Trainer with id " + trainer.getId_trainer_pk() + " was not found!";
            }
        } else if (request.getServletPath().equals("/updateTrainer")) {
            if (myTrainerBLL.findById(trainer.getId_trainer_pk()) != null) {
                myTrainerBLL.updateTrainer(new Trainer(trainer.getId_trainer_pk(), trainer.getName(), trainer.getUniversity_diploma(), trainer.getTraining_price()), trainer.getId_trainer_pk());
                return "Trainer updated uccesfully";
            } else {
                return "Trainer with id " + trainer.getId_trainer_pk() + " was not found!";
            }
        } else if (request.getServletPath().equals("/insertTrainer")) {
            int currentBiggestId = myTrainerBLL.findBiggestTrainerId();
            if (trainer.getId_trainer_pk() - 1 != currentBiggestId) {
                return "The {id_trainer} fields has to be consecutive(last id is " + currentBiggestId + ").";
            }
            myTrainerBLL.insertTrainer(new Trainer(trainer.getId_trainer_pk(), trainer.getName(), trainer.getUniversity_diploma(), trainer.getTraining_price()));
            return "Trainer inserted successfuly!";
        }
        return "Request " + request.getServletPath() + " does not exist!";
    }
}
