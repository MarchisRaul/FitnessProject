package com.example.demo;


import org.springframework.web.bind.annotation.*;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/M/yyyy hh:mm:ss");
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

    ////////// Shop /////////
//    @GetMapping("/getShops")
//    public List<Shop> getShops() {
//        myShops = shopBLL.findAllShops();
//
//        return myShops;
//    }
//
//    @RequestMapping(value={"/{findShopById}"}, method = RequestMethod.GET)
//    public Shop findShopByIdRequest(@PathVariable String findShopById, @RequestBody int id){
//        return myShopBLL.findById(id);
//    }
//
//    @RequestMapping(value={"/{insertShop}"}, method = RequestMethod.POST)
//    public String insertShopRequest(@PathVariable String insertShop, @RequestBody Shop shop){
//        myShopBLL.insertShop(new Shop(shop.getId_shop(), shop.isDiscount_mode()));
//        return "Trainer inserted successfuly!";
//    }
//
//    @RequestMapping(value={"/{deleteShop}"}, method = RequestMethod.POST)
//    public String deleteShopRequest(@PathVariable String deleteShop, @RequestBody Shop shop) {
//        myShopBLL.deleteShop(new Shop(shop.getId_shop(), shop.isDiscount_mode()));
//        return "Trainer deleted succesfully";
//    }
//
//    @RequestMapping(value={"/{updateShop}"}, method = RequestMethod.POST)
//    public String updateShopRequest(@PathVariable String updateShop, @RequestBody Shop shop) {
//        myShopBLL.updateShop(new Shop(shop.getId_shop(), shop.isDiscount_mode()), shop.getId_shop());
//        return "Trainer updated uccesfully";
//    }


    ////////// Sauna /////////
//    @GetMapping("/getSaunas")
//    public List<Sauna> getSaunas() {
//        mySaunas = mySaunaBLL.findAllSaunas();
//
//        return mySaunas;
//    }
//
//    @RequestMapping(value={"/{findSaunaById}"}, method = RequestMethod.GET)
//    public Sauna findSaunaByIdRequest(@PathVariable String findSaunaById, @RequestBody int id){
//        return mySaunaBLL.findById(id);
//    }
//
//    @RequestMapping(value={"/{insertSauna}"}, method = RequestMethod.POST)
//    public String insertSaunaRequest(@PathVariable String insertSauna, @RequestBody Sauna sauna) throws ParseException {
//        mySaunaBLL.insertSauna(new Sauna(sauna.getId_sauna(), sauna.getOccupied(), sauna.getSession_time(), sauna.getSize_number()));
//        return "Sauna inserted successfuly!";
//    }
//
//    @RequestMapping(value={"/{deleteSauna}"}, method = RequestMethod.POST)
//    public String deleteSaunaRequest(@PathVariable String deleteSauna, @RequestBody Sauna sauna) {
//        mySaunaBLL.deleteSauna(new Sauna(sauna.getId_sauna(), sauna.getOccupied(), sauna.getSession_time(), sauna.getSize_number()));
//        return "Sauna deleted succesfully";
//    }
//
//    @RequestMapping(value={"/{updateSauna}"}, method = RequestMethod.POST)
//    public String updateSaunaRequest(@PathVariable String updateSauna, @RequestBody Sauna sauna) {
//        mySaunaBLL.updateSauna(new Sauna(sauna.getId_sauna(), sauna.getOccupied(), sauna.getSession_time(), sauna.getSize_number()), sauna.getId_sauna());
//        return "Sauna updated succesfully";
//    }


    ////////// Product /////////
//    @GetMapping("/getProducts")
//    public List<Product> getProducts() {
//        myProducts = myProductBLL.findAllProducts();
//
//        return myProducts;
//    }
//
//    @RequestMapping(value={"/{findProductById}"}, method = RequestMethod.GET)
//    public Product findProductByIdRequest(@PathVariable String findProductById, @RequestBody int id){
//        return myProductBLL.findById(id);
//    }
//
//    @RequestMapping(value={"/{insertProduct}"}, method = RequestMethod.POST)
//    public String insertProductRequest(@PathVariable String insertProduct, @RequestBody Product product) throws ParseException {
//        myProductBLL.insertProduct(new Product(product.getId_product(), product.getName(), product.getId_shop_fk(), product.getUtility(), product.getPrice(), product.getQuantity()));
//        return "Product inserted successfuly!";
//    }
//
//    @RequestMapping(value={"/{deleteProduct}"}, method = RequestMethod.POST)
//    public String deleteProductRequest(@PathVariable String deleteProduct, @RequestBody Product product) {
//        myProductBLL.deleteProduct(new Product(product.getId_product(), product.getName(), product.getId_shop_fk(), product.getUtility(), product.getPrice(), product.getQuantity()));
//        return "Product deleted succesfully";
//    }
//
//    @RequestMapping(value={"/{updateProduct}"}, method = RequestMethod.POST)
//    public String updateProductRequest(@PathVariable String updateProduct, @RequestBody Product product) {
//        myProductBLL.updateProduct(new Product(product.getId_product(), product.getName(), product.getId_shop_fk(), product.getUtility(), product.getPrice(), product.getQuantity()), product.getId_product());
//        return "Product updated uccesfully";
//    }


    ////////// SportClass /////////
//    @GetMapping("/getSportClasses")
//    public List<SportClass> getSportClasses() {
//        mySportClasses = mySportClassBLL.findAllSportClasses();
//
//        return mySportClasses;
//    }
//
//    @RequestMapping(value={"/{findSportClassById}"}, method = RequestMethod.GET)
//    public SportClass findSportClassByIdRequest(@PathVariable String findSportClassById, @RequestBody int id){
//        return mySportClassBLL.findById(id);
//    }
//
//    @RequestMapping(value={"/{insertSportClass}"}, method = RequestMethod.POST)
//    public String insertSportClassRequest(@PathVariable String insertSportClass, @RequestBody SportClass sportClass) throws ParseException {
//        mySportClassBLL.insertSportClass(new SportClass(sportClass.getId_class(), sportClass.getName(), sportClass.getId_trainer_fk(), sportClass.getMonth_price()));
//        return "Sport class inserted successfuly!";
//    }
//
//    @RequestMapping(value={"/{deleteSportClass}"}, method = RequestMethod.POST)
//    public String deleteSportClassRequest(@PathVariable String deleteSportClass, @RequestBody SportClass sportClass) {
//        mySportClassBLL.deleteSportClass(new SportClass(sportClass.getId_class(), sportClass.getName(), sportClass.getId_trainer_fk(), sportClass.getMonth_price()));
//        return "Sport class deleted succesfully";
//    }
//
//    @RequestMapping(value={"/{updateSportClass}"}, method = RequestMethod.POST)
//    public String deleteSportClass(@PathVariable String updateSportClass, @RequestBody SportClass sportClass) {
//        mySportClassBLL.updateSportClass(new SportClass(sportClass.getId_class(), sportClass.getName(), sportClass.getId_trainer_fk(), sportClass.getMonth_price()), sportClass.getId_class());
//        return "Product updated uccesfully";
//    }
}

