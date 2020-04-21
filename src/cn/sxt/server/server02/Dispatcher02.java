package cn.sxt.server.server02;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * �ַ���������״̬���ݴ��� 404 505 �Լ���ҳ
 * @author thinkpad
 */
public class Dispatcher02 implements Runnable{
    private Socket client;
    private Request request;
    private Response response;

    public Dispatcher02(Socket client) {
        this.client = client;
        try {
            //��ȡ����Э��
            request = new Request(client);
            //��ȡ��ӦЭ��
            response = new Response(client);
        } catch (IOException e) {
            e.printStackTrace();
            this.release();
        }
    }

    @Override
    public void run() {
        try {
            if (null==request.getUrl() || request.getUrl().equals("")){
                InputStream is;
                is = Thread.currentThread().getContextClassLoader().getResourceAsStream("cn/sxt/server/server02/index.html");
                byte[] bytes = IOUtils.toByteArray(is);
                response.print(new String(bytes));
                response.pushToBrowser(200);
                is.close();
                return;
            }
            Servlet servlet = WebApp.getServletFromUrl(request.getUrl());
            if (null!=servlet){
                servlet.service(request,response);
                //��ע��״̬��
                response.pushToBrowser(200);
            }else {
                //����
                InputStream is;
                is = Thread.currentThread().getContextClassLoader().getResourceAsStream("cn/sxt/server/server02/error.html");
                byte[] bytes = IOUtils.toByteArray(is);
                response.print(new String(bytes));
                response.pushToBrowser(404);
                is.close();
            }
        }catch (Exception e){
            try {
                response.print("����Ҳ��ã��һ����Ϻ�");
                response.pushToBrowser(500);
            }catch (IOException e1){
                e1.printStackTrace();
            }
        }
    }

    /**
     * �ͷ���Դ
     */
    private void release() {
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
