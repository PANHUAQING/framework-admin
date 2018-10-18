package com.frame.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.frame.admin.model.OmEmpT;
import com.frame.admin.model.vo.OmEmpTVo;

@Mapper
public interface OmEmpTMapper {
   
	//获取用户列表
	public List<OmEmpT>  selectUserList(OmEmpTVo omEmpTVo);
	
	//获取总记录数
	public int selectUserTotal(OmEmpTVo omEmpTVo);
	
	public int selectUserCount(OmEmpT omEmpT);
}