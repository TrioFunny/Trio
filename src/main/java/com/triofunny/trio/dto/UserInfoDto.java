package com.triofunny.trio.dto;


import com.triofunny.trio.model.User;

import java.util.Date;

public class UserInfoDto {
	
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

    
    public User toUser() {
    	
    	User user=new User();
    	user.setId(this.id);
    	user.setAge(this.age);
    	user.setBanreason(this.banreason);
    	user.setEmail(this.email);
    	user.setEmailconfirm(this.emailconfirm);
    	user.setExp(this.exp);
    	user.setGender(this.gender);
    	user.setGithub(this.github);
    	user.setHeadportrait(this.headportrait);
    	user.setIntroduce(this.introduce);
    	user.setIsban(this.isban);
    	user.setLastloginip(this.lastloginip);
    	user.setLastlogintime(this.lastlogintime);
    	user.setNickname(this.nickname);
    	user.setPassword(this.password);
    	user.setPhone(this.phone);
    	user.setPhoneconfirm(this.phoneconfirm);
    	user.setQq(this.qq);
    	user.setSchool(this.school);
    	user.setUsername(this.username);
    	user.setWealth(this.wealth);
    	
		return user;
    }
    
    
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
		this.lastloginip = lastloginip;
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
		this.email = email;
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
		this.github = github;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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
		this.nickname = nickname;
	}

	public String getBanreason() {
		return banreason;
	}

	public void setBanreason(String banreason) {
		this.banreason = banreason;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
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
		this.school = school;
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
		this.headportrait = headportrait;
	}
    

}
