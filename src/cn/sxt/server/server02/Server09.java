package cn.sxt.server.server02;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Ŀ�꣺���̴߳������ַ���
 * @author �ƽ���
 */
public class Server09 {
    private ServerSocket serverSocket;
    private boolean isRunning;
    public static void main(String[] args) {
        Server09 server = new Server09();
        server.start();
    }

    /**
     * ��������
     */
    public void start(){
        try {
            serverSocket = new ServerSocket(8888);
            isRunning = true;
            receive();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("����������ʧ��");
            stop();
        }
    }

    /**
     * �������Ӵ���
     */
    public void receive(){
        while (isRunning) {
            try {
                Socket client = serverSocket.accept();
                System.out.println("һ���ͻ��˽��������ӡ�����");
                //���̴߳���
                new Thread(new Dispatcher02(client)).start();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("�ͻ��˴���");
            }
        }
    }

    /**
     * ֹͣ����
     */
    public void stop(){
        isRunning = false;
        try {
            this.serverSocket.close();
            System.out.println("��������ֹͣ");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
