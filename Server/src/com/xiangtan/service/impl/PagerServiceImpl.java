package com.xiangtan.service.impl;

import com.xiangtan.beans.Pager;
import com.xiangtan.dao.PagerDao;
import com.xiangtan.exception.IllegalRequestException;
import com.xiangtan.service.PagerService;
import com.xiangtan.utils.AuthorizeUtil;

public class PagerServiceImpl implements PagerService{

	private static PagerDao pagerDao;
	public static void setPagerDao(PagerDao pagerDao) {
		PagerServiceImpl.pagerDao = pagerDao;
	}
	@Override
	public Pager getPager(String tableName, String key) {
		if (!AuthorizeUtil.requestAuthorize(key)) {
			throw new IllegalRequestException("非法请求,身份验证失败");
		}
		return pagerDao.getPager(tableName);
	}

}
