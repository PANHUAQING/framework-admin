package com.frame.admin.service;


import com.frame.admin.common.ResultEntity;
import com.frame.admin.model.OmRoleT;
import com.frame.admin.model.vo.OmRoleTVo;

public interface RoleManagerService {
	   
	//查询角色列表
	public ResultEntity getRoleList(OmRoleTVo omRoleTVo) throws Exception;
	
	//保存角色信息
	public ResultEntity saveRoleInfo(OmRoleT omRoleT) throws Exception;
	
	//删除角色
	public ResultEntity deleteRoleInfo(String roleId) throws Exception;
	
	//修改角色
	public ResultEntity updateRoleInfo(OmRoleT omRoleT) throws Exception;
}
