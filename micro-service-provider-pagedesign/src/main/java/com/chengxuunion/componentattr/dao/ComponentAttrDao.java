package com.chengxuunion.componentattr.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.chengxuunion.common.exception.BaseException;
import com.chengxuunion.vo.ComponentAttr;

/**
 * 组件属性DAO
 *
 * @author kutome
 * @date 2018年10月26日
 * @version V1.0
 */
@Repository
public interface ComponentAttrDao {
	
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
