package com.frame.admin.model.common;

import java.util.List;

/**
 * 
* @ClassName: TreeModel
* @Description: 
*    tree生成实体类 
* @author panhuaqing
* @date 2018年8月6日 上午10:09:13
*
 */
public class TreeModel {
	private String id; // 树id
	private String label;// 树显示名称
	private String pid;// 树父节点
	private String isHave;// 是否有子节点
	private String level;//级别
	
	private List<TreeModel> children;

	
	
	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public List<TreeModel> getChildren() {
		return children;
	}

	public void setChildren(List<TreeModel> children) {
		this.children = children;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getIsHave() {
		return isHave;
	}

	public void setIsHave(String isHave) {
		this.isHave = isHave;
	}

}
