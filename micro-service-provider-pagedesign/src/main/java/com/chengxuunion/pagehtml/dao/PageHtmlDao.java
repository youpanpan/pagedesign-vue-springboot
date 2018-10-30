package com.chengxuunion.pagehtml.dao;

import org.springframework.stereotype.Repository;

import com.chengxuunion.common.exception.BaseException;
import com.chengxuunion.vo.PageHtml;

@Repository
public interface PageHtmlDao {
	
	/**
	 * 查询页面HTML
	 * 
	 * @param pageId
	 * @return
	 * @throws BaseException
	 */
	PageHtml queryPageHtml(String pageId) throws BaseException;
	
	/**
	 * 保存页面HTML
	 * 
	 * @param pageHtml
	 * @return
	 * @throws BaseException
	 */
	int savePageHtml(PageHtml pageHtml) throws BaseException;

	/**
	 * 更新页面HTML
	 * 
	 * @param pageHtml
	 * @return
	 * @throws BaseException
	 */
	int updatePageHtml(PageHtml pageHtml) throws BaseException;
	
	/**
	 * 删除页面HTML
	 * 
	 * @param pageId	页面ID
	 * @return
	 * @throws BaseException
	 */
	int deletePageHtml(String pageId) throws BaseException;
}
