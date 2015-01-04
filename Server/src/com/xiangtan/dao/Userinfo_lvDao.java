package com.xiangtan.dao;

import java.util.List;

import com.xiangtan.beans.Userinfo_lv;
/**
 * @author Shangyidong
 * @date 2014-11-21
 * @version 1.0
 */
public interface Userinfo_lvDao {
	/*
	public Userinfo_lv get(String name, String password);
	*/
	
	public Userinfo_lv add(String name, String password, String email, String tel, String truename, String department, String note);
	
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
	//public List<Userinfo_lv> getByRole(int role);
	
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
	public Userinfo_lv update(int id, String name, String password, String email, String tel, String truename, String department, String note);

	/**
	 * ��ѯ�����û�
	 * @return ����ѯ�ɹ����򷵻ز�ѯ����װ��Userinfo_lv��list�����򷵻�null��
	 */
	public List<Userinfo_lv> getAll();
	
	/**
	 * 
	 * @param pageSize ÿҳ�ļ�¼��
	 * @param currentPage ��ǰҳ��
	 * @return
	 */
	public List<Userinfo_lv> getUsersByPager(int pageSize, int currentPage);
	
	/**
	 * �����û���ģ������
	 * @param name
	 * @return ����ѯ�ɹ����򷵻ز�ѯ����װ��Userinfo_lv��list�����򷵻�null��
	 */
	public List<Userinfo_lv> getUserinfo_lvsLikeName(String name);
	
	/**
	 * ���ݲ���ģ������
	 * @param department
	 * @return ����ѯ�ɹ����򷵻ز�ѯ����װ��Userinfo_lv��list�����򷵻�null��
	 */
	public List<Userinfo_lv> getUserinfo_lvsLikeDepartment(String department);
	
	/**
	 * ������ʵ����ģ������
	 * @param truename
	 * @return ����ѯ�ɹ����򷵻ز�ѯ����װ��Userinfo_lv��list�����򷵻�null��
	 */
	public List<Userinfo_lv> getUserinfo_lvsLikeTruename(String truename);
	
	//public Userinfo_lv update(int id, String name, String password,String email, String tel, String truename, String department,String note);
}

/**
private int id;
private String name;
private int role;
private String password;
private int groupid;
*/