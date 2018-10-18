package com.frame.admin.model.vo;

import com.frame.admin.common.CommonModel;
/**
 * 
 * 角色参数查询类
 *
 */
public class OmRoleTVo extends CommonModel {
   
	private String  roleName;
	private String  roleStatus;
	
	
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleStatus() {
		return roleStatus;
	}
	public void setRoleStatus(String roleStatus) {
		this.roleStatus = roleStatus;
	}
	@Override
	public String toString() {
		return "OmRoleTVo [roleName=" + roleName + ", roleStatus=" + roleStatus + "]";
	}
	
	
}
