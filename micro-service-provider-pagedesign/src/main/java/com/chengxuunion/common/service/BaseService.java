package com.chengxuunion.common.service;

import java.util.Date;

import com.chengxuunion.common.utils.StringUtils;
import com.chengxuunion.constants.Constants;
import com.chengxuunion.vo.BaseVO;

/**
 * 公共服务
 *
 * @author kutome
 * @date 2018年10月28日
 * @version V1.0
 */
public class BaseService {
	
	/**
	 * 设置公共属性
	 * 
	 * @param baseVO
	 */
	public void setCommonAttr(BaseVO baseVO) {
		Date nowDate = new Date();
		if (baseVO.getCreateDate() == null) {
			baseVO.setCreateDate(nowDate);
		}
		if (baseVO.getUpdateDate() == null) {
			baseVO.setUpdateDate(nowDate);
		}
		if (StringUtils.isEmpty(baseVO.getState())) {
			baseVO.setState(Constants.VALID);			
		}
	}

}
