package com.shaoyuayu.entity;

/**
 * 学校类型
 */
public class SchoolInfo {

    private String id;					//表中id
    private String address;				//详细地址
    private String belong;				//隶属
    private String city_name;			//城市名字
    private String level_name;			//学校水平
    private String name;			    //学校名字
    private String province_name;		//省/直辖市名称
    private String school_nature_name;	//学校性质
    private String school_type_name;	//学校类型
    private String site;			    //官方网站
    private String town_name;			//城镇
    private String type_name;			//学科类型
    private String phone;		        //联系电话
    private String school_id;			//学校ID

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBelong() {
        return belong;
    }

    public void setBelong(String belong) {
        this.belong = belong;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getLevel_name() {
        return level_name;
    }

    public void setLevel_name(String level_name) {
        this.level_name = level_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvince_name() {
        return province_name;
    }

    public void setProvince_name(String province_name) {
        this.province_name = province_name;
    }

    public String getSchool_nature_name() {
        return school_nature_name;
    }

    public void setSchool_nature_name(String school_nature_name) {
        this.school_nature_name = school_nature_name;
    }

    public String getSchool_type_name() {
        return school_type_name;
    }

    public void setSchool_type_name(String school_type_name) {
        this.school_type_name = school_type_name;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getTown_name() {
        return town_name;
    }

    public void setTown_name(String town_name) {
        this.town_name = town_name;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSchool_id() {
        return school_id;
    }

    public void setSchool_id(String school_id) {
        this.school_id = school_id;
    }

    @Override
    public String toString() {
        return "SchoolInfo{" +
                "id='" + id + '\'' +
                ", address='" + address + '\'' +
                ", belong='" + belong + '\'' +
                ", city_name='" + city_name + '\'' +
                ", level_name='" + level_name + '\'' +
                ", name='" + name + '\'' +
                ", province_name='" + province_name + '\'' +
                ", school_nature_name='" + school_nature_name + '\'' +
                ", school_type_name='" + school_type_name + '\'' +
                ", site='" + site + '\'' +
                ", town_name='" + town_name + '\'' +
                ", type_name='" + type_name + '\'' +
                ", phone='" + phone + '\'' +
                ", school_id='" + school_id + '\'' +
                '}';
    }
}
