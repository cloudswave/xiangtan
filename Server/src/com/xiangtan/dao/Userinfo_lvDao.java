package com.xiangtan.dao;

import java.util.List;

import com.xiangtan.beans.Userinfo_lv;
/**
 * @author Shangyidong
 * @date 2014-11-21
 * @version 1.0
 */
public interface Userinfo_lvDao {
	public Userinfo_lv get(String name, String password);
	
	public Userinfo_lv add(String name, String password, int role, int groupid);
	
	/**
	 * ����idɾ���û�
	 * @param id �û�id
	 * @return ��ɾ���ɹ��򷵻�true�����򷵻�false
	 */
	public boolean delete(int id);
	
	/**
	 * ����id��ѯ�û�
	 * @param id �û�id
	 * @return ���ز�ѯ����Userinfo_lv��������ѯʧ�ܷ���null
	 */
	public Userinfo_lv get(int id);
	
	/**
	 * �����û�����ѯ�û�
	 * @param name �û���
	 * @return ���ز�ѯ����Userinfo_lv��������ѯʧ�ܷ���null
	 */
	public Userinfo_lv get(String name);
	
	/**
	 * �����û���ɫid��ѯ�û�
	 * @param role �û���ɫid
	 * @return ���ز�ѯ����װ������������Userinfo_lv��list������ѯʧ���򷵻�null��
	 */
	public List<Userinfo_lv> getByRole(int role);
	
	/**
	 * �����û���id��ѯ�û�
	 * @param groupid �û���id
	 * @return ���ز�ѯ����װ������������Userinfo_lv��list������ѯʧ���򷵻�null��
	 */
	public List<Userinfo_lv> getByGroupid(int groupid);
	
	/**
	 * �����û���Ϣ
	 * @param id �û�id
	 * @param name �û���
	 * @param role �û���ɫid
	 * @param password �û�����
	 * @param groupid �û���id
	 * @return ���³ɹ���Userinfo_lv����������ʧ���򷵻�null��
	 */
	public Userinfo_lv update(int id, String name, int role, String password, int groupid);
}

/**
private int id;
private String name;
private int role;
private String password;
private int groupid;
*/