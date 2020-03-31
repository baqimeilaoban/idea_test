package cn.sxt.udp;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.util.Date;

/**
 * �������ͷ��Ͷ� ��������
 * 1.ʹ��DatagramSocket ָ���˿� �������Ͷ�
 * 2.����������ת���ֽ�����
 * 3.��װ��DatagramPacket��������Ҫָ��Ŀ�ĵ�
 * 4.���Ͱ���send(DatagramPacket p)
 * 5.�ͷ���Դ
 * @author �ƽ���
 */
public class UdpObjClient {
    public static void main(String[] args) throws IOException {
        System.out.println("���Ͷ������С�����");
        //ʹ��DatagramSocket ָ���˿� �������Ͷ�
        DatagramSocket client = new DatagramSocket(8888);
        //תΪ�ֽ�����
        ByteOutputStream baos = new ByteOutputStream();
        ObjectOutputStream dos = new ObjectOutputStream(new BufferedOutputStream(baos));
        dos.writeUTF("����������");
        dos.writeInt(18);
        dos.writeBoolean(false);
        dos.writeChar('a');
        dos.writeObject("˭������ζ");
        dos.writeObject(new Date());
        Employee employee = new Employee("����",400);
        dos.writeObject(employee);
        dos.flush();
        byte[] datas = baos.toByteArray();
        //��װ��DatagramPacket��������Ҫָ��Ŀ�ĵ�
        DatagramPacket packet = new DatagramPacket(datas,0,datas.length,new InetSocketAddress("localhost",6666));
        //���Ͱ���
        client.send(packet);
        //�ͷ���Դ
        client.close();
    }
}
