package com.ivan.dubbo.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.ivan.api.WeiXinMessageService;
import org.ivan.entity.weixin.message.MessageUtil;
import org.ivan.entity.weixin.message.resp.TextMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.dubbo.config.annotation.Service;
/**
 * 微信消息处理核心实现类
 * @author Administrator
 *
 */
@Service
public class WeiXinMessageServiceImpl implements WeiXinMessageService{
	private static final Logger logger = LoggerFactory.getLogger(WeiXinMessageServiceImpl.class);
	@Override
	public Map<String, Object> handleMessageCode(Map<String, String> requestMap)throws Exception {
		logger.info("====消息处理核心类被调起=========");
		Map<String, Object> returnMap=new HashMap<String, Object>();
		String respMessage = null;
		String respContent = "请求处理异常，请稍候尝试！";
        // 发送方帐号（open_id）
        String fromUserName = requestMap.get("FromUserName");;
        // 公众帐号
        String toUserName =  requestMap.get("ToUserName");
        // 消息类型
        String msgType = requestMap.get("MsgType");
        // 回复文本消息
        TextMessage textMessage = new TextMessage();
        textMessage.setToUserName(fromUserName);
        textMessage.setFromUserName(toUserName);
        textMessage.setCreateTime(new Date().getTime());
       
        textMessage.setFuncFlag(0);;
        
        // 文本消息  
        if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
        	//转发给客服
        	textMessage.setMsgType(MessageUtil.TRANSFER_CUSTOMER_SERVICE);
            respContent = "您发送的是文本消息！";  
        }  
        // 图片消息  
        else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
        	textMessage.setMsgType(MessageUtil.REQ_MESSAGE_TYPE_IMAGE);
            respContent = "您发送的是图片消息！";  
        }  
        // 地理位置消息  
        else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
        	textMessage.setMsgType(MessageUtil.REQ_MESSAGE_TYPE_LOCATION);
            respContent = "您发送的是地理位置消息！";  
        }  
        // 链接消息  
        else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
        	textMessage.setMsgType(MessageUtil.REQ_MESSAGE_TYPE_LINK);
            respContent = "您发送的是链接消息！";  
        }  
        // 音频消息  
        else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
        	textMessage.setMsgType(MessageUtil.REQ_MESSAGE_TYPE_VOICE);
            respContent = "您发送的是音频消息！";  
        }  
        // 事件推送  
        else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {  
            // 事件类型  
            String eventType = requestMap.get("Event");  
            // 订阅  
            if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {  
            	textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
            	respContent = "Hello，你好！为了能每天给各位读者更全面、更及时的互联网金融资讯，\n此服务号的功能和内容转至新的订阅号“金服前沿”,欢迎大家关注我们新的公众平台，\n本服务号暂时停更喔，望各位新老同仁能一如既往的支持我们，感谢！";  
            }  
            // 取消订阅  
            else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {  
                // TODO 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息  
            }  
            // 自定义菜单点击事件  
            else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {  
                // 事件KEY值，与创建自定义菜单时指定的KEY值对应  
                String eventKey = requestMap.get("EventKey");  

                if (eventKey.equals("11")) {  
                    respContent = "天气预报菜单项被点击！";  
                } else if (eventKey.equals("12")) {  
                    respContent = "公交查询菜单项被点击！";  
                } else if (eventKey.equals("13")) {  
                    respContent = "周边搜索菜单项被点击！";  
                } else if (eventKey.equals("14")) {  
                    respContent = "历史上的今天菜单项被点击！";  
                } else if (eventKey.equals("21")) {  
                    respContent = "歌曲点播菜单项被点击！";  
                } else if (eventKey.equals("22")) {  
                    respContent = "经典游戏菜单项被点击！";  
                } else if (eventKey.equals("23")) {  
                    respContent = "美女电台菜单项被点击！";  
                } else if (eventKey.equals("24")) {  
                    respContent = "人脸识别菜单项被点击！";  
                } else if (eventKey.equals("25")) {  
                    respContent = "聊天唠嗑菜单项被点击！";  
                } else if (eventKey.equals("31")) {  
                    respContent = "Q友圈菜单项被点击！";  
                } else if (eventKey.equals("32")) {  
                    respContent = "电影排行榜菜单项被点击！";  
                } else if (eventKey.equals("33")) {  
                    respContent = "幽默笑话菜单项被点击！";  
                }  
            }  
        }  
        textMessage.setContent(respContent);  
        respMessage = MessageUtil.textMessageToXml(textMessage);
        returnMap.put("respMessage", respMessage);
		return returnMap;
	}


}
