package cn.sxt.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ��Ϥ����
 * ����������
 * 1.ָ���˿� ʹ��ServerSocket����������
 * 2.����ʽ�ȴ�����accept
 * 3.���������������
 * 4.�ͷ���Դ
 */
public class Server {
    public static void main(String[] args) throws IOException {
        System.out.println("---server---");
        //ָ���˿� ʹ��ServerSocket����������
        ServerSocket server = new ServerSocket(8888);
        //����ʽ�ȴ�����accept
        Socket client = server.accept();
        System.out.println("һ���ͻ��˽���������");
        //�����������������
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        String data = "hello";
        dos.writeUTF(data);
        dos.flush();
        //�ͷ���Դ
        dos.close();
        client.close();

        server.close();
    }
}
