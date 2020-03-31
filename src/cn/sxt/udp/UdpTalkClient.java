package cn.sxt.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * ��ν��������Ͷ� ��������
 * 1.ʹ��DatagramSocket ָ���˿� �������Ͷ�
 * 2.׼������ һ��ת���ֽ�����
 * 3.��װ��DatagramPacket��������Ҫָ��Ŀ�ĵ�
 * 4.���Ͱ���send(DatagramPacket p)
 * 5.�ͷ���Դ
 * @author �ƽ���
 */
public class UdpTalkClient {
    public static void main(String[] args) throws IOException {
        System.out.println("���ͷ������С�����");
        //ʹ��DatagramSocket ָ���˿� �������Ͷ�
        DatagramSocket client = new DatagramSocket(8888);
        while (true){
            //׼������ תΪ�ֽ�����
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String data = reader.readLine();
            byte[] datas = data.getBytes();
            //��װ��DatagramPacket��������ָ��Ŀ�ĵ�
            DatagramPacket packet = new DatagramPacket(datas,0,datas.length,
                    new InetSocketAddress("localhost",6666));
            //���Ͱ���
            client.send(packet);
            if (data.equals("bye")){
                break;
            }
        }
        //�ͷ���Դ
        client.close();
    }
}
