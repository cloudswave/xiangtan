package com.xiangtan.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.xiangtan.beans.Userinfo_lv;
@WebService
public interface Userinfo_lvService {
	
	/**
	 * �û���¼
	 * @param name �û���
	 * @param password ����
	 * @return �����¼�ɹ����򷵻ص�¼�ɹ���Userinfo_lv���󡣷��򷵻�null
	 */
	@WebMethod
	public Userinfo_lv login(String name, String password);
}
