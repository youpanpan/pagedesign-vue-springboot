package com.chengxuunion.vo;

import java.io.Serializable;

/**
 * 组件属性实体
 *
 * @author kutome
 * @date 2018年10月24日
 * @version V1.0
 */
@SuppressWarnings("serial")
public class ComponentAttr extends BaseVO implements Serializable {

	/**
	 * 主键ID
	 */
	private String id;
	
	/**
	 * 组件ID
	 */
	private String componentId;
	
	/**
	 * 属性名
	 */
	private String attrName;
	
	/**
	 * 属性值
	 */
	private String attrValue;
	
	/**
	 * 属性类型，1:简单类型,2:数组,3:对象
	 */
	private String attrType;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getComponentId() {
		return componentId;
	}

	public void setComponentId(String componentId) {
		this.componentId = componentId;
	}

	public String getAttrName() {
		return attrName;
	}

	public void setAttrName(String attrName) {
		this.attrName = attrName;
	}

	public String getAttrValue() {
		return attrValue;
	}

	public void setAttrValue(String attrValue) {
		this.attrValue = attrValue;
	}

	public String getAttrType() {
		return attrType;
	}

	public void setAttrType(String attrType) {
		this.attrType = attrType;
	}

	@Override
	public String toString() {
		return "ComponentAttr [id=" + id + ", componentId=" + componentId + ", attrName=" + attrName + ", attrValue="
				+ attrValue + ", attrType=" + attrType + ", getCreateDate()=" + getCreateDate() + ", getCreateUser()="
				+ getCreateUser() + ", getUpdateDate()=" + getUpdateDate() + ", getUpdateUser()=" + getUpdateUser()
				+ ", getOrderNum()=" + getOrderNum() + ", getState()=" + getState() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}

