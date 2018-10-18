package com.frame.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.frame.admin.model.OmRoleT;
import com.frame.admin.model.vo.OmRoleTVo;
@Mapper
public interface OmRoleTMapper {
   

    int deleteByPrimaryKey(String id);

    int insert(OmRoleT record);

    int updateByPrimaryKey(OmRoleT record);
    //获取角色列表数据
    List<OmRoleT> selectRoleList(OmRoleTVo omRoleTVo);
    
    //获取角色列表数据
    int selectRoleTotal(OmRoleTVo omRoleTVo);
    
    int selectRoleByName(@Param("name") String name);
}