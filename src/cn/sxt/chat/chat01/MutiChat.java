package cn.sxt.chat.chat01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ���������ң�������
 * Ŀ�ꣻʵ��һ���ͻ����������ն�������Ϣ
 * @author �ƽ���
 */
public class MutiChat {
    public static void main(String[] args) throws IOException {
        System.out.println("---Server---");
        //ָ���˿�
        ServerSocket server = new ServerSocket(8888);
        //����ʽ�ȴ�����
        Socket client = server.accept();
        System.out.println("һ���ͻ��˽���������");
        //������Ϣ
        DataInputStream dis = new DataInputStream(client.getInputStream());
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        boolean isRunning = true;
        while (isRunning) {
            String msg = dis.readUTF();
            //������Ϣ
            dos.writeUTF(msg);
            dos.flush();
        }
        //�ͷ���Դ
        dos.close();
        dis.close();
        client.close();
    }
}
