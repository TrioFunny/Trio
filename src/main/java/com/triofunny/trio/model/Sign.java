package com.triofunny.trio.model;

import java.util.Date;

public class Sign {
    private String id;

    private Date time;

    private String userid;

    private Integer count;

    private Boolean iscontinue;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Boolean getIscontinue() {
        return iscontinue;
    }

    public void setIscontinue(Boolean iscontinue) {
        this.iscontinue = iscontinue;
    }
}