package com.shaoyuayu.entity;

public class Local {

    private String local;			//省
    private String data_bin;		//省bin
    private String localArea;		//地区
    private String provinces;		//省拼音
    private String localAreaID;	    //地区bin

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getData_bin() {
        return data_bin;
    }

    public void setData_bin(String data_bin) {
        this.data_bin = data_bin;
    }

    public String getLocalArea() {
        return localArea;
    }

    public void setLocalArea(String localArea) {
        this.localArea = localArea;
    }

    public String getProvinces() {
        return provinces;
    }

    public void setProvinces(String provinces) {
        this.provinces = provinces;
    }

    public String getLocalAreaID() {
        return localAreaID;
    }

    public void setLocalAreaID(String localAreaID) {
        this.localAreaID = localAreaID;
    }

    @Override
    public String toString() {
        return "Local{" +
                "local='" + local + '\'' +
                ", data_bin='" + data_bin + '\'' +
                ", localArea='" + localArea + '\'' +
                ", provinces='" + provinces + '\'' +
                ", localAreaID='" + localAreaID + '\'' +
                '}';
    }
}
