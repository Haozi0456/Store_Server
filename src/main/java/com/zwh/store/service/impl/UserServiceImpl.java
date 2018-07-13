package com.zwh.store.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zwh.store.entity.User;
import com.zwh.store.mapper.UserMapper;
import com.zwh.store.service.UserService;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User toRegister(User user) {
		// TODO Auto-generated method stub\
		if(userMapper.insert(user)>0) {
			return userMapper.getUserById(user.getId());
		}
		return null;
	}

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return userMapper.getUserById(id);
	}

	@Override
	public User getUserByOpenid(String openid) {
		// TODO Auto-generated method stub
		return userMapper.getUserByOpenid(openid);
	}

	@Override
	public User getUserByAccount(String account) {
		// TODO Auto-generated method stub
		return userMapper.getUserByAccount(account);
	}

	@Override
	public User getUserByAccountAndPassword(String account, String password) {
		// TODO Auto-generated method stub
		return userMapper.getUserByAccountAndPassword(account, password);
	}

	@Override
	public int updateUserById(User user) {
		// TODO Auto-generated method stub
		return userMapper.updateUserById(user);
	}

}
