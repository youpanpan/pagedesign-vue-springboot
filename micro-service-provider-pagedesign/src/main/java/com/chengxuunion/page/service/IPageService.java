package com.chengxuunion.page.service;

import java.util.List;

import com.chengxuunion.common.exception.BaseException;
import com.chengxuunion.vo.Page;

/**
 * 页面服务接口
 *
 * @author kutome
 * @date 2018年10月24日
 * @version V1.0
 */
public interface IPageService {

	/**
	 * 根据用户ID查询所有页面
	 * 
	 * @param userId	用户ID
	 * @return
	 * @throws BaseException
	 */
	List<Page> queryAllPage(String userId) throws BaseException;
	
	/**
	 * 根据页面ID查询指定的页面
	 * 
	 * @param pageId	页面ID
	 * @return
	 * @throws BaseException
	 */
	Page queryPage(String pageId) throws BaseException;
	
	/**
	 * 新增页面
	 * 
	 * @param page
	 * @return
	 * @throws BaseException
	 */
	int savePage(Page page) throws BaseException;
	
	/**
	 * 更新页面
	 * 
	 * @param page
	 * @return
	 * @throws BaseException
	 */
	int updatePage(Page page) throws BaseException;
	
	/**
	 * 删除指定页面ID的页面
	 * 
	 * @param pageId	页面ID
	 * @return
	 * @throws BaseException
	 */
	int deletePage(String pageId) throws BaseException;
	
}
