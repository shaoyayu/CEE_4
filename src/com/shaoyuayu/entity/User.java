package com.shaoyuayu.entity;

/**
 *对于user_id
 */
public class User {

    private int id;
    private String mail;
    private String user_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", mail='" + mail + '\'' +
                ", user_id='" + user_id + '\'' +
                '}';
    }
}
