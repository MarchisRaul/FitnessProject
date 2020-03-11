package com.example.demo;

public class SportClass {
    private String name;
    private int id_trainer_fk;
    private int month_price;

    public SportClass(String name, int id_trainer_fk, int month_price) {
        this.name = name;
        this.id_trainer_fk = id_trainer_fk;
        this.month_price = month_price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId_trainer_fk() {
        return id_trainer_fk;
    }

    public void setId_trainer_fk(int id_trainer_fk) {
        this.id_trainer_fk = id_trainer_fk;
    }

    public int getMonth_price() {
        return month_price;
    }

    public void setMonth_price(int month_price) {
        this.month_price = month_price;
    }
}
