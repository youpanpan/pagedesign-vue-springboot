package com.chengxuunion.componentattr.service;

import java.util.List;

import com.chengxuunion.common.exception.BaseException;
import com.chengxuunion.vo.ComponentAttr;

/**
 * 组件属性服务接口
 *
 * @author kutome
 * @date 2018年10月26日
 * @version V1.0
 */
public interface IComponentAttrService {
	
	/**
	 * 批量新增组件属性
	 * 
	 * @param componentAttrs
	 * @return
	 * @throws BaseException
	 */
	int saveComponentAttrBatch(List<ComponentAttr> componentAttrs) throws BaseException;

	/**
	 * 删除指定页面下所有的组件属性
	 * 
	 * @param pageId	页面ID
	 * @return
	 * @throws BaseException
	 */
	int deleteComponentAttr(String pageId) throws BaseException;
	
	/**
	 * 删除页面组件属性
	 * 
	 * @param pageId
	 * @return
	 * @throws BaseException
	 */
	int deleteComponentAttrByPage(String pageId) throws BaseException;
	
}
