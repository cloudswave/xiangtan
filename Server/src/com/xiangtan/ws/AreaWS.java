package com.xiangtan.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.xiangtan.beans.Area;

@WebService
public interface AreaWS {
	/**
	 * ����areaCode��ѯArea����
	 * @param areaCode ��������������
	 * @return ����ѯ�ɹ��򷵻ز�ѯ����Area���󣬷��򷵻�null��
	 */
	@WebMethod
	public Area getAreaByCode(String areaCode, String key);
	
	/**
	 * ����areaCode��ѯ�õ������Ӽ�����
	 * @param areaCode
	 * @return areaCode��Ӧ�������Ӽ�����
	 */
	@WebMethod
	public List<Area> getSubAreasByCode(String areaCode, String key);
}
