package com.zwh.store.service;

import org.apache.ibatis.annotations.Param;

import com.zwh.store.entity.Manager;

public interface ManagerService {

	Manager getManagerByAccountAndPassword(@Param("account")String account,@Param("password")String password);
	
}
