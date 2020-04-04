package cn.sxt.chat.chat03;

import java.io.*;
import java.net.Socket;

/**
 * 在线聊天室：客户端
 * 目标；封装使用多线程实现多个客户可以正常收发多条消息
 * @author 黄建波
 */
public class TMultiClient {
    public static void main(String[] args) throws IOException {
        System.out.println("---Client---");
        //建立连接
        Socket client = new Socket("localhost",8888);
        //客户端发送消息
        new Thread(new Send(client)).start();
        new Thread(new Receive(client)).start();
    }
}
