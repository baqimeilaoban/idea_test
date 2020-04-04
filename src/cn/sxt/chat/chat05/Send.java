package cn.sxt.chat.chat05;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 使用多线程封装发送端
 * 1.发送消息
 * 2.释放资源
 * 3.从控制台获取资源
 * 4.重写run
 * @author 黄建波
 */
public class Send implements Runnable {
    private BufferedReader console;
    private DataOutputStream dos;
    private Socket client;
    private boolean isRunning;
    private String name;

    public Send(Socket client, String name) {
        this.client = client;
        this.isRunning = true;
        console = new BufferedReader(new InputStreamReader(System.in));
        this.name = name;
        try {
            dos = new DataOutputStream(client.getOutputStream());
            //发送名称
            send(name);
        } catch (IOException e) {
            System.out.println("---客户端异常---");
            this.release();
        }
    }

    @Override
    public void run() {
        while (isRunning){
            String msg = getStrFromConsole();
            if (!"".equals(msg)){
                send(msg);
            }
        }
    }

    //发送消息
    private void send(String msg){
        try {
            dos.writeUTF(msg);
            dos.flush();
        } catch (IOException e) {
            System.out.println("---客户端发送异常---");
            release();
        }
    }
    //从控制台获取消息
    private String getStrFromConsole(){
        try {
            return console.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
    //释放资源
    private void release(){
        SxtUtils.close(dos,client);
    }
}
