package com.xiangtan.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.xiangtan.beans.Area;
@WebService
public interface AreaService {

	/**
	 * ����areaCode��ѯArea
	 * @param areaCode
	 * @return Area����
	 */
	@WebMethod
	public Area getAreaByCode(String areaCode);
	
}
