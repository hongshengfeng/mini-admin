package cn.scene.util;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期转换
 */
public class DateFormat {

	// 格式化日期（格式是yyyy-MM-dd）
	public static String format(Date source) {
		try{
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			return simpleDateFormat.format(source);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	//String转Date
	public static Date strToDate(String strDate) {
		String temp = strDate+" 23:59:59";
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		ParsePosition pos = new ParsePosition(0);
		Date strtodate = formatter.parse(temp, pos);
		return strtodate;
	}

	/**
	 * 日期的加减
	 * @param dateTime 待处理的日期
	 * @param n 加减天数
	 * @return
	 */
	public static Date addAndSubtractDaysByGetTime(Date dateTime,int n){

		//日期格式
		SimpleDateFormat dd=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//注意这里一定要转换成Long类型，要不n超过25时会出现范围溢出，从而得不到想要的日期值
		return new Date(dateTime.getTime() + n * 24 * 60 * 60 * 1000L);
	}

	//日期比较
	public static int dateCompare (Date date1, Date date2){
		int i = date1.compareTo(date2);
		return i;
	}
}