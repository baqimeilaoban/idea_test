package cn.sxt.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * ���Ͷ� ��������
 * 1.ʹ��DatagramSocket ָ���˿� �������Ͷ�
 * 2.׼������ һ��ת���ֽ�����
 * 3.��װ��DatagramPacket��������Ҫָ��Ŀ�ĵ�
 * 4.���Ͱ���send(DatagramPacket p)
 * 5.�ͷ���Դ
 * @author �ƽ���
 */
public class UdpClient {
    public static void main(String[] args) throws IOException {
        System.out.println("���ͷ������С���������");
        //ʹ��DatagramSocket ָ���˿� �������Ͷ�
        DatagramSocket client = new DatagramSocket(8888);
        //׼������ һ��ҪתΪ�ֽ�����
        String data = "�Ϻ���ѧ��";
        byte[] datas = data.getBytes();
        //��װ��DatagramPacket��������Ҫָ��Ŀ�ĵ�
        DatagramPacket packet = new DatagramPacket(datas,0,datas.length,new InetSocketAddress("localhost",9999));
        //���Ͱ���
        client.send(packet);
        //�ͷ���Դ
        client.close();
    }
}
