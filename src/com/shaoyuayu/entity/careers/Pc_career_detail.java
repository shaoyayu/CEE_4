package com.shaoyuayu.entity.careers;

public class Pc_career_detail {
    /**
     * 专业代码	code
     * 专业名字	name
     * 专业id		id
     * 男女生比例	rate
     * 授予学位	degree
     * 专业方向	do_what
     * 是什么		is_what
     * 主要课程	learn_what
     */
    private String code 	;
    private String name 	;
    private String id 		;
    private String rate 	;
    private String degree 	;
    private String do_what 	;
    private String is_what 	;
    private String learn_what;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getDo_what() {
        return do_what;
    }

    public void setDo_what(String do_what) {
        this.do_what = do_what;
    }

    public String getIs_what() {
        return is_what;
    }

    public void setIs_what(String is_what) {
        this.is_what = is_what;
    }

    public String getLearn_what() {
        return learn_what;
    }

    public void setLearn_what(String learn_what) {
        this.learn_what = learn_what;
    }

    @Override
    public String toString() {
        return "Pc_career_detail{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", rate='" + rate + '\'' +
                ", degree='" + degree + '\'' +
                ", do_what='" + do_what + '\'' +
                ", is_what='" + is_what + '\'' +
                ", learn_what='" + learn_what + '\'' +
                '}';
    }
}
