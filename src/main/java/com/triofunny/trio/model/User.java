package com.triofunny.trio.model;

import java.util.Date;

public class User {
	
    private String id;

    private String username;

    private String password;

    private Date lastlogintime;

    private String lastloginip;

    private Boolean isban;

    private String email;

    private Boolean emailconfirm;

    private String github;

    private String phone;

    private Boolean phoneconfirm;

    private String nickname;

    private String banreason;

    private String introduce;

    private String qq;

    private Boolean gender;

    private String school;

    private Integer age;

    private Integer exp;

    private Long wealth;

    private String headportrait;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Date getLastlogintime() {
        return lastlogintime;
    }

    public void setLastlogintime(Date lastlogintime) {
        this.lastlogintime = lastlogintime;
    }

    public String getLastloginip() {
        return lastloginip;
    }

    public void setLastloginip(String lastloginip) {
        this.lastloginip = lastloginip == null ? null : lastloginip.trim();
    }

    public Boolean getIsban() {
        return isban;
    }

    public void setIsban(Boolean isban) {
        this.isban = isban;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Boolean getEmailconfirm() {
        return emailconfirm;
    }

    public void setEmailconfirm(Boolean emailconfirm) {
        this.emailconfirm = emailconfirm;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github == null ? null : github.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Boolean getPhoneconfirm() {
        return phoneconfirm;
    }

    public void setPhoneconfirm(Boolean phoneconfirm) {
        this.phoneconfirm = phoneconfirm;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getBanreason() {
        return banreason;
    }

    public void setBanreason(String banreason) {
        this.banreason = banreason == null ? null : banreason.trim();
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getExp() {
        return exp;
    }

    public void setExp(Integer exp) {
        this.exp = exp;
    }

    public Long getWealth() {
        return wealth;
    }

    public void setWealth(Long wealth) {
        this.wealth = wealth;
    }

    public String getHeadportrait() {
        return headportrait;
    }

    public void setHeadportrait(String headportrait) {
        this.headportrait = headportrait == null ? null : headportrait.trim();
    }
}