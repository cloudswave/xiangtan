package com.xiangtan.utils;
/**
 * @author Shangyidong
 * @date 2014-11-11
 * @version 1.0
 */
public class AreaUtil {
	
	public static int getAreaLevelByCode(String areaCode) {
		int areaLevel = 0;
		if (areaCode.contains("000000000000")) {
			areaLevel = 1;
		}else if (areaCode.contains("0000000000")) {
			areaLevel = 2;//ʡ
		}else if (areaCode.contains("00000000")) {
			areaLevel = 3;//��
		}else if (areaCode.contains("000000")) {
			areaLevel = 4;//��
		}else if (areaCode.contains("000")) {
			areaLevel = 5;//��
		}else{
			areaLevel = 6;//��
		}
		return areaLevel;
	}
}
