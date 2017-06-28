package com.ivan.dubbo.service.impl;

import java.util.List;

import org.ivan.api.UserService;
import org.ivan.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.ivan.dubbo.dao.SysucenterusermainMapper;
import com.ivan.dubbo.dao.UserMapper;

@Service
public class UserServiceImpl implements UserService {
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private SysucenterusermainMapper sysucenterusermainMapper;
	public int insert(User record) {
		return userMapper.insert(record);
	}
	/**
	 * 插入
	 */
	public int insertSelective(User record) {
		logger.info("插入开始");
		userMapper.insertSelective(record);
		sysucenterusermainMapper.insertByEntity(null);
		return 1;
	}

	// 需要自己定义Mapper文件中的方法
	public List<User> getUsers() {
		logger.info("开始查询所有用户信息");

		logger.info("查询结束");
		return userMapper.selectAll();
	}

	public int deleteByPrimaryKey(Integer id) {
		return userMapper.deleteByPrimaryKey(id);
	}

	public User selectByPrimaryKey(Integer id) {
		return userMapper.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(User record) {
		return userMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(User record) {
		return userMapper.updateByPrimaryKey(record);
	}
}
