package com.zwh.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zwh.store.entity.Manager;
import com.zwh.store.service.ManagerService;
import com.zwh.system.common.MessageCode;
import com.zwh.system.common.Result;

@RestController
@RequestMapping("/manager/user")
public class ManagerController {
	
	@Autowired
	private ManagerService managerService;
	
	@PostMapping("/login")
	public Result login(String account, String password) {
		Manager manager = managerService.getManagerByAccountAndPassword(account, password);
		if(manager != null) {
			return new Result(MessageCode.SUCCESS, "登录成功！", manager);
		}else {
			return new Result(MessageCode.ERROR, "用户名或密码错误！", manager);
		}
	}

}
