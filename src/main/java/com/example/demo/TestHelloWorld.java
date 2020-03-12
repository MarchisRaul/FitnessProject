package com.example.demo;


import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
public class TestHelloWorld {
    UserBLL myUsersBLL = new UserBLL();
    List<User> myUsers = new ArrayList<User>();

    TrainerBLL myTrainerBLL = new TrainerBLL();
    List<Trainer> myTrainers = new ArrayList<Trainer>();
////////// USER /////////
//    @GetMapping("/getUsers")
//    public List<User> getUsers() {
//        myUsers = myUsersBLL.findAllClients();
//        for (User currentUser: myUsers) {
//            System.out.println(currentUser.getName() + currentUser.getAge() + currentUser.getId_trainer_fkk() + currentUser.getCard_type());
//        }
//        return myUsers;
//    }

//    @RequestMapping(value={"/{findUserById}"}, method = RequestMethod.GET)
//    public User insertUserRequest(@PathVariable String findUserById, @RequestBody int id){
//        return myUsersBLL.findById(id);
//    }

//    @RequestMapping(value={"/{insertUser}"}, method = RequestMethod.POST)
//    public String insertUserRequest(@PathVariable String insertUser, @RequestBody User user){
//        System.out.println(user.getName() + " " + user.getAge() + " " + user.getCard_type());
//        System.out.println(insertUser);
//        myUsersBLL.insertClient(new User(user.getId_user(), user.getName(), user.getId_trainer_fkk(), user.getAge(), user.getCard_type()));
//        return "Something";
//    }

//    @RequestMapping(value={"/{deleteUser}"}, method = RequestMethod.POST)
//    public String deleteUserRequest(@PathVariable String deleteUser, @RequestBody User user) {
//        System.out.println("SALVE");
//        myUsersBLL.deleteClient(new User(user.getName(), user.getId_trainer_fkk(), user.getAge(), user.getCard_type()));
//        return "Deleted succesfully";
//    }

//    @RequestMapping(value={"/{updateUser}"}, method = RequestMethod.POST)
//    public String updateUserRequest(@PathVariable String updateUser, @RequestBody User user) {
//        System.out.println("SALVE");
//        myUsersBLL.updateClient(new User(user.getId_user(), user.getName(), user.getId_trainer_fkk(), user.getAge(), user.getCard_type()), user.getId_user());
//        return "Updated succesfully";
//    }


    ////////// Trainer /////////
//    @GetMapping("/getTrainers")
//    public List<Trainer> getTrainers() {
//        myTrainers = myTrainerBLL.findAllTrainers();
//
//        return myTrainers;
//    }

//    @RequestMapping(value={"/{findTrainerById}"}, method = RequestMethod.GET)
//    public Trainer findTrainersByIdRequest(@PathVariable String findTrainerById, @RequestBody int id){
//        return myTrainerBLL.findById(id);
//    }

//    @RequestMapping(value={"/{insertTrainer}"}, method = RequestMethod.POST)
//    public String insertTrainerRequest(@PathVariable String insertTrainer, @RequestBody Trainer trainer){
//        myTrainerBLL.insertTrainer(new Trainer(trainer.getName(), trainer.getId_trainer_pk(), trainer.getUniversity_diploma(), trainer.getTraining_price()));
//        return "Trainer inserted successfuly!";
//    }

//    @RequestMapping(value={"/{deleteTrainer}"}, method = RequestMethod.POST)
//    public String deleteTrainerRequest(@PathVariable String deleteTrainer, @RequestBody Trainer trainer) {
//        myTrainerBLL.deleteTrainer(new Trainer(trainer.getName(), trainer.getId_trainer_pk(), trainer.getUniversity_diploma(), trainer.getTraining_price()));
//        return "Trainer deleted succesfully";
//    }

//    @RequestMapping(value={"/{updateTrainer}"}, method = RequestMethod.POST)
//    public String updateTrainerRequest(@PathVariable String updateTrainer, @RequestBody Trainer trainer) {
//        myTrainerBLL.updateTrainer(new Trainer(trainer.getId_trainer_pk(), trainer.getName(), trainer.getUniversity_diploma(), trainer.getTraining_price()), trainer.getId_trainer_pk());
//        return "Trainer updated uccesfully";
//    }

}

