package com.shaoyuayu.entity;

/**
 * 验证码实体类user_token
 */
public class Token {

    private int id;              //表中id
    private String token;           //验证码
    private String mail;            //邮箱
    private int useful_life;     //有效时间
    private String begin;           //存储时间
    private int type;            //验证码类型

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getUseful_life() {
        return useful_life;
    }

    public void setUseful_life(int useful_life) {
        this.useful_life = useful_life;
    }

    public String getBegin() {
        return begin;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Token{" +
                "id=" + id +
                ", token='" + token + '\'' +
                ", mail='" + mail + '\'' +
                ", useful_life=" + useful_life +
                ", begin='" + begin + '\'' +
                ", type=" + type +
                '}';
    }
}
