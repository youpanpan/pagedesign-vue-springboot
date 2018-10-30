package com.chengxuunion.pagecomponent.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chengxuunion.common.exception.BaseException;
import com.chengxuunion.pagecomponent.dao.PageComponentDao;
import com.chengxuunion.pagecomponent.service.IPageComponentService;
import com.chengxuunion.vo.PageComponent;

/**
 * 页面组件服务实现
 *
 * @author kutome
 * @date 2018年10月26日
 * @version V1.0
 */
@Service
public class PageComponentService implements IPageComponentService {

	/**
	 * 页面组件DAO
	 */
	@Autowired
	private PageComponentDao pageComponentDao;
	
	@Override
	public List<PageComponent> queryPageComponens(String pageId) throws BaseException {
		return pageComponentDao.queryPageComponens(pageId);
	}

	@Override
	public int savePageComponentBatch(List<PageComponent> pageComponents) throws BaseException {
		return pageComponentDao.savePageComponentBatch(pageComponents);
	}

	@Override
	public int deletePageComponents(String pageId) throws BaseException {
		return pageComponentDao.deletePageComponents(pageId);
	}

}
