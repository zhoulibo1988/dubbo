package org.ivan.api;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface WeChatThridService {
	/**
	 * 处理微信授权事件
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public void handleAuthorize(HttpServletRequest request, HttpServletResponse response,Map<String,Object> map) throws Exception;
}
