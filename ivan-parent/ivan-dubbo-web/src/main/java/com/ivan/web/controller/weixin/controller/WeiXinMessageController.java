package com.ivan.web.controller.weixin.controller;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.ivan.api.WeiXinMessageService;
import org.ivan.api.WeixinAuthorizationTokenService;
import org.ivan.entity.WeixinAuthorizationToken;
import org.ivan.entity.weixin.dto.WeChatContants;
import org.ivan.entity.weixin.utils.MD5Util;
import org.ivan.entity.weixin.utils.XMLUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import weixin.popular.api.CustomserviceAPI;
import weixin.popular.bean.BaseResult;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qq.weixin.mp.aes.WXBizMsgCrypt;
/**
 * 微信消息处理
 * @author 周立波
 *
 */
@Controller
@RequestMapping("/{APPID}")
public class WeiXinMessageController {
	private static final Logger logger = LoggerFactory.getLogger(WeiXinMessageController.class);
	@Reference
	private WeiXinMessageService weiXinMessageService;
	@Reference
	private WeixinAuthorizationTokenService weixinAuthorizationTokenService;
	@RequestMapping("/callback")
	public void weiXinMessage(HttpServletResponse response,HttpServletRequest request,@RequestParam Map<String,Object> map){
		logger.info("-----------》微信消息来推送XML了《-----------");
		// 将请求、响应的编码均设置为UTF-8（防止中文乱码）
        try {
        	logger.info("map:----------->"+map);
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			
			String timeStamp=String.valueOf(map.get("timestamp"));
	        String encrypt_type=String.valueOf(map.get("encrypt_type"));
	        String nonce=String.valueOf(map.get("nonce"));
	        String msg_signature=String.valueOf(map.get("msg_signature"));
	        logger.info("timestamp:-----------》"+timeStamp);
	        logger.info("encrypt_type:-----------》"+encrypt_type);
	        logger.info("nonce:-----------》-----------》"+nonce);
	        logger.info("msg_signature:-----------》"+msg_signature);
	        //验证通过后
	        StringBuilder sb = new StringBuilder();
	        BufferedReader in = request.getReader();
	        String line;
	        while ((line = in.readLine()) != null) {
	            sb.append(line);
	        }
	        String xml = sb.toString();
	        logger.info("微信推送的原生：-----------》"+xml);
	        String encodingAesKey =WeChatContants.encodingAesKey;// 第三方平台组件加密密钥
	        String appId=WeChatContants.appId;//从xml中解析
	        WXBizMsgCrypt pc = new WXBizMsgCrypt(WeChatContants.token, encodingAesKey,appId);
	        
	        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			StringReader sr = new StringReader(xml);
			InputSource is = new InputSource(sr);
			Document document = db.parse(is);

			Element root = document.getDocumentElement();
			NodeList nodelist1 = root.getElementsByTagName("Encrypt");

			String encrypt = nodelist1.item(0).getTextContent();
	        String fromXML = String.format(xml, encrypt);
	        xml = pc.decryptMsg(msg_signature, timeStamp, nonce, fromXML);
	        logger.info("解密后的：---------------》"+xml);
			
			
			
	        Map<String, String> parseXml=XMLUtil.doXMLParse(xml);
			logger.info("解析微信消息推送的原生XML结果为：-----------》"+parseXml);
			//消息处理
			Map<String, Object> responseMap=weiXinMessageService.handleMessageCode(parseXml);
			//响应信息
			String responseXML=String.valueOf(responseMap.get("respMessage"));
			logger.info("响应用户的信息为：--------------》"+responseXML);
			//加密
			String encryptMsg=	pc.encryptMsg(responseXML, timeStamp, nonce);
			 PrintWriter pw = response.getWriter();
		     pw.write(encryptMsg);
		     pw.flush();
//		     pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
