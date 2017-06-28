package org.ivan.entity;

import java.io.Serializable;
@SuppressWarnings("serial")
public class SysUcenterUserMain implements Serializable{
	private	Long id;
	private	String userCode;
	private	Integer userType;
	private	String userName;
	private	Long userMobile;
	private	String userIdcard;
	
	public SysUcenterUserMain(){
		
	}
	public SysUcenterUserMain(Long id,String userCode,Integer userType,String userName,Long userMobile,String userIdcard){
		this.id=id;
		this.userCode=userCode;
		this.userIdcard=userIdcard;
		this.userMobile=userMobile;
		this.userType=userType;
		this.userName=userName;
				
	}
	/**
	* id  Long(19)  NOTNULL  //    
	*/
	public Long getId(){
		return id;
	}
	
	/**
	* id  Long(19)  NOTNULL  //    
	*/
	public void setId(Long id){
		this.id = id;
	}
	
	/**
	* user_code  String(32)  NOTNULL  //个人电子账号    
	*/
	public String getUserCode(){
		return userCode;
	}
	
	/**
	* user_code  String(32)  NOTNULL  //个人电子账号    
	*/
	public void setUserCode(String userCode){
		this.userCode = userCode;
	}
	
	/**
	* user_type  Integer(10)  NOTNULL  //用户类型  （1-注册用户；2-游客用户；3-其他）    
	*/
	public Integer getUserType(){
		return userType;
	}
	
	/**
	* user_type  Integer(10)  NOTNULL  //用户类型  （1-注册用户；2-游客用户；3-其他）    
	*/
	public void setUserType(Integer userType){
		this.userType = userType;
	}
	
	/**
	* user_name  String(128)  //用户名    
	*/
	public String getUserName(){
		return userName;
	}
	
	/**
	* user_name  String(128)  //用户名    
	*/
	public void setUserName(String userName){
		this.userName = userName;
	}
	
	/**
	* user_mobile  Long(19)  //用户手机号码    
	*/
	public Long getUserMobile(){
		return userMobile;
	}
	
	/**
	* user_mobile  Long(19)  //用户手机号码    
	*/
	public void setUserMobile(Long userMobile){
		this.userMobile = userMobile;
	}
	
	/**
	* user_idcard  String(20)  //身份证号码    
	*/
	public String getUserIdcard(){
		return userIdcard;
	}
	
	/**
	* user_idcard  String(20)  //身份证号码    
	*/
	public void setUserIdcard(String userIdcard){
		this.userIdcard = userIdcard;
	}
	
}