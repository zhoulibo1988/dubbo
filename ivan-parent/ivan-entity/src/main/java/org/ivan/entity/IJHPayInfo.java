package org.ivan.entity;

import java.io.Serializable;

public class IJHPayInfo implements Serializable{
	private String P_UserId;//商户ID:必须（由 i 聚合平台提供）
	private String P_OrderId;//商户订单号  必须，在商户系统中保持唯一
	private String P_CardId;//卡类充值时的卡号:卡类充值时必须，否则可为空
	private String P_CardPass;//卡类充值时的卡密:卡类充值时必须，否则可为空
	private String P_FaceValue;//面值;必须（实际价格）
	private String P_FaceType;//币种 固定值 CNY
	private String P_ChannelId;//支付类型  整型数字
	private String P_Subject;// 产品名称 否 字符串，最常 20 位 可为空
	private String P_Price; //产品价格 否 float，保留 2 位小数 必须，可传 0（价格标签）
	private String P_Quantity;// 产品数量 否 字符串，最长 100 位 必须
	private String P_Description;// 产品描述 否 字符串，最长 100 位 可为空
	private String P_Notic; //用户附加信息 否 字符串，最长 50 位 可为空
	private String P_Result_URL;// 支付状态通知地址 否 字符串，最长 100 位 必须异步通知地址
	private String P_Notify_URL;// 支付后网页跳转地址 否 字符串，最长 100 位 可为空（跳回）同步
	private String P_PostKey;// 签名认证串 否 字符串 必须
	private String P_APPID; //(或最终支付网址) 当前支付的 appid 或者网址 否 字符串，最长 100 位 必须
	private String P_OpenID; //openid 否 字符串，最长 128 位 公众号、APP 对接时需要，为必 填项 6 2.3 提交网关验签说明： ▶ 签名认证 postKey 的生成：必须按照“参与签名”状态为“是”的参数按其顺序用“|”
	public String getP_UserId() {
		return P_UserId;
	}
	public void setP_UserId(String p_UserId) {
		P_UserId = p_UserId;
	}
	public String getP_OrderId() {
		return P_OrderId;
	}
	public void setP_OrderId(String p_OrderId) {
		P_OrderId = p_OrderId;
	}
	public String getP_CardId() {
		return P_CardId;
	}
	public void setP_CardId(String p_CardId) {
		P_CardId = p_CardId;
	}
	public String getP_CardPass() {
		return P_CardPass;
	}
	public void setP_CardPass(String p_CardPass) {
		P_CardPass = p_CardPass;
	}
	public String getP_FaceValue() {
		return P_FaceValue;
	}
	public void setP_FaceValue(String p_FaceValue) {
		P_FaceValue = p_FaceValue;
	}
	public String getP_FaceType() {
		return P_FaceType;
	}
	public void setP_FaceType(String p_FaceType) {
		P_FaceType = p_FaceType;
	}
	public String getP_ChannelId() {
		return P_ChannelId;
	}
	public void setP_ChannelId(String p_ChannelId) {
		P_ChannelId = p_ChannelId;
	}
	public String getP_Subject() {
		return P_Subject;
	}
	public void setP_Subject(String p_Subject) {
		P_Subject = p_Subject;
	}
	public String getP_Price() {
		return P_Price;
	}
	public void setP_Price(String p_Price) {
		P_Price = p_Price;
	}
	public String getP_Quantity() {
		return P_Quantity;
	}
	public void setP_Quantity(String p_Quantity) {
		P_Quantity = p_Quantity;
	}
	public String getP_Description() {
		return P_Description;
	}
	public void setP_Description(String p_Description) {
		P_Description = p_Description;
	}
	public String getP_Notic() {
		return P_Notic;
	}
	public void setP_Notic(String p_Notic) {
		P_Notic = p_Notic;
	}
	public String getP_Result_URL() {
		return P_Result_URL;
	}
	public void setP_Result_URL(String p_Result_URL) {
		P_Result_URL = p_Result_URL;
	}
	public String getP_Notify_URL() {
		return P_Notify_URL;
	}
	public void setP_Notify_URL(String p_Notify_URL) {
		P_Notify_URL = p_Notify_URL;
	}
	public String getP_PostKey() {
		return P_PostKey;
	}
	public void setP_PostKey(String p_PostKey) {
		P_PostKey = p_PostKey;
	}
	public String getP_APPID() {
		return P_APPID;
	}
	public void setP_APPID(String p_APPID) {
		P_APPID = p_APPID;
	}
	public String getP_OpenID() {
		return P_OpenID;
	}
	public void setP_OpenID(String p_OpenID) {
		P_OpenID = p_OpenID;
	}
	
}
