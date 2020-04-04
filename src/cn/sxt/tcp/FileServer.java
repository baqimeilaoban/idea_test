package cn.sxt.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * �洢�ļ�
 * ����������
 * 1.ָ���˿� ʹ��ServerSocket����������
 * 2.����ʽ�ȴ�����accept
 * 3.���������������
 * 4.�ͷ���Դ
 */
public class FileServer {
    public static void main(String[] args) throws IOException {
        System.out.println("---Server---");
        //ָ���˿�
        ServerSocket server = new ServerSocket(8888);
        //����ʽ�ȴ�����
        Socket client = server.accept();
        System.out.println("һ���ͻ��˽���������");
        //����:�ļ��Ĵ洢
        InputStream is = new BufferedInputStream(client.getInputStream());
        OutputStream os = new BufferedOutputStream(new FileOutputStream("src/cn/sxt/tcp/tcp.png"));
        byte[] flush = new byte[1024];
        int len = -1;
        while ((len=is.read(flush))!=-1){
            os.write(flush,0,len);
        }
        os.flush();
        //�ͷ���Դ
        os.close();
        is.close();
        client.close();
    }
}
