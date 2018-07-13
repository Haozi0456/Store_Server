package com.zwh.pet.store.service;

import org.apache.ibatis.annotations.Param;

import com.zwh.pet.store.entity.User;

public interface UserService {

	
	/**
	 * 用户注册
	 * @param user
	 * @return
	 */
	public User toRegister(User user);
	
	public User getUserById(int id);
	
	User getUserByOpenid(String openid);
    
    User getUserByAccount(String account);
    
    User getUserByAccountAndPassword(String account,String password);
    
    int updateUserById(User record);
}
