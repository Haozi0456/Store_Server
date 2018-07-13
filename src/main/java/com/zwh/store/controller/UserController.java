package com.zwh.store.controller;

import java.io.File;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.zwh.store.entity.User;
import com.zwh.store.service.UserService;
import com.zwh.store.utils.FileUtils;
import com.zwh.system.common.MessageCode;
import com.zwh.system.common.Result;

@RestController
@RequestMapping("/app/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Value("${file.uploadFolder}") // 文件上传虚拟路径
	private String uploadFolder;

	// @GetMapping("/register/{username}")
	// public Result toRegister(@PathVariable("username")String username) {
	//
	// return new Result(MessageCode.SUCCESS, "注册成功!");
	// }

	// @RequestMapping("/toRegister")
	@PostMapping(value = "/toRegister")
	public Result toRegister(User user) {
		User mUser = null;

		// 判断是否微信号登录注册
		if (!user.getOpenid().isEmpty()) {
			mUser = userService.getUserByOpenid(user.getOpenid());
			return new Result(MessageCode.SUCCESS, "该用户已注册!", mUser);
		}

		// 判断是否手机号注册
		if (!user.getPhone().isEmpty()) {
			mUser = userService.getUserByAccount(user.getPhone());
			return new Result(MessageCode.SUCCESS, "该用户已注册!", mUser);
		}

		if (mUser == null) {
			mUser = userService.toRegister(user);
		}

		return new Result(MessageCode.SUCCESS, "注册成功!", mUser);
	}

	@PostMapping("/toLogin")
	public Result toLogin(String account, String password) {
		User user = userService.getUserByAccountAndPassword(account, password);
		if (user == null) {
			return new Result(MessageCode.SUCCESS, "用户名或密码错误", user);
		}
		user.setLastvisittime(new Date());
		userService.updateUserById(user);
		return new Result(MessageCode.SUCCESS, "登录成功!", user);
	}

	/**
	 * 绑定微信账号
	 * 
	 * @param user
	 * @param account
	 * @return
	 */
	@PostMapping("/bindWeiXin")
	public Result bindWeiXin(User user, String account) {
		User mUser = null;
		mUser = userService.getUserByAccount(account);
		if (mUser == null) {
			return new Result(MessageCode.SUCCESS, "该用户未注册", mUser);
		} else {
			// mUser.setPhone(account);
			mUser.setOpenid(user.getOpenid());
			int row = userService.updateUserById(mUser);
			if (row > 0) {
				mUser = userService.getUserById(mUser.getId());
				return new Result(MessageCode.SUCCESS, "绑定成功!", mUser);
			}
		}
		return new Result(MessageCode.SUCCESS, "绑定失败!", mUser);
	}

	/**
	 * 微信登陆
	 * 
	 * @param user
	 * @return
	 */
	@PostMapping("/loginWithWeixin")
	public Result loginWithWeixin(User user) {
		User mUser = null;
		// 判断是否微信号登录注册
		if (!user.getOpenid().isEmpty()) {
			mUser = userService.getUserByOpenid(user.getOpenid());
			return new Result(MessageCode.SUCCESS, "登录成功!", mUser);
		}

		return new Result(MessageCode.SUCCESS, "登录失败!", mUser);
	}

	/**
	 * 更新头像
	 * @param files
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/uploadHeadImg", method = RequestMethod.POST)
	public Result uploadImg(@RequestParam("imgs") MultipartFile[] files, HttpServletRequest request) {
		MultipartHttpServletRequest params = ((MultipartHttpServletRequest) request);

		// 获取表单参数
		String id = params.getParameter("id");
		if (id == null || id.isEmpty()) {
			return new Result(MessageCode.PARAM_ERROR, "缺少必要参数", null);
		}
		System.out.println("id:" + id);
		User user = userService.getUserById(Integer.parseInt(id));
		if (user == null) {
			return new Result(MessageCode.ERROR, "用户不存在", null);
		}

		String avatarUrl = "";
		for (MultipartFile file : files) {
			// 文件名
			String originalfFileName = file.getOriginalFilename();
			if ("".equals(originalfFileName)) {
				continue;
			}
			// 文件后缀
			String suffx = originalfFileName.substring(originalfFileName.lastIndexOf('.'));
			String filePath = uploadFolder + "headerImgs/";
			File dir = new File(filePath);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			String fileName = new Date().getTime() + suffx;
			avatarUrl = "/files/headerImgs/" + new Date().getTime() + suffx;
			try {
				FileUtils.uploadFile(file.getBytes(), filePath, fileName);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		user.setAvatarurl(avatarUrl);
		int row = userService.updateUserById(user);
		if (row > 0) {
			return new Result(MessageCode.SUCCESS, "头像更新成功!", user);
		}else {
			return new Result(MessageCode.ERROR, "头像更新失败");
		}
	}

}
