package org.ivan.entity.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import org.apache.log4j.Logger;

/**
 * Map 转换 成对象
 * @author buyuer
 * @version 
 * @param <T>
 */
public class MapToEntity<T> {

	Logger logger = Logger.getLogger(MapToEntity.class);

	private T t;
	
	private Map<String, Object> map;

	//实体类名
	private String className;
	
	//实体类对象
	private Class<T> tClass;
	/**
	 * Map 转换 成对象
	 * @author buyuer
	 * @version 
	 * @param tClass实体类型
	 * @param map 需要转换的map
	 */
	public MapToEntity(Class<T> tClass, Map<String, Object> map) {
		this.map = map;
		try {
			this.t = tClass.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.tClass = tClass;
		this.className = tClass.getName();
	}

	/**
 	 * Map 获取实体对象
	 * @author buyuer
 	 * @version 
 	 */
	@SuppressWarnings("rawtypes")
	public T getEntity() {
		boolean temp = false;
		Class c = null;
		try {
			c = Class.forName(className);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Field[] fields = c.getDeclaredFields();
		ObjectValue tool = new ObjectValue();
		for (Field field : fields) {
			for (Map.Entry entry : map.entrySet()) {
				String key = (String) entry.getKey();
				String value = (String) entry.getValue();
				logger.debug(" key :"+key+"    field.getname(): "+field.getName());
				if(value!=null)
				if (field.getName().equals(key)&&!value.equals("")) {
					logger.debug(field.getName() +"\t" +key+"\t"+value);
					temp = true;
					String prop = Character.toUpperCase(key.charAt(0))+ key.substring(1);
					String methodName = "set" + prop;
					Class[] types = new Class[] { field.getType() };
					Method method;
					try {
						method = tClass.getMethod(methodName, types);
						method.invoke(
								t,
								new Object[] { tool.getValue(value,field.getType()) });
					} catch (SecurityException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (NoSuchMethodException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		logger.debug(temp);
		return temp ? t : null;
	}

}
