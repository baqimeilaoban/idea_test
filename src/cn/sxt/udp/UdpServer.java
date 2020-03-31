package cn.sxt.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * ���ն� ��������
 * 1.ʹ��DatagramSocketָ���˿� �������ն�
 * 2.׼������ ��װ��DatagramPacket����
 * 3.����ʽ���հ���receive(DatagramPacket p)
 * 4.��������
 *  getData()
 *  getLength()
 * 5.�ͷ���Դ
 * @author �ƽ���
 */
public class UdpServer {
    public static void main(String[] args) throws IOException {
        System.out.println("���շ������С�������");
        //ʹ��DatagramSocket ָ���˿� �������ܶ�
        DatagramSocket server = new DatagramSocket(9999);
        //׼������ ��װ��DatagramPacket����
        byte[] container = new byte[1024];
        DatagramPacket packet = new DatagramPacket(container,0,container.length);
        //����ʽ�����°���
        server.receive(packet);
        //��������
        byte[] datas = packet.getData();
        int len = packet.getLength();
        System.out.println(new String(datas,0,len));
        //�ͷ���Դ
        server.close();
    }
}
