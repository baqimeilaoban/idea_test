package com.company.MyPro04;

/**
 * ���Թ��췽��������
 * @author �ƽ���
 *
 */
public class User {

	/**
	 * id
	 */
	int id;
	/**
	 * �˻���
	 */
	String name;
	/**
	 * ����
	 */
	String pwd;
	
	public User() {
		
	}
	
	public User(int id, String name) {
		//���췽���ĵ�һ������super
		super();
		//this��ʾ�����õ�id
		this.id = id;
		this.name = name;
	}
	
	public User(int id, String name, String pwd) {
		this.id = id;
		this.name = name;
		this.pwd = pwd;
	}

	public static void main(String[] args) {
		User u1 = new User();
		User u2 = new User(01, "��С��");
		User u3 = new User(100, "�ƽ���", "123456");
	}
}
