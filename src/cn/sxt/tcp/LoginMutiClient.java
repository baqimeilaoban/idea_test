package cn.sxt.tcp;

import java.io.*;
import java.net.Socket;

/**
 * 模拟登录 多个客户端请求
 * 创建客户端
 * 1.建立连接；使用Socket创建客户端 + 服务器的地址和端口
 * 2.操作：输入输出流操作
 * 2.释放资源
 *
 * @author 黄建波
*/
public class LoginMutiClient {
    public static void main(String[] args) throws IOException {
        System.out.println("---Client---");
        //建立连接
        Socket client = new Socket("localhost",8888);
        //操作：输入输出流操作，先请求后响应
        new Send(client).send();
        new Receive(client).receive();
        //释放资源
        client.close();
    }

    /**
     * 发送
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
                System.out.print("请输入用户名：");
                String uname = console.readLine();
                System.out.print("请输入密码：");
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
     * 接收
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
