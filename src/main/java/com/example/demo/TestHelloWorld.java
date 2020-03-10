package com.example.demo;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestHelloWorld {
    UserBLL myUsersBLL = new UserBLL();
    List<User> myUsers = new ArrayList<User>();

    @GetMapping("salut")
    public List<User> getUsers() {
        myUsers = myUsersBLL.findAllClients();
        for (User currentUser: myUsers) {
            System.out.println(currentUser.getName() + currentUser.getAge() + currentUser.getCardtype());
        }
        return myUsers;
    }

    @GetMapping("salve")
    public void testMePlease() {
        System.out.println("AM INTRAT");
    }

    @PostMapping("/{insertUser}")
    public String postRequest(@PathVariable String insertUser,@RequestBody User user){
        System.out.println(user.getName() + " " + user.getAge() + " " + user.getCardtype());
        System.out.println(insertUser);
        myUsersBLL.insertClient(new User(user.getName(), user.getAge(), user.getCardtype()));
        return "Something";
    }
}

