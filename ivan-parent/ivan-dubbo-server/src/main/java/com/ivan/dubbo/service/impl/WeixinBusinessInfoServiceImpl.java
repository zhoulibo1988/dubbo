package com.ivan.dubbo.service.impl;

import java.util.Map;

import org.ivan.api.WeixinBusinessInfoService;
import org.ivan.entity.WeixinBusinessInfo;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.ivan.dubbo.dao.WeixinBusinessInfoMapper;

/**
 * @author cyl
 * @version 
 */
@Service
public class WeixinBusinessInfoServiceImpl implements WeixinBusinessInfoService {
	// 注入当前dao对象
    @Autowired
    private WeixinBusinessInfoMapper weixinBusinessInfoMapper;

	@Override
	public WeixinBusinessInfo selectSingle(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return weixinBusinessInfoMapper.selectSingle(map);
	}

	@Override
	public WeixinBusinessInfo selectSingle(WeixinBusinessInfo WeixinBusinessInfo) {
		// TODO Auto-generated method stub
		return weixinBusinessInfoMapper.selectSingle(WeixinBusinessInfo);
	}

	@Override
	public void updateByEntity(WeixinBusinessInfo WeixinBusinessInfo) {
		// TODO Auto-generated method stub
		weixinBusinessInfoMapper.updateByEntity(WeixinBusinessInfo);
	}

	@Override
	public void insert(WeixinBusinessInfo WeixinBusinessInfo) {
		// TODO Auto-generated method stub
		weixinBusinessInfoMapper.insertByEntity(WeixinBusinessInfo);
	}

   
 
}
