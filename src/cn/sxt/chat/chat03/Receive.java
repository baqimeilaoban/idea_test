package cn.sxt.chat.chat03;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * ʹ�ö��̷߳�װ���ն�
 * 1.������Ϣ
 * 2.�ͷ���Դ
 * 3.��дrun
 * @author �ƽ���
 */
public class Receive implements Runnable {
    private DataInputStream dis;
    private Socket client;
    private boolean isRunning;

    public Receive(Socket client) {
        this.client = client;
        this.isRunning = true;
        try {
            dis = new DataInputStream(client.getInputStream());
        } catch (IOException e) {
            System.out.println("---���ն��쳣---");
            release();
        }
    }

    //������Ϣ
    private String receive(){
        String msg = "";
        try {
            msg = dis.readUTF();
        } catch (IOException e) {
            System.out.println("---������Ϣ�쳣---");
            release();
        }
        return msg;
    }
    @Override
    public void run() {
        while (isRunning){
            String msg = receive();
            if (!"".equals(msg)){
                System.out.println(msg);
            }
        }
    }

    //�ͷ���Դ
    private void release(){
        SxtUtils.close(dis,client);
    }
}
