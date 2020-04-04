package cn.sxt.tcp;

import java.io.*;
import java.net.Socket;

/**
 * ģ���¼ ����ͻ�������
 * �����ͻ���
 * 1.�������ӣ�ʹ��Socket�����ͻ��� + �������ĵ�ַ�Ͷ˿�
 * 2.�������������������
 * 2.�ͷ���Դ
 *
 * @author �ƽ���
*/
public class LoginMutiClient {
    public static void main(String[] args) throws IOException {
        System.out.println("---Client---");
        //��������
        Socket client = new Socket("localhost",8888);
        //������������������������������Ӧ
        new Send(client).send();
        new Receive(client).receive();
        //�ͷ���Դ
        client.close();
    }

    /**
     * ����
     */
    static class Send{
        private Socket client;
        private DataOutputStream dos;
        private BufferedReader console;
        private String msg;
        public Send(Socket client) throws IOException {
            console = new BufferedReader(new InputStreamReader(System.in));
            msg = init();
            this.client = client;
            dos = new DataOutputStream(client.getOutputStream());
        }

        private String init(){
            try {
                System.out.print("�������û�����");
                String uname = console.readLine();
                System.out.print("���������룺");
                String upwd = console.readLine();
                return "uname=" + uname + "&" + "upwd=" + upwd;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "";
        }

        public void send() throws IOException {
            dos.writeUTF(msg);
            dos.flush();
        }
    }

    /**
     * ����
     */
    static class Receive{
        private DataInputStream dis;
        private Socket client;
        public Receive(Socket client) throws IOException {
            this.dis = dis;
            dis = new DataInputStream(client.getInputStream());
        }

        public void receive() throws IOException{
            String result = dis.readUTF();
            System.out.println(result);
        }
    }
}
