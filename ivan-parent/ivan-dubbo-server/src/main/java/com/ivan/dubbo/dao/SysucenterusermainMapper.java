package com.ivan.dubbo.dao;

import java.util.List;

import org.ivan.entity.SysUcenterUserMain;


/**
 * @author buyuer
 * @version 
 */
public interface SysucenterusermainMapper{
	public Integer getCount();
	public void insertByEntity(SysUcenterUserMain userman);
	public void deleteByEntity();
	public void updateByEntity();
	public List<SysUcenterUserMain> selectByObject ();
	public SysUcenterUserMain selectSingle();
}