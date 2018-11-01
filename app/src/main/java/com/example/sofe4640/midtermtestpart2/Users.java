package com.example.sofe4640.midtermtestpart2;
/*
This class is used to handel users info
 */
public class Users {
    private int id;
    private String name;

    public Users(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
