package org.ivan.entity;

import java.io.Serializable;
import java.util.Date;

/**
TABLE:.weixin_authorization_info  
--------------------------------------------------------
id                   Integer(10)        NOTNULL             //自增ID
nick_name            String(255)                            //授权方昵称
head_img             String(255)                            //授权方头像
service_type_info    Integer(10)                            //授权方公众号类型，0代表订阅号，1代表由历史老帐号升级后的订阅号，2代表服务号
verify_type_info     Integer(10)                            //授权方认证类型:-1代表未认证，0代表微信认证，1代表新浪微博认证，2代表腾讯微博认证，3代表已资质认证通过但还未通过名称认证，4代表已资质认证通过、还未通过名称认证，但通过了新浪微博认证，5代表已资质认证通过、还未通过名称认证，但通过了腾讯微博认证
user_name            String(255)                            //授权方公众号的原始ID
principal_name       String(255)                            //公众号的主体名称
alias                String(255)                            //授权方公众号所设置的微信号，可能为空
business_info        String(255)                            //用以了解以下功能的开通状况（0代表未开通，1代表已开通）：
qrcode_url           String(255)                            //二维码图片的UR
authorizer_appid     String(255)        NOTNULL             //授权方appid
func_info            String(255)                            //公众号授权给开发者的权限集列表，ID为1到15时分别代表：
消息管理权限
用户管理权限
帐号服务权限
网页服务权限
微信小店权限
微信多客服权限
群发与通知权限
微信卡券权限
微信扫一扫权限
微信连WIFI权限
素材管理权限
微信摇周边权限
微信门店权限
微信支付权限
自定义菜单权限
time                 Date(19)                               //
*/
public class WeixinAuthorizationInfo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private	Integer id;
	private	String nickName;
	private	String headImg;
	private	Integer serviceTypeInfo;
	private	Integer verifyTypeInfo;
	private	String userName;
	private	String principalName;
	private	String alias;
	private	Integer businessInfo;
	private	String qrcodeUrl;
	private	String authorizerAppid;
	private	String funcInfo;
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
	* nick_name  String(255)  //授权方昵称    
	*/
	public String getNickName(){
		return nickName;
	}
	
	/**
	* nick_name  String(255)  //授权方昵称    
	*/
	public void setNickName(String nickName){
		this.nickName = nickName;
	}
	
	/**
	* head_img  String(255)  //授权方头像    
	*/
	public String getHeadImg(){
		return headImg;
	}
	
	/**
	* head_img  String(255)  //授权方头像    
	*/
	public void setHeadImg(String headImg){
		this.headImg = headImg;
	}
	
	/**
	* service_type_info  Integer(10)  //授权方公众号类型，0代表订阅号，1代表由历史老帐号升级后的订阅号，2代表服务号    
	*/
	public Integer getServiceTypeInfo(){
		return serviceTypeInfo;
	}
	
	/**
	* service_type_info  Integer(10)  //授权方公众号类型，0代表订阅号，1代表由历史老帐号升级后的订阅号，2代表服务号    
	*/
	public void setServiceTypeInfo(Integer serviceTypeInfo){
		this.serviceTypeInfo = serviceTypeInfo;
	}
	
	/**
	* verify_type_info  Integer(10)  //授权方认证类型:-1代表未认证，0代表微信认证，1代表新浪微博认证，2代表腾讯微博认证，3代表已资质认证通过但还未通过名称认证，4代表已资质认证通过、还未通过名称认证，但通过了新浪微博认证，5代表已资质认证通过、还未通过名称认证，但通过了腾讯微博认证    
	*/
	public Integer getVerifyTypeInfo(){
		return verifyTypeInfo;
	}
	
	/**
	* verify_type_info  Integer(10)  //授权方认证类型:-1代表未认证，0代表微信认证，1代表新浪微博认证，2代表腾讯微博认证，3代表已资质认证通过但还未通过名称认证，4代表已资质认证通过、还未通过名称认证，但通过了新浪微博认证，5代表已资质认证通过、还未通过名称认证，但通过了腾讯微博认证    
	*/
	public void setVerifyTypeInfo(Integer verifyTypeInfo){
		this.verifyTypeInfo = verifyTypeInfo;
	}
	
	/**
	* user_name  String(255)  //授权方公众号的原始ID    
	*/
	public String getUserName(){
		return userName;
	}
	
	/**
	* user_name  String(255)  //授权方公众号的原始ID    
	*/
	public void setUserName(String userName){
		this.userName = userName;
	}
	
	/**
	* principal_name  String(255)  //公众号的主体名称    
	*/
	public String getPrincipalName(){
		return principalName;
	}
	
	/**
	* principal_name  String(255)  //公众号的主体名称    
	*/
	public void setPrincipalName(String principalName){
		this.principalName = principalName;
	}
	
	/**
	* alias  String(255)  //授权方公众号所设置的微信号，可能为空    
	*/
	public String getAlias(){
		return alias;
	}
	
	/**
	* alias  String(255)  //授权方公众号所设置的微信号，可能为空    
	*/
	public void setAlias(String alias){
		this.alias = alias;
	}
	
	/**
	* business_info  String(255)  //用以了解以下功能的开通状况（0代表未开通，1代表已开通）：    
	*/
	public Integer getBusinessInfo(){
		return businessInfo;
	}
	
	/**
	* business_info  String(255)  //用以了解以下功能的开通状况（0代表未开通，1代表已开通）：    
	*/
	public void setBusinessInfo(Integer businessInfo){
		this.businessInfo = businessInfo;
	}
	
	/**
	* qrcode_url  String(255)  //二维码图片的UR    
	*/
	public String getQrcodeUrl(){
		return qrcodeUrl;
	}
	
	/**
	* qrcode_url  String(255)  //二维码图片的UR    
	*/
	public void setQrcodeUrl(String qrcodeUrl){
		this.qrcodeUrl = qrcodeUrl;
	}
	
	/**
	* authorizer_appid  String(255)  NOTNULL  //授权方appid    
	*/
	public String getAuthorizerAppid(){
		return authorizerAppid;
	}
	
	/**
	* authorizer_appid  String(255)  NOTNULL  //授权方appid    
	*/
	public void setAuthorizerAppid(String authorizerAppid){
		this.authorizerAppid = authorizerAppid;
	}
	
	/**
	* func_info  String(255)  //公众号授权给开发者的权限集列表，ID为1到15时分别代表：  消息管理权限  用户管理权限  帐号服务权限  网页服务权限  微信小店权限  微信多客服权限  群发与通知权限  微信卡券权限  微信扫一扫权限  微信连WIFI权限  素材管理权限  微信摇周边权限  微信门店权限  微信支付权限  自定义菜单权限    
	*/
	public String getFuncInfo(){
		return funcInfo;
	}
	
	/**
	* func_info  String(255)  //公众号授权给开发者的权限集列表，ID为1到15时分别代表：  消息管理权限  用户管理权限  帐号服务权限  网页服务权限  微信小店权限  微信多客服权限  群发与通知权限  微信卡券权限  微信扫一扫权限  微信连WIFI权限  素材管理权限  微信摇周边权限  微信门店权限  微信支付权限  自定义菜单权限    
	*/
	public void setFuncInfo(String funcInfo){
		this.funcInfo = funcInfo;
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