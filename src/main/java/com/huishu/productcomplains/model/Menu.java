package com.huishu.productcomplains.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_item_menu")
public class Menu implements Serializable{
	
	/**
	 * 菜单
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name="id", nullable=false)
	private Integer id;
	@Column(name="title", nullable=false)
	private String title;
	@Column(name="remark", nullable=false)
	private String remark;
	@Column(name="url", nullable=false)
	private String url;
	@Column(name="sort", nullable=false)
	private int sort;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getRenark() {
		return remark;
	}
	public void setRenark(String renark) {
		this.remark = renark;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	
}
