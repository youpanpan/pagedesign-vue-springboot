package com.chengxuunion.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 页面实体
 *
 * @author kutome
 * @date 2018年10月24日
 * @version V1.0
 */
@SuppressWarnings("serial")
public class Page extends BaseVO implements Serializable {
	
	/**
	 * 主键ID
	 */
	private String id;
	
	/**
	 * 页面名称
	 */
	private String pageName;
	
	/**
	 * 页面组件列表
	 */
	private List<PageComponent> pageComponents;
	
	/**
	 * 页面属性列表
	 */
	private List<ComponentAttr> componentAttrs;
	
	/**
	 * 页面HTML
	 */
	private PageHtml pageHtml;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public List<PageComponent> getPageComponents() {
		return pageComponents;
	}

	public void setPageComponents(List<PageComponent> pageComponents) {
		this.pageComponents = pageComponents;
	}

	public List<ComponentAttr> getComponentAttrs() {
		return componentAttrs;
	}

	public void setComponentAttrs(List<ComponentAttr> componentAttrs) {
		this.componentAttrs = componentAttrs;
	}

	public PageHtml getPageHtml() {
		return pageHtml;
	}

	public void setPageHtml(PageHtml pageHtml) {
		this.pageHtml = pageHtml;
	}

	@Override
	public String toString() {
		return "Page [id=" + id + ", pageName=" + pageName + ", getCreateDate()=" + getCreateDate()
				+ ", getCreateUser()=" + getCreateUser() + ", getUpdateDate()=" + getUpdateDate() + ", getUpdateUser()="
				+ getUpdateUser() + ", getOrderNum()=" + getOrderNum() + ", getState()=" + getState() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}
