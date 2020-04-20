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
public class PasswordRestController {
    PasswordDAO passwordDAO = new PasswordDAO();
    PasswordBLL myPasswordBLL = new PasswordBLL(passwordDAO);

    UserDAO userDAO = new UserDAO();
    UserBLL userBLL = new UserBLL(userDAO);

    @GetMapping("/verifyLogin")
    public String verifyLoginRequest(@RequestParam(value="emailOfUser") String emailOfUser, @RequestParam(value="password") String password, HttpServletRequest request) {
        User user = userBLL.findByName(emailOfUser);
        if (user == null) {
            return "Email does not exist, please try again!";
        }

        List<Password> passwordsList = myPasswordBLL.findAllPasswords();

        for (Password currentPassword : passwordsList) {
            if (currentPassword.getId_user() == user.getId_user() && currentPassword.getName().equals(user.getName()) && currentPassword.getPassword().equals(password)) {
                return "You successfully logged in. Have a great training at our gym!";
            }
        }

        return "Password is incorrect for user " + user.getName();
    }

    @RequestMapping(value={"/insertNewAccount"}, method = RequestMethod.POST)
    public String insertNewAccountRequest(@RequestParam(value="nameOfUser") String nameOfUser, @RequestParam(value="passwordOfUser") String password, HttpServletRequest request) {
       User user = userBLL.findByName(nameOfUser);
       if (user == null) {
           return "User " + nameOfUser + " was not created in the database! Please do that first!";
       }

       myPasswordBLL.insertAccountDetails(new Password(user.getId_user(), nameOfUser, password));
       return "Account for user " + nameOfUser + " was created successfully!";
    }

}
