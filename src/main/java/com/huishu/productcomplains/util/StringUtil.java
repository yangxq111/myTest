package com.huishu.productcomplains.util;

import java.math.BigDecimal;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class StringUtil {

	private StringUtil(){}
	
	
	/**
	 * double 四舍五入保留二位小数
	 * @param value
	 * @return
	 */
	public static double getRound(double value){
		BigDecimal decimal = new BigDecimal(value+"");
		return decimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue(); 
	}
	
	/**
	 * 校验字符串是否为空或为""
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		return str == null || "".equals(str.trim());
	}

	/**
	 * 校验字符串是否为电话格式
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isPhone(String str) {
		if (isEmpty(str)) {
			return false;
		}
		return str.matches("^((13[0-9])|(14[57])|(15[0-9])|(17[01678])|(18[0-9]))\\d{8}$");
	}

	/**
	 * 校验字符串是否为电话格式
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isPhones(String str) {
		if (isEmpty(str)) {
			return false;
		}
		if (str.indexOf(",") >= 0) {
			String[] split = str.split(",");
			for (int x = 0; x < split.length; x++) {
				boolean flag = split[x].matches("^((13[0-9])|(15[0-9])|(18[0,2,5-9]))\\d{8}$");
				// ^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$
				if (!flag) {
					return false;
				}
			}
			return true;
		}
		return str.matches("^((13[0-9])|(15[0-9])|(18[0,2,5-9]))\\d{8}$");
	}

	/**
	 * 判断字符串是否包含中文
	 */
	public static boolean isContainChinese(String str) {
		Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
		Matcher m = p.matcher(str);
        return m.find();
    }

	/**
	 * 校验字符串是否为日期格式 yyyy-MM-dd
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isDate(String str) {
		if (isEmpty(str)) {
			return false;
		}
		return str.matches("^(\\d{4})-(0\\d{1}|1[0-2])-(0\\d{1}|[12]\\d{1}|3[01])$");
	}

	/**
	 * 校验字符串是否为日期格式 yyyy-MM-dd HH:mm:ss
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isDateTime(String str) {
		if (isEmpty(str)) {
			return false;
		}
		return str.matches("^(\\d{4})-(0\\d{1}|1[0-2])-(0\\d{1}|[12]\\d{1}|3[01]) (\\d{2}):(\\d{2}):(\\d{2})$");
	}

	/**
	 * 将yyyy-MM-dd格式的日期字符串转换成日期对象
	 * 
	 * @param date
	 * @return
	 */
	public static Date formatDate(String date) {
		Date result = null;
		if (isDate(date)) {
			DateTimeFormatter format = DateTimeFormat.forPattern(DateUtils.DATE_FORMAT);
			result = DateTime.parse(date, format).toDate();
		}
		return result;
	}

	/**
	 * 判断dateA是否小于dateB
	 * 
	 * @param dateA
	 * @param dateB
	 * @return
	 */
	public static boolean lessThan(Date dateA, Date dateB) {
		if (dateA == null || dateB == null) {
			return false;
		} else {
			return dateA.compareTo(dateB) < 0;
		}
	}
	
	/**
	 * 校验用户的邮箱
	 * 
	 * @param email
	 * @return cmx
	 */
	public static boolean checkEmail(String email) {
		String pattern = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(email);
		return m.matches();
	}

	/**
	 * 校验密码
	 */
	public static boolean checkPassword(String password) {
		String pattern = "^[a-zA-Z]\\w{5,17}$";
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(password);
		return m.matches();
	}

	/**
	 * 将yyyy-MM-dd HH:mm:ss格式的日期字符串转换成日期对象
	 * 
	 * @param date
	 * @return
	 */
	public static Date formatDataTimeToDate(String date, String format) {
		Date result = null;
		DateTimeFormatter dtf = null;
		if (isEmpty(format)) {
			dtf = DateTimeFormat.forPattern(DateUtils.DATE_FORMAT);
		} else {
			dtf = DateTimeFormat.forPattern(format);
		}
		if (isDateTime(date)) {
			result = DateTime.parse(date, dtf).toDate();
		}
		return result;
	}
	
	/**
	 * 验证字符串是否数字（包含有符号或者无符号的整数和浮点数）
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str) {
		if (StringUtils.isBlank(str)) {
			return false;
		}
		Pattern pattern = Pattern.compile("^\\+?-?\\d+\\.?\\d+$");
		Matcher isNum = pattern.matcher(str);
        return isNum.matches();
    }

	/**
	 * 判断是否包含sql的特殊字符
	 */
	public static boolean isSpecialSql(String str) {
		if (str != null) {
			String[] strArray = new String[] { "'", "<", ">", "%", "\"\"", ",", ".", ">=", "=<", "<>", "-", "_",
					";" + "||", "\\", "[", "]", "&", "/", "-", "|", " " };
			for (int i = 0; i < strArray.length; i++) {
				if (str.contains(strArray[i])) {
					return true;
				}
			}
			return false;
		}
		return false;
	}
}
