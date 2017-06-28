package org.ivan.api;

import java.util.Map;
/**
 * 处理微信信息核心类
 * 根据业务需要自行处理编码
 * @author Administrator
 *
 */
public interface WeiXinMessageService {
	public Map<String,Object> handleMessageCode(Map<String,String> map) throws Exception;
}
