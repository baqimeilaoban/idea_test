package com.company.MyPro04;

/**
 *
 * @author 黄建波
 *
 */
public class SxtStu {

	int id;
	String name;
	int age;
	
	Computer comp;
	
	void study() {
		System.out.println("��������ѧϰ��ʹ�õ��ԣ�" + comp.brand);
	}
	
	void play() {
		System.out.println("�Ұ�����Ϸ����");
	}

	public SxtStu() {
		// TODO Auto-generated constructor stub
	}
	
	//����ִ�����
	public static void main(String[] args) {
		//创建一个对象
		SxtStu stu = new SxtStu();
		stu.play();
		stu.id = 1001;
		stu.name = "�ƽ���";
		stu.age = 18;
		
		Computer c1 = new Computer();
		c1.brand = "����";
		
		stu.comp = c1;
		
		stu.play();
		stu.study();
	}
}

class Computer{
	String brand;
	
}
