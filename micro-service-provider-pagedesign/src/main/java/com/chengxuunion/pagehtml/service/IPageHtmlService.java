package com.chengxuunion.pagehtml.service;

import com.chengxuunion.common.exception.BaseException;
import com.chengxuunion.vo.PageHtml;

/**
 * 页面HTML服务接口
 *
 * @author kutome
 * @date 2018年10月26日
 * @version V1.0
 */
public interface IPageHtmlService {
	
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
