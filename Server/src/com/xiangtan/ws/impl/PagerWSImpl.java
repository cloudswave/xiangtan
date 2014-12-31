package com.xiangtan.ws.impl;

import com.xiangtan.beans.Pager;
import com.xiangtan.service.PagerService;
import com.xiangtan.ws.PagerWS;

public class PagerWSImpl implements PagerWS{

	private static PagerService pagerService;
	public static void setPagerService(PagerService pagerService) {
		PagerWSImpl.pagerService = pagerService;
	}
	@Override
	public Pager getPager(String tableName, String key) {
		// TODO Auto-generated method stub
		return pagerService.getPager(tableName, key);
	}

}
