package cn.sxt.chat.chat03;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 在线聊天室：服务器
 * 目标；封装使用多线程实现多个客户可以正常收多条发消息
 * 问题：
 * 1.代码不好维护
 * 2.客户端读写没有分开 必须先写后读
 * @author 黄建波
 */
public class TMultiChat {
    public static void main(String[] args) throws IOException{
        System.out.println("---Server---");
        //指定端口
        ServerSocket server = new ServerSocket(8888);
        //阻塞式等待连接
        while (true){
            Socket client = server.accept();
            System.out.println("一个客户端建立了连接");
            new Thread(new Channel(client)).start();
        }
    }

    /**
     * 一个客户代表一个Channel
     */
    static class Channel implements Runnable{
        private DataInputStream dis;
        private DataOutputStream dos;
        private Socket client;
        private boolean isRunning;

        public Channel( Socket client) {
            this.client = client;
            isRunning = true;
            try {
                dis = new DataInputStream(client.getInputStream());
                dos = new DataOutputStream(client.getOutputStream());
            }catch (IOException e){
                release();
            }
        }

        //接收消息
        private String receive(){
            String msg = "";
            try {
                msg = dis.readUTF();
            } catch (IOException e) {
                System.out.println("---2：接收有误---");
                release();
            }
            return msg;
        }

        //发送消息
        private void send(String msg){
            try {
                dos.writeUTF(msg);
                dos.flush();
            } catch (IOException e) {
                System.out.println("---3：发送有误---");
                release();
            }
        }

        //释放资源
        private void release(){
            this.isRunning = false;
            SxtUtils.close(dis,dos,client);
        }

        @Override
        public void run() {
            while (isRunning){
                String msg = receive();
                if (!"".equals(msg)){
                    send(msg);
                }
            }
        }
    }
}
