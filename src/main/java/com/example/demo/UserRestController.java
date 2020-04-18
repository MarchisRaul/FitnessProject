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
public class UserRestController {
    UserDAO userDAO = new UserDAO();
    UserBLL myUsersBLL = new UserBLL(userDAO);

    ////////////////// USER //////////////////
    @GetMapping("/getUsers")
    public List<User> getUsers() {
        List<User> myUsers = new ArrayList<User>();
        myUsers = myUsersBLL.findAllClients();

        return myUsers;
    }

    @GetMapping("/findUserById")
    public User findUserByIdRequest(@RequestBody int id){
        if (id > myUsersBLL.findBiggestUserId()) {
            System.out.println("There is no user with id " + id);
            return new User(-1,"",-1,-1,"","", -1, -1);
        }
        return myUsersBLL.findById(id);
    }

    @GetMapping("/findUserByName")
    public User findUserByNameRequest(@RequestBody String name){
        return myUsersBLL.findByName(name);
    }

    @RequestMapping(value={"/deleteUser", "/updateUser", "/insertUser"}, method = RequestMethod.POST)
    public String performUserPostRequests(@RequestBody User user, HttpServletRequest request) {
        if(request.getServletPath().equals("/deleteUser")) {
            if (myUsersBLL.findById(user.getId_user()) != null) {
                myUsersBLL.deleteClient(new User(user.getId_user(), user.getName(), user.getId_trainer_fkk(), user.getAge(), user.getCard_type(), user.getFree_saunas_info(), user.getId_sauna_fk(), user.getMoney_card()));
                return "User deleted succesfully";
            } else {
                return "User with id " + user.getId_user() + " was not found!";
            }
        } else if (request.getServletPath().equals("/updateUser")) {
            if (myUsersBLL.findById(user.getId_user()) != null) {
                myUsersBLL.updateClient(new User(user.getId_user(), user.getName(), user.getId_trainer_fkk(), user.getAge(), user.getCard_type(), user.getFree_saunas_info(), user.getId_sauna_fk(), user.getMoney_card()), user.getId_user());
                return "User updated succesfully";
            } else {
                return "User with id " + user.getId_user() + " was not found!";
            }
        } else if (request.getServletPath().equals("/insertUser")) {
            int currentBiggestId = myUsersBLL.findBiggestUserId();
            if (user.getId_user() - 1 != currentBiggestId) {
                return "The {id_user} fields has to be consecutive(last id is " + currentBiggestId + ").";
            }
            myUsersBLL.insertClient(new User(user.getId_user(), user.getName(), user.getId_trainer_fkk(), user.getAge(), user.getCard_type(), user.getFree_saunas_info(), user.getId_sauna_fk(), user.getMoney_card()));
            return "User inserted successfully!";
        }
        return "Request " + request.getServletPath() + " does not exist!";
    }
}
