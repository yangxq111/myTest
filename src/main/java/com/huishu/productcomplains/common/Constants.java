package com.huishu.productcomplains.common;


/**
 * 公共常量
 * @author
 */
public class Constants {
	
	/**
	 * es相关配置
	 */
	public static class EsConfig {
		public static final String INDEX = "productcomplains";
		public static final String TYPE = "esTest";
	}

	
	/** 
	 * 最大分页数
	 */
	public static final int MAX_PAGENUMBER = 1000;
	
	/**
	 * 词库内网ip地址 10.24.164.113
	 * 本地测试可以改为外网ip：120.76.102.48（但是不要提交）
	 */ 
	public static final String WORD_ADRESS = "10.24.164.113:8080";

	public static final Integer DEFAULT_PAGE_SIZE = 10;

	public static final Integer MAX_PAGE_SIZE = 20;

	public static final Integer MIN_PAGE_SIZE = 8;

	public static final Integer MAX_PAGE_NUMBER = 10000;
	
	/**
	 * es中情感存储的值
	 */
	public static class EmotionValue{
		
		/**
		 * 正面
		 */
		public static final String POSITIVE = "positive";
		
		/**
		 * 中性
		 */
		public static final String NETURE1 = "neutral";
		
		public static final String NETURE2 = "neture";
		
		/**
		 * 负面
		 */
		public static final String NEGATIVE = "negative";
		
	}

}
