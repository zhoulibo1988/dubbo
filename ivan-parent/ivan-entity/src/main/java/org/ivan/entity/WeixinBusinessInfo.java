package org.ivan.entity;

import java.io.Serializable;
import java.util.Date;

/**
TABLE:.weixin_business_info     
--------------------------------------------------------
id                   Integer(10)        NOTNULL             //
authorizer_appid     String(255)        NOTNULL             //
open_store           Integer(10)                            //是否开通微信门店功能
open_scan            Integer(10)                            //是否开通微信扫商品功能
open_pay             Integer(10)                            //是否开通微信支付功能
open_card            Integer(10)                            //是否开通微信卡券功能
open_shake           Integer(10)                            //是否开通微信摇一摇功能
time                 Date(19)                               //创建时间
*/
public class WeixinBusinessInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private	Integer id;
	private	String authorizerAppid;
	private	Integer openStore;
	private	Integer openScan;
	private	Integer openPay;
	private	Integer openCard;
	private	Integer openShake;
	private	Date time;

	/**
	* id  Integer(10)  NOTNULL  //    
	*/
	public Integer getId(){
		return id;
	}
	
	/**
	* id  Integer(10)  NOTNULL  //    
	*/
	public void setId(Integer id){
		this.id = id;
	}
	
	/**
	* authorizer_appid  String(255)  NOTNULL  //    
	*/
	public String getAuthorizerAppid(){
		return authorizerAppid;
	}
	
	/**
	* authorizer_appid  String(255)  NOTNULL  //    
	*/
	public void setAuthorizerAppid(String authorizerAppid){
		this.authorizerAppid = authorizerAppid;
	}
	
	/**
	* open_store  Integer(10)  //是否开通微信门店功能    
	*/
	public Integer getOpenStore(){
		return openStore;
	}
	
	/**
	* open_store  Integer(10)  //是否开通微信门店功能    
	*/
	public void setOpenStore(Integer openStore){
		this.openStore = openStore;
	}
	
	/**
	* open_scan  Integer(10)  //是否开通微信扫商品功能    
	*/
	public Integer getOpenScan(){
		return openScan;
	}
	
	/**
	* open_scan  Integer(10)  //是否开通微信扫商品功能    
	*/
	public void setOpenScan(Integer openScan){
		this.openScan = openScan;
	}
	
	/**
	* open_pay  Integer(10)  //是否开通微信支付功能    
	*/
	public Integer getOpenPay(){
		return openPay;
	}
	
	/**
	* open_pay  Integer(10)  //是否开通微信支付功能    
	*/
	public void setOpenPay(Integer openPay){
		this.openPay = openPay;
	}
	
	/**
	* open_card  Integer(10)  //是否开通微信卡券功能    
	*/
	public Integer getOpenCard(){
		return openCard;
	}
	
	/**
	* open_card  Integer(10)  //是否开通微信卡券功能    
	*/
	public void setOpenCard(Integer openCard){
		this.openCard = openCard;
	}
	
	/**
	* open_shake  Integer(10)  //是否开通微信摇一摇功能    
	*/
	public Integer getOpenShake(){
		return openShake;
	}
	
	/**
	* open_shake  Integer(10)  //是否开通微信摇一摇功能    
	*/
	public void setOpenShake(Integer openShake){
		this.openShake = openShake;
	}
	
	/**
	* time  Date(19)  //创建时间    
	*/
	public Date getTime(){
		return time;
	}
	
	/**
	* time  Date(19)  //创建时间    
	*/
	public void setTime(Date time){
		this.time = time;
	}
	
}