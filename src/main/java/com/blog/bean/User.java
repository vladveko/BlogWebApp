package com.blog.bean;

public class User {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String login;
    private String userRole;

    public User(int anInt, String string, String rsString, String s, String string1, String rsString1) {}

    public User(int id, String firstName, String lastName, String email, String userRole){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userRole = userRole;
    }

    public String getLogin() {
        return login;
    }

    public int getId(){
        return id;

    }

    public String getFirstName(){
        return firstName;

    }

    public String getLastName(){
        return lastName;

    }

    public String getEmail(){
        return email;

    }

    public String getUserRole(){
        return userRole;

    }

    public void setId(int id){
        this.id = id;

    }

    public void setFirstName(String firstName){
        this.firstName = firstName;

    }

    public void setLastName(String lastName){
        this.lastName = lastName;

    }

    public void setEmail(String email){
        this.email = email;

    }

    public void setUserRole(String userRole){
        this.userRole = userRole;

    }

    public void setLogin(String login) {
        this.login = login;
    }
}
