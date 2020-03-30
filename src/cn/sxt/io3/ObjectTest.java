package cn.sxt.io3;

import java.io.*;
import java.util.Date;

/**
 * 对象流
 * 1.写出后读取
 * 2.读取的顺序与写出保持一致
 * 3.不是所有的对象都可以序列化 Serializable
 * ObjectOutputStream
 * ObjectInputStream
 * @author thinkpad
 */
public class ObjectTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //写出-->序列化
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream dos = new ObjectOutputStream(new BufferedOutputStream(baos));
        //操作数据类型
        dos.writeUTF("编码辛酸泪");
        dos.writeInt(18);
        dos.writeBoolean(false);
        dos.writeChar('a');
        //对象
        dos.writeObject("谁解其中味");
        dos.writeObject(new Date());
        Employee employee = new Employee("马云",400);
        dos.writeObject(employee);
        dos.flush();
        byte[] datas = baos.toByteArray();
        System.out.println(datas.length);
        //读取
        ObjectInputStream dis = new ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
        //顺序与写出一致
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
