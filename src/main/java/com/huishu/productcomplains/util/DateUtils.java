package com.huishu.productcomplains.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * 日期工具类
 * 
 * @author gzg
 *
 */
public class DateUtils {
	
	public static final String DATE_FORMAT = "yyyy-MM-dd";
	public static final String DATE_SECOND_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public static final String DATE_MINUTE_FORMAT = "yyyy-MM-dd HH:mm";
	
	private DateUtils(){}

	/**
	 * 转为yyyy-MM-dd格式的字符串 如果Number小于 946656000000 (2000年)就直接返回数字
	 * 
	 * @param value
	 *            Date|Number 类型
	 * @return
	 */
	public static String toDateStr(Object value) {
		if (value == null)
			return "";
		if (value instanceof Date)
			return new SimpleDateFormat(DATE_FORMAT).format((Date) value);
		if (value instanceof Number) {
			long longValue = ((Number) value).longValue();
			if (longValue < 946656000000L) {
				return Long.toString(longValue + 1);
			}
			return new SimpleDateFormat(DATE_FORMAT).format(new Date(longValue));
		}
		if(value instanceof String){
			return value.toString();
		}else {
			throw new RuntimeException("can not cast to date, value : " + value);
		}
	}

	/**
	 * 将long类型的数据转换为date的格式化
	 * 
	 * @param format
	 *            转换的时间格式
	 * @param millSec
	 *            时间
	 * @return
	 */
	public static String longToDate(String format, Long millSec) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(new Date(millSec));
	}

	/**
	 * 获取两个日期之间所有的日期
	 * 
	 * @param startStr
	 * @param endStr
	 * @return
	 */
	public static List<String> getAllDate(String startStr, String endStr) {

		List<String> result = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
			result = new ArrayList<String>();
			Date startDate = sdf.parse(startStr);
			Date endDate = sdf.parse(endStr);

			result.add(sdf.format(startDate));
			Calendar start = Calendar.getInstance();
			start.setTime(startDate);
			Calendar end = Calendar.getInstance();
			end.setTime(endDate);
			Calendar temp = (Calendar) start.clone();
			temp.add(Calendar.DAY_OF_YEAR, 1);
			while (temp.before(end)) {
				result.add(sdf.format(temp.getTime()));
				temp.add(Calendar.DAY_OF_YEAR, 1);
			}
			result.add(sdf.format(endDate));
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 获取两个日期之间所有的日期
	 * 
	 * @param startStr
	 * @param endStr
	 * @return
	 */
	public static List<String> getAllDate(String startStr) {

		List<String> result = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
			result = new ArrayList<String>();
			if(startStr.length() > 10){
				startStr = startStr.substring(0, 10);
			}
			Date startDate = sdf.parse(startStr);
			Date endDate = new Date();

			result.add(sdf.format(startDate));
			Calendar start = Calendar.getInstance();
			start.setTime(startDate);
			Calendar end = Calendar.getInstance();
			end.setTime(endDate);
			Calendar temp = (Calendar) start.clone();
			temp.add(Calendar.DAY_OF_YEAR, 1);
			while (temp.before(end)) {
				result.add(sdf.format(temp.getTime()));
				temp.add(Calendar.DAY_OF_YEAR, 1);
			}
//			result.add(sdf.format(endDate));
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 获取一天中的小时数
	 * 
	 * @return
	 */
	public static List<String> getAllTime() {
		List<String> times = new ArrayList<String>();
		for (int i = 0; i < 24; i++) {
			if(i < 10){
				times.add("0" + i);
			}else{
				times.add(String.valueOf(i));
			}
		}
		return times;
	}

	/**
	 * 判断两个日期是不是同一天
	 * 
	 * @param start
	 *            yyyy-MM-dd HH:mm:ss
	 * @param end
	 *            yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static boolean isOneDay(String start, String end) {
		return start.split(" ")[0].equals(end.split(" ")[0]);
	}

	/**
	 * 将字符串转为时间戳
	 * 
	 * @param user_time
	 * @return
	 */
	public static long dateToTimestamp(String user_time) {
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_SECOND_FORMAT);
		Date d;
		try {
			d = sdf.parse(user_time);
			return d.getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static long getEndToStartMinus(String startDate, String endDate) {
		long startStamp = dateToTimestamp(startDate);
		long endStamp = dateToTimestamp(endDate);
		long remainder = ((endStamp - startStamp) % (1000 * 60 * 60 * 24));
		if (remainder != 0) {
			return ((endStamp - startStamp) / (1000 * 60 * 60 * 24)) + 1;
		} else {
			return ((endStamp - startStamp) / (1000 * 60 * 60 * 24));
		}
	}
	
	/**
	 * 获取指定日期对象的小时字段的值
	 * @param date
	 * @return
	 */
	public static int getHours(Date date){
		int hours = 0;
		if(date != null){
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			hours = calendar.get(Calendar.HOUR_OF_DAY);
		}
		
		return hours;
	}
	
	/**
	 * 判断开始时间和结束时间是否在同一天
	 * @param startDate 格式：yyyy-MM-dd HH:mm:ss
	 * @param endDate 格式：yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static boolean isInOneDay(String startDateTime, String endDateTime){
		boolean flag = false;
		if(StringUtils.isNotBlank(startDateTime)
				&& StringUtils.isNotBlank(endDateTime)){
			String startDate = startDateTime;
			String endDate = endDateTime;
			if(startDateTime.length() > 10){
				startDate = startDateTime.substring(0, 10);
			}
			if(endDateTime.length() > 10){
				endDate = endDateTime.substring(0, 10);
			}
			if(startDate.equals(endDate)){
				flag = true;
			}
		}
		return flag;
	}
	/**
	 * 是否是今天
	 * 
	 * @param date
	 * @return
	 */
	public static boolean isToday(String str) {
		SimpleDateFormat sdf=new SimpleDateFormat(DATE_FORMAT);
		String today = sdf.format(new Date());
		String old = str.substring(0, 10);
        return old.equals(today);
    }
	
	/**
	 * 获取timeRange控件日期区间
	 * @param range
	 * @return
	 */
	public static String[] getDatesByRange(String range){
		String[] dates = new String[2];
		DateFormat df = new SimpleDateFormat(DATE_FORMAT);
		Date now = new Date();
		Calendar cal = Calendar.getInstance();
		dates[1] = df.format(now)+" 23:59:59";
		if("今日".equals(range)){
			dates[0] = df.format(now)+" 00:00:00";
		}else if("近一周".equals(range)){
			cal.setTimeInMillis(now.getTime() - 1000l * 60 * 60 * 24 * 7);
			dates[0] = df.format(cal.getTime()) + " 00:00:00";
		}else if("近一月".equals(range)){
			cal.setTimeInMillis(now.getTime() - 1000l * 60 * 60 * 24 * 30);
			dates[0] = df.format(cal.getTime()) + " 00:00:00";
		}else if("近一年".equals(range)){
			cal.setTimeInMillis(now.getTime() - 1000l * 60 * 60 * 24 * 30 * 12);
			dates[0] = df.format(cal.getTime()) + " 00:00:00";
		}else{     
			throw new RuntimeException("unknow type " + range);
		}
		return dates;
	}
	
	public static Date parseDate(String date,String dateFormat){
		Date result = null;
		if(StringUtils.isNotBlank(date)
				&& StringUtils.isNotBlank(dateFormat)){
			SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
			try {
				result = sdf.parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public static String formatDate(Date date,String dateFormat){
		String result = null;
		if(date != null
				&& StringUtils.isNotBlank(dateFormat)){
			DateTimeFormatter format = DateTimeFormat.forPattern(dateFormat);
			DateTime dateTime = new DateTime(date.getTime());
			result = dateTime.toString(format);
		}
		return result;
	}
	
	/**
	 * 根据开始时间和结束时间获取这个时间段之间的所有日期，包含开始日期和结束日期
	 * @param startDateTime 格式：yyyy-MM-dd 或者  yyyy-MM-dd HH:mm:ss
	 * @param endDateTime 格式：yyyy-MM-dd 或者  yyyy-MM-dd HH:mm:ss
	 * @return 格式为yyyy-MM-dd的日期列表
	 */
	public static List<String> getDateList(String startDateTime, String endDateTime){
		List<String> result = new ArrayList<String>();
		if(StringUtils.isNotBlank(startDateTime)
				&& StringUtils.isNotBlank(endDateTime)){
			try {
				SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
				String startDateStr = startDateTime;
				String endDateStr = endDateTime;
				if(startDateTime.length() > 10){
					startDateStr = startDateTime.substring(0, 10);
				}
				if(endDateTime.length() > 10){
					endDateStr = endDateTime.substring(0, 10);
				}
				Calendar startDate = Calendar.getInstance();
				startDate.setTime(sdf.parse(startDateStr));
				
				Calendar endDate = Calendar.getInstance();
				endDate.setTime(sdf.parse(endDateStr));
				
				result.add(startDateStr);
				while(startDate.before(endDate)){
					startDate.add(Calendar.DAY_OF_YEAR, 1);
					result.add(sdf.format(startDate.getTime()));
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	/**
	 * 获取一天当中所有的小时
	 * @return
	 */
	public static List<Integer> getAllHour(){
		List<Integer> list = new ArrayList<Integer>();
		for(int i=1; i<=24; i++){
			list.add(i);
		}
		
		return list;
	}
	
	/**
	 * 计算开始时间和结束时间间隔的天数
	 * @param startDate 格式：yyyy-MM-dd HH:mm:ss
	 * @param endDate 格式：yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static int calculateDays(String startDateTime, String endDateTime){
		int result = 0;
		SimpleDateFormat sdf = new SimpleDateFormat(DateUtils.DATE_SECOND_FORMAT);
		long millsOfOneDay = 1000L*60L*60L*24L;//一天的毫秒数
		try {
			if(StringUtils.isNotEmpty(startDateTime)
					&& StringUtils.isNotEmpty(endDateTime)){
				Date startDate = sdf.parse(startDateTime);
				Date endDate = sdf.parse(endDateTime);
				
				result = Integer.parseInt(((endDate.getTime() - startDate.getTime())/millsOfOneDay)+"");
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println(getDatesByRange("今日")[0] + " " + getDatesByRange("今日")[1]);
		System.out.println(getDatesByRange("近一周")[0] + " " + getDatesByRange("近一周")[1]);
		System.out.println(getDatesByRange("近一月")[0] + " " + getDatesByRange("近一月")[1]);
	}

}
