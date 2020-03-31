package cn.sxt.location;

import java.net.InetSocketAddress;

/**
 * 端口
 * 1.区分软件
 * 2.2个字节0-65535 UDP TCP
 * 3.同一协议端口不能冲突
 * 4.定义端口越大越好
 *
 * 构造器
 * new InetSocketAddress(地址|域名，端口)
 *
 * 方法
 * 1.getAddress()
 * 2.getPort()
 * 3.getHostName()
 * @author 黄建波
 */
public class PortTest {
    public static void main(String[] args) {
        //包含端口
        InetSocketAddress socketAddress = new InetSocketAddress("127.0.0.1",8080);
        InetSocketAddress socketAddress1 = new InetSocketAddress("localhost",9000);
        System.out.println(socketAddress.getHostName());
        System.out.println(socketAddress1.getAddress());
        System.out.println(socketAddress.getPort());
    }
}
