package org.ivan.entity.weixin.utils;

public enum TradeType {
	/**
	 * 交易类型枚举
	 * @author Javen
	 * 2017年4月15日
	 * JSAPI--公众号支付、NATIVE--原生扫码支付、APP--app支付，统一下单接口trade_type的传参可参考这里
	 * MICROPAY--刷卡支付，刷卡支付有单独的支付接口，不调用统一下单接口
	 */
	JSAPI, NATIVE, APP, WAP , MICROPAY
}
