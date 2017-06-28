package org.ivan.entity.utils;

/**
 * 常量类
 * @author 
 * @version 
 */
public interface Common
{
	/**
	 * 空格
	 */
	String WHITE_SPACE = "";
	
	/**
	 * 每页显示的数据量
	 */
	int PAGE_DATA = 2;
	
	/**
	 * 当前页面属性名
	 */
	String CUR_PAGE_NAME = "curPage";
	
	/**
	 * 当前
	 */
	String PAGE_DATA_NAME = "pageData";
	
	/**
	 * 要排序的属性名
	 */
	String ORDER_NAME = "orderName";
	
	/**
	 * 要排序的方式
	 */
	String ORDER_FLAG = "orderFlag";
	
	/**
	 * 看是否为数字
	 */
	String NUMBER_REGEX = "^[1-9]\\d*$";
	
	/**
	 * 默认为第一页
	 */
	int FIRST_PAGE = 1;
}
