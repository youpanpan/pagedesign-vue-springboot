package com.chengxuunion.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 基础实体
 *
 * @author kutome
 * @date 2018年10月24日
 * @version V1.0
 */
@SuppressWarnings("serial")
public class BaseVO implements Serializable {

	/**
	 * 创建时间
	 */
	private Date createDate;
	
	/**
	 * 创建人
	 */
	private String createUser;
	
	/**
	 * 更新时间
	 */
	private Date updateDate;
	
	/**
	 * 更新人
	 */
	private String updateUser;
	
	/**
	 * 排序号
	 */
	private Integer orderNum;
	
	/**
	 * 状态，1：有效，0：无效
	 */
	private String state;

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public Integer getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
}
