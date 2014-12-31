package com.xiangtan.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.xiangtan.beans.Area;
import com.xiangtan.beans.Role_lv;

@WebService
public interface Role_lvWS {

		/**
		 * ����id��ѯ��ɫ
		 * @param id ��ɫid
		 * @return ��ѯ����Role_lv��������ѯʧ���򷵻�null
		 */
		@WebMethod
		public Role_lv getRole_lv(int id, String key);
		
		/**
		 * ���ݽ�ɫ����ѯ��ɫ
		 * @param roleName ��ɫ����
		 * @return ��ѯ����Role_lv��������ѯʧ���򷵻�null
		 */
		@WebMethod
		public Role_lv getByRoleName(String roleName, String key);
		
		/**
		 * ���ݽ�ɫ��ɾ����ɫ
		 * @param roleName ��ɫ����
		 * @return ��ɾ���ɹ��򷵻�true�����򷵻�false
		 */
		@WebMethod
		public boolean deleteByRoleName(String roleName, String key);
		
		/**
		 * ���ݽ�ɫidɾ����ɫ
		 * @param id ��ɫid
		 * @return ��ɾ���ɹ��򷵻�true�����򷵻�false
		 */
		@WebMethod
		public boolean deleteByRoleId(int id, String key);
		
		/**
		 * ��ӽ�ɫ
		 * @param roleName ��ɫ����
		 * @param type ��ɫ����
		 * @param desText ��ɫ��Ϣ
		 * @return ����ӳɹ��򷵻���ӳɹ���Role_lv���󡣷��򷵻�null
		 */
		@WebMethod
		public Role_lv addRole_lv(String roleName, String type, String desText, String key);
		
		/**
		 * ���½�ɫ��Ϣ
		 * @param id ��ɫid
		 * @param roleName ��ɫ����
		 * @param type ��ɫ����
		 * @param desText ��ɫ��Ϣ
		 * @return ���ظ��³ɹ���Role_lv����������ʧ���򷵻�null
		 */
		@WebMethod
		public Role_lv updateRole_lv(int id, String roleName, String type, String desText, String key);
		
		/***
		 * �����û�ID��ѯ�û������Ľ�ɫ
		 * @param userid �û�id
		 * @return
		 */
		@WebMethod
		public List<Role_lv> getRole_lvsByUserid(int userid, String key);
		
		/***
		 * ��ѯ���н�ɫ
		 * @return
		 */
		@WebMethod
		public List<Role_lv> getAll(String key);
		
		/**
		 * @param pageSize ÿҳ��¼��
		 * @param currentPage ��ǰҳ��
		 * @return
		 */
		@WebMethod
		public List<Role_lv> getRolesByPager(int pageSize, int currentPage, String key);
		
		/**
		 * 
		 * @param desText ����Ȩ�������ַ���
		 * @return
		 */
		@WebMethod
		public List<Area> getAreasByDesText(String desText, String key);
	}
