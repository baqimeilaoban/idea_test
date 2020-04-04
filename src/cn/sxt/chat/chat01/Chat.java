package cn.sxt.chat.chat01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ���������ң�������
 * Ŀ�ꣻʵ��һ���ͻ����������շ���Ϣ
 * @author �ƽ���
 */
public class Chat {
    public static void main(String[] args) throws IOException {
        System.out.println("---Server---");
        //ָ���˿�
        ServerSocket server = new ServerSocket(8888);
        //����ʽ�ȴ�����
        Socket client = server.accept();
        System.out.println("һ���ͻ��˽���������");
        //������Ϣ
        DataInputStream dis = new DataInputStream(client.getInputStream());
        String msg = dis.readUTF();
        //������Ϣ
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        dos.writeUTF(msg);
        dos.flush();
        //�ͷ���Դ
        dos.close();
        dis.close();
        client.close();
    }
}
