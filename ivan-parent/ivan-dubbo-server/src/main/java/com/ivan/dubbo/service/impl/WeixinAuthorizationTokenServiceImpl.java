package com.ivan.dubbo.service.impl;

import java.util.Map;

import org.ivan.api.WeixinAuthorizationTokenService;
import org.ivan.entity.WeixinAuthCode;
import org.ivan.entity.WeixinAuthorizationToken;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.ivan.dubbo.dao.WeixinAuthorizationTokenMapper;
/**
 * @author cyl
 * @version 
 */
@Service
public class WeixinAuthorizationTokenServiceImpl implements WeixinAuthorizationTokenService {
	@Autowired
	private WeixinAuthorizationTokenMapper weixinAuthorizationTokenMapper;
	
	@Override
	public void insert(WeixinAuthorizationToken weixinAuthorizationToken) {
		// TODO Auto-generated method stub
		weixinAuthorizationTokenMapper.insertByEntity(weixinAuthorizationToken);
		
	}

	@Override
	public WeixinAuthorizationToken selectSingle(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return weixinAuthorizationTokenMapper.selectSingle(map);
	}

	@Override
	public WeixinAuthorizationToken selectSingle(
			WeixinAuthorizationToken weixinAuthorizationToken) {
		// TODO Auto-generated method stub
		return weixinAuthorizationTokenMapper.selectSingle(weixinAuthorizationToken);
	}

	@Override
	public void updateByEntity(WeixinAuthorizationToken weixinAuthorizationToken) {
		// TODO Auto-generated method stub
		weixinAuthorizationTokenMapper.updateByEntity(weixinAuthorizationToken);
	}
 
}
