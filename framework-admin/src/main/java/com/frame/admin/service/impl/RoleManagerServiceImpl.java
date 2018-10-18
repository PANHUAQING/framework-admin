package com.frame.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.frame.admin.common.ConstantEntity;
import com.frame.admin.common.ResultEntity;
import com.frame.admin.mapper.OmRoleTMapper;
import com.frame.admin.model.OmRoleT;
import com.frame.admin.model.vo.OmRoleTVo;
import com.frame.admin.service.RoleManagerService;
import com.frame.utils.UUIDUtils;
/**
 * 
* @ClassName: RoleManagerServiceImpl
* @Description: 
*   角色接口实现类
* @author panhuaqing
* @date 2018年7月26日 下午9:10:09
*
 */
@Service
public class RoleManagerServiceImpl  implements RoleManagerService{

	@Autowired
    private OmRoleTMapper omRoleTMapper;
	
	
	@Override
	public ResultEntity getRoleList(OmRoleTVo omRoleTVo) throws Exception {
		List<OmRoleT>  rows =  omRoleTMapper.selectRoleList(omRoleTVo);
		int total = omRoleTMapper.selectRoleTotal(omRoleTVo);
		return new ResultEntity(ConstantEntity.SUCCESS,ConstantEntity.SUCCESS_MSG,rows,total);
	}


	@Override
	public ResultEntity saveRoleInfo(OmRoleT omRoleT) throws Exception {
		ResultEntity  result = new ResultEntity();
		int isave =  omRoleTMapper.selectRoleByName(omRoleT.getName());
		if(isave>0) {
			result.setResultCode(ConstantEntity.FAIL);
			result.setResultMsg("角色名称重复!");
			return result;
		}
		omRoleT.setId(UUIDUtils.getUUID());
		//保存
		omRoleTMapper.insert(omRoleT);
		
		
		result.setResultCode(ConstantEntity.SUCCESS);
		result.setResultMsg(ConstantEntity.SUCCESS_MSG);
		return result;
	}


	@Override
	public ResultEntity deleteRoleInfo(String roleId) throws Exception {
		ResultEntity  result = new ResultEntity();
	 
		if(StringUtils.isEmpty(roleId)) {
			result.setResultCode(ConstantEntity.FAIL);
			result.setResultMsg("删除失败，参数有误!");
			return result;
		}
		
		//删除
		omRoleTMapper.deleteByPrimaryKey(roleId);
		
		result.setResultCode(ConstantEntity.SUCCESS);
		result.setResultMsg(ConstantEntity.SUCCESS_MSG);
		return result;
	}


	@Override
	public ResultEntity updateRoleInfo(OmRoleT omRoleT) throws Exception {
		ResultEntity  result = new ResultEntity();
		 
		if(StringUtils.isEmpty(omRoleT.getId())|| StringUtils.isEmpty(omRoleT.getName())) {
			result.setResultCode(ConstantEntity.FAIL);
			result.setResultMsg("修改失败，参数有误!");
			return result;
		}
		
		//更新
		omRoleTMapper.updateByPrimaryKey(omRoleT);
		
		result.setResultCode(ConstantEntity.SUCCESS);
		result.setResultMsg(ConstantEntity.SUCCESS_MSG);
		return result;
	}
	
	

}
