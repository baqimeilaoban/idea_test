package cn.sxt.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 接收端 基本流程
 * 1.使用DatagramSocket指定端口 创建接收端
 * 2.准备容器 封装成DatagramPacket包裹
 * 3.阻塞式接收包裹receive(DatagramPacket p)
 * 4.分析数据
 *  getData()
 *  getLength()
 * 5.释放资源
 * @author 黄建波
 */
public class UdpServer {
    public static void main(String[] args) throws IOException {
        System.out.println("接收方启动中。。。。");
        //使用DatagramSocket 指定端口 创建接受端
        DatagramSocket server = new DatagramSocket(9999);
        //准备容器 封装成DatagramPacket包裹
        byte[] container = new byte[1024];
        DatagramPacket packet = new DatagramPacket(container,0,container.length);
        //阻塞式接收新包裹
        server.receive(packet);
        //分析数据
        byte[] datas = packet.getData();
        int len = packet.getLength();
        System.out.println(new String(datas,0,len));
        //释放资源
        server.close();
    }
}
