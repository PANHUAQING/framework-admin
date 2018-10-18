package com.frame.admin.mapper;

import com.frame.admin.model.OmResourceT;
import com.frame.admin.model.OmResourceTExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface OmResourceTMapper {

    //删除资源换数据
    int deleteByPrimaryKey(String resourceId);
   
    //保存资源数据
    int insert(OmResourceT record);

    OmResourceT selectByPrimaryKey(String resourceId);
    
    int updateResourceById(String resourceId);
    
    int updateByPrimaryKey(OmResourceT omResourceT);
    //下级节点数据集合
    List<OmResourceT> selectByExampleByParentId(String resourceId);
    //是否剧透下级节点
    int selectCountByExampleByParentId(String resourceId);
}