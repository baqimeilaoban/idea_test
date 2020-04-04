package cn.sxt.tcp;

import java.io.*;
import java.net.Socket;

/**
 * 模拟登录 双向
 * 创建客户端
 * 1.建立连接；使用Socket创建客户端 + 服务器的地址和端口
 * 2.操作：输入输出流操作
 * 2.释放资源
 *
 * @author 黄建波
 */
public class LoginTwoWayClient {
    public static void main(String[] args) throws IOException {
        System.out.println("---Client---");
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("请输入用户名：");
        String uname = console.readLine();
        System.out.print("请输入密码：");
        String upwd = console.readLine();
        //建立连接
        Socket cilent = new Socket("localhost",8888);
        DataOutputStream dos = new DataOutputStream(cilent.getOutputStream());
        dos.writeUTF("uname=" + uname + "&" + "upwd=" + upwd);
        dos.flush();
        DataInputStream dis = new DataInputStream(cilent.getInputStream());
        String datas = dis.readUTF();

        System.out.println(datas);
        //释放资源
        dos.close();
        cilent.close();

    }
}
