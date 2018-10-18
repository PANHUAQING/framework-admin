package com.frame.admin.mapper;

import com.frame.admin.model.OmUserRoleT;
import com.frame.admin.model.OmUserRoleTExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OmUserRoleTMapper {
    int countByExample(OmUserRoleTExample example);

    int deleteByExample(OmUserRoleTExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OmUserRoleT record);

    int insertSelective(OmUserRoleT record);

    List<OmUserRoleT> selectByExample(OmUserRoleTExample example);

    OmUserRoleT selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OmUserRoleT record, @Param("example") OmUserRoleTExample example);

    int updateByExample(@Param("record") OmUserRoleT record, @Param("example") OmUserRoleTExample example);

    int updateByPrimaryKeySelective(OmUserRoleT record);

    int updateByPrimaryKey(OmUserRoleT record);
}