package com.example.demo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
