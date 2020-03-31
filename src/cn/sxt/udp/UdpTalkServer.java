package cn.sxt.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * ��ν��������ն� ��������
 * 1.ʹ��DatagramSocketָ���˿� �������ն�
 * 2.׼������ ��װ��DatagramPacket����
 * 3.����ʽ���հ���receive(DatagramPacket p)
 * 4.��������
 *  getData()
 *  getLength()
 * 5.�ͷ���Դ
 * @author �ƽ���
 */
public class UdpTalkServer {
    public static void main(String[] args) throws IOException {
        System.out.println("���շ������С�����");
        //ʹ��DatagramSocketָ���˿� �������ն�
        DatagramSocket server = new DatagramSocket(6666);
        //׼������
        while (true){
            byte[] container = new byte[1024];
            DatagramPacket packet = new DatagramPacket(container,0,container.length);
            //����ʽ���հ���
            server.receive(packet);
            //��������
            byte[] datas = packet.getData();
            int len = packet.getLength();
            String data = new String(datas,0,len);
            System.out.println(data);
            if (data.equals("bye")){
                break;
            }
        }
        //�ͷ���Դ
        server.close();
    }
}
