package com.chengxuunion.page.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.chengxuunion.common.exception.BaseException;
import com.chengxuunion.common.model.ResponseBean;
import com.chengxuunion.vo.Page;

/**
 * 页面控制器（客户端交互）
 *
 * @author kutome
 * @date 2018年10月24日
 * @version V1.0
 */
@Controller
public class PageController {
	
	private static Logger log = LoggerFactory.getLogger(PageController.class);
	
	private static final String QUERY_ALL_PAGE = "http://localhost:8090/pagedesign-provider/pages/user/{userId}";
	private static final String QUERY_PAGE = "http://localhost:8090/pagedesign-provider/pages/{pageId}";
	private static final String ADD_PAGE = "http://localhost:8090/pagedesign-provider/pages";
	private static final String QUERY_PAGE_COMPONENTS = "http://localhost:8090/pagedesign-provider/pagecomponents/{pageId}";
	
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private HttpHeaders headers;
	
	@ResponseBody
	@RequestMapping(value="/pages/user/{userId}", method=RequestMethod.GET)
	public ResponseBean queryAllPage(@PathVariable("userId") String userId) throws BaseException {
		
		ResponseEntity<ResponseBean> responseEntity = restTemplate.exchange(QUERY_ALL_PAGE, HttpMethod.GET, new HttpEntity<Object>(this.headers), ResponseBean.class, userId);
		ResponseBean responseBean = responseEntity.getBody();
		
		return responseBean; 
	}
	
	@ResponseBody
	@RequestMapping(value="/pages/{pageId}", method=RequestMethod.GET)
	public ResponseBean queryPage(@PathVariable("pageId") String pageId) throws BaseException {
		
		ResponseEntity<ResponseBean> responseEntity = restTemplate.exchange(QUERY_PAGE, HttpMethod.GET, new HttpEntity<Object>(this.headers), ResponseBean.class, pageId);
		ResponseBean responseBean = responseEntity.getBody();
		
		return responseBean;
	}
	
	@ResponseBody
	@RequestMapping(value="/pages", method=RequestMethod.POST)
	public ResponseBean addPage(@RequestBody Page page) throws BaseException {
		log.debug(page.toString());  
		
		ResponseEntity<ResponseBean> responseEntity = restTemplate.exchange(ADD_PAGE, HttpMethod.POST, new HttpEntity<Object>(page, this.headers), ResponseBean.class);
		
		return responseEntity.getBody();
	}
	
	@ResponseBody
	@RequestMapping(value="/pages", method=RequestMethod.PUT)
	public ResponseBean updatePage(@RequestBody Page page) throws BaseException {
		log.debug(page.toString());    
		
		ResponseEntity<ResponseBean> responseEntity = restTemplate.exchange(ADD_PAGE, HttpMethod.PUT, new HttpEntity<Object>(page, this.headers), ResponseBean.class);
		
		return responseEntity.getBody();
	}
	
	@ResponseBody
	@RequestMapping(value="/pages/{pageId}", method=RequestMethod.DELETE)
	public ResponseBean deletePage(@PathVariable("pageId") String pageId) throws BaseException {
		ResponseEntity<ResponseBean> responseEntity = restTemplate.exchange(QUERY_PAGE, HttpMethod.DELETE, new HttpEntity<Object>(this.headers), ResponseBean.class, pageId);
		
		return responseEntity.getBody();
	}
	
	@ResponseBody
	@RequestMapping(value="/pages/pagecomponents/{pageId}", method=RequestMethod.GET)
	public ResponseBean queryPageComponents(@PathVariable("pageId") String pageId) throws BaseException {
		
		ResponseEntity<ResponseBean> responseEntity = restTemplate.exchange(QUERY_PAGE_COMPONENTS, HttpMethod.GET, new HttpEntity<Object>(this.headers), ResponseBean.class, pageId);
		ResponseBean responseBean = responseEntity.getBody();
		
		return responseBean;
	}
	

}
