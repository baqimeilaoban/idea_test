package cn.sxt.server.server01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server05 {
    private ServerSocket serverSocket;
    public static void main(String[] args) {
        Server05 server = new Server05();
        server.start();
    }

    /**
     * ��������
     */
    public void start(){
        try {
            serverSocket = new ServerSocket(8888);
            receive();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("����������ʧ��");
        }
    }

    /**
     * �������Ӵ���
     */
    public void receive(){
        try {
            Socket client = serverSocket.accept();
            System.out.println("һ���ͻ��˽��������ӡ�����");
            //��ȡ����Э��
            Request02 request = new Request02(client);
            Response response = new Response(client);
            //��ע������
            response.print("<html>");
            response.print("<head>");
            response.print("<title>");
            response.print("Server responded successfully");
            response.print("</title>");
            response.print("</head>");
            response.print("<body>");
            response.print("shsxt server is finally back..." + request.getParameter("uname"));
            response.print("</body>");
            response.print("</html>");
            //��ע��״̬��
            response.pushToBrowser(200);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("�ͻ��˴���");
        }
    }

    /**
     * ֹͣ����
     */
    public void stop(){

    }
}