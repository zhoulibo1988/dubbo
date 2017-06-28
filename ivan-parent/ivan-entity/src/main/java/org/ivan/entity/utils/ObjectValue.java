package org.ivan.entity.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ObjectValue {
	@SuppressWarnings("unchecked")
	public <T> T getValue(Object obj, Class<T> clz) {
		try {
			if (obj != null && !obj.toString().trim().equals("")) {
				if (clz.equals(String.class))
					return (T) obj.toString();
				if (clz.equals(Long.class))
					return (T) Long.valueOf(obj.toString().trim());
				if (clz.equals(Integer.class))
					return (T) Integer.valueOf(obj.toString().trim());
				if (clz.equals(Double.class))
					return (T) Double.valueOf(obj.toString().trim());
				if (clz.equals(Float.class)) {
					return (T) Float.valueOf(obj.toString().trim());
				}
				if (clz.equals(Date.class)) {
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
					//yyyy-MM-dd HH:mm:ss
					Date day = df.parse(obj.toString().trim());					
					return (T) day;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
