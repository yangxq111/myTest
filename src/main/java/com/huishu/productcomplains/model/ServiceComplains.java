package com.huishu.productcomplains.model;

import java.io.Serializable;

public class ServiceComplains implements Serializable{
	
	/**
	 * 服务投诉的实体类
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String username;
	private String nickname;
	private String sex;
	private String age;
	private String telphone;
	private String  userId;
	private String complainsId;
	private String area;
	private String complainsTime;
	private String complainsCarType;
	private String carRankLevel;
	private String complainsProblem;
	private String title;
	private String link;
	private String site;
	private String siteTel;
	private String state;
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
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getTelphone() {
		return telphone;
	}
	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getComplainsId() {
		return complainsId;
	}
	public void setComplainsId(String complainsId) {
		this.complainsId = complainsId;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getComplainsTime() {
		return complainsTime;
	}
	public void setComplainsTime(String complainsTime) {
		this.complainsTime = complainsTime;
	}
	public String getComplainsCarType() {
		return complainsCarType;
	}
	public void setComplainsCarType(String complainsCarType) {
		this.complainsCarType = complainsCarType;
	}
	public String getCarRankLevel() {
		return carRankLevel;
	}
	public void setCarRankLevel(String carRankLevel) {
		this.carRankLevel = carRankLevel;
	}
	public String getComplainsProblem() {
		return complainsProblem;
	}
	public void setComplainsProblem(String complainsProblem) {
		this.complainsProblem = complainsProblem;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getSiteTel() {
		return siteTel;
	}
	public void setSiteTel(String siteTel) {
		this.siteTel = siteTel;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	

}
