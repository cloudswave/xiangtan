package com.xiangtan.service.impl;

import com.xiangtan.beans.Pager;
import com.xiangtan.dao.PagerDao;
import com.xiangtan.service.PagerService;

public class PagerServiceImpl implements PagerService{

	private static PagerDao pagerDao;
	public static void setPagerDao(PagerDao pagerDao) {
		PagerServiceImpl.pagerDao = pagerDao;
	}
	@Override
	public Pager getPager(String tableName) {
		return pagerDao.getPager(tableName);
	}

}
