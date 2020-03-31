package cn.sxt.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * 文件发送端 基本流程
 * 1.使用DatagramSocket 指定端口 创建发送端
 * 2.将基本类型转成字节数组
 * 3.封装成DatagramPacket包裹，需要指定目的地
 * 4.发送包裹send(DatagramPacket p)
 * 5.释放资源
 * @author 黄建波
 */
public class UdpFileClient {
    public static void main(String[] args)throws IOException {
        System.out.println("发送端启动中。。。");
        //使用DatagramSocket指定端口 创建发送端
        DatagramSocket client = new DatagramSocket(8888);
        //文件转为字节数组
        byte[] datas = IOUtils.fileToByteArray("src/cn/sxt/udp/logo.png");
        //封装成DatagramPacket包裹，需要指定目的地
        DatagramPacket packet = new DatagramPacket(datas,0,datas.length,
                new InetSocketAddress("localhost",6666));
        //发送包裹send
        client.send(packet);
        //释放资源
        client.close();

    }
}
