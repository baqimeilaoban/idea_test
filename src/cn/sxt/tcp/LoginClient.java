package cn.sxt.tcp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * ģ���¼
 * �����ͻ���
 * 1.�������ӣ�ʹ��Socket�����ͻ��� + �������ĵ�ַ�Ͷ˿�
 * 2.�������������������
 * 2.�ͷ���Դ
 *
 * @author �ƽ���
 */
public class LoginClient {
    public static void main(String[] args) throws IOException {
        System.out.println("---Client---");
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("�������û�����");
        String uname = console.readLine();
        System.out.print("���������룺");
        String upwd = console.readLine();
        //��������
        Socket client = new Socket("localhost",8888);
        //����
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        dos.writeUTF( "uname="+ uname + "&" + "upwd=" + upwd);
        dos.flush();
    }
}
