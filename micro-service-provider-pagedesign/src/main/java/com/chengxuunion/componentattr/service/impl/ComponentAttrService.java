package com.chengxuunion.componentattr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chengxuunion.common.exception.BaseException;
import com.chengxuunion.componentattr.dao.ComponentAttrDao;
import com.chengxuunion.componentattr.service.IComponentAttrService;
import com.chengxuunion.vo.ComponentAttr;

/**
 * 组件属性服务实现
 *
 * @author kutome
 * @date 2018年10月26日
 * @version V1.0
 */
@Service
public class ComponentAttrService implements IComponentAttrService {

	/**
	 * 组件属性DAO
	 */
	@Autowired
	private ComponentAttrDao componentAttrDao;
	
	@Override
	public int saveComponentAttrBatch(List<ComponentAttr> componentAttrs) throws BaseException {
		return componentAttrDao.saveComponentAttrBatch(componentAttrs);
	}

	@Override
	public int deleteComponentAttr(String pageId) throws BaseException {
		return componentAttrDao.deleteComponentAttr(pageId);
	}

	@Override
	public int deleteComponentAttrByPage(String pageId) throws BaseException {
		return componentAttrDao.deleteComponentAttrByPage(pageId);
	}

}
