package com.xiangtan.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.xiangtan.beans.Userinfo_lv;

@WebService
public interface Userinfo_lvWS {
	/**
	 * �û���¼
	 * @param name �û���
	 * @param password ����
	 * @return ����¼�ɹ����򷵻��û����������Ӧ��Userinfo_lv���󡣷��򷵻�null��
	 */
	@WebMethod
	public Userinfo_lv login(String name, String password);
	
	/**
	 * ����û�
	 * @param name �û���
	 * @param password ����
	 * @param role ��ɫid
	 * @param groupid ��id
	 * @return ����ӳɹ����򷵻سɹ���ӵ�Userinfo_lv���󡣷��򷵻�null��
	 */
	@WebMethod
	public Userinfo_lv add(String name, String password, String email, String tel, String truename, String department, String note, String roleIds, String key);
	/**
	 * �����û�id��ѯUserinfo_lv����
	 * @param id �û�id
	 * @return ����ѯ�ɹ����򷵻ز�ѯ����Userinfo_lv���󡣷��򷵻�null��
	 */
	@WebMethod
	public Userinfo_lv getUserinfo_lv(int id, String key);
	
	/**
	 * �����û���Ϣ
	 * @param id
	 * @param name
	 * @param password
	 * @param email
	 * @param tel
	 * @param truename
	 * @param department
	 * @param note
	 * @param roleIds
	 * @return ���³ɹ���Userinfo_lv����
	 */
	@WebMethod
	public Userinfo_lv update(int id, String name, String password, String email, String tel, String truename, String department, String note, String roleIds, String key);
	
	/**
	 * �����û�name��ѯUserinfo_lv����
	 * @param name �û���
	 * @return ����ѯ�ɹ����򷵻ز�ѯ����Userinfo_lv���󡣷��򷵻�null��
	 */
	@WebMethod
	public Userinfo_lv getUserinfo_lvByName(String name, String key);
	
	/**
	 * �����û���ģ������
	 * @param name
	 * @return ����ѯ�ɹ����򷵻ز�ѯ����װ��Userinfo_lv��list�����򷵻�null��
	 */
	@WebMethod
	public List<Userinfo_lv> getUserinfo_lvsLikeSth(String name, String department, String truename, String key);
	
	/**
	 * �����û���ɫid��ѯװ��Userinfo_lv��list
	 * @param role �û���ɫid
	 * @return ����ѯ�ɹ����򷵻ز�ѯ����װ��Userinfo_lv��list�����򷵻�null��
	 */
	/*
	@WebMethod
	public List<Userinfo_lv> getUserinfo_lvsByRole(int role);
	*/
	/**
	 * �����û���id��ѯװ��Userinfo_lv��list
	 * @param groupid �û���id
	 * @return ����ѯ�ɹ����򷵻ز�ѯ����װ��Userinfo_lv��list�����򷵻�null��
	 */
	@WebMethod
	public List<Userinfo_lv> getUserinfo_lvsByGroupid(int groupid, String key);
	
	/**
	 * ����idɾ���û�
	 * @param id �û�id
	 * @return ��ɾ���ɹ��򷵻�true����ɾ��ʧ���򷵻�false
	 */
	@WebMethod
	public boolean deleteUserinfo_lv(int id, String key);
	
	/**
	 * ��ѯ�����û�
	 * @return ����ѯ�ɹ����򷵻ز�ѯ����װ��Userinfo_lv��list�����򷵻�null��
	 */
	@WebMethod
	public List<Userinfo_lv> getAll(String key);
	
	/**
	 * 
	 * @param pageSize ÿҳ��¼��
	 * @param currentPage ��ǰҳ��
	 * @return
	 */
	@WebMethod
	public List<Userinfo_lv> getUsersByPager(int pageSize, int currentPage, String key);
}
