package com.ivan.dubbo.dao;

import java.util.List;
import java.util.Map;

import org.ivan.entity.WeixinAuthorizationToken;
/**
 * @author cyl
 * @version 
 */
public interface WeixinAuthorizationTokenMapper{
	public Integer getCount(Map<String,Object> map);
	public void insertByEntity(WeixinAuthorizationToken weixinAuthorizationToken);
	public void deleteByEntity(Map<String,Object> map);
	public void updateByEntity(Map<String,Object> map);
	public void updateByEntity(WeixinAuthorizationToken weixinAuthorizationToken);
	public List<WeixinAuthorizationToken> selectByObject (Map<String,Object> map);
	public WeixinAuthorizationToken selectSingle(Map<String,Object> map);
	public WeixinAuthorizationToken selectSingle(WeixinAuthorizationToken weixinAuthorizationToken);
}