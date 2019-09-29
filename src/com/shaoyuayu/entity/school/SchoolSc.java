package com.shaoyuayu.entity.school;

/**
 * 学校联系方式
 */
public class SchoolSc {

    private String schoolID	;	//学校id
    private String schoolName	;	//学校名字
    private String presentationUrl	;//相关介绍网址
    private String type	;		//学校类型
    private String site	;		//学校地区
    private String phone;			//联系电话
    private String location;		//地址
    private String officialWebsite;//网址

    public String getSchoolID() {
        return schoolID;
    }

    public void setSchoolID(String schoolID) {
        this.schoolID = schoolID;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getPresentationUrl() {
        return presentationUrl;
    }

    public void setPresentationUrl(String presentationUrl) {
        this.presentationUrl = presentationUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOfficialWebsite() {
        return officialWebsite;
    }

    public void setOfficialWebsite(String officialWebsite) {
        this.officialWebsite = officialWebsite;
    }

    @Override
    public String toString() {
        return "SchoolSc{" +
                "schoolID='" + schoolID + '\'' +
                ", schoolName='" + schoolName + '\'' +
                ", presentationUrl='" + presentationUrl + '\'' +
                ", type='" + type + '\'' +
                ", site='" + site + '\'' +
                ", phone='" + phone + '\'' +
                ", location='" + location + '\'' +
                ", officialWebsite='" + officialWebsite + '\'' +
                '}';
    }
}
