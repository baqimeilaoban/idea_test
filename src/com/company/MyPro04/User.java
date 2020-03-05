package com.company.MyPro04;

/**
 * 测试构造方法的重载
 * @author 黄建波
 *
 */
public class User {

	/**
	 * id
	 */
	int id;
	/**
	 * 账户名
	 */
	String name;
	/**
	 * 密码
	 */
	String pwd;
	
	public User() {
		
	}
	
	public User(int id, String name) {
		//构造方法的第一句总是super
		super();
		//this表示创建好的id
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
		User u2 = new User(01, "高小七");
		User u3 = new User(100, "黄建波", "123456");
	}
}
