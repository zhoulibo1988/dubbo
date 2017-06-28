package org.ivan.api;

import java.util.Map;

import org.ivan.entity.WeixinBusinessInfo;


/**
 * @author cyl
 * @version 
 */
public interface WeixinBusinessInfoService  {
	public void  insert(WeixinBusinessInfo WeixinBusinessInfo);
	public WeixinBusinessInfo selectSingle(Map<String,Object> map);
	public WeixinBusinessInfo selectSingle(WeixinBusinessInfo WeixinBusinessInfo);
	public void updateByEntity(WeixinBusinessInfo WeixinBusinessInfo);
}
