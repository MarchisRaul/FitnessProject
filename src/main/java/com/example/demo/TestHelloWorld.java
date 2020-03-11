package com.example.demo;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestHelloWorld {
    UserBLL myUsersBLL = new UserBLL();
    List<User> myUsers = new ArrayList<User>();

    @GetMapping("/getUsers")
    public List<User> getUsers() {
        myUsers = myUsersBLL.findAllClients();
        for (User currentUser: myUsers) {
            System.out.println(currentUser.getName() + currentUser.getAge() + currentUser.getId_trainer_fkk() + currentUser.getCard_type());
        }
        return myUsers;
    }

    @PostMapping("/{insertUser}")
    public String postRequest(@PathVariable String insertUser, @RequestBody User user){
        System.out.println(user.getName() + " " + user.getAge() + " " + user.getCard_type());
        System.out.println(insertUser);
        myUsersBLL.insertClient(new User(user.getName(), user.getId_trainer_fkk(), user.getAge(), user.getCard_type()));
        return "Something";
    }
}

