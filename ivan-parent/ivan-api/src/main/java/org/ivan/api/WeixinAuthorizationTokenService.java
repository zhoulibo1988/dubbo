package org.ivan.api;

import java.util.Map;

import org.ivan.entity.WeixinAuthCode;
import org.ivan.entity.WeixinAuthorizationToken;

/**
 * @author cyl
 * @version 
 */
public interface WeixinAuthorizationTokenService{
public void insert(WeixinAuthorizationToken weixinAuthorizationToken);
	
	public WeixinAuthorizationToken selectSingle(Map<String,Object> map);
	
	public WeixinAuthorizationToken selectSingle(WeixinAuthorizationToken weixinAuthorizationToken);
	
	
	public void updateByEntity(WeixinAuthorizationToken weixinAuthorizationToken);
}
