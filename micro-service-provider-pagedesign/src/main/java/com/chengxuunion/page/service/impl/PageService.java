package com.chengxuunion.page.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chengxuunion.common.exception.BaseException;
import com.chengxuunion.common.service.BaseService;
import com.chengxuunion.common.utils.CollectionUtils;
import com.chengxuunion.common.utils.IdGenerator;
import com.chengxuunion.common.utils.StringUtils;
import com.chengxuunion.componentattr.service.IComponentAttrService;
import com.chengxuunion.page.dao.PageDao;
import com.chengxuunion.page.service.IPageService;
import com.chengxuunion.pagecomponent.service.IPageComponentService;
import com.chengxuunion.pagehtml.service.IPageHtmlService;
import com.chengxuunion.vo.ComponentAttr;
import com.chengxuunion.vo.Page;
import com.chengxuunion.vo.PageComponent;

/**
 * 页面服务实现
 *
 * @author kutome
 * @date 2018年10月24日
 * @version V1.0
 */
@Service
public class PageService extends BaseService implements IPageService {
	
	@Autowired
	private PageDao pageDao;
	
	@Autowired
	private IPageComponentService pageComponentService;
	
	@Autowired
	private IComponentAttrService componentAttrService;

	@Autowired
	private IPageHtmlService pageHtmlService;
	
	@Override
	public List<Page> queryAllPage(String userId) throws BaseException {
		return pageDao.queryAllPage(userId);
	}

	@Override
	public Page queryPage(String pageId) throws BaseException {
		return pageDao.queryPage(pageId);
	}

	@Override
	public int savePage(Page page) throws BaseException {
		
		IdGenerator idGenerator = new IdGenerator();
		String pageId = idGenerator.nextIdString();
		
		//如果为更新数据，则删除原有数据
		if (StringUtils.isNotEmpty(page.getId())) {
			pageId = page.getId();
			//1、删除组件属性
			componentAttrService.deleteComponentAttr(pageId);
			componentAttrService.deleteComponentAttrByPage(pageId);
			
			//2、删除组件
			pageComponentService.deletePageComponents(pageId);
			
			//3、删除页面HTML
			pageHtmlService.deletePageHtml(pageId);
			
			//4、更新页面时间
			this.updatePage(page);
		} else {
			//1、保存页面记录
			page.setId(pageId);
			setCommonAttr(page);
			pageDao.addPage(page);
		}
		
		List<ComponentAttr> componentAttrs = new ArrayList<ComponentAttr>();
		
		//2、保存页面组件记录
		if (CollectionUtils.isNotEmpty(page.getPageComponents())) { 
			for (PageComponent pageComponent : page.getPageComponents()) {
				pageComponent.setId(idGenerator.nextIdString());
				pageComponent.setPageId(pageId);
				setCommonAttr(pageComponent);
				for (ComponentAttr componentAttr : pageComponent.getComponentAttrs()) {
					componentAttr.setId(idGenerator.nextIdString());
					componentAttr.setComponentId(pageComponent.getId());
					setCommonAttr(componentAttr);
					componentAttrs.add(componentAttr);
				}
			}
			pageComponentService.savePageComponentBatch(page.getPageComponents());
		}
		List<ComponentAttr> pageAttrs = page.getComponentAttrs();
		for (ComponentAttr componentAttr : pageAttrs) {
			componentAttr.setComponentId(pageId);
			componentAttr.setId(idGenerator.nextIdString());
			setCommonAttr(componentAttr);
			componentAttrs.add(componentAttr);
		}
		
		//3、保存组件属性记录
		if (CollectionUtils.isNotEmpty(componentAttrs)) {
			componentAttrService.saveComponentAttrBatch(componentAttrs);
		}
		
		//4、保存页面HTML记录
		setCommonAttr(page.getPageHtml());
		page.getPageHtml().setId(idGenerator.nextIdString());
		page.getPageHtml().setPageId(pageId);
		pageHtmlService.savePageHtml(page.getPageHtml());
		
		return 1;
	}
	
	@Override
	public int updatePage(Page page) throws BaseException {
		page.setUpdateDate(new Date());
		return pageDao.updatePage(page);
	}

	@Override
	public int deletePage(String pageId) throws BaseException {
		
		//1、删除组件属性
		componentAttrService.deleteComponentAttr(pageId);
		componentAttrService.deleteComponentAttrByPage(pageId);
		
		//2、删除组件
		pageComponentService.deletePageComponents(pageId);
		
		//3、删除页面HTML
		pageHtmlService.deletePageHtml(pageId);
		
		//4、删除当前页面
		return pageDao.deletePage(pageId);
	}

	
	
}
