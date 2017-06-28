package org.ivan.entity.weixin.message.req;
/**
 * 请求消息之文本消息 
 * @author 周立波
 *
 */
public class TextMessage extends BaseMessage{
	// 消息内容  
    private String Content;  
  
    public String getContent() {  
        return Content;  
    }  
  
    public void setContent(String content) {  
        Content = content;  
    }  
}
