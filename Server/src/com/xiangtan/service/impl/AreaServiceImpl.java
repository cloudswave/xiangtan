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
		//���areaCodeΪnull��""�򳤶Ȳ��Ϸ��򷵻�null
		if (areaCode == null || areaCode.equals("") || areaCode.length() != 12) {
			return null;
		}
		//��֤�������ݿ��ѯ��ʱ��areaCodeһ���ĺϷ���
		Area area = areaDao.get(areaCode);
		System.out.println(area);
		return area;
	}
}
