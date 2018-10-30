package com.chengxuunion.vo;

import java.io.Serializable;

/**
 * 页面HTML实体
 *
 * @author kutome
 * @date 2018年10月24日
 * @version V1.0
 */
@SuppressWarnings("serial")
public class PageHtml extends BaseVO implements Serializable {

	/**
	 * 主键ID
	 */
	private String id;
	
	/**
	 * 页面ID
	 */
	private String pageId;
	
	/**
	 * 页面HTML内容
	 */
	private String html;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPageId() {
		return pageId;
	}

	public void setPageId(String pageId) {
		this.pageId = pageId;
	}

	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}

	@Override
	public String toString() {
		return "PageHtml [id=" + id + ", pageId=" + pageId + ", html=" + html + ", getCreateDate()=" + getCreateDate()
				+ ", getCreateUser()=" + getCreateUser() + ", getUpdateDate()=" + getUpdateDate() + ", getUpdateUser()="
				+ getUpdateUser() + ", getOrderNum()=" + getOrderNum() + ", getState()=" + getState() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}
