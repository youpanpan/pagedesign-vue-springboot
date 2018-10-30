package com.chengxuunion.page.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.chengxuunion.common.exception.BaseException;
import com.chengxuunion.vo.Page;

/**
 * 页面DAO
 *
 * @author kutome
 * @date 2018年10月24日
 * @version V1.0
 */
@Repository
public interface PageDao {
	
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
	int addPage(Page page) throws BaseException;
	
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
