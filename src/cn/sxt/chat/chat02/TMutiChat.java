package cn.sxt.chat.chat02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ���������ң�������
 * Ŀ�ꣻʹ�ö��߳�ʵ�ֶ���ͻ����������ն�������Ϣ
 * ���⣺
 * 1.���벻��ά��
 * 2.�ͻ��˶�дû�зֿ� ������д���
 * @author �ƽ���
 */
public class TMutiChat {
    public static void main(String[] args) throws IOException {
        System.out.println("---Server---");
        //ָ���˿�
        ServerSocket server = new ServerSocket(8888);
        while (true) {
            Socket client = server.accept();
            System.out.println("һ���ͻ��˽���������");
            //����ʽ�ȴ�����
            new Thread(() -> {
                //������Ϣ
                DataInputStream dis = null;
                try {
                    dis = new DataInputStream(client.getInputStream());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                DataOutputStream dos = null;
                try {
                    dos = new DataOutputStream(client.getOutputStream());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                boolean isRunning = true;
                while (isRunning) {
                    String msg = null;
                    try {
                        msg = dis.readUTF();
                        //������Ϣ
                        dos.writeUTF(msg);
                        dos.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                        //ֹͣ�߳�
                        isRunning = false;
                    }
                }
                //�ͷ���Դ
                try {
                    if (null == dos) {
                        dos.close();
                    }
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    if (dis == null) {
                        dis.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    if (null == client) {
                        client.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
