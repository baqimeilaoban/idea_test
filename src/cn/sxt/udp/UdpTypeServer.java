package cn.sxt.udp;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 基本类型：接收端 基本流程
 * 1.使用DatagramSocket指定端口 创建接收端
 * 2.准备容器 封装成DatagramPacket包裹
 * 3.阻塞式接收包裹receive(DatagramPacket p)
 * 4.分析数据 将字节数组还原为对应得类型
 *  getData()
 *  getLength()
 * 5.释放资源
 * @author 黄建波
 */
public class UdpTypeServer {
    public static void main(String[] args) throws IOException {
        System.out.println("接收端启动中。。。。");
        //使用DatagramSocket指定端口 创建接收端
        DatagramSocket server = new DatagramSocket(6666);
        //准备容器，封装成DatagramPacket包裹
        byte[] container = new byte[1024];
        DatagramPacket packet = new DatagramPacket(container,0,container.length);
        //阻塞式接收包裹
        server.receive(packet);
        //分析数据
        byte[] datas = packet.getData();
        int len = datas.length;
        DataInputStream dis = new DataInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
        String msg = dis.readUTF();
        int age = dis.readInt();
        boolean flag = dis.readBoolean();
        char ch = dis.readChar();
        System.out.println(msg + "--->" + flag);
        //释放资源
        server.close();
    }
}
