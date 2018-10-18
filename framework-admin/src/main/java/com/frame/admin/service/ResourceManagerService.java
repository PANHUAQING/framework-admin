package com.frame.admin.service;

import java.util.List;

import com.frame.admin.common.ResultEntity;
import com.frame.admin.model.OmResourceT;
import com.frame.admin.model.common.TreeModel;

public interface ResourceManagerService {

	
	public  OmResourceT  getOmResourceTInfo(String resourceId)  throws Exception;
	
	//删除
	public  ResultEntity  deleteOmResourceInfo(String resourceId)  throws Exception;
	
	
	public ResultEntity saveOmResourceInfo(OmResourceT omResourceT) throws Exception;
	
	public ResultEntity updateOmResourceInfo(OmResourceT omResourceT) throws Exception;
	
	//获取左侧资源树
	public List<TreeModel>  getResourceInfoTree(String resourceId) throws Exception;
}
