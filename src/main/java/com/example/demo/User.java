package com.example.demo;

public class User {
    private String name;
    private int id_trainer_fkk;
    private int age;
    private String card_type;

    public User(String name, int id_trainer_fkk, int age, String cardtype) {
        this.name = name;
        this.id_trainer_fkk = id_trainer_fkk;
        this.age = age;
        this.card_type = cardtype;
    }

    public User() {

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
}
