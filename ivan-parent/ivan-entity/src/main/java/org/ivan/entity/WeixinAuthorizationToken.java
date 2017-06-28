package org.ivan.entity;

import java.io.Serializable;
import java.util.Date;

/**
TABLE:.weixin_authorization_token  
--------------------------------------------------------
id                   Integer(10)        NOTNULL             //自增ID
app_id               String(255)        NOTNULL             //第三方APPID
authorizer_appid     String(255)        NOTNULL             //授权方app_id
authorizer_access_token String(1000)       NOTNULL             //令牌
expires_in           Integer(10)        NOTNULL             //有效期
authorizer_refresh_token String(1000)       NOTNULL             //接口调用凭据刷新令牌
time                 Date(19)                               //
*/
public class WeixinAuthorizationToken implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private	Integer id;
	private	String appId;
	private	String authorizerAppid;
	private	String authorizerAccessToken;
	private	Integer expiresIn;
	private	String authorizerRefreshToken;
	private	Date time;

	/**
	* id  Integer(10)  NOTNULL  //自增ID    
	*/
	public Integer getId(){
		return id;
	}
	
	/**
	* id  Integer(10)  NOTNULL  //自增ID    
	*/
	public void setId(Integer id){
		this.id = id;
	}
	
	/**
	* app_id  String(255)  NOTNULL  //第三方APPID    
	*/
	public String getAppId(){
		return appId;
	}
	
	/**
	* app_id  String(255)  NOTNULL  //第三方APPID    
	*/
	public void setAppId(String appId){
		this.appId = appId;
	}
	
	/**
	* authorizer_appid  String(255)  NOTNULL  //授权方app_id    
	*/
	public String getAuthorizerAppid(){
		return authorizerAppid;
	}
	
	/**
	* authorizer_appid  String(255)  NOTNULL  //授权方app_id    
	*/
	public void setAuthorizerAppid(String authorizerAppid){
		this.authorizerAppid = authorizerAppid;
	}
	
	/**
	* authorizer_access_token  String(1000)  NOTNULL  //令牌    
	*/
	public String getAuthorizerAccessToken(){
		return authorizerAccessToken;
	}
	
	/**
	* authorizer_access_token  String(1000)  NOTNULL  //令牌    
	*/
	public void setAuthorizerAccessToken(String authorizerAccessToken){
		this.authorizerAccessToken = authorizerAccessToken;
	}
	
	/**
	* expires_in  Integer(10)  NOTNULL  //有效期    
	*/
	public Integer getExpiresIn(){
		return expiresIn;
	}
	
	/**
	* expires_in  Integer(10)  NOTNULL  //有效期    
	*/
	public void setExpiresIn(Integer expiresIn){
		this.expiresIn = expiresIn;
	}
	
	/**
	* authorizer_refresh_token  String(1000)  NOTNULL  //接口调用凭据刷新令牌    
	*/
	public String getAuthorizerRefreshToken(){
		return authorizerRefreshToken;
	}
	
	/**
	* authorizer_refresh_token  String(1000)  NOTNULL  //接口调用凭据刷新令牌    
	*/
	public void setAuthorizerRefreshToken(String authorizerRefreshToken){
		this.authorizerRefreshToken = authorizerRefreshToken;
	}
	
	/**
	* time  Date(19)  //    
	*/
	public Date getTime(){
		return time;
	}
	
	/**
	* time  Date(19)  //    
	*/
	public void setTime(Date time){
		this.time = time;
	}
	
}