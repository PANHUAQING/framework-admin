package com.frame.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.frame.admin.common.ResultEntity;
import com.frame.admin.model.vo.OmEmpTVo;
import com.frame.admin.service.UserManagerService;
/**
* @ClassName: UserController
* @Description: 
*     用户管理
* @author panhuaqing
* @date 2018年7月27日 上午1:44:24
*
 */
@RestController
@RequestMapping("/UserController")
public class UserController {

	@Autowired
	private UserManagerService userManagerService;
	
	/**
	 * 用户列表
	* @Title: showUserList
	* @Description: TODO
	* @param @param omEmpTVo
	* @param @return
	* @param @throws Exception    
	* @return ResultEntity    
	* @throws
	 */
	@RequestMapping("/showUserList")
	public ResultEntity  showUserList(OmEmpTVo omEmpTVo) throws Exception {

		ResultEntity result = userManagerService.getUserList(omEmpTVo);
		return result;
	} 
}
