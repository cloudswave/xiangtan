package com.xiangtan.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.xiangtan.beans.Area;

@WebService
public interface AreaWS {
	/**
	 * 根据areaCode查询Area对象
	 * @param areaCode 主键，地区编码
	 * @return 若查询成功则返回查询到的Area对象，否则返回null。
	 */
	@WebMethod
	public Area getAreaByCode(String areaCode, String key);
	
	/**
	 * 根据areaCode查询该地区的子级地区
	 * @param areaCode
	 * @return areaCode对应地区的子级地区
	 */
	@WebMethod
	public List<Area> getSubAreasByCode(String areaCode, String key);
}
