package cn.sxt.chat.chat03;

import java.io.*;
import java.net.Socket;

/**
 * ���������ң��ͻ���
 * Ŀ�ꣻ��װʹ�ö��߳�ʵ�ֶ���ͻ����������շ�������Ϣ
 * @author �ƽ���
 */
public class TMultiClient {
    public static void main(String[] args) throws IOException {
        System.out.println("---Client---");
        //��������
        Socket client = new Socket("localhost",8888);
        //�ͻ��˷�����Ϣ
        new Thread(new Send(client)).start();
        new Thread(new Receive(client)).start();
    }
}
