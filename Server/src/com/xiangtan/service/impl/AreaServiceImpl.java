package com.xiangtan.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xiangtan.beans.Area;
import com.xiangtan.dao.AreaDao;
import com.xiangtan.service.AreaService;
//@Service("areaService")
/**
 * @author Shangyidong
 * @date 2014-11-21
 * @version 1.0
 */
public class AreaServiceImpl implements AreaService{

	//@Resource
	private static AreaDao areaDao;
	
	public void setAreaDao(AreaDao areaDao) {
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

	@Override
	public List<Area> getSubAreasByCode(String areaCode) {
		return areaDao.getSubAreasByCode(areaCode);
	}
}
