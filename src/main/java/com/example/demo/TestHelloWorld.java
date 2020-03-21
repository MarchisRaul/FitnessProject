package com.example.demo;


import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class TestHelloWorld {
    UserBLL myUsersBLL = new UserBLL();
    TrainerBLL myTrainerBLL = new TrainerBLL();
    ShopBLL myShopBLL = new ShopBLL();
    SaunaBLL mySaunaBLL = new SaunaBLL();
    ProductBLL myProductBLL = new ProductBLL();
    SportClassBLL mySportClassBLL = new SportClassBLL();

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss");

    ////////////////// USER //////////////////
    @GetMapping("/getUsers")
    public List<User> getUsers() {
        List<User> myUsers = myUsersBLL.findAllClients();

        return myUsers;
    }

    @GetMapping("/findUserById")
    public User findUserByIdRequest(@RequestBody int id){
        if (id > myUsersBLL.findBiggestUserId()) {
            System.out.println("There is no user with id " + id);
            return new User(-1,"",-1,-1,"");        }
        return myUsersBLL.findById(id);
    }

    @RequestMapping(value={"/deleteUser", "/updateUser", "/insertUser"}, method = RequestMethod.POST)
    public String performUserPostRequests(@RequestBody User user, HttpServletRequest request) {
        if(request.getServletPath().equals("/deleteUser")) {
            if (myUsersBLL.findById(user.getId_user()) != null) {
                myUsersBLL.deleteClient(new User(user.getId_user(), user.getName(), user.getId_trainer_fkk(), user.getAge(), user.getCard_type()));
                return "User deleted succesfully";
            } else {
                return "User with id " + user.getId_user() + " was not found!";
            }
        } else if (request.getServletPath().equals("/updateUser")) {
            if (myUsersBLL.findById(user.getId_user()) != null) {
                myUsersBLL.updateClient(new User(user.getId_user(), user.getName(), user.getId_trainer_fkk(), user.getAge(), user.getCard_type()), user.getId_user());
                return "User updated succesfully";
            } else {
                return "User with id " + user.getId_user() + " was not found!";
            }
        } else if (request.getServletPath().equals("/insertUser")) {
            int currentBiggestId = myUsersBLL.findBiggestUserId();
            if (user.getId_user() - 1 != currentBiggestId) {
                return "The {id_user} fields has to be consecutive(last id is " + currentBiggestId + ").";
            }
            myUsersBLL.insertClient(new User(user.getId_user(), user.getName(), user.getId_trainer_fkk(), user.getAge(), user.getCard_type()));
            return "User inserted successfully!";
        }
        return "Request " + request.getServletPath() + " does not exist!";
    }

    ////////////////// Trainer //////////////////
    @GetMapping("/getTrainers")
    public List<Trainer> getTrainers() {
        List<Trainer> myTrainers = myTrainerBLL.findAllTrainers();

        return myTrainers;
    }

    @GetMapping("/findTrainerById")
    public Trainer findTrainersByIdRequest(@RequestBody int id) {
        if (id > myTrainerBLL.findBiggestTrainerId()) {
            System.out.println("There is no trainer with id " + id);
            return new Trainer(-1, "",-1,-1);
        }
        return myTrainerBLL.findById(id);
    }

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

    ////////////////// Shop //////////////////
    @GetMapping("/getShops")
    public List<Shop> getShops() {
        List<Shop> myShops = myShopBLL.findAllShops();

        return myShops;
    }

    @GetMapping("/findShopById")
    public Shop findShopByIdRequest(@RequestBody int id){
        if (id > myShopBLL.findBiggestShopId()) {
            System.out.println("There is no user with id " + id);
            return new Shop(-1, -1);
        }
        return myShopBLL.findById(id);
    }

    @RequestMapping(value={"/deleteShop", "/updateShop", "/insertShop"}, method = RequestMethod.POST)
    public String performShopPostRequests(@RequestBody Shop shop, HttpServletRequest request) {
        if(request.getServletPath().equals("/deleteShop")) {
            if (myShopBLL.findById(shop.getId_shop()) != null) {
                myShopBLL.deleteShop(new Shop(shop.getId_shop(), shop.getDiscount_mode()));
                return "Shop deleted succesfully";
            } else {
                return "Shop with id " + shop.getId_shop() + " was not found!";
            }
        } else if (request.getServletPath().equals("/updateShop")) {
            if (myShopBLL.findById(shop.getId_shop()) != null) {
                myShopBLL.updateShop(new Shop(shop.getId_shop(), shop.getDiscount_mode()), shop.getId_shop());
                return "Shop updated succesfully";
            } else {
                return "Shop with id " + shop.getId_shop() + " was not found!";
            }
        } else if (request.getServletPath().equals("/insertShop")) {
            int currentBiggestId = myShopBLL.findBiggestShopId();
            if (shop.getId_shop() - 1 != currentBiggestId) {
                return "The {id_shop} fields has to be consecutive(last id is " + currentBiggestId + ").";
            }
            myShopBLL.insertShop(new Shop(shop.getId_shop(), shop.getDiscount_mode()));
            return "Shop inserted successfuly!";
        }
        return "Request " + request.getServletPath() + " does not exist!";
    }

    ////////////////// Sauna //////////////////
    @GetMapping("/getSaunas")
    public List<Sauna> getSaunas() {
        List<Sauna> mySaunas = mySaunaBLL.findAllSaunas();

        return mySaunas;
    }

    @GetMapping("/findSaunaById")
    public Sauna findSaunaByIdRequest(@RequestBody int id) throws ParseException {
        if (id > mySaunaBLL.findBiggestSaunaId()) {
            System.out.println("There is no sauna with id " + id);
            return new Sauna(-1, -1, new java.sql.Time(1, 45, 0), -1);
        }
        return mySaunaBLL.findById(id);
    }

    @RequestMapping(value={"/deleteSauna", "/updateSauna", "/insertSauna"}, method = RequestMethod.POST)
    public String performSaunaPostRequests(@RequestBody Sauna sauna, HttpServletRequest request) {
        if(request.getServletPath().equals("/deleteSauna")) {
            if (mySaunaBLL.findById(sauna.getId_sauna()) != null) {
                mySaunaBLL.deleteSauna(new Sauna(sauna.getId_sauna(), sauna.getOccupied(), sauna.getSession_time(), sauna.getSize_number()));
                return "Sauna deleted succesfully";
            } else {
                return "Sauna with id " + sauna.getId_sauna() + " was not found!";
            }
        } else if (request.getServletPath().equals("/updateSauna")) {
            if (mySaunaBLL.findById(sauna.getId_sauna()) != null) {
                mySaunaBLL.updateSauna(new Sauna(sauna.getId_sauna(), sauna.getOccupied(), sauna.getSession_time(), sauna.getSize_number()), sauna.getId_sauna());
                return "Sauna updated succesfully";
            } else {
                return "Sauna with id " + sauna.getId_sauna() + " was not found!";
            }
        } else if (request.getServletPath().equals("/insertSauna")) {
            int currentBiggestId = mySaunaBLL.findBiggestSaunaId();
            if (sauna.getId_sauna() - 1 != currentBiggestId) {
                return "The {id_sauna} fields has to be consecutive(last id is " + currentBiggestId + ").";
            }
            System.out.println(sauna.getSession_time());
            mySaunaBLL.insertSauna(new Sauna(sauna.getId_sauna(), sauna.getOccupied(), sauna.getSession_time(), sauna.getSize_number()));
            return "Sauna inserted successfuly!";
        }
        return "Request " + request.getServletPath() + " does not exist!";
    }

    ////////////////// Product //////////////////
    @GetMapping("/getProducts")
    public List<Product> getProducts() {
        List<Product> myProducts = myProductBLL.findAllProducts();

        return myProducts;
    }

    @GetMapping("/findProductById")
    public Product findProductByIdRequest(@RequestBody int id){
        if (id > myProductBLL.findBiggestProductId()) {
            System.out.println("There is no product with id " + id);
            return new Product(-1, "", -1, "", -1, -1);
        }
        return myProductBLL.findById(id);
    }

    @RequestMapping(value={"/deleteProduct", "/updateProduct", "/insertProduct"}, method = RequestMethod.POST)
    public String performProductPostRequests(@RequestBody Product product, HttpServletRequest request) {
        if(request.getServletPath().equals("/deleteProduct")) {
            if (myProductBLL.findById(product.getId_product()) != null) {
                myProductBLL.deleteProduct(new Product(product.getId_product(), product.getName(), product.getId_shop_fk(), product.getUtility(), product.getPrice(), product.getQuantity()));
                return "Product deleted succesfully";
            } else {
                return "Product with id " + product.getId_product() + " was not found!";
            }
        } else if (request.getServletPath().equals("/updateProduct")) {
            if (myProductBLL.findById(product.getId_product()) != null) {
                myProductBLL.updateProduct(new Product(product.getId_product(), product.getName(), product.getId_shop_fk(), product.getUtility(), product.getPrice(), product.getQuantity()), product.getId_product());
                return "Product updated succesfully";
            } else {
                return "Product with id " + product.getId_product() + " was not found!";
            }
        } else if (request.getServletPath().equals("/insertProduct")) {
            int currentBiggestId = myProductBLL.findBiggestProductId();
            if (product.getId_product() - 1 != currentBiggestId) {
                return "The {id_product} fields has to be consecutive(last id is " + currentBiggestId + ").";
            }
            myProductBLL.insertProduct(new Product(product.getId_product(), product.getName(), product.getId_shop_fk(), product.getUtility(), product.getPrice(), product.getQuantity()));
            return "Product inserted successfuly!";
        }
        return "Request " + request.getServletPath() + " does not exist!";
    }

    ////////////////// SportClass //////////////////
    @GetMapping("/getSportClasses")
    public List<SportClass> getSportClasses() {
        List<SportClass> mySportClasses =  mySportClassBLL.findAllSportClasses();

        return mySportClasses;
    }

    @GetMapping("/findSportClassById")
    public SportClass findSportClassByIdRequests(@RequestBody int id){
        if (id > mySportClassBLL.findBiggestSportClassId()) {
            System.out.println("There is no sport class with id " + id);
            return new SportClass(-1, "", -1, -1);
        }
        return mySportClassBLL.findById(id);
    }

    @RequestMapping(value={"/deleteSportClass", "/updateSportClass", "/insertSportClass"}, method = RequestMethod.POST)
    public String performSportClassPostRequest(@RequestBody SportClass sportClass, HttpServletRequest request) {
        if(request.getServletPath().equals("/deleteSportClass")) {
            if (mySportClassBLL.findById(sportClass.getId_class()) != null) {
                mySportClassBLL.deleteSportClass(new SportClass(sportClass.getId_class(), sportClass.getName(), sportClass.getId_trainer_fk(), sportClass.getMonth_price()));
                return "Sport class deleted succesfully";
            } else {
                return "Sport class with id " + sportClass.getId_class() + " was not found!";
            }
        } else if (request.getServletPath().equals("/updateSportClass")) {
            if (mySportClassBLL.findById(sportClass.getId_class()) != null) {
                mySportClassBLL.updateSportClass(new SportClass(sportClass.getId_class(), sportClass.getName(), sportClass.getId_trainer_fk(), sportClass.getMonth_price()), sportClass.getId_class());
                return "Sport class updated succesfully";
            } else {
                return "Sport class with id " + sportClass.getId_class() + " was not found!";
            }
        } else if (request.getServletPath().equals("/insertSportClass")) {
            int currentBiggestId = mySportClassBLL.findBiggestSportClassId();
            if (sportClass.getId_class() - 1 != currentBiggestId) {
                return "The {id_class} fields has to be consecutive(last id is " + currentBiggestId + ").";
            }
            mySportClassBLL.insertSportClass(new SportClass(sportClass.getId_class(), sportClass.getName(), sportClass.getId_trainer_fk(), sportClass.getMonth_price()));
            return "Sport class inserted successfuly!";
        }
        return "Request " + request.getServletPath() + " does not exist!";
    }
}

