package com.frame.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.frame.admin.common.ConstantEntity;
import com.frame.admin.common.ResultEntity;
import com.frame.admin.model.OmEmpT;
import com.frame.admin.service.UserManagerService;
import com.frame.utils.MD5Utils;

/**
 * 系统登录控制类
 */
@RestController
@RequestMapping("/LoginController")
public class LoginController {

	@Autowired
	private UserManagerService userManagerService;

	@RequestMapping("/loginIn")
	public ResultEntity loginIn(OmEmpT emp) {
		ResultEntity result = new ResultEntity();
		ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = sra.getRequest();
		HttpSession session = request.getSession();

		// 对用户名密码校验
		if (StringUtils.isEmpty(emp.getUsername()) || StringUtils.isEmpty(emp.getPassword())) {
			result.setResultCode(ConstantEntity.FAIL);
			result.setResultMsg("用户名和密码不能为空!");
			return result;
		}
		
		// 数据库查询 并校验 是否存在该用户
		try {
			String password =  MD5Utils.EncoderByMd5(emp.getPassword());
			emp.setPassword(password);
			int user =  userManagerService.selectUserCount(emp);
			if(user >0) {
				//session存放用户	
				session.setAttribute("user", emp.getLoginname());
				result.setResultCode(ConstantEntity.SUCCESS);
				result.setResultMsg("登录成功!");
			}else {
				result.setResultCode(ConstantEntity.FAIL);
				result.setResultMsg("用户名不存在");
			}
		} catch (Exception e) {
			result.setResultCode(ConstantEntity.FAIL);
			result.setResultMsg("用户名不存在");
			
			e.printStackTrace();
		}
		return result;
	}
}
