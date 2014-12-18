package com.xiangtan.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.xiangtan.beans.Role_lv;
import com.xiangtan.beans.Userinfo_lv;

/**
 * @author Shangyidong
 * @date 2014-11-21
 * @version 1.0
 */
@WebService
public interface Role_lvService {

	/**
	 * ����id��ѯ��ɫ
	 * @param id ��ɫid
	 * @return ��ѯ����Role_lv��������ѯʧ���򷵻�null
	 */
	@WebMethod
	public Role_lv getRole_lv(int id);
	
	/**
	 * ���ݽ�ɫ����ѯ��ɫ
	 * @param roleName ��ɫ����
	 * @return ��ѯ����Role_lv��������ѯʧ���򷵻�null
	 */
	@WebMethod
	public Role_lv getByRoleName(String roleName);
	
	/**
	 * ���ݽ�ɫ��ɾ����ɫ
	 * @param roleName ��ɫ����
	 * @return ��ɾ���ɹ��򷵻�true�����򷵻�false
	 */
	@WebMethod
	public boolean deleteByRoleName(String roleName);
	
	/**
	 * ���ݽ�ɫidɾ����ɫ
	 * @param id ��ɫid
	 * @return ��ɾ���ɹ��򷵻�true�����򷵻�false
	 */
	@WebMethod
	public boolean deleteByRoleId(int id);
	
	/**
	 * ��ӽ�ɫ
	 * @param roleName ��ɫ����
	 * @param type ��ɫ����
	 * @param desText ��ɫ��Ϣ
	 * @return ����ӳɹ��򷵻���ӳɹ���Role_lv���󡣷��򷵻�null
	 */
	@WebMethod
	public Role_lv addRole_lv(String roleName, String type, String desText);
	
	/**
	 * ���½�ɫ��Ϣ
	 * @param id ��ɫid
	 * @param roleName ��ɫ����
	 * @param type ��ɫ����
	 * @param desText ��ɫ��Ϣ
	 * @return ���ظ��³ɹ���Role_lv����������ʧ���򷵻�null
	 */
	@WebMethod
	public Role_lv updateRole_lv(int id, String roleName, String type, String desText);
	
	/***
	 * �����û�ID��ѯ�û������Ľ�ɫ
	 * @param userid �û�id
	 * @return
	 */
	@WebMethod
	public List<Role_lv> getRole_lvsByUserid(int userid);
	
	/***
	 * ��ѯ���н�ɫ
	 * @return
	 */
	@WebMethod
	public List<Role_lv> getAll();
	
	/**
	 * @param pageSize ÿҳ��¼��
	 * @param currentPage ��ǰҳ��
	 * @return
	 */
	@WebMethod
	public List<Role_lv> getRolesByPager(int pageSize, int currentPage);
}

/*
 * 	private int id;
	private String roleName;
	private String type;
	private String desText;
 */
