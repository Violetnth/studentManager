package com.yushuhuai.bean;

public class Customer {
    private Integer id;
    private String username;
    private String password;
    private String message;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public Customer() {
    }

    public Customer(String username, String password, String message) {
        this.username = username;
        this.password = password;
        this.message = message;
    }
}
