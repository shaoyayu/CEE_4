package com.shaoyuayu.entity.school;

public class School {
    private String schoolID		;       //学校id
    private String presentationUrl	;   //相关微博
    private String schoolName	;       //学校名字
    private String location	;           //省/直辖市
    private String keyDiscipline;       //学校重点学科
    private String category	;           //院校类别
    private String master;              //学校硕士点数
    private String subjection;          //学校属性
    private String doctor;              //学校博士点数
    private String rests;               //学校标签

    public String getSchoolID() {
        return schoolID;
    }

    public void setSchoolID(String schoolID) {
        this.schoolID = schoolID;
    }

    public String getPresentationUrl() {
        return presentationUrl;
    }

    public void setPresentationUrl(String presentationUrl) {
        this.presentationUrl = presentationUrl;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getKeyDiscipline() {
        return keyDiscipline;
    }

    public void setKeyDiscipline(String keyDiscipline) {
        this.keyDiscipline = keyDiscipline;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    public String getSubjection() {
        return subjection;
    }

    public void setSubjection(String subjection) {
        this.subjection = subjection;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getRests() {
        return rests;
    }

    public void setRests(String rests) {
        this.rests = rests;
    }

    @Override
    public String toString() {
        return "School{" +
                "schoolID='" + schoolID + '\'' +
                ", presentationUrl='" + presentationUrl + '\'' +
                ", schoolName='" + schoolName + '\'' +
                ", location='" + location + '\'' +
                ", keyDiscipline='" + keyDiscipline + '\'' +
                ", category='" + category + '\'' +
                ", master='" + master + '\'' +
                ", subjection='" + subjection + '\'' +
                ", doctor='" + doctor + '\'' +
                ", rests='" + rests + '\'' +
                '}';
    }
}
