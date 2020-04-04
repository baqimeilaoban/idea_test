package cn.sxt.chat.chat05;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * ʹ�ö��̷߳�װ���Ͷ�
 * 1.������Ϣ
 * 2.�ͷ���Դ
 * 3.�ӿ���̨��ȡ��Դ
 * 4.��дrun
 * @author �ƽ���
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
            //��������
            send(name);
        } catch (IOException e) {
            System.out.println("---�ͻ����쳣---");
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

    //������Ϣ
    private void send(String msg){
        try {
            dos.writeUTF(msg);
            dos.flush();
        } catch (IOException e) {
            System.out.println("---�ͻ��˷����쳣---");
            release();
        }
    }
    //�ӿ���̨��ȡ��Ϣ
    private String getStrFromConsole(){
        try {
            return console.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
    //�ͷ���Դ
    private void release(){
        SxtUtils.close(dos,client);
    }
}
