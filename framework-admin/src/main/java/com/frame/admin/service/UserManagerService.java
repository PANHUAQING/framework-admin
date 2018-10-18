package com.frame.admin.service;

import com.frame.admin.common.ResultEntity;
import com.frame.admin.model.OmEmpT;
import com.frame.admin.model.vo.OmEmpTVo;

public interface UserManagerService {
   
	public ResultEntity getUserList(OmEmpTVo omEmpTVo) throws Exception;
	
	public int selectUserCount(OmEmpT omEmpT)throws Exception;
}
