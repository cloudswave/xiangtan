package com.xiangtan.service.impl;

import com.xiangtan.beans.Area;
import com.xiangtan.dao.AreaDao;
import com.xiangtan.service.AreaService;
//@Service("areaService")
public class AreaServiceImpl implements AreaService{

	//@Resource
	private static AreaDao areaDao;
	
	public void setAreaDao(AreaDao areaDao) {
//		System.out.println("set..." + areaDao);
		AreaServiceImpl.areaDao = areaDao;
	}

	@Override
	public Area getAreaByCode(String areaCode) {
		//如果areaCode为null或""或长度不合法则返回null
		if (areaCode == null || areaCode.equals("") || areaCode.length() != 12) {
			return null;
		}
		//保证进行数据库查询的时候areaCode一定的合法的
		Area area = areaDao.get(areaCode);
		System.out.println(area);
		return area;
	}
}
