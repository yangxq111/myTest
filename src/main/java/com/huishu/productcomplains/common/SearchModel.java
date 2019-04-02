package com.huishu.productcomplains.common;

import java.io.Serializable;

import com.alibaba.fastjson.JSONObject;

/*
 * @Description: 公用查询
 * @author yxq
 * @date: 2018年1月10日 下午2:17:09
 */
public class SearchModel implements Serializable{
	/**
	 * 可序列化
	 */
	private static final long serialVersionUID = 1L;
	/** 当前页 */
	private Integer pageNumber;
	/** 页容量 */
	private Integer pageSize;
	/** 总页数 */
	private Integer totalPage;
	/** 总条数 */
	private Integer totalSize;
	/** 分页查询起始条数 */
	private Integer pageFrom;
	
	public SearchModel() {
		if(null == pageSize){
			setPageSize(Constants.DEFAULT_PAGE_SIZE);
		}else if (pageSize>Constants.MAX_PAGE_SIZE){
			setPageSize(Constants.MAX_PAGE_SIZE);
		}else if (pageSize<Constants.MIN_PAGE_SIZE){
			setPageSize(Constants.MIN_PAGE_SIZE);
		}
		if(null == pageNumber){
			setPageNumber(1);
		}else if (pageNumber>Constants.MAX_PAGE_NUMBER){
			setPageNumber(Constants.MAX_PAGE_NUMBER);
		}else if (pageNumber<1){
			setPageNumber(1);
		}
			
	}
	public Integer getPageFrom() {
		this.pageFrom = (pageNumber-1)*pageSize>0?(pageNumber-1)*pageSize:0;
		return pageFrom;
	}
	public Integer getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(Integer pageNumber) {
		if(pageNumber>0){
			this.pageNumber = pageNumber;
		}
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		if(pageSize>0){
			this.pageSize = pageSize;
		}
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public Integer getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(Integer totalSize) {
		this.totalSize = totalSize;
		totalPage = (totalSize/pageSize)+((totalSize%pageSize)>0?1:0);
		if(pageNumber>totalPage){
			pageNumber=totalPage;
		}
	}
	@Override
	public String toString() {
		return JSONObject.toJSONString(this);
	}
	
}

