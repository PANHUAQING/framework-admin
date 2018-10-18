package com.frame.admin.service.impl;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.frame.admin.common.ConstantEntity;
import com.frame.admin.common.ResultEntity;
import com.frame.admin.mapper.OmResourceTMapper;
import com.frame.admin.model.OmResourceT;
import com.frame.admin.model.common.TreeModel;
import com.frame.admin.service.ResourceManagerService;
import com.frame.utils.UUIDUtils;
/**
* @ClassName: ResourceManagerServiceImpl
* @Description:  
*    资源 管理
* @author panhuaqing
* @date 2018年7月27日 下午3:51:18
*
 */
@Service
public class ResourceManagerServiceImpl implements  ResourceManagerService{
    
	@Autowired
	private  OmResourceTMapper omResourceTMapper;
   
	//获取资源
	@Override
	public OmResourceT  getOmResourceTInfo(String resourceId) throws Exception{
		if(StringUtils.isEmpty(resourceId)) {
			return new OmResourceT();
		}	
		return omResourceTMapper.selectByPrimaryKey(resourceId);
	}
	//保存资源
	@Override
	public ResultEntity saveOmResourceInfo(OmResourceT omResourceT) throws Exception {
		ResultEntity  result = new ResultEntity();
		
		omResourceT.setResourceId(UUIDUtils.getUUID());
		omResourceT.setCreateDate(new Date());

		//保存
		omResourceTMapper.insert(omResourceT);
		
		result.setResultCode(ConstantEntity.SUCCESS);
		result.setResultMsg(ConstantEntity.SUCCESS_MSG);
		return result;
	}
    /**
     * 获取左侧资源树
     */
	@Override
	public List<TreeModel> getResourceInfoTree(String resourceId) throws Exception {
		
		 List<TreeModel> firstNodelList = new ArrayList<TreeModel>();
		 List<TreeModel> twoNodelList = new ArrayList<TreeModel>();
		
		
		 OmResourceT  root =  omResourceTMapper.selectByPrimaryKey(resourceId);
		 //初始化根节点数据
		 TreeModel rootTree = new TreeModel();
		 rootTree.setId(root.getResourceId());
		 rootTree.setLabel(root.getResourceName());
		 rootTree.setLevel("1");
		 rootTree.setPid(root.getResourcePid());
		
		 List<OmResourceT> twolist = omResourceTMapper.selectByExampleByParentId(root.getResourceId());
		 
		 Iterator<OmResourceT> it = twolist.iterator();
		 while(it.hasNext()) {
			 OmResourceT  om = it.next();
			 TreeModel model= new TreeModel();
			 model.setId(om.getResourceId());
			 model.setLabel(om.getResourceName());
			 model.setLevel("2");
			 model.setPid(om.getResourcePid());
			 
			 List<TreeModel> threeNodelList = new ArrayList<TreeModel>();
			 //查询第三级
			 List<OmResourceT> threelist = omResourceTMapper.selectByExampleByParentId(om.getResourceId());
			 
			 for (OmResourceT omResourceT : threelist) {
				 TreeModel modelThree= new TreeModel();
				 modelThree.setId(omResourceT.getResourceId());
				 modelThree.setLabel(omResourceT.getResourceName());
				 modelThree.setLevel("3");
				 modelThree.setIsHave("0");
				 modelThree.setPid(omResourceT.getResourcePid());
				 modelThree.setChildren(null);
				 threeNodelList.add(modelThree);
			}
		   if(threelist!=null && threelist.size()>0) {
			    model.setIsHave("1");
			 
			}else {
				model.setIsHave("0");
			}
		   model.setChildren(threeNodelList);
		  twoNodelList.add(model);
		 }
		 
		if(twolist!=null && twolist.size()>0) {
			rootTree.setIsHave("1");
		}else {
			rootTree.setIsHave("0");
		}
		rootTree.setChildren(twoNodelList); 
		firstNodelList.add(rootTree);
		return firstNodelList;
	}
	
	
    //编辑资源
	@Override
	public ResultEntity updateOmResourceInfo(OmResourceT omResourceT) throws Exception {
		ResultEntity  result = new ResultEntity();
		
		if(StringUtils.isEmpty(omResourceT.getResourceId())) {
			result.setResultCode(ConstantEntity.FAIL);
			result.setResultMsg(ConstantEntity.FAIL_MSG);
			return result;
		}	
		//更新资源
		omResourceTMapper.updateByPrimaryKey(omResourceT);
		
		result.setResultCode(ConstantEntity.SUCCESS);
		result.setResultMsg(ConstantEntity.SUCCESS_MSG);
		return result;
	}

	//删除资源操作
	@Override
	public ResultEntity deleteOmResourceInfo(String resourceId) throws Exception {
		ResultEntity  result = new ResultEntity();
		if(StringUtils.isEmpty(resourceId)) {
			result.setResultCode(ConstantEntity.FAIL);
			result.setResultMsg(ConstantEntity.FAIL_MSG);
			return result;
		}	
		
		//先判断是否具体下级
		int nextCount = omResourceTMapper.selectCountByExampleByParentId(resourceId);
		
		if(nextCount>0) {
			result.setResultCode(ConstantEntity.FAIL);
			result.setResultMsg("该资源存在下级资源不能删除!");
			return result;
		}
		//资源更新为无效
		omResourceTMapper.updateResourceById(resourceId);
		
		result.setResultCode(ConstantEntity.SUCCESS);
		result.setResultMsg(ConstantEntity.SUCCESS_MSG);
		return result;
	}
	
	

	
}
