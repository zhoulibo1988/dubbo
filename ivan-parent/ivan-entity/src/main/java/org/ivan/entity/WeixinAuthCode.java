package org.ivan.entity;

import java.io.Serializable;
import java.util.Date;

/**
TABLE:.weixin_auth_code         
--------------------------------------------------------
id                   Integer(10)        NOTNULL             //
auth_code            String(255)        NOTNULL             //预授权码
app_id               String(255)        NOTNULL             //第三方平台appid
time                 Date(19)                               //创建时间
component_access_token String(255)        NOTNULL             //token
*/
public class WeixinAuthCode implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private	Integer id;
	private	String authCode;
	private	String appId;
	private	Date time;
	private	String componentAccessToken;

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
	* auth_code  String(255)  NOTNULL  //预授权码    
	*/
	public String getAuthCode(){
		return authCode;
	}
	
	/**
	* auth_code  String(255)  NOTNULL  //预授权码    
	*/
	public void setAuthCode(String authCode){
		this.authCode = authCode;
	}
	
	/**
	* app_id  String(255)  NOTNULL  //第三方平台appid    
	*/
	public String getAppId(){
		return appId;
	}
	
	/**
	* app_id  String(255)  NOTNULL  //第三方平台appid    
	*/
	public void setAppId(String appId){
		this.appId = appId;
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
	
	/**
	* component_access_token  String(255)  NOTNULL  //token    
	*/
	public String getComponentAccessToken(){
		return componentAccessToken;
	}
	
	/**
	* component_access_token  String(255)  NOTNULL  //token    
	*/
	public void setComponentAccessToken(String componentAccessToken){
		this.componentAccessToken = componentAccessToken;
	}
	
}