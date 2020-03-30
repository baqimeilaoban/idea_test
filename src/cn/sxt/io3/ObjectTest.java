package cn.sxt.io3;

import java.io.*;
import java.util.Date;

/**
 * ������
 * 1.д�����ȡ
 * 2.��ȡ��˳����д������һ��
 * 3.�������еĶ��󶼿������л� Serializable
 * ObjectOutputStream
 * ObjectInputStream
 * @author thinkpad
 */
public class ObjectTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //д��-->���л�
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream dos = new ObjectOutputStream(new BufferedOutputStream(baos));
        //������������
        dos.writeUTF("����������");
        dos.writeInt(18);
        dos.writeBoolean(false);
        dos.writeChar('a');
        //����
        dos.writeObject("˭������ζ");
        dos.writeObject(new Date());
        Employee employee = new Employee("����",400);
        dos.writeObject(employee);
        dos.flush();
        byte[] datas = baos.toByteArray();
        System.out.println(datas.length);
        //��ȡ
        ObjectInputStream dis = new ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
        //˳����д��һ��
        String msg = dis.readUTF();
        int age = dis.readInt();
        boolean flag = dis.readBoolean();
        char ch = dis.readChar();
        System.out.println(flag);
        Object str = dis.readObject();
        Object date = dis.readObject();
        Object emp = dis.readObject();

        if (str instanceof String){
            String strObj = (String)str;
            System.out.println(strObj);
        }

        if (date instanceof Date){
            Date dateObj = (Date)date;
            System.out.println(dateObj);
        }

        if (employee instanceof Employee){
            Employee empObj = employee;
            System.out.println(empObj.getName() + "--->" + empObj.getSalary());
        }
    }
}

class Employee implements java.io.Serializable{
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public Employee() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
