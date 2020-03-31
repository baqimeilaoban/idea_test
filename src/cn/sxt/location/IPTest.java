package cn.sxt.location;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * ip.定位一个节点：计算机、路由、通信设备
 * InetAddress:提供多个静态方法
 * 1.getLocalHost:本机
 * 2.getByName:根据域名DNS IP地址 --->IP
 * 两个成员方法：
 * 1.getHostAddress:返回地址
 * 2.getHostName:返回计算机名
 *
 * @author 黄建波
 */
public class IPTest {
    public static void main(String[] args) throws UnknownHostException {
        //使用getLocalHost方法创建InetAddress对象
        InetAddress addr = InetAddress.getLocalHost();
        //返回ip地址
        System.out.println(addr.getHostAddress());
        //输出计算机名
        System.out.println(addr.getHostName());
        System.out.println("----------------------------");
        //根据域名得到InetAddress对象
        addr = InetAddress.getByName("www.163.com");
        //返回163服务器的ip
        System.out.println(addr.getHostAddress());
        //输出；www.163.com
        System.out.println(addr.getHostName());
        System.out.println("----------------------------");

    }
}
