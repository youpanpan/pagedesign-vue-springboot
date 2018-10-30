package com.chengxuunion.pagecomponent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chengxuunion.common.exception.BaseException;
import com.chengxuunion.common.model.HttpStatus;
import com.chengxuunion.common.model.ResponseBean;
import com.chengxuunion.pagecomponent.service.IPageComponentService;
import com.chengxuunion.vo.PageComponent;

/**
 * 页面组件控制器
 *
 * @author kutome
 * @date 2018年10月26日
 * @version V1.0
 */
@RestController
public class PageComponentController {
	
	@Autowired
	private IPageComponentService pageComponentService;
	
	@RequestMapping("/pagecomponents/{pageId}")
	public ResponseBean queryPageComponents(@PathVariable("pageId") String pageId) throws BaseException {
		List<PageComponent> pageComponents = pageComponentService.queryPageComponens(pageId);
		
		return new ResponseBean(HttpStatus.OK, pageComponents);
	}

}
