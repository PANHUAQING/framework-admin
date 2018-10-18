package com.frame.admin.mapper;

import com.frame.admin.model.OmRoleResourceT;
import com.frame.admin.model.OmRoleResourceTExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface OmRoleResourceTMapper {
    int countByExample(OmRoleResourceTExample example);

    int deleteByExample(OmRoleResourceTExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OmRoleResourceT record);

    int insertSelective(OmRoleResourceT record);

    List<OmRoleResourceT> selectByExample(OmRoleResourceTExample example);

    OmRoleResourceT selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OmRoleResourceT record, @Param("example") OmRoleResourceTExample example);

    int updateByExample(@Param("record") OmRoleResourceT record, @Param("example") OmRoleResourceTExample example);

    int updateByPrimaryKeySelective(OmRoleResourceT record);

    int updateByPrimaryKey(OmRoleResourceT record);
}