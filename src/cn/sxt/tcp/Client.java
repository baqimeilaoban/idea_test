package cn.sxt.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * ��Ϥ����
 * �����ͻ���
 * 1.�������ӣ�ʹ��Socket�����ͻ��� + �������ĵ�ַ�Ͷ˿�
 * 2.�������������������
 * 2.�ͷ���Դ
 *
 * @author �ƽ���
 */
public class Client {
    public static void main(String[] args) throws IOException {
        System.out.println("---client---");
        //��������
        Socket client = new Socket("localhost",8888);
        //����
        DataInputStream dis = new DataInputStream(client.getInputStream());
        String data = dis.readUTF();
        System.out.println(data);
        //�ͷ���Դ
        dis.close();
        client.close();

    }
}
