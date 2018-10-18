package com.frame.admin.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.frame.admin.common.ResultEntity;
import com.frame.admin.model.OmRoleT;
import com.frame.admin.model.vo.OmRoleTVo;
import com.frame.admin.service.RoleManagerService;
import com.frame.admin.util.RedisService;
import com.frame.admin.util.SerializationUtil;
/**
 * 角色管理 
 *
 */
@RestController
@RequestMapping("/RoleManagerController")
public class RoleManagerController {
	
	@Autowired
	private RedisService redisService;

	@Autowired
	private RoleManagerService roleManagerService;
	/**
	 * 展示角色列表数据
	 * @param omRoleTVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/showRoleList")
	public ResultEntity  showRoleList(OmRoleTVo omRoleTVo) throws Exception {
		
		ResultEntity result = roleManagerService.getRoleList(omRoleTVo);
		return result;
	} 
	/**
	 * 新增角色名称
	 * @param omRoleT
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/addRoleInfo")
	public ResultEntity  addRoleInfo(OmRoleT omRoleT) throws Exception {
		
		ResultEntity result = roleManagerService.saveRoleInfo(omRoleT);
		return result;
	} 
	/**
	 * 删除角色
	 * @param omRoleT
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/delRoleInfo")
	public ResultEntity  delRoleInfo(@RequestParam("roleId")String roleId ) throws Exception {
		
		ResultEntity result = roleManagerService.deleteRoleInfo(roleId);
		return result;
	} 
	/**
	 * 修改角色
	 * @param omRoleT
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/editRoleInfo")
	public ResultEntity  editRoleInfo(OmRoleT omRoleT) throws Exception {
		
		ResultEntity result = roleManagerService.updateRoleInfo(omRoleT);
		return result;
	} 
}
