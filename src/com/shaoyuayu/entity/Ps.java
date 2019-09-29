package com.shaoyuayu.entity;

/**
 * tb_ps表中的实体类
 * Created by shaoyayu on 2019/4/25.
 */
public class Ps {

    private int id;
    private String local;
    private int syear;
    private String wl;
    private String point;
    private int sectionPerson;
    private int addUpPerson;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getSyear() {
        return syear;
    }

    public void setSyear(int syear) {
        this.syear = syear;
    }

    public String getWl() {
        return wl;
    }

    public void setWl(String wl) {
        this.wl = wl;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public int getSectionPerson() {
        return sectionPerson;
    }

    public void setSectionPerson(int sectionPerson) {
        this.sectionPerson = sectionPerson;
    }

    public int getAddUpPerson() {
        return addUpPerson;
    }

    public void setAddUpPerson(int addUpPerson) {
        this.addUpPerson = addUpPerson;
    }

    @Override
    public String toString() {
        return "Ps{" +
                "id=" + id +
                ", local='" + local + '\'' +
                ", syear=" + syear +
                ", wl='" + wl + '\'' +
                ", point='" + point + '\'' +
                ", sectionPerson=" + sectionPerson +
                ", addUpPerson=" + addUpPerson +
                '}';
    }
}