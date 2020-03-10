package com.example.demo;

public class User {
    private String name;
    private int age;
    private String cardtype;

    public User(String name, int age, String cardtype) {
        this.name = name;
        this.age = age;
        this.cardtype = cardtype;
    }

    public User() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCardtype() {
        return cardtype;
    }

    public void setCardtype(String cardtype) {
        this.cardtype = cardtype;
    }
}
