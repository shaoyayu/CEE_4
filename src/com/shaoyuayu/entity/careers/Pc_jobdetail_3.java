package com.shaoyuayu.entity.careers;

public class Pc_jobdetail_3 {

    /**
     * 表id		id
     * 职位		detail_pos
     * 具体职位：	detail_job
     * 专业ID		special_id
     * 占比		rate
     */
    private String id;
    private String detail_pos;
    private String detail_job;
    private String special_id;
    private String rate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDetail_pos() {
        return detail_pos;
    }

    public void setDetail_pos(String detail_pos) {
        this.detail_pos = detail_pos;
    }

    public String getDetail_job() {
        return detail_job;
    }

    public void setDetail_job(String detail_job) {
        this.detail_job = detail_job;
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
        return "Pc_jobdetail_3{" +
                "id='" + id + '\'' +
                ", detail_pos='" + detail_pos + '\'' +
                ", detail_job='" + detail_job + '\'' +
                ", special_id='" + special_id + '\'' +
                ", rate='" + rate + '\'' +
                '}';
    }
}
