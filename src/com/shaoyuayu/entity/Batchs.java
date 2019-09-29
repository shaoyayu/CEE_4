package com.shaoyuayu.entity;

/**
 * 省控分数线
 */
public class Batchs {

    private String id;			//表id
    private String local;		//地区
    private String syear;		//年份
    private String batch;		//批次
    private String wl;			//文理
    private String MINscore;	//控档线

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getSyear() {
        return syear;
    }

    public void setSyear(String syear) {
        this.syear = syear;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getWl() {
        return wl;
    }

    public void setWl(String wl) {
        this.wl = wl;
    }

    public String getMINscore() {
        return MINscore;
    }

    public void setMINscore(String MINscore) {
        this.MINscore = MINscore;
    }

    @Override
    public String toString() {
        return "Batchs{" +
                "id='" + id + '\'' +
                ", local='" + local + '\'' +
                ", syear='" + syear + '\'' +
                ", batch='" + batch + '\'' +
                ", wl='" + wl + '\'' +
                ", MINscore='" + MINscore + '\'' +
                '}';
    }
}
