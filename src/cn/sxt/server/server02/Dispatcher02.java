package cn.sxt.server.server02;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * 分发器：加入状态内容处理 404 505 以及首页
 * @author thinkpad
 */
public class Dispatcher02 implements Runnable{
    private Socket client;
    private Request request;
    private Response response;

    public Dispatcher02(Socket client) {
        this.client = client;
        try {
            //获取请求协议
            request = new Request(client);
            //获取响应协议
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
                //关注了状态码
                response.pushToBrowser(200);
            }else {
                //错误
                InputStream is;
                is = Thread.currentThread().getContextClassLoader().getResourceAsStream("cn/sxt/server/server02/error.html");
                byte[] bytes = IOUtils.toByteArray(is);
                response.print(new String(bytes));
                response.pushToBrowser(404);
                is.close();
            }
        }catch (Exception e){
            try {
                response.print("你好我不好，我会马上好");
                response.pushToBrowser(500);
            }catch (IOException e1){
                e1.printStackTrace();
            }
        }
    }

    /**
     * 释放资源
     */
    private void release() {
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
