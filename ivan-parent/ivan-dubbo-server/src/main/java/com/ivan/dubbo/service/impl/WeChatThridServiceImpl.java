package com.ivan.dubbo.service.impl;

import java.io.BufferedReader;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ivan.api.WeChatThridService;
import org.ivan.entity.WeixinAuthCode;
import org.ivan.entity.weixin.dto.WeChatContants;
import org.ivan.entity.weixin.utils.XMLUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import weixin.popular.api.ComponentAPI;
import weixin.popular.bean.component.ComponentAccessToken;
import weixin.popular.bean.component.PreAuthCode;

import com.alibaba.dubbo.config.annotation.Service;
import com.ivan.dubbo.dao.WeixinAuthCodeMapper;
import com.qq.weixin.mp.aes.WXBizMsgCrypt;
/**
 * 微信处理授权事件
 * @author Administrator
 *
 */
@Service
public class WeChatThridServiceImpl implements WeChatThridService {
	private static final Logger logger = LoggerFactory.getLogger(WeChatThridServiceImpl.class);
	@Autowired
	private WeixinAuthCodeMapper weixinAuthCodeMapper;
	public void handleAuthorize(HttpServletRequest request,HttpServletResponse response,Map<String,Object> map) throws Exception {
		logger.info("微信来推送XML了");
        String timestamp=String.valueOf(map.get("timestamp"));
        String encrypt_type=String.valueOf(map.get("encrypt_type"));
        String nonce=String.valueOf(map.get("nonce"));
        String msg_signature=String.valueOf(map.get("msg_signature"));
        logger.info("timestamp:"+timestamp);
        logger.info("encrypt_type:"+encrypt_type);
        logger.info("nonce:"+nonce);
        logger.info("msg_signature:"+msg_signature);
        //验证通过后
        StringBuilder sb = new StringBuilder();
        BufferedReader in = request.getReader();
        String line;
        while ((line = in.readLine()) != null) {
            sb.append(line);
        }
        String xml = sb.toString();
        logger.info("微信推送的原生："+xml);
        String encodingAesKey =WeChatContants.encodingAesKey;// 第三方平台组件加密密钥
        String appId=WeChatContants.appId;//从xml中解析
        WXBizMsgCrypt pc = new WXBizMsgCrypt(WeChatContants.token, encodingAesKey,appId);
        xml = pc.decryptMsg(msg_signature, timestamp, nonce, xml);
        logger.info("解密后的："+xml);
        //获取component_verify_ticket（第三方验证的票据） 
        //解析上述解密后的xml文件，获取节点component_verify_ticket内容，后续用来调用微信接口获取第三方通行token.
//        Map<String, String> parseXml = WeChatUtils.parseXml(xml);
        //修改为下
        Map<String, String> parseXml=XMLUtil.doXMLParse(xml);
        String component_verify_ticket=parseXml.get("ComponentVerifyTicket");
        logger.info("component_verify_ticket为："+component_verify_ticket);
        /************调用接口获取component_access_token 获取自己的接口调用凭据***************/
        ComponentAccessToken  componentAccessToken = ComponentAPI.api_component_token(WeChatContants.appId, WeChatContants.appSecret, component_verify_ticket);
        /*****************获取预授权码pre_auth_code*************************/
        PreAuthCode preAuthCode= ComponentAPI.api_create_preauthcode(componentAccessToken.getComponent_access_token(), WeChatContants.appId);
        //将预授权码存入数据库
        //并将component_access_token存在数据库中，用来授权时使用。
        if(preAuthCode.getPre_auth_code()!=null){
        	WeixinAuthCode weixinAuthCode=new WeixinAuthCode();
        	weixinAuthCode.setAppId(WeChatContants.appId);
        	weixinAuthCode=weixinAuthCodeMapper.selectSingle(weixinAuthCode);
        	if(weixinAuthCode!=null){
        		weixinAuthCode.setAuthCode(preAuthCode.getPre_auth_code());
        		weixinAuthCode.setComponentAccessToken(componentAccessToken.getComponent_access_token());
        		weixinAuthCode.setTime(new Date());
        		weixinAuthCodeMapper.updateByEntity(weixinAuthCode);
        	}else{
        		weixinAuthCode.setAuthCode(preAuthCode.getPre_auth_code());
        		weixinAuthCode.setComponentAccessToken(componentAccessToken.getComponent_access_token());
        		weixinAuthCode.setTime(new Date());
        		weixinAuthCodeMapper.insertByEntity(weixinAuthCode);
        	}
        }else{
        	logger.error("获取预授权码pre_auth_code失败");
        }
	}
}
