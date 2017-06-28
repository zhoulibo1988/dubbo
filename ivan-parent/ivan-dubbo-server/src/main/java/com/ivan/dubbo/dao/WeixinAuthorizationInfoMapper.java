package com.ivan.dubbo.dao;

import java.util.List;
import java.util.Map;

import org.ivan.entity.WeixinAuthorizationInfo;

/**
 * @author cyl
 * @version 
 */
public interface WeixinAuthorizationInfoMapper{
	public Integer getCount(Map<String,Object> map);
	public void insertByEntity(WeixinAuthorizationInfo WeixinAuthorizationInfo);
	public void deleteByEntity(Map<String,Object> map);
	public void updateByEntity(Map<String,Object> map);
	public void updateByEntity(WeixinAuthorizationInfo WeixinAuthorizationInfo);
	public List<WeixinAuthorizationInfo> selectByObject (Map<String,Object> map);
	public WeixinAuthorizationInfo selectSingle(Map<String,Object> map);
	public WeixinAuthorizationInfo selectSingle(WeixinAuthorizationInfo WeixinAuthorizationInfo);
}