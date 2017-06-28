package org.ivan.api;

import java.util.Map;

import org.ivan.entity.WeixinAuthCode;


/**
 * @author cyl
 * @version 
 */
public interface WeixinAuthCodeService{
	public void insert(WeixinAuthCode weixinAuthCode);
	
	public WeixinAuthCode selectSingle(Map<String,Object> map);
	
	public WeixinAuthCode selectSingle(WeixinAuthCode weixinAuthCode);
	
	
	public void updateByEntity(WeixinAuthCode weixinAuthCode);
}
