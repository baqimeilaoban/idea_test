package cn.sxt.udp;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.util.Date;

/**
 * 引用类型发送端 基本流程
 * 1.使用DatagramSocket 指定端口 创建发送端
 * 2.将基本类型转成字节数组
 * 3.封装成DatagramPacket包裹，需要指定目的地
 * 4.发送包裹send(DatagramPacket p)
 * 5.释放资源
 * @author 黄建波
 */
public class UdpObjClient {
    public static void main(String[] args) throws IOException {
        System.out.println("发送端启动中。。。");
        //使用DatagramSocket 指定端口 创建发送端
        DatagramSocket client = new DatagramSocket(8888);
        //转为字节数组
        ByteOutputStream baos = new ByteOutputStream();
        ObjectOutputStream dos = new ObjectOutputStream(new BufferedOutputStream(baos));
        dos.writeUTF("编码辛酸泪");
        dos.writeInt(18);
        dos.writeBoolean(false);
        dos.writeChar('a');
        dos.writeObject("谁解其中味");
        dos.writeObject(new Date());
        Employee employee = new Employee("马云",400);
        dos.writeObject(employee);
        dos.flush();
        byte[] datas = baos.toByteArray();
        //封装成DatagramPacket包裹，需要指定目的地
        DatagramPacket packet = new DatagramPacket(datas,0,datas.length,new InetSocketAddress("localhost",6666));
        //发送包裹
        client.send(packet);
        //释放资源
        client.close();
    }
}
