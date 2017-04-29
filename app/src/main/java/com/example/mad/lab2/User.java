package com.example.mad.lab2;

import java.util.ArrayList;

import static android.R.id.list;

/**
 * Created by AndroidBash on 10/07/16
 */
public class User {

    private String id;
    private String name;
    private String phoneNumber;
    private String email;
    private String password;
    private ArrayList<String> groups = new ArrayList<>();


    public User() {
        this.id = "";
        this.name = "";
        this.phoneNumber = "";
        this.email = "";
        this.password = "";
        this.groups.clear();
    }

    public User(String id, String name, String phoneNumber, String email, String password) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.groups.clear();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<String> getGroups(){return  groups;}
    public void setGroups(String new_group){this.groups.add(new_group);}

}