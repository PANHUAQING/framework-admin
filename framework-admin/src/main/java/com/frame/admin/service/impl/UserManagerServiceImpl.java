package com.frame.admin.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frame.admin.common.ConstantEntity;
import com.frame.admin.common.ResultEntity;
import com.frame.admin.mapper.OmEmpTMapper;
import com.frame.admin.model.OmEmpT;
import com.frame.admin.model.vo.OmEmpTVo;
import com.frame.admin.service.UserManagerService;
/**
 * 
* @ClassName: UserManagerServiceImpl
* @Description: 
*    用户接口实现类
* @author panhuaqing
* @date 2018年7月27日 上午1:46:11
*
 */
@Service
public class UserManagerServiceImpl implements UserManagerService {
	    @Autowired
        private OmEmpTMapper omEmpTMapper;
	    
	    @Override
		public ResultEntity getUserList(OmEmpTVo omEmpTVo) throws Exception {
			List<OmEmpT>  rows =  omEmpTMapper.selectUserList(omEmpTVo);
			int total = omEmpTMapper.selectUserTotal(omEmpTVo);
			return new ResultEntity(ConstantEntity.SUCCESS,ConstantEntity.SUCCESS_MSG,rows,total);
		}
	    /**
	     * 查询是否存在该用户
	     */
	    public int selectUserCount(OmEmpT omEmpT)throws Exception {
	    	return omEmpTMapper.selectUserCount(omEmpT);
	    	
	    }
	    
	    
}
