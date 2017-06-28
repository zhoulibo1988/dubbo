package org.ivan.entity.utils;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ObjectUtil {

	public static void main(String[] args) {
	}

	/**
	 * 根据属性名获取属性值
	 * */
	private static Object getFieldValueByName(String fieldName, Object o) {
		try {
			String firstLetter = fieldName.substring(0, 1).toUpperCase();
			String getter = "get" + firstLetter + fieldName.substring(1);
			Method method = o.getClass().getMethod(getter, new Class[] {});
			Object value = method.invoke(o, new Object[] {});
			return value;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 获取属性名数组
	 * */
	private static String[] getFiledName(Object o) {
		Field[] fields = o.getClass().getDeclaredFields();
		String[] fieldNames = new String[fields.length];
		for (int i = 0; i < fields.length; i++) {
			System.out.println(fields[i].getType());
			fieldNames[i] = fields[i].getName();
		}
		return fieldNames;
	}

	/**
	 * 获取属性类型(type)，属性名(name)，属性值(value)的map组成的list
	 * */
	@SuppressWarnings({ "unused", "rawtypes", "unchecked" })
	private static  List getFiledsInfo(Object o) {
		Field[] fields = o.getClass().getDeclaredFields();
		String[] fieldNames = new String[fields.length];
		List list = new ArrayList();
		Map infoMap = null;
		for (int i = 0; i < fields.length; i++) {
			infoMap = new HashMap();
			infoMap.put("type", fields[i].getType().toString());
			infoMap.put("name", fields[i].getName());
			infoMap.put("value", getFieldValueByName(fields[i].getName(), o));
			list.add(infoMap);
		}
		return list;
	}

	/**
	 * 获取对象的所有属性值，返回一个对象数组
	 * */
	@SuppressWarnings("static-access")
	public Object[] getFiledValues(Object o) {
		String[] fieldNames = this.getFiledName(o);
		Object[] value = new Object[fieldNames.length];
		for (int i = 0; i < fieldNames.length; i++) {
			value[i] = this.getFieldValueByName(fieldNames[i], o);
		}
		return value;
	}

	/**
	 * 判断是否为空 
	 * @param files
	 * @param o
	 * @return
	 */
	public static boolean checkObjectFile(String[] files, Object o) {
		List<Map<String, Object>> list=getFiledsInfo(o);
		for (Map<String, Object> map : list) {
			String fileName=map.get("name").toString();
			if (Arrays.asList(files).contains(fileName)) {
				Object value=map.get("value");
				if (value==null) {
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * 
	 * @author buyuer
	 * @Title: getObjectByFileNames
	 * @Description: 获取一个object对象中的字段
	 * @param files 字段数组
	 * @param o 对象
	 * @return
	 */
	public static Map<String, Object> getObjectByFileNames(String[] files,Object o) {
	    Map<String, Object> map=new HashMap<>();
	    List<Map<String, Object>> list=getFiledsInfo(o);
	    for (Map<String, Object> filemap : list) {
	      String fileName=filemap.get("name").toString();
	      if (Arrays.asList(files).contains(fileName)) {
	        Object value=filemap.get("value");
	        if (value!=null) {
	            map.put(fileName, value);
	        }
	      }
	    }
	    return map;
	}
}
