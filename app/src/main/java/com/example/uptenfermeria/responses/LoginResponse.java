package com.example.uptenfermeria.responses;

import com.example.uptenfermeria.models.User;

import java.util.ArrayList;

public class LoginResponse {

    private int id;
    private String name;
    private String secondName;
    private String email;
    private String password;
    private String data_added;
    private String data_updated;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
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

    public String getData_added() {
        return data_added;
    }

    public void setData_added(String data_added) {
        this.data_added = data_added;
    }

    public String getData_updated() {
        return data_updated;
    }

    public void setData_updated(String data_updated) {
        this.data_updated = data_updated;
    }
}
