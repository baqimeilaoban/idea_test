package cn.sxt.chat.chat01;

import java.io.*;
import java.net.Socket;

/**
 * ���������ң��ͻ���
 * Ŀ�ꣻʵ��һ���ͻ����������շ���Ϣ
 * @author �ƽ���
 */
public class Client {
    public static void main(String[] args) throws IOException {
        System.out.println("---Client---");
        //��������
        Socket client = new Socket("localhost",8888);
        //�ͻ��˷�����Ϣ
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String msg = console.readLine();
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        dos.writeUTF(msg);
        dos.flush();
        //��ȡ��Ϣ
        DataInputStream dis = new DataInputStream(client.getInputStream());
        msg = dis.readUTF();
        System.out.println(msg);
        //�ͷ���Դ
        dos.close();
        dis.close();
        client.close();
    }
}
