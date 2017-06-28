package com.ivan.web.demo;

import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.ivan.entity.weixin.ase.WXBizMsgCrypt;
import org.ivan.entity.weixin.dto.WeChatContants;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;


public class Program {

	public static void main(String[] args) throws Exception {

		//
		// 第三方回复公众平台
		//

		// 需要加密的明文
		String encodingAesKey = WeChatContants.encodingAesKey;
		String token =WeChatContants.token;
		String timeStamp = "1498094189";
		String nonce = "1420288590";
		String appId =WeChatContants.appId;
		String msgSignature="01afd71af2c6b4cf723ca4c100dc3cc9088610ef";
		String postData="<xml>    <AppId><![CDATA[wxab704684bc31ff32]]></AppId>    <Encrypt><![CDATA[0JsJnC81jjHcn2UAskDkZKL8yN80N615xWFaeTAUKi0/NyJPpA25nWn+x/MEBSvmQspwUozfYUPw1I3AHJDdBPH6z5c+UsTypczmhn6Uzwa0Emjmhv4rlhVYwDcp88OjSrklGmuN8RNTjvse4CtF9u+Rf+yHE4m/zjmPMY79RwJK7Hiydb2sOgat9fYh1O6iYPL++HpZ5NAWmMwrTH+20tF8Zz6vnmL92dEBC/4B2jNpp+FhXcTxflChicD1VvaDRgI4HJkYDXRHRqJvsjgzhscJ/F3tIh6z0/4rHAaRoqg5GY3Tms+A0VpBuHkLmtyC/Ta3Sq3o19QHkU/IArSFhrIf02iUd97es6pcggEIvUjxD4VezLm6WcZS3SDYtv69XJo0agEtXGc0Q9Cs7bY10QG8p159lhwyEmrqhc+ok3AkbS0nKhGIucW7Ec2GDJnKGd4Ze3FrQO4w7c8zhVji8w==]]></Encrypt></xml>";
		WXBizMsgCrypt pc = new WXBizMsgCrypt(token, encodingAesKey, appId);
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		StringReader sr = new StringReader(postData);
		InputSource is = new InputSource(sr);
		Document document = db.parse(is);
		Element root = document.getDocumentElement();
		NodeList nodelist1 = root.getElementsByTagName("Encrypt");
//		NodeList nodelist2 = root.getElementsByTagName("MsgSignature");
		String encrypt = nodelist1.item(0).getTextContent();
		String format = "<xml><ToUserName><![CDATA[toUser]]></ToUserName><Encrypt><![CDATA[%1$s]]></Encrypt></xml>";
		String fromXML = String.format(format, encrypt);
		String mingwen = pc.decryptMsg(msgSignature, timeStamp, nonce, fromXML);
		System.out.println("解密后: " + mingwen);

//		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//		DocumentBuilder db = dbf.newDocumentBuilder();
//		StringReader sr = new StringReader(mingwen);
//		InputSource is = new InputSource(sr);
//		Document document = db.parse(is);
//
//		Element root = document.getDocumentElement();
//		NodeList nodelist1 = root.getElementsByTagName("Encrypt");
//		NodeList nodelist2 = root.getElementsByTagName("MsgSignature");
//
//		String encrypt = nodelist1.item(0).getTextContent();
//		String msgSignature = nodelist2.item(0).getTextContent();
//
//		String format = "<xml><ToUserName><![CDATA[toUser]]></ToUserName><Encrypt><![CDATA[%1$s]]></Encrypt></xml>";
//		String fromXML = String.format(format, encrypt);
//
//		//
//		// 公众平台发送消息给第三方，第三方处理
//		//
//
//		// 第三方收到公众号平台发送的消息
//		String result2 = pc.decryptMsg(msgSignature, timestamp, nonce, fromXML);
//		System.out.println("解密后明文: " + result2);
		
		//pc.verifyUrl(null, null, null, null);
	}
}
