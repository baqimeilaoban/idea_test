package cn.sxt.tcp;

import java.io.*;
import java.net.Socket;

/**
 * ģ���¼ ˫��
 * �����ͻ���
 * 1.�������ӣ�ʹ��Socket�����ͻ��� + �������ĵ�ַ�Ͷ˿�
 * 2.�������������������
 * 2.�ͷ���Դ
 *
 * @author �ƽ���
 */
public class LoginTwoWayClient {
    public static void main(String[] args) throws IOException {
        System.out.println("---Client---");
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("�������û�����");
        String uname = console.readLine();
        System.out.print("���������룺");
        String upwd = console.readLine();
        //��������
        Socket cilent = new Socket("localhost",8888);
        DataOutputStream dos = new DataOutputStream(cilent.getOutputStream());
        dos.writeUTF("uname=" + uname + "&" + "upwd=" + upwd);
        dos.flush();
        DataInputStream dis = new DataInputStream(cilent.getInputStream());
        String datas = dis.readUTF();

        System.out.println(datas);
        //�ͷ���Դ
        dos.close();
        cilent.close();

    }
}
