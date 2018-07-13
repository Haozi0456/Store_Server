package com.zwh.store.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zwh.store.entity.Manager;
import com.zwh.store.mapper.ManagerMapper;
import com.zwh.store.service.ManagerService;

@Service(value = "managerService")
public class ManagerServiceImpl implements ManagerService {

	@Autowired
	private ManagerMapper managerMapper;

	@Override
	public Manager getManagerByAccountAndPassword(String account, String password) {
		// TODO Auto-generated method stub
		return managerMapper.getManagerByAccountAndPassword(account, password);
	}
	
	
	
}
