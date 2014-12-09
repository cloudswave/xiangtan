package com.xiangtan.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.xiangtan.beans.Pager;

@WebService
public interface PagerService {

	@WebMethod
	public Pager getPager(String tableName);
}
