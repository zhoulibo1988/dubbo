package org.ivan.api;

import java.util.List;

import org.ivan.entity.User;


/**
 * @ClassName: UserService
 * @Description:接口
 * @author zhoulibo
 * @date 2016年8月19日 下午12:00:58
 */
public interface UserService {
	int deleteByPrimaryKey(Integer id);

	int insert(User record);

	int insertSelective(User record);

	User selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);

	// 自定义
	List<User> getUsers();
}
