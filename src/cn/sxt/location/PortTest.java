package cn.sxt.location;

import java.net.InetSocketAddress;

/**
 * �˿�
 * 1.�������
 * 2.2���ֽ�0-65535 UDP TCP
 * 3.ͬһЭ��˿ڲ��ܳ�ͻ
 * 4.����˿�Խ��Խ��
 *
 * ������
 * new InetSocketAddress(��ַ|�������˿�)
 *
 * ����
 * 1.getAddress()
 * 2.getPort()
 * 3.getHostName()
 * @author �ƽ���
 */
public class PortTest {
    public static void main(String[] args) {
        //�����˿�
        InetSocketAddress socketAddress = new InetSocketAddress("127.0.0.1",8080);
        InetSocketAddress socketAddress1 = new InetSocketAddress("localhost",9000);
        System.out.println(socketAddress.getHostName());
        System.out.println(socketAddress1.getAddress());
        System.out.println(socketAddress.getPort());
    }
}
