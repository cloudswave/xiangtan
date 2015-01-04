package com.xiangtan.ws.impl;

import java.util.List;

import com.xiangtan.beans.Area;
import com.xiangtan.service.AreaService;
import com.xiangtan.ws.AreaWS;

public class AreaWSImpl implements AreaWS{

	private static AreaService areaService;
	public static void setAreaService(AreaService areaService) {
		AreaWSImpl.areaService = areaService;
	}
	@Override
	public Area getAreaByCode(String areaCode, String key) {
		// TODO Auto-generated method stub
		return areaService.getAreaByCode(areaCode, key);
	}


	@Override
	public List<Area> getSubAreasByCode(String areaCode, String key) {
		return areaService.getSubAreasByCode(areaCode, key);
	}

}
