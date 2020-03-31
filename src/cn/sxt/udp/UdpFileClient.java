package cn.sxt.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * �ļ����Ͷ� ��������
 * 1.ʹ��DatagramSocket ָ���˿� �������Ͷ�
 * 2.����������ת���ֽ�����
 * 3.��װ��DatagramPacket��������Ҫָ��Ŀ�ĵ�
 * 4.���Ͱ���send(DatagramPacket p)
 * 5.�ͷ���Դ
 * @author �ƽ���
 */
public class UdpFileClient {
    public static void main(String[] args)throws IOException {
        System.out.println("���Ͷ������С�����");
        //ʹ��DatagramSocketָ���˿� �������Ͷ�
        DatagramSocket client = new DatagramSocket(8888);
        //�ļ�תΪ�ֽ�����
        byte[] datas = IOUtils.fileToByteArray("src/cn/sxt/udp/logo.png");
        //��װ��DatagramPacket��������Ҫָ��Ŀ�ĵ�
        DatagramPacket packet = new DatagramPacket(datas,0,datas.length,
                new InetSocketAddress("localhost",6666));
        //���Ͱ���send
        client.send(packet);
        //�ͷ���Դ
        client.close();

    }
}
