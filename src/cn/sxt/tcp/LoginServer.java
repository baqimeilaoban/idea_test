package cn.sxt.tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ģ���¼
 * ����������
 * 1.ָ���˿� ʹ��ServerSocket����������
 * 2.����ʽ�ȴ�����accept
 * 3.���������������
 * 4.�ͷ���Դ
 */
public class LoginServer {
    public static void main(String[] args) throws IOException {
        System.out.println("---Server---");
        //ָ���˿�
        ServerSocket server = new ServerSocket(8888);
        //����ʽ�ȴ�����
        Socket client = server.accept();
        System.out.println("һ���ͻ��˽���������");
        //����
        DataInputStream dis = new DataInputStream(client.getInputStream());
        String datas = dis.readUTF();
        //����
        String[] dataArray = datas.split("&");
        for (String info:dataArray){
            String[] userInfo = info.split("=");
            if (userInfo[0].equals("uname")){
                System.out.println("����û���Ϊ��" + userInfo[1]);
            }else if (userInfo[0].equals("upwd")){
                System.out.println("�������Ϊ��" + userInfo[1]);
            }
        }
        //�ͷ���Դ
        dis.close();
        client.close();

    }
}
