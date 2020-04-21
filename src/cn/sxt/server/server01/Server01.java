package cn.sxt.server.server01;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Ŀ�ꣻʹ��ServerSocket����������������ӣ���ȡ����Э��
 * @author �ƽ���
 */
public class Server01 {
    private ServerSocket serverSocket;
    public static void main(String[] args) {
        Server01 server = new Server01();
        server.start();
    }

    /**
     * ��������
     */
    public void start(){
        try {
            serverSocket = new ServerSocket(8888);
            receive();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("����������ʧ�ܡ�����");
        }
    }

    /**
     * �������Ӵ���
     */
    public void receive(){
        try {
            Socket client = serverSocket.accept();
            System.out.println("һ���ͻ��˽��������ӡ�����");
            //��ȡ����Э��
            InputStream is = client.getInputStream();
            byte[] datas = new byte[1024*1024];
            int len = is.read(datas);
            String requestInfo = new String(datas,0,len);
            System.out.println(requestInfo);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("�ͻ��˴���");
        }
    }

    /**
     * ֹͣ����
     */
    public void stop(){

    }
}
