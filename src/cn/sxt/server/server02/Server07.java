package cn.sxt.server.server02;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Ŀ�꣺���������ļ�
 * @author thinkpad
 */
public class Server07 {
    private ServerSocket serverSocket;
    public static void main(String[] args) {
        Server07 server = new Server07();
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
            Request request = new Request(client);
            //��ȡ��ӦЭ��
            Response response = new Response(client);
            Servlet servlet = WebApp.getServletFromUrl(request.getUrl());
            if (null!=servlet){
                servlet.service(request,response);
                //��ע��״̬��
                response.pushToBrowser(200);
            }else {
                response.pushToBrowser(404);
            }
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
