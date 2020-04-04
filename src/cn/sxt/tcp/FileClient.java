package cn.sxt.tcp;

import java.io.*;
import java.net.Socket;

/**
 * �ϴ��ļ�
 * �����ͻ���
 * 1.�������ӣ�ʹ��Socket�����ͻ��� + �������ĵ�ַ�Ͷ˿�
 * 2.�������������������
 * 2.�ͷ���Դ
 *
 * @author �ƽ���
 */
public class FileClient {
    public static void main(String[] args) throws IOException {
        System.out.println("---Client---");
        //��������
        Socket client = new Socket("localhost",8888);
        //����
        InputStream is = new BufferedInputStream(new FileInputStream("src/cn/sxt/io/IO.png"));
        OutputStream os = new BufferedOutputStream(client.getOutputStream());
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
