package com.java.yxt.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.Objects;

public class DateTimeUtil {

	public static final DateTimeFormatter NOT_YEAR_FORMATTER = DateTimeFormatter.ofPattern("MMddHHmmss");

	public static final DateTimeFormatter BASIC_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

	public static final DateTimeFormatter BASIC_TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");

	public static final DateTimeFormatter ISO_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	public static final String BASIC_DATE_TIME_FORMAT = "yyyyMMddHHmmss";

	public static final String ISO_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 返回不含年的当前时间 格式为：MMddHHmmss
	 * 
	 * @return
	 */
	public static String getNotYearDateTime() {
		LocalDateTime date = LocalDateTime.now();
		return date.format(NOT_YEAR_FORMATTER);
	}

	/**
	 * 返回当前日期时间 格式为：yyyyMMddHHmmss
	 * 
	 * @return
	 */
	public static String getBasicDateTime() {
		LocalDateTime date = LocalDateTime.now();
		return date.format(BASIC_DATE_TIME_FORMATTER);
	}

	/**
	 * 返回当前日期时间 格式为：yyyy-MM-dd HH:mm:ss
	 *
	 * @return
	 */
	public static String getIsoDateTime() {
		LocalDateTime date = LocalDateTime.now();
		return date.format(ISO_DATE_TIME_FORMATTER);
	}

	/**
	 * 格式化日期，将日期从yyyy-MM-dd HH:mm:ss转换为yyyyMMddHHmmss
	 * 
	 * @param datetime String
	 * @return String
	 */
	public static String formatIsoToBasicDateTime(String datetime) {
		LocalDateTime date = LocalDateTime.parse(datetime, ISO_DATE_TIME_FORMATTER);
		return date.format(BASIC_DATE_TIME_FORMATTER);
	}

	/**
	 * 格式化日期，将日期从yyyyMMddHHmmss转换为yyyy-MM-dd HH:mm:ss
	 * 
	 * @param datetime
	 * @return
	 */
	public static String formatBasicToIsoDateTime(String datetime) {
		LocalDateTime date = LocalDateTime.parse(datetime, BASIC_DATE_TIME_FORMATTER);
		return date.format(ISO_DATE_TIME_FORMATTER);
	}

	/**
	 *
	 * @Title: parseBasicDateTime @Description: 解析日期字符串yyyyMMddHHmmss为 LocalDateTime
	 *         日期 @param @param datetime @param @return 参数 @return LocalDateTime
	 *         返回类型 @throws
	 */
	public static LocalDateTime parseBasicDateTime(String datetime) {
		LocalDateTime date = LocalDateTime.parse(datetime, BASIC_DATE_TIME_FORMATTER);
		return date;
	}

	/**
	 *
	 * @Title: parseBasicDateTime @Description: 解析日期字符串HH:mm:ss为 LocalDateTime
	 *         日期 @param @param datetime @param @return 参数 @return LocalDateTime
	 *         返回类型 @throws
	 */
	public static LocalTime parseBasicTime(String datetime) {
		LocalTime date = LocalTime.parse(datetime, BASIC_TIME_FORMATTER);
		return date;
	}

	/**
	 *
	 * @Title: formatBasicDateTime @Description: 解析日期字符串yyyy-MM-dd HH:mm:ss为
	 *         yyyyMMddHHmmss 日期 @param @param datetime @param @return 参数 @return
	 *         String 返回类型 @throws
	 */
	public static String formatBasicDateTime(String datetime) {
		LocalDateTime date = LocalDateTime.parse(datetime, ISO_DATE_TIME_FORMATTER);
		return date.format(BASIC_DATE_TIME_FORMATTER);
	}

	/**
	 * 获取两个日期的相差秒数
	 * 
	 * @param startDate
	 * @param endDate
	 * @param format
	 * @return
	 */
	public static long getDiffSecondBetween(String startDate, String endDate, String format) {
		DateTimeFormatter applyFormatter;
		if (BASIC_DATE_TIME_FORMAT.equals(format)) {
			applyFormatter = BASIC_DATE_TIME_FORMATTER;
		} else { // 默认 ISO_DATE_TIME_FORMAT
			applyFormatter = ISO_DATE_TIME_FORMATTER;
		}

		LocalDateTime startDateTime = LocalDateTime.parse(startDate, applyFormatter);
		LocalDateTime endDateTime = LocalDateTime.parse(endDate, applyFormatter);

		Duration d = Duration.between(startDateTime, endDateTime);
		long second = d.getSeconds();
		return second;
	}

	/**
	 * TODO 当前方法的使用场景待后期确定是否修改 ，先不重构； 判断当前时间是否在该时间段内
	 * 
	 * @description <09:00-20:00>
	 * @param begin
	 * @param end
	 * @return
	 * @author jixing
	 * @version V1.0
	 * @date 2017年6月23日
	 */
	public static boolean checkTimeBetween(String begin, String end) {
		try {
			String beginTime = getIsoDate() + " " + begin + ":00";
			String endTime = getIsoDate() + " " + end + ":00";
			LocalDateTime beginDate = LocalDateTime.parse(beginTime, ISO_DATE_TIME_FORMATTER);
			LocalDateTime endDate = LocalDateTime.parse(endTime, ISO_DATE_TIME_FORMATTER);
			LocalDateTime now = LocalDateTime.now();
			if (now.isAfter(beginDate) && now.isBefore(endDate)) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 判断当前时间是否在该时间段内
	 * 
	 * @param begin
	 * @param end
	 * @return
	 */
	public static boolean checkTimeBetween(Date begin, Date end) {
		Date date = new Date();
		if (date.after(begin) && date.before(end)) {
			return true;
		}
		return false;
	}

	/**
	 * 返回当前日期 格式为：yyyy-MM-dd
	 * 
	 * @return
	 */
	public static String getIsoDate() {
		LocalDateTime date = LocalDateTime.now();
		return date.format(DateTimeFormatter.ISO_LOCAL_DATE);
	}

	/**
	 * 返回当前日期 格式为：yyyyMMdd
	 * 
	 * @return
	 */
	public static String getBasicDate() {
		LocalDate date = LocalDate.now();
		return date.format(DateTimeFormatter.BASIC_ISO_DATE);
	}

	/**
	 * 获取当前月第一天
	 * 
	 * @return 20170601000000
	 */
	public static String getCurrentMonthFirstDateTime() {
		LocalDate date = LocalDate.now();
		LocalDate firstDate = date.with(TemporalAdjusters.firstDayOfMonth());
		LocalTime firstTime = LocalTime.of(00, 00, 00);
		LocalDateTime firstDateTime = firstDate.atTime(firstTime);
		String firstDateTimeStr = firstDateTime.format(BASIC_DATE_TIME_FORMATTER);
		return firstDateTimeStr;
	}

	/**
	 * 获取当前日最后一秒
	 * 
	 * @return currentday235959
	 */
	public static String getCurrentDayLastDateTime() {
		LocalDate date = LocalDate.now();
		LocalTime lastTime = LocalTime.of(23, 59, 59);
		LocalDateTime lastDateTime = date.atTime(lastTime);
		String lastDateTimeStr = lastDateTime.format(BASIC_DATE_TIME_FORMATTER);
		return lastDateTimeStr;
	}

	/**
	 * 获取当前月最后一天
	 * 
	 * @return 20170630235959
	 */
	public static String getCurrentMonthLastDateTime() {
		LocalDate date = LocalDate.now();
		LocalDate lastDate = date.with(TemporalAdjusters.lastDayOfMonth());
		LocalTime lastTime = LocalTime.of(23, 59, 59);
		LocalDateTime lastDateTime = lastDate.atTime(lastTime);
		String lastDateTimeStr = lastDateTime.format(BASIC_DATE_TIME_FORMATTER);
		return lastDateTimeStr;
	}

	/**
	 * 从字节数组中获取日期时间并格式化
	 * 
	 * @param bytes
	 * @return
	 */
	public static String getDateTimeByByte(byte[] bytes) {
		int year = bytes[0] + 2000;
		int month = bytes[1];
		int date = bytes[2];
		int hour = bytes[3];
		int min = bytes[4];
		int sec = bytes[5];
		return String.valueOf(year) + "-" + formatInt(String.valueOf(month)) + "-" + formatInt(String.valueOf(date))
				+ " " + formatInt(String.valueOf(hour)) + ":" + formatInt(String.valueOf(min)) + ":"
				+ formatInt(String.valueOf(sec));
	}

	private static String formatInt(String value) {
		if (value.length() == 1) {
			return "0" + value;
		} else {
			return value;
		}
	}

	/**
	 * 返回给定日期时间 格式为：yyyyMMddHHmmss
	 * 
	 * @return
	 */
	public static String getBasicDateTime(LocalDateTime date) {
		Objects.requireNonNull(date, "LocalDateTime");
		return date.format(BASIC_DATE_TIME_FORMATTER);
	}

	/**
	 * localDateTime 转Date 默认时区为东8区
	 * 
	 * @param localDateTime
	 * @return
	 */
	public static Date localDateTimeConvertToDate(LocalDateTime localDateTime) {
		return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
	}

	/**
	 * 
	 * @Title: getDate @Description: 获取当前日期时间 原始版本 @param @return 参数 @return Date
	 *         返回类型 @throws
	 */
	public static Date getDate() {
		return Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
	}

	/**
	 * 
	 * @Title: checkDateValid @Description: 检查日期时间格式是否有效 @param @param
	 *         datetime @param @param format @param @return 参数 @return boolean 返回类型
	 *         成功：true 失败:false @throws
	 */
	public static boolean checkDateValid(String datetime, String format) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format.replace("y", "u"))
				.withResolverStyle(ResolverStyle.STRICT);
		boolean dateFlag = true;
		try {
			LocalDate.parse(datetime, dtf);
		} catch (Exception e) {
			dateFlag = false;
		}

		return dateFlag;
	}

	/**
	 * 计算本日还有多少秒，从当前时间开始算
	 * 
	 * @return
	 */
	public static long getLastSecondOfDay() {
		String startDate = getBasicDateTime();
		String endDate = getCurrentDayLastDateTime();
		return getDiffSecondBetween(startDate, endDate, BASIC_DATE_TIME_FORMAT);
	}

	/**
	 * 计算本月还有多少秒，从当前时间开始算
	 * 
	 * @return
	 */
	public static long getLastSecondOfMonth() {
		String startDate = getBasicDateTime();
		String endDate = getCurrentMonthLastDateTime();
		return getDiffSecondBetween(startDate, endDate, BASIC_DATE_TIME_FORMAT);
	}

	/**
	 * 
	 * @Title: getBeforeBasicDateTime @Description: 返回当前时间往前或往后
	 *         格式为：yyyyMMddHHmmss的时间 @param @param time @param @param
	 *         unit @param @return 参数 @return long 返回类型 @throws
	 */
	public static long getBeforeBasicDateTime(long time, ChronoUnit unit) {
		LocalDateTime localDateTime = LocalDateTime.now().minus(time, unit);
		long beforeBasicDateTime = Long.valueOf(localDateTime.format(BASIC_DATE_TIME_FORMATTER));
		return beforeBasicDateTime;
	}

	public static Date parseStringToDateTime(String timeStr) throws ParseException {
		Date date = null;
		SimpleDateFormat formatter = new SimpleDateFormat(ISO_DATE_TIME_FORMAT);
		date = formatter.parse(timeStr);
		return date;
	}

}
