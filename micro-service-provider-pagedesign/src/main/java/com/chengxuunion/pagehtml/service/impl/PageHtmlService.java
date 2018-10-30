package com.chengxuunion.pagehtml.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chengxuunion.common.exception.BaseException;
import com.chengxuunion.pagehtml.dao.PageHtmlDao;
import com.chengxuunion.pagehtml.service.IPageHtmlService;
import com.chengxuunion.vo.PageHtml;

/**
 * 页面HTML服务实现
 *
 * @author kutome
 * @date 2018年10月26日
 * @version V1.0
 */
@Service
public class PageHtmlService implements IPageHtmlService {
	
	@Autowired
	private PageHtmlDao pageHtmlDao;

	@Override
	public PageHtml queryPageHtml(String pageId) throws BaseException {
		return pageHtmlDao.queryPageHtml(pageId);
	}
	
	@Override
	public int savePageHtml(PageHtml pageHtml) throws BaseException {
		return pageHtmlDao.savePageHtml(pageHtml);
	}

	@Override
	public int updatePageHtml(PageHtml pageHtml) throws BaseException {
		return pageHtmlDao.updatePageHtml(pageHtml);
	}

	@Override
	public int deletePageHtml(String pageId) throws BaseException {
		return pageHtmlDao.deletePageHtml(pageId);
	}

	

}
