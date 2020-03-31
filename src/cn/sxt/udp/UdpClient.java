package cn.sxt.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * 发送端 基本流程
 * 1.使用DatagramSocket 指定端口 创建发送端
 * 2.准备数据 一定转成字节数组
 * 3.封装成DatagramPacket包裹，需要指定目的地
 * 4.发送包裹send(DatagramPacket p)
 * 5.释放资源
 * @author 黄建波
 */
public class UdpClient {
    public static void main(String[] args) throws IOException {
        System.out.println("发送方启动中。。。。。");
        //使用DatagramSocket 指定端口 创建发送端
        DatagramSocket client = new DatagramSocket(8888);
        //准备数据 一定要转为字节数组
        String data = "上海尚学堂";
        byte[] datas = data.getBytes();
        //封装成DatagramPacket包裹，需要指定目的地
        DatagramPacket packet = new DatagramPacket(datas,0,datas.length,new InetSocketAddress("localhost",9999));
        //发送包裹
        client.send(packet);
        //释放资源
        client.close();
    }
}
