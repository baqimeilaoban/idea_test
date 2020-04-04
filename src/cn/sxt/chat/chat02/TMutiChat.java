package cn.sxt.chat.chat02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 在线聊天室：服务器
 * 目标；使用多线程实现多个客户可以正常收多条发消息
 * 问题：
 * 1.代码不好维护
 * 2.客户端读写没有分开 必须先写后读
 * @author 黄建波
 */
public class TMutiChat {
    public static void main(String[] args) throws IOException {
        System.out.println("---Server---");
        //指定端口
        ServerSocket server = new ServerSocket(8888);
        while (true) {
            Socket client = server.accept();
            System.out.println("一个客户端建立了连接");
            //阻塞式等待连接
            new Thread(() -> {
                //接收消息
                DataInputStream dis = null;
                try {
                    dis = new DataInputStream(client.getInputStream());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                DataOutputStream dos = null;
                try {
                    dos = new DataOutputStream(client.getOutputStream());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                boolean isRunning = true;
                while (isRunning) {
                    String msg = null;
                    try {
                        msg = dis.readUTF();
                        //返回消息
                        dos.writeUTF(msg);
                        dos.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                        //停止线程
                        isRunning = false;
                    }
                }
                //释放资源
                try {
                    if (null == dos) {
                        dos.close();
                    }
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    if (dis == null) {
                        dis.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    if (null == client) {
                        client.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
