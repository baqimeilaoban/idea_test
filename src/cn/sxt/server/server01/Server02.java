package cn.sxt.server.server01;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * 目标: 返回响应协议
 * @author 黄建波
 */
public class Server02 {
    private ServerSocket serverSocket;
    public static void main(String[] args) {
        Server02 server = new Server02();
        server.start();
    }
    /**
     * 启动服务
     */
    public void start(){
        try {
            serverSocket = new ServerSocket(8888);
            receive();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("服务器启动失败。。。");
        }
    }
    /**
     * 接受连接处理
     */
    public void receive(){
        try {
            Socket client = serverSocket.accept();
            System.out.println("一个客户端建立了连接");
            //��ȡ����Э��
            InputStream is = client.getInputStream();
            byte[] datas = new byte[1024*1024];
            int len = is.read(datas);
            String requestInfo = new String(datas,0,len);
            System.out.println(requestInfo);

            StringBuilder content = new StringBuilder();
            content.append("<html>");
            content.append("<head>");
            content.append("<title>");
            content.append("服务器响应成功");
            content.append("</title>");
            content.append("</head>");
            content.append("<body>");
            content.append("sxsht server终于回来了。。。");
            content.append("</body>");
            content.append("</html>");
            //必须获得字节长度
            int size = content.toString().getBytes().length;
            StringBuilder responseInfo = new StringBuilder();
            String blank = " ";
            String CRLF = "\r\n";
            //����
            //1.��Ӧ��
            responseInfo.append("Http/1.1").append(blank);
            responseInfo.append(200).append(blank);
            responseInfo.append("OK").append(CRLF);
            /*Date:Mon,31Dec209904:25:57GMT
            Server:shsxt?Server/0.0.1;charset=GBK
            Content-type:text/html
            Content-length:39725426*/
            //2.响应头
            responseInfo.append("Date:").append(new Date()).append(CRLF);
            responseInfo.append("Server;").append("shsxt Server/0.0.1;charset=GBK").append(CRLF);
            responseInfo.append("Content-type:text/html").append(CRLF);
            responseInfo.append("Content-length:").append(size).append(CRLF);
            responseInfo.append(CRLF);
            //3.正文
            responseInfo.append(content.toString());
            //写出到客户端
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            bw.write(responseInfo.toString());
            //避免注入在内存中不出去
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("客户端错误");
        }
    }
    /**
     * 停止服务
     */
    public void stop(){

    }
}
