package com.huishu.productcomplains.model;

import com.huishu.productcomplains.common.SearchModel;

/*
 * @Description: 服务投诉全景dto
 * @author yxq
 * @date: 2018年1月10日 下午2:18:47
 */
public class ServiceComplainsViewDTO extends SearchModel{
	
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;
	private String carBrand;
	private String carSeries;
	private String carModel;
	private String carLevel;
	private String downTime;
	private String area;
	private String serviceProblem;
	public String getCarBrand() {
		return carBrand;
	}
	public void setCarBrand(String carBrand) {
		this.carBrand = carBrand;
	}
	public String getCarSeries() {
		return carSeries;
	}
	public void setCarSeries(String carSeries) {
		this.carSeries = carSeries;
	}
	public String getCarModel() {
		return carModel;
	}
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	public String getCarLevel() {
		return carLevel;
	}
	public void setCarLevel(String carLevel) {
		this.carLevel = carLevel;
	}
	public String getDownTime() {
		return downTime;
	}
	public void setDownTime(String downTime) {
		this.downTime = downTime;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getServiceProblem() {
		return serviceProblem;
	}
	public void setServiceProblem(String serviceProblem) {
		this.serviceProblem = serviceProblem;
	}
	
}
