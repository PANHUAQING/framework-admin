package com.frame.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.druid.util.StringUtils;
import com.frame.admin.common.ConstantEntity;
import com.frame.admin.common.ResultEntity;
import com.frame.admin.model.OmResourceT;
import com.frame.admin.model.common.TreeModel;
import com.frame.admin.service.ResourceManagerService;
/**
 * 资源管理 控制类
 */
@RestController
@RequestMapping("/ResourceController")
public class ResourceController {

	@Autowired
	private ResourceManagerService resourceManagerService;
	
	/**
	 * 获取单个资源数
	* @Title: showResourceInfo
	* @Description: TODO
	* @param @param resourceId
	* @param @return
	* @param @throws Exception    
	* @return OmResourceT    
	* @throws
	 */
	@RequestMapping("/showResourceInfo")
	public OmResourceT  showResourceInfo(@RequestParam("resourceId")String resourceId ) throws Exception {
		
		OmResourceT omResourceT = resourceManagerService.getOmResourceTInfo(resourceId);
		return omResourceT;
	}
	
	/**
	 * 获取左侧资源数
	* @Title: showResourceTree
	* @Description: TODO
	* @param @param resourceId
	* @param @return
	* @param @throws Exception    
	* @return OmResourceT    
	* @throws
	 */
	@RequestMapping("/showResourceTree")
	public ResultEntity  showResourceTree(@RequestParam("resourceId")String resourceId) throws Exception {
		ResultEntity result = new ResultEntity();
		if(StringUtils.isEmpty(resourceId)) {
			result.setResultCode(ConstantEntity.FAIL);
			result.setResultMsg(ConstantEntity.FAIL_MSG);
			return result;
		}
		List<TreeModel> list =  resourceManagerService.getResourceInfoTree(resourceId);
		result.setResultCode(ConstantEntity.SUCCESS);
		result.setResultMsg(ConstantEntity.SUCCESS_MSG);
		result.setResultRows(list);
		return result;
	}
	
   /**
    * 
   * @Title: addResourceInfo
   * @Description: 
   *   新增资源
   * @param @param omResourceT
   * @param @return
   * @param @throws Exception    
   * @return ResultEntity    
   * @throws
    */
	@RequestMapping("/addResourceInfo")
	public ResultEntity  addResourceInfo(OmResourceT omResourceT ) throws Exception {
		
		ResultEntity result = resourceManagerService.saveOmResourceInfo(omResourceT);
		return result;
	} 
	
	/**
	 * 
	 * @Title: addResourceInfo
	 * @Description: 
	 *   编辑资源
	 * @param @param omResourceT
	 * @param @return
	 * @param @throws Exception    
	 * @return ResultEntity    
	 * @throws
	 */
	@RequestMapping("/editResourceInfo")
	public ResultEntity  editResourceInfo(OmResourceT omResourceT ) throws Exception {
		
		ResultEntity result = resourceManagerService.updateOmResourceInfo(omResourceT);
		return result;
	} 
	
	/**
	 * 
	 * @Title: addResourceInfo
	 * @Description: 
	 *   新增资源
	 * @param @param omResourceT
	 * @param @return
	 * @param @throws Exception    
	 * @return ResultEntity    
	 * @throws
	 */
	@RequestMapping("/delResourceInfo")
	public ResultEntity  delResourceInfo(@RequestParam("resourceId")String resourceId) throws Exception {
		ResultEntity result = resourceManagerService.deleteOmResourceInfo(resourceId);
		return result;
	} 
	
}
