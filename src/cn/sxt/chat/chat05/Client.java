package cn.sxt.chat.chat05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * ���������ң��ͻ���
 * Ŀ�ꣻ��������ʵ��Ⱥ��
 */
public class Client {
    public static void main(String[] args) throws IOException {
        System.out.println("---Client---");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("�������û�����");
        String name = br.readLine();
        //��������
        Socket client = new Socket("localhost",8888);
        //�ͻ��˷�����Ϣ
        new Thread(new Send(client,name)).start();
        new Thread(new Receive(client)).start();
    }
}
