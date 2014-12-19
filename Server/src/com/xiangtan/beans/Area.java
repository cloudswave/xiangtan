package com.xiangtan.beans;
/**
 * @author Shangyidong
 * @date 2014-11-21
 * @version 1.0
 */
public class Area {
	private String areaCode;
	private int areaLevel;
	private String areaName;
	private int subAreaNum;
	private String completeAddress;
	

	public String getCompleteAddress() {
		return completeAddress;
	}

	public void setCompleteAddress(String completeAddress) {
		this.completeAddress = completeAddress;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public int getAreaLevel() {
		return areaLevel;
	}

	public String getAreaName() {
		return areaName;
	}

	public int getSubAreaNum() {
		return subAreaNum;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public void setAreaLevel(int areaLevel) {
		this.areaLevel = areaLevel;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public void setSubAreaNum(int subAreaNum) {
		this.subAreaNum = subAreaNum;
	}

	public Area(String areaCode, int areaLevel, String areaName, int subAreaNum) {
		super();
		this.areaCode = areaCode;
		this.areaLevel = areaLevel;
		this.areaName = areaName;
		this.subAreaNum = subAreaNum;
	}
//
	public Area() {
		super();
	}

	@Override
	public String toString() {
		return "Area [areaCode=" + areaCode + ", areaLevel=" + areaLevel
				+ ", areaName=" + areaName + ", subAreaNum=" + subAreaNum
				+ ", completeAddress=" + completeAddress + "]";
	}

}
