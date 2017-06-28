package org.ivan.api;

import java.util.Map;

import org.ivan.entity.WeixinAuthorizationInfo;


/**
 * @author cyl
 * @version 
 */
public interface WeixinAuthorizationInfoService {
	public void insert(WeixinAuthorizationInfo WeixinAuthorizationInfo);
	
	public WeixinAuthorizationInfo selectSingle(Map<String,Object> map);
	
	public WeixinAuthorizationInfo selectSingle(WeixinAuthorizationInfo WeixinAuthorizationInfo);
	
	
	public void updateByEntity(WeixinAuthorizationInfo WeixinAuthorizationInfo);
}
