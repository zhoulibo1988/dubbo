package com.ivan.dubbo.service.impl;


import org.ivan.api.SysUcenterUserMainService;
import org.ivan.entity.SysUcenterUserMain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.ivan.dubbo.dao.SysucenterusermainMapper;
/**
 * @author buyuer
 * @version 
 */
@Service
public class SysUcenterUserMainServiceImpl implements SysUcenterUserMainService {
	private static final Logger logger = LoggerFactory.getLogger(SysUcenterUserMainServiceImpl.class);
	// 注入当前dao对象
    @Autowired
    private SysucenterusermainMapper sysUcenterUserMainMapper;
	public void insert(SysUcenterUserMain userman) {
		sysUcenterUserMainMapper.insertByEntity(userman);
	}
 
}
