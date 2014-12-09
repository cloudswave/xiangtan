package com.xiangtan.dao;

import java.util.List;

import com.xiangtan.beans.Area;
/**
 * @author Shangyidong
 * @date 2014-11-21
 * @version 1.0
 */
public interface AreaDao {
	
	public Area get(String areaCode);
	
	public Area update(String areaCode, int areaLevel, String areaName, int subAreaNum);
	
	public boolean delete(Area area);
	
	public Area add(Area area);
	
	public List<Area> getSubAreasByCode(String areaCode);
}

/*
 *
 *	private String areaCode;
	private int areaLevel;
	private String areaName;
	private int subAreaNum;
 */
