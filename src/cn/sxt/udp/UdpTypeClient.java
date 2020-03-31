package cn.sxt.udp;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * �������ͷ��Ͷ� ��������
 * 1.ʹ��DatagramSocket ָ���˿� �������Ͷ�
 * 2.����������ת���ֽ�����
 * 3.��װ��DatagramPacket��������Ҫָ��Ŀ�ĵ�
 * 4.���Ͱ���send(DatagramPacket p)
 * 5.�ͷ���Դ
 * @author �ƽ���
 */
public class UdpTypeClient {
    public static void main(String[] args) throws IOException {
        System.out.println("���ͷ������С�������");
        //ʹ��DatagramSocket ָ���˿� �������Ͷ�
        DatagramSocket client = new DatagramSocket(8888);
        //����������ת���ֽ�����
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(baos));
        dos.writeUTF("����������");
        dos.writeInt(18);
        dos.writeBoolean(false);
        dos.writeChar('a');
        dos.flush();
        byte[] datas = baos.toByteArray();
        //��װ��DatagramPacket��������Ҫָ��Ŀ�ĵ�
        DatagramPacket packet = new DatagramPacket(datas,0,datas.length,
                new InetSocketAddress("localhost",6666));
        //���Ͱ���
        client.send(packet);
        //�ͷ���Դ
        client.close();
    }
}
