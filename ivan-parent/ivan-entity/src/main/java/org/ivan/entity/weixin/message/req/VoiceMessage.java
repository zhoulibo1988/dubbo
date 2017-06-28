package org.ivan.entity.weixin.message.req;
/**
 * 请求消息之语音信息
 * @author 周立波
 *
 */
public class VoiceMessage extends BaseMessage{
	 // 媒体ID  
    private String MediaId;  
    // 语音格式  
    private String Format;  
  
    public String getMediaId() {  
        return MediaId;  
    }  
  
    public void setMediaId(String mediaId) {  
        MediaId = mediaId;  
    }  
  
    public String getFormat() {  
        return Format;  
    }  
  
    public void setFormat(String format) {  
        Format = format;  
    }  
}
