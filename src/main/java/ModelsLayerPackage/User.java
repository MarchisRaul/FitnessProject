package ModelsLayerPackage;

import BusinessLogicLayerPackage.ObserverChannel;
import ModelsLayerPackage.GymCardPackage.DiscountForSubscriptionStrategy;

public class User {
    private int id_user;
    private String name;
    private int id_trainer_fkk;
    private int age;
    private String card_type;
    private String free_saunas_info;
    private int id_sauna_fk;
    private int money_card;

    public User(int id_user, String name, int id_trainer_fkk, int age, String card_type, String free_saunas_info, int id_sauna_fk, int money_card) {
        this.id_user = id_user;
        this.name = name;
        this.id_trainer_fkk = id_trainer_fkk;
        this.age = age;
        this.card_type = card_type;
        this.free_saunas_info = free_saunas_info;
        this.id_sauna_fk = id_sauna_fk;
        this.money_card = money_card;
    }

    public User() {

    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId_trainer_fkk() {
        return id_trainer_fkk;
    }

    public void setId_trainer_fkk(int id_trainer_fkk) {
        this.id_trainer_fkk = id_trainer_fkk;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCard_type() {
        return card_type;
    }

    public void setCard_type(String card_type) {
        this.card_type = card_type;
    }

    public String getFree_saunas_info() {
        return free_saunas_info;
    }

    public void setFree_saunas_info(String free_saunas_info) {
        this.free_saunas_info = free_saunas_info;
    }

    public int getId_sauna_fk() {
        return id_sauna_fk;
    }

    public void setId_sauna_fk(int id_sauna_fk) {
        this.id_sauna_fk = id_sauna_fk;
    }

    public int getMoney_card() {
        return money_card;
    }

    public void setMoney_card(int money_card) {
        this.money_card = money_card;
    }

}
