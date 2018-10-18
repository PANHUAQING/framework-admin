package com.frame.admin.model.vo;

import com.frame.admin.common.CommonModel;
/**
 * 
* @ClassName: OmEmpTVo
* @Description: 
*     用户查询实体类
* @author panhuaqing
* @date 2018年7月27日 上午2:03:01
*
 */
public class OmEmpTVo extends CommonModel{

	private String loginName;
	private String userName;
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
