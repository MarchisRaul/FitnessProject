package com.example.demo;

import java.util.Date;

public class Sauna {
    private int id_sauna;
    private int occupied;
    private Date session_time;
    private int size_number;

    public Sauna(int id_sauna, int occupied, Date session_time, int size_number) {
        this.id_sauna = id_sauna;
        this.occupied = occupied;
        this.session_time = session_time;
        this.size_number = size_number;
    }

    public int getId_sauna() {
        return id_sauna;
    }

    public void setId_sauna(int id_sauna) {
        this.id_sauna = id_sauna;
    }

    public int getOccupied() {
        return occupied;
    }

    public void setOccupied(int occupied) {
        this.occupied = occupied;
    }

    public Date getSession_time() {
        return session_time;
    }

    public void setSession_time(Date session_time) {
        this.session_time = session_time;
    }

    public int getSize_number() {
        return size_number;
    }

    public void setSize_number(int size_number) {
        this.size_number = size_number;
    }
}
