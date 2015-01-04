package com.xiangtan.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.xiangtan.beans.Pager;

@WebService
public interface PagerWS {

	@WebMethod
	public Pager getPager(String tableName, String key);
}
