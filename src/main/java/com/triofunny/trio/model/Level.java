package com.triofunny.trio.model;

public class Level {
    private String id;

    private String name;

    private Long startvalue;

    private Long endvalue;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Long getStartvalue() {
        return startvalue;
    }

    public void setStartvalue(Long startvalue) {
        this.startvalue = startvalue;
    }

    public Long getEndvalue() {
        return endvalue;
    }

    public void setEndvalue(Long endvalue) {
        this.endvalue = endvalue;
    }
}