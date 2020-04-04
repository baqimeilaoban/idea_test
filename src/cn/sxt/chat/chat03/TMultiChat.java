package cn.sxt.chat.chat03;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ���������ң�������
 * Ŀ�ꣻ��װʹ�ö��߳�ʵ�ֶ���ͻ����������ն�������Ϣ
 * ���⣺
 * 1.���벻��ά��
 * 2.�ͻ��˶�дû�зֿ� ������д���
 * @author �ƽ���
 */
public class TMultiChat {
    public static void main(String[] args) throws IOException{
        System.out.println("---Server---");
        //ָ���˿�
        ServerSocket server = new ServerSocket(8888);
        //����ʽ�ȴ�����
        while (true){
            Socket client = server.accept();
            System.out.println("һ���ͻ��˽���������");
            new Thread(new Channel(client)).start();
        }
    }

    /**
     * һ���ͻ�����һ��Channel
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

        //������Ϣ
        private String receive(){
            String msg = "";
            try {
                msg = dis.readUTF();
            } catch (IOException e) {
                System.out.println("---2����������---");
                release();
            }
            return msg;
        }

        //������Ϣ
        private void send(String msg){
            try {
                dos.writeUTF(msg);
                dos.flush();
            } catch (IOException e) {
                System.out.println("---3����������---");
                release();
            }
        }

        //�ͷ���Դ
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
