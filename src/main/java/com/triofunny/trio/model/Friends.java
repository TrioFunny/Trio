package com.triofunny.trio.model;

public class Friends {
    private String fromuserid;

    private String touserid;

    public String getFromuserid() {
        return fromuserid;
    }

    public void setFromuserid(String fromuserid) {
        this.fromuserid = fromuserid == null ? null : fromuserid.trim();
    }

    public String getTouserid() {
        return touserid;
    }

    public void setTouserid(String touserid) {
        this.touserid = touserid == null ? null : touserid.trim();
    }
}