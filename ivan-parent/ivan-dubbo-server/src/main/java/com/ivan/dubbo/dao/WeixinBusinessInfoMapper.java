package com.ivan.dubbo.dao;

import java.util.List;
import java.util.Map;

import org.ivan.entity.WeixinBusinessInfo;


/**
 * @author cyl
 * @version 
 */
public interface WeixinBusinessInfoMapper{
	public Integer getCount(Map<String,Object> map);
	public void insertByEntity(WeixinBusinessInfo WeixinBusinessInfo);
	public void deleteByEntity(Map<String,Object> map);
	public void updateByEntity(Map<String,Object> map);
	public void updateByEntity(WeixinBusinessInfo WeixinBusinessInfo);
	public List<WeixinBusinessInfo> selectByObject (Map<String,Object> map);
	public WeixinBusinessInfo selectSingle(Map<String,Object> map);
	public WeixinBusinessInfo selectSingle(WeixinBusinessInfo WeixinBusinessInfo);
}