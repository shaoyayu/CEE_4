package com.shaoyuayu.entity.careers;

public class Pc_jobdetail_1 {

    /**
     * 就业分布 jobdetail_1
     * 表id		id
     * 行业名称	name
     * 专业id		special_id
     * 占比		rate
     */
    private String id;
    private String name;
    private String special_id;
    private String rate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecial_id() {
        return special_id;
    }

    public void setSpecial_id(String special_id) {
        this.special_id = special_id;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Pc_jobdetail_1{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", special_id='" + special_id + '\'' +
                ", rate='" + rate + '\'' +
                '}';
    }
}
