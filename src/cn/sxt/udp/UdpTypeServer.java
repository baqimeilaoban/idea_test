package cn.sxt.udp;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * �������ͣ����ն� ��������
 * 1.ʹ��DatagramSocketָ���˿� �������ն�
 * 2.׼������ ��װ��DatagramPacket����
 * 3.����ʽ���հ���receive(DatagramPacket p)
 * 4.�������� ���ֽ����黹ԭΪ��Ӧ������
 *  getData()
 *  getLength()
 * 5.�ͷ���Դ
 * @author �ƽ���
 */
public class UdpTypeServer {
    public static void main(String[] args) throws IOException {
        System.out.println("���ն������С�������");
        //ʹ��DatagramSocketָ���˿� �������ն�
        DatagramSocket server = new DatagramSocket(6666);
        //׼����������װ��DatagramPacket����
        byte[] container = new byte[1024];
        DatagramPacket packet = new DatagramPacket(container,0,container.length);
        //����ʽ���հ���
        server.receive(packet);
        //��������
        byte[] datas = packet.getData();
        int len = datas.length;
        DataInputStream dis = new DataInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
        String msg = dis.readUTF();
        int age = dis.readInt();
        boolean flag = dis.readBoolean();
        char ch = dis.readChar();
        System.out.println(msg + "--->" + flag);
        //�ͷ���Դ
        server.close();
    }
}
