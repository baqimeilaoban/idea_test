package cn.sxt.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * �ļ������ն� ��������
 * 1.ʹ��DatagramSocketָ���˿� �������ն�
 * 2.׼������ ��װ��DatagramPacket����
 * 3.����ʽ���հ���receive(DatagramPacket p)
 * 4.�������� ���ֽ����黹ԭΪ��Ӧ������
 *  getData()
 *  getLength()
 * 5.�ͷ���Դ
 * @author �ƽ���
 */
public class UdpFileServer {
    public static void main(String[] args) throws IOException {
        System.out.println("���ն������С�����");
        //ʹ��DatagramSocketָ���˿� �������ն�
        DatagramSocket server = new DatagramSocket(6666);
        //׼������ ��װ��DatagramPacket����
        byte[] container = new byte[1024*60];
        DatagramPacket packet = new DatagramPacket(container,0,container.length);
        //����ʽ���հ���
        server.receive(packet);
        //��������
        byte[] datas = packet.getData();
        int len = packet.getLength();
        IOUtils.byteArrayToFile(datas,"src/cn/sxt/udp/logo-copy.png");
        //�ͷ���Դ
        server.close();
    }
}
