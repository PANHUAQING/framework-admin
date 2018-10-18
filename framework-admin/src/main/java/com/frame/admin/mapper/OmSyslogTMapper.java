package com.frame.admin.mapper;

import com.frame.admin.model.OmSyslogT;
import com.frame.admin.model.OmSyslogTExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface OmSyslogTMapper {
    int countByExample(OmSyslogTExample example);

    int deleteByExample(OmSyslogTExample example);

    int insert(OmSyslogT record);

    int insertSelective(OmSyslogT record);

    List<OmSyslogT> selectByExample(OmSyslogTExample example);

    int updateByExampleSelective(@Param("record") OmSyslogT record, @Param("example") OmSyslogTExample example);

    int updateByExample(@Param("record") OmSyslogT record, @Param("example") OmSyslogTExample example);
}