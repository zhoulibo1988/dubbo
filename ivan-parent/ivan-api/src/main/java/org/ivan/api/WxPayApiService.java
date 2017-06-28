package org.ivan.api;

import java.util.Map;

public interface WxPayApiService {
	/**
	 * 统一下单
	 * 服务商模式接入文档:https://pay.weixin.qq.com/wiki/doc/api/native_sl.php?chapter=9_1
	 * 商户模式接入文档:https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=9_1
	 * @param params
	 * @return
	 */
	public String pushOrder(Map<String, String> params);
	/**
	 * 订单查询
	 * 服务商模式接入文档:https://pay.weixin.qq.com/wiki/doc/api/micropay_sl.php?chapter=9_2
	 * 商户模式接入文档:https://pay.weixin.qq.com/wiki/doc/api/micropay.php?chapter=9_2
	 * @param params 请求参数
	 * @return
	 */
	public String orderQuery(Map<String, String> params);
	/**
	 * 关闭订单
	 * 服务商模式接入文档:https://pay.weixin.qq.com/wiki/doc/api/jsapi_sl.php?chapter=9_3
	 * 商户模式接入文档:https://pay.weixin.qq.com/wiki/doc/api/jsapi.php?chapter=9_3
	 * @param params
	 * @return
	 */
	public String closeOrder(Map<String, String> params);
	
	/**
	 * 撤销订单
	 * 服务商模式接入文档:https://pay.weixin.qq.com/wiki/doc/api/micropay_sl.php?chapter=9_11&index=3
	 * 商户模式接入文档:https://pay.weixin.qq.com/wiki/doc/api/micropay.php?chapter=9_11&index=3
	 * @param params 请求参数
	 * @param certPath 证书文件目录
	 * @param certPass 证书密码
	 * @return
	 */
	public String orderReverse(Map<String, String> params, String certPath, String certPass);
	/**
	 * 申请退款
	 * 服务商模式接入文档:https://pay.weixin.qq.com/wiki/doc/api/micropay_sl.php?chapter=9_4
	 * 商户模式接入文档:https://pay.weixin.qq.com/wiki/doc/api/micropay.php?chapter=9_4
	 * @param params 请求参数
	 * @param certPath 证书文件目录
	 * @param certPass 证书密码
	 * @return
	 */
	public String orderRefund(Map<String, String> params, String certPath, String certPass);
	/**
	 * 查询退款
	 * 服务商模式接入文档:https://pay.weixin.qq.com/wiki/doc/api/micropay_sl.php?chapter=9_5
	 * 商户模式接入文档:https://pay.weixin.qq.com/wiki/doc/api/micropay.php?chapter=9_5
	 * @param params 请求参数
	 * @return
	 */
	public String orderRefundQuery(Map<String, String> params);
	/**
	 * 下载对账单
	 * 服务商模式接入文档:https://pay.weixin.qq.com/wiki/doc/api/micropay_sl.php?chapter=9_6
	 * 商户模式接入文档:https://pay.weixin.qq.com/wiki/doc/api/micropay.php?chapter=9_6
	 * @param params 请求参数
	 * @return
	 */
	public String downloadBill(Map<String, String> params);
	
	/**
	 * 交易保障
	 * 服务商模式接入文档:https://pay.weixin.qq.com/wiki/doc/api/micropay_sl.php?chapter=9_14&index=7
	 * 商户模式接入文档:https://pay.weixin.qq.com/wiki/doc/api/micropay.php?chapter=9_14&index=7
	 * @param params 请求参数
	 * @return
	 */
	public String orderReport(Map<String, String> params);
	/**
	 * 转换短链接
	 * 服务商模式接入文档:https://pay.weixin.qq.com/wiki/doc/api/micropay_sl.php?chapter=9_9&index=8
	 * 商户模式接入文档:https://pay.weixin.qq.com/wiki/doc/api/micropay.php?chapter=9_9&index=8
	 * @param params 请求参数
	 * @return
	 */
	public String toShortUrl(Map<String, String> params);
	/**
	 * 授权码查询openId
	 * 服务商模式接入文档:https://pay.weixin.qq.com/wiki/doc/api/micropay_sl.php?chapter=9_12&index=9
	 * 商户模式接入文档: https://pay.weixin.qq.com/wiki/doc/api/micropay.php?chapter=9_13&index=9
	 * @param params 请求参数
	 * @return
	 */
	public String authCodeToOpenid(Map<String, String> params);
	
	/**
	 * 刷卡支付
	 * 服务商模式接入文档:https://pay.weixin.qq.com/wiki/doc/api/micropay_sl.php?chapter=9_10&index=1
	 * 商户模式接入文档: https://pay.weixin.qq.com/wiki/doc/api/micropay.php?chapter=9_10&index=1
	 *
	 * @param params 请求参数
	 * @return
	 */
	public String micropay(Map<String, String> params);
	/**
	 * 企业付款
	 * @param params 请求参数
	 * @param certPath 证书文件目录
	 * @param certPassword 证书密码
	 * @return {String}
	 */
	public String transfers(Map<String, String> params, String certPath, String certPassword);
	/**
	 * 查询企业付款
	 * @param params 请求参数
	 * @param certPath 证书文件目录
	 * @param certPassword 证书密码
	 * @return {String}
	 */
	public String getTransferInfo(Map<String, String> params, String certPath, String certPassword);
	
	
	/**
	 * 商户模式下 扫码模式一之生成二维码
	 * @param appid
	 * @param mch_id
	 * @param product_id
	 * @param partnerKey
	 * @param isToShortUrl 是否转化为短连接
	 * @return
	 */
	public String getCodeUrl(String appid, String mch_id, String product_id, String partnerKey, boolean isToShortUrl);
	
	public String doPost(String url, Map<String, String> params);
	
	public String doPostSSL(String url, Map<String, String> params, String certPath, String certPass );
}
