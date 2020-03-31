package cn.sxt.udp;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Date;

/**
 * 引用类型：接收端 基本流程
 * 1.使用DatagramSocket指定端口 创建接收端
 * 2.准备容器 封装成DatagramPacket包裹
 * 3.阻塞式接收包裹receive(DatagramPacket p)
 * 4.分析数据 将字节数组还原为对应得类型
 *  getData()
 *  getLength()
 * 5.释放资源
 * @author 黄建波
 */
public class UdpObjServer {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("接收端启动中。。。");
        //使用DatagramSocket指定端口 创建接收端
        DatagramSocket server = new DatagramSocket(6666);
        //准备容器 封装成DatagramPacket包裹
        byte[] container = new byte[1024];
        DatagramPacket packet = new DatagramPacket(container,0,container.length);
        //阻塞式接收包裹
        server.receive(packet);
        //分析数据
        byte[] datas = packet.getData();
        int len = packet.getLength();
        ObjectInputStream dis = new ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
        String msg = dis.readUTF();
        int age = dis.readInt();
        boolean flag = dis.readBoolean();
        char ch = dis.readChar();
        System.out.println(flag);
        Object str = dis.readObject();
        Object date = dis.readObject();
        Object employee = dis.readObject();
        if (str instanceof String){
            String strObj = (String)str;
            System.out.println(strObj);
        }
        if (date instanceof Date){
            Date dateObj = (Date)date;
            System.out.println(dateObj);
        }
        if (employee instanceof Employee){
            Employee empObj = (Employee) employee;
            System.out.println(empObj.getName() + "--->" + empObj.getSalary());
        }
        //释放资源
        server.close();
    }
}
