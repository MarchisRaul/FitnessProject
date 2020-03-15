package com.example.demo;


import org.springframework.web.bind.annotation.*;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class TestHelloWorld {
    UserBLL myUsersBLL = new UserBLL();
    List<User> myUsers = new ArrayList<User>();

    TrainerBLL myTrainerBLL = new TrainerBLL();
    List<Trainer> myTrainers = new ArrayList<Trainer>();

    ShopBLL myShopBLL = new ShopBLL();
    List<Shop> myShops = new ArrayList<Shop>();

    SaunaBLL mySaunaBLL = new SaunaBLL();
    List<Sauna> mySaunas = new ArrayList<Sauna>();

    ProductBLL myProductBLL = new ProductBLL();
    List<Product> myProducts = new ArrayList<Product>();

    SportClassBLL mySportClassBLL = new SportClassBLL();
    List<SportClass> mySportClasses = new ArrayList<SportClass>();

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss");
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
//    public User findUserByIdRequest(@PathVariable String findUserById, @RequestBody int id){
//        if (id > myUsersBLL.findBiggestUserId()) {
//            System.out.println("There is no user with id " + id);
//            return new User(-1,"",-1,-1,"");        }
//        return myUsersBLL.findById(id);
//    }

//    @RequestMapping(value={"/{insertUser}"}, method = RequestMethod.POST)
//    public String insertUserRequest(@PathVariable String insertUser, @RequestBody User user){
//        int currentBiggestId = myUsersBLL.findBiggestUserId();
//        if (user.getId_user() - 1 != currentBiggestId) {
//            return "The {id_user} fields has to be consecutive(last id is " + currentBiggestId + ").";
//        }
//        myUsersBLL.insertClient(new User(user.getId_user(), user.getName(), user.getId_trainer_fkk(), user.getAge(), user.getCard_type()));
//        return "User inserted successfully!";
//    }

//    @RequestMapping(value={"/{deleteUser}"}, method = RequestMethod.POST)
//    public String deleteUserRequest(@PathVariable String deleteUser, @RequestBody User user) {
//        if (myUsersBLL.findById(user.getId_user()) != null) {
//        myUsersBLL.deleteClient(new User(user.getId_user(), user.getName(), user.getId_trainer_fkk(), user.getAge(), user.getCard_type()));
//        return "Deleted succesfully";
//    }
//        return "User with id " + user.getId_user() + " was not found!";
//    }

//    @RequestMapping(value={"/{updateUser}"}, method = RequestMethod.POST)
//    public String updateUserRequest(@PathVariable String updateUser, @RequestBody User user) {
//        if (myUsersBLL.findById(user.getId_user()) != null) {
//            myUsersBLL.updateClient(new User(user.getId_user(), user.getName(), user.getId_trainer_fkk(), user.getAge(), user.getCard_type()), user.getId_user());
//            return "Updated succesfully";
//        }
//        return "User with id " + user.getId_user() + " was not found!";
//    }


//    //////// Trainer /////////
//    @GetMapping("/getTrainers")
//    public List<Trainer> getTrainers() {
//        myTrainers = myTrainerBLL.findAllTrainers();
//
//        return myTrainers;
//    }

//    @RequestMapping(value={"/{findTrainerById}"}, method = RequestMethod.GET)
//    public Trainer findTrainersByIdRequest(@PathVariable String findTrainerById, @RequestBody int id) {
//        if (id > myTrainerBLL.findBiggestTrainerId()) {
//            System.out.println("There is no trainer with id " + id);
//            return new Trainer(-1, "",-1,-1);
//        }
//        return myTrainerBLL.findById(id);
//    }

//    @RequestMapping(value={"/{insertTrainer}"}, method = RequestMethod.POST)
//    public String insertTrainerRequest(@PathVariable String insertTrainer, @RequestBody Trainer trainer){
//        int currentBiggestId = myTrainerBLL.findBiggestTrainerId();
//        if (trainer.getId_trainer_pk() - 1 != currentBiggestId) {
//            return "The {id_trainer} fields has to be consecutive(last id is " + currentBiggestId + ").";
//        }
//        myTrainerBLL.insertTrainer(new Trainer(trainer.getId_trainer_pk(), trainer.getName(), trainer.getUniversity_diploma(), trainer.getTraining_price()));
//        return "Trainer inserted successfuly!";
//    }

//    @RequestMapping(value={"/{deleteTrainer}"}, method = RequestMethod.POST)
//    public String deleteTrainerRequest(@PathVariable String deleteTrainer, @RequestBody Trainer trainer) {
//        if (myTrainerBLL.findById(trainer.getId_trainer_pk()) != null) {
//            myTrainerBLL.deleteTrainer(new Trainer(trainer.getId_trainer_pk(), trainer.getName(), trainer.getUniversity_diploma(), trainer.getTraining_price()));
//            return "Trainer deleted succesfully";
//        }
//        return "Trainer with id " + trainer.getId_trainer_pk() + " was not found!";
//    }

//    @RequestMapping(value={"/{updateTrainer}"}, method = RequestMethod.POST)
//    public String updateTrainerRequest(@PathVariable String updateTrainer, @RequestBody Trainer trainer) {
//        if (myTrainerBLL.findById(trainer.getId_trainer_pk()) != null) {
//            myTrainerBLL.updateTrainer(new Trainer(trainer.getId_trainer_pk(), trainer.getName(), trainer.getUniversity_diploma(), trainer.getTraining_price()), trainer.getId_trainer_pk());
//            return "Trainer updated uccesfully";
//        }
//        return "Trainer with id " + trainer.getId_trainer_pk() + " was not found!";
//    }

//    //////// Shop /////////
//    @GetMapping("/getShops")
//    public List<Shop> getShops() {
//        myShops = myShopBLL.findAllShops();
//
//        return myShops;
//    }
//
//    @RequestMapping(value={"/{findShopById}"}, method = RequestMethod.GET)
//    public Shop findShopByIdRequest(@PathVariable String findShopById, @RequestBody int id){
//        if (id > myShopBLL.findBiggestShopId()) {
//            System.out.println("There is no user with id " + id);
//            return new Shop(-1, -1);
//        }
//        return myShopBLL.findById(id);
//    }
//
//    @RequestMapping(value={"/{insertShop}"}, method = RequestMethod.POST)
//    public String insertShopRequest(@PathVariable String insertShop, @RequestBody Shop shop){
//        int currentBiggestId = myShopBLL.findBiggestShopId();
//        if (shop.getId_shop() - 1 != currentBiggestId) {
//            return "The {id_shop} fields has to be consecutive(last id is " + currentBiggestId + ").";
//        }
//        myShopBLL.insertShop(new Shop(shop.getId_shop(), shop.getDiscount_mode()));
//        return "Shop inserted successfuly!";
//    }
//
//    @RequestMapping(value={"/{deleteShop}"}, method = RequestMethod.POST)
//    public String deleteShopRequest(@PathVariable String deleteShop, @RequestBody Shop shop) {
//        if (myShopBLL.findById(shop.getId_shop()) != null) {
//            myShopBLL.deleteShop(new Shop(shop.getId_shop(), shop.getDiscount_mode()));
//            return "Shop deleted succesfully";
//        }
//        return "Shop with id " + shop.getId_shop() + " was not found!";
//    }
//
//    @RequestMapping(value={"/{updateShop}"}, method = RequestMethod.POST)
//    public String updateShopRequest(@PathVariable String updateShop, @RequestBody Shop shop) {
//        if (myShopBLL.findById(shop.getId_shop()) != null) {
//            myShopBLL.updateShop(new Shop(shop.getId_shop(), shop.getDiscount_mode()), shop.getId_shop());
//            return "Shop updated succesfully";
//        }
//        return "Shop with id " + shop.getId_shop() + " was not found!";
//    }


//    ////////// Sauna /////////
//    @GetMapping("/getSaunas")
//    public List<Sauna> getSaunas() {
//        mySaunas = mySaunaBLL.findAllSaunas();
//
//        return mySaunas;
//    }

//    @RequestMapping(value={"/{findSaunaById}"}, method = RequestMethod.GET)
//    public Sauna findSaunaByIdRequest(@PathVariable String findSaunaById, @RequestBody int id) throws ParseException {
//            if (id > mySaunaBLL.findBiggestSaunaId()) {
//            System.out.println("There is no sauna with id " + id);
//            return new Sauna(-1, -1, new java.sql.Time(1, 45, 0), -1);
//            }
//        return mySaunaBLL.findById(id);
//    }

//    @RequestMapping(value={"/{insertSauna}"}, method = RequestMethod.POST)
//    public String insertSaunaRequest(@PathVariable String insertSauna, @RequestBody Sauna sauna) throws ParseException {
//        int currentBiggestId = mySaunaBLL.findBiggestSaunaId();
//        if (sauna.getId_sauna() - 1 != currentBiggestId) {
//            return "The {id_sauna} fields has to be consecutive(last id is " + currentBiggestId + ").";
//        }
//        System.out.println(sauna.getSession_time());
//        mySaunaBLL.insertSauna(new Sauna(sauna.getId_sauna(), sauna.getOccupied(), sauna.getSession_time(), sauna.getSize_number()));
//        return "Sauna inserted successfuly!";
//    }

//    @RequestMapping(value={"/{deleteSauna}"}, method = RequestMethod.POST)
//    public String deleteSaunaRequest(@PathVariable String deleteSauna, @RequestBody Sauna sauna) {
//        if (mySaunaBLL.findById(sauna.getId_sauna()) != null) {
//            mySaunaBLL.deleteSauna(new Sauna(sauna.getId_sauna(), sauna.getOccupied(), sauna.getSession_time(), sauna.getSize_number()));
//            return "Sauna deleted succesfully";
//        }
//
//        return "Sauna with id " + sauna.getId_sauna() + " was not found!";
//    }
//
//    @RequestMapping(value={"/{updateSauna}"}, method = RequestMethod.POST)
//    public String updateSaunaRequest(@PathVariable String updateSauna, @RequestBody Sauna sauna) {
//        if (mySaunaBLL.findById(sauna.getId_sauna()) != null){
//            mySaunaBLL.updateSauna(new Sauna(sauna.getId_sauna(), sauna.getOccupied(), sauna.getSession_time(), sauna.getSize_number()), sauna.getId_sauna());
//            return "Sauna updated succesfully";}
//
//        return "Sauna with id " + sauna.getId_sauna() + " was not found!";
//    }


//    //////// Product /////////
//    @GetMapping("/getProducts")
//    public List<Product> getProducts() {
//        myProducts = myProductBLL.findAllProducts();
//
//        return myProducts;
//    }
//
//    @RequestMapping(value={"/{findProductById}"}, method = RequestMethod.GET)
//    public Product findProductByIdRequest(@PathVariable String findProductById, @RequestBody int id){
//        if (id > myProductBLL.findBiggestProductId()) {
//            System.out.println("There is no product with id " + id);
//            return new Product(-1, "", -1, "", -1, -1);
//            }
//        return myProductBLL.findById(id);
//    }
//
//    @RequestMapping(value={"/{insertProduct}"}, method = RequestMethod.POST)
//    public String insertProductRequest(@PathVariable String insertProduct, @RequestBody Product product) throws ParseException {
//        int currentBiggestId = myProductBLL.findBiggestProductId();
//        if (product.getId_product() - 1 != currentBiggestId) {
//            return "The {id_product} fields has to be consecutive(last id is " + currentBiggestId + ").";
//        }
//        myProductBLL.insertProduct(new Product(product.getId_product(), product.getName(), product.getId_shop_fk(), product.getUtility(), product.getPrice(), product.getQuantity()));
//        return "Product inserted successfuly!";
//    }
//
//    @RequestMapping(value={"/{deleteProduct}"}, method = RequestMethod.POST)
//    public String deleteProductRequest(@PathVariable String deleteProduct, @RequestBody Product product) {
//        if (myProductBLL.findById(product.getId_product()) != null) {
//            myProductBLL.deleteProduct(new Product(product.getId_product(), product.getName(), product.getId_shop_fk(), product.getUtility(), product.getPrice(), product.getQuantity()));
//            return "Product deleted succesfully";
//        }
//        return "Product with id " + product.getId_product() + " was not found!";
//    }
//
//    @RequestMapping(value={"/{updateProduct}"}, method = RequestMethod.POST)
//    public String updateProductRequest(@PathVariable String updateProduct, @RequestBody Product product) {
//        if (myProductBLL.findById(product.getId_product()) != null) {
//            myProductBLL.updateProduct(new Product(product.getId_product(), product.getName(), product.getId_shop_fk(), product.getUtility(), product.getPrice(), product.getQuantity()), product.getId_product());
//            return "Product updated succesfully";
//        }
//        return "Product with id " + product.getId_product() + " was not found!";
//    }


//    //////// SportClass /////////
//    @GetMapping("/getSportClasses")
//    public List<SportClass> getSportClasses() {
//        mySportClasses = mySportClassBLL.findAllSportClasses();
//
//        return mySportClasses;
//    }
//
//    @RequestMapping(value={"/{findSportClassById}"}, method = RequestMethod.GET)
//    public SportClass findSportClassByIdRequest(@PathVariable String findSportClassById, @RequestBody int id){
//        if (id > mySportClassBLL.findBiggestSportClassId()) {
//            System.out.println("There is no sport class with id " + id);
//            return new SportClass(-1, "", -1, -1);
//        }
//        return mySportClassBLL.findById(id);
//    }
//
//    @RequestMapping(value={"/{insertSportClass}"}, method = RequestMethod.POST)
//    public String insertSportClassRequest(@PathVariable String insertSportClass, @RequestBody SportClass sportClass) throws ParseException {
//        int currentBiggestId = mySportClassBLL.findBiggestSportClassId();
//        if (sportClass.getId_class() - 1 != currentBiggestId) {
//            return "The {id_class} fields has to be consecutive(last id is " + currentBiggestId + ").";
//        }
//        mySportClassBLL.insertSportClass(new SportClass(sportClass.getId_class(), sportClass.getName(), sportClass.getId_trainer_fk(), sportClass.getMonth_price()));
//        return "Sport class inserted successfuly!";
//    }
//
//    @RequestMapping(value={"/{deleteSportClass}"}, method = RequestMethod.POST)
//    public String deleteSportClassRequest(@PathVariable String deleteSportClass, @RequestBody SportClass sportClass) {
//        if (mySportClassBLL.findById(sportClass.getId_class()) != null) {
//            mySportClassBLL.deleteSportClass(new SportClass(sportClass.getId_class(), sportClass.getName(), sportClass.getId_trainer_fk(), sportClass.getMonth_price()));
//            return "Sport class deleted succesfully";
//        }
//        return "Sport class with id " + sportClass.getId_class() + " was not found!";
//    }
//
    @RequestMapping(value={"/{updateSportClass}"}, method = RequestMethod.POST)
    public String deleteSportClass(@PathVariable String updateSportClass, @RequestBody SportClass sportClass) {
        if (mySportClassBLL.findById(sportClass.getId_class()) != null) {
            mySportClassBLL.updateSportClass(new SportClass(sportClass.getId_class(), sportClass.getName(), sportClass.getId_trainer_fk(), sportClass.getMonth_price()), sportClass.getId_class());
            return "Sport class updated succesfully";
        }
        return "Sport class with id " + sportClass.getId_class() + " was not found!";
    }
}

