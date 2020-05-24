package com.example.demo;

import BusinessLogicLayerPackage.*;
import DAOlayerPackage.*;
import ModelsLayerPackage.*;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class UserAndSaunaRestController {
    UserDAO userDAO = new UserDAO();
    UserBLL myUsersBLL = new UserBLL(userDAO);

    SaunaDAO saunaDAO = new SaunaDAO();
    SaunaBLL mySaunaBLL = new SaunaBLL(saunaDAO);

    @CrossOrigin(origins="*")
    @RequestMapping(value={"/addUserToSauna"}, method = RequestMethod.POST)
    public String performUserPostRequests(@RequestParam(value="nameOfUser") String nameOfUser, @RequestParam(value="saunaId") int saunaId, HttpServletRequest request) throws ParseException {
        if(request.getServletPath().equals("/addUserToSauna")) {
            User user = myUsersBLL.findByName(nameOfUser);
            if (user == null) {
               return "Something went wrong because your name was not found in the database!";
            }
            Sauna sauna = mySaunaBLL.findById(saunaId);
            if (sauna == null) {
                return "Something went wrong because the sauna you selected does not exist in this gym!";
            }

            if (sauna.getOccupied() == 1) {
                return "Sorry dear " + user.getName() + ", but sauna with id " + sauna.getId_sauna() + " is already full!";
            }

            if (user.getId_sauna_fk() == sauna.getId_sauna()) {
                return "It seems like user " + user.getName() + " is already in sauna with id " + sauna.getId_sauna();
            }

            user.setId_sauna_fk(saunaId);
            sauna.incrementSizeNumber();
            myUsersBLL.updateClient(user, user.getId_user());

            DateFormat sdf = new SimpleDateFormat("hh:mm:ss");
            Date date = sdf.parse(sauna.getSession_time().toString());
            mySaunaBLL.updateSauna(new Sauna(sauna.getId_sauna(), sauna.getOccupied(), date, sauna.getSize_number()), sauna.getId_sauna());

            return "We hope you'll relax and enjoy your time in the sauna! Don't forget the towel, it's hot there.";
        }
        return "Request " + request.getServletPath() + " does not exist!";
    }
}
