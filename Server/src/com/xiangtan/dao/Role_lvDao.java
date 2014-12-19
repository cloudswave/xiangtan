package com.xiangtan.dao;

import java.util.List;

import com.xiangtan.beans.Role_lv;
import com.xiangtan.beans.Userinfo_lv;
/**
 * @author Shangyidong
 * @date 2014-11-21
 * @version 1.0
 */
public interface Role_lvDao {

	/**
	 * ����µĽ�ɫ
	 * @param roleName ��ɫ��
	 * @param type ��ɫ����
	 * @param desText ��ɫ��Ϣ
	 * @return ���سɹ���ӵĽ�ɫ������Ӳ��ɹ��򷵻�null��
	 */
	public Role_lv add(String roleName, String type, String desText);
	
	/**
	 * ���ݽ�ɫidɾ����ɫ
	 * @param id ��ɫid
	 * @return ��ɾ���ɹ��򷵻�true�����򷵻�false
	 */
	public boolean delete(int id);
	
	/**
	 * ���ݽ�ɫ��ɾ����ɫ
	 * @param roleName ��ɫ��
	 * @return ��ɾ���ɹ��򷵻�true�����򷵻�false
	 */
	public boolean deleteByRoleName(String roleName);
	
	/**
	 * ����id��ѯ��ɫ
	 * @param id ��ɫid
	 * @return ���ز�ѯ����Role_lv��������ѯ���ɹ��򷵻�null��
	 */
	public Role_lv get(int id);
	
	/**
	 * ���ݽ�ɫ����ѯ��ɫ
	 * @param roleName ��ɫ��
	 * @return ���ز�ѯ����Role_lv��������ѯ���ɹ��򷵻�null��
	 */
	public Role_lv getByRoleName(String roleName);
	
	/**
	 * ���½�ɫ��Ϣ
	 * @param id ��ɫid
	 * @param roleName ��ɫ����
	 * @param type ��ɫ����
	 * @param desText ��ɫ��Ϣ
	 * @return ���سɹ����µ�Role_lv����
	 */
	public Role_lv update(int id, String roleName, String type, String desText);
	
	/***
	 * �����û�ID��ѯ�û������Ľ�ɫ
	 * @param userid �û�id
	 * @return
	 */
	public List<Role_lv> getRole_lvsByUserid(int userid);
	
	/**
	 * ��ѯ���н�ɫ
	 * @return
	 */
	public List<Role_lv> getAll();
	
	/**
	 * @param pageSize ÿҳ�ļ�¼��
	 * @param currentPage ��ǰҳ��
	 * @return
	 */
	public List<Role_lv> getRolesByPager(int pageSize, int currentPage);
}

/*
 * 
 * 	private int id;
	private String roleName;
	private String type;
	private String desText;
 */
