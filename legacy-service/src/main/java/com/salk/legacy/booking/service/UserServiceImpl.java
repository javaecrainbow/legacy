package com.salk.legacy.booking.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.salk.legacy.domain.User;
import com.salk.legacy.product.dao.UserMapper;

public class UserServiceImpl implements UserService {
@Autowired
private UserMapper userMapper;
	@Override
	public void addUser(User user) {
		userMapper.insert(user);

	}

	@Override
	public void modifyUser(User user) {
		userMapper.updateByPrimaryKey(user);

	}

	@Override
	public User findUser(String id) {
		Integer it_id=Integer.parseInt(id);
		return userMapper.selectByPrimaryKey(it_id);
	}

	@Override
	public void deleteUser(String[] ids) {
		//userMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void queryUsers() {
		//return userMapper.

	}

}
