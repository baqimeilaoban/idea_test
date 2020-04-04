package cn.sxt.tcp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 模拟登录
 * 创建客户端
 * 1.建立连接；使用Socket创建客户端 + 服务器的地址和端口
 * 2.操作：输入输出流操作
 * 2.释放资源
 *
 * @author 黄建波
 */
public class LoginClient {
    public static void main(String[] args) throws IOException {
        System.out.println("---Client---");
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("请输入用户名：");
        String uname = console.readLine();
        System.out.print("请输入密码：");
        String upwd = console.readLine();
        //建立连接
        Socket client = new Socket("localhost",8888);
        //操作
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        dos.writeUTF( "uname="+ uname + "&" + "upwd=" + upwd);
        dos.flush();
    }
}
