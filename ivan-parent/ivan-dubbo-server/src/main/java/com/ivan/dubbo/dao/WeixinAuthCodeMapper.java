package com.ivan.dubbo.dao;

import java.util.List;
import java.util.Map;

import org.ivan.entity.WeixinAuthCode;

/**
 * @author cyl
 * @version 
 */
public interface WeixinAuthCodeMapper{
	public Integer getCount(Map<String,Object> map);
	public void insertByEntity(WeixinAuthCode weixinAuthCode);
	public void deleteByEntity(Map<String,Object> map);
	public void updateByEntity(Map<String,Object> map);
	public void updateByEntity(WeixinAuthCode weixinAuthCode);
	public List<WeixinAuthCode> selectByObject (Map<String,Object> map);
	public WeixinAuthCode selectSingle(Map<String,Object> map);
	public WeixinAuthCode selectSingle(WeixinAuthCode weixinAuthCode);
}