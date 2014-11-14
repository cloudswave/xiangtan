package com.xiangtan.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.xiangtan.beans.Area;
@WebService
public interface AreaService {

	/**
	 * 根据areaCode查询Area
	 * @param areaCode
	 * @return Area对象
	 */
	@WebMethod
	public Area getAreaByCode(String areaCode);
	
}
