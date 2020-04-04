package cn.sxt.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ģ���¼ ����ͻ�������
 * ����������
 * 1.ָ���˿� ʹ��ServerSocket����������
 * 2.����ʽ�ȴ�����accept
 * 3.���������������
 * 4.�ͷ���Դ
 */
public class LoginMutiServer {
    public static void main(String[] args) throws IOException {
        System.out.println("---Server---");
        //ָ���˿�
        ServerSocket server = new ServerSocket(8888);
        boolean isRunning = true;
        //����ʽ�ȴ�����
        while (isRunning){
            Socket client = server.accept();
            new Thread(new Channel(client)).start();
        }
        server.close();
    }

    static class Channel implements Runnable{
        private Socket client;
        //������
        private DataInputStream dis;
        //�����
        DataOutputStream dos;
        public Channel(Socket client){
            this.client = client;
            //����
            try {
                //����
                dis = new DataInputStream(client.getInputStream());
                //���
                dos = new DataOutputStream(client.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
                release();
            }
        }

        /**
         * ��������
         * @return ��������
         */
        private String receive(){
            String datas = "";
            try {
                datas = dis.readUTF();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return datas;
        }

        /**
         * �ͷ���Դ
         */
        private void release(){
            try {
                if (null != dos){
                    dos.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }

            try {
                if (null != dis){
                    dis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (null != client){
                    client.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        /**
         * ��������
         * @param msg
         */
        private void send(String msg){
            try {
                dos.writeUTF(msg);
                dos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        @Override
        public void run() {
            String uname = "";
            String upwd = "";
            //����
            String[] dataArray = receive().split("&");
            for (String info:dataArray){
                String[] userInfo = info.split("=");
                if (userInfo[0].equals("uname")){
                    System.out.println("����û���Ϊ��" + userInfo[1]);
                    uname = userInfo[1];
                }else if (userInfo[0].equals("upwd")){
                    System.out.println("�������Ϊ��" + userInfo[1]);
                    upwd = userInfo[1];
                }
            }
            if ("shsxt".equals(uname)&& "laopei".equals(upwd)){
                //�ɹ�
                send("��½�ɹ�����ӭ������");
            }else {
                //ʧ��
                send("�û������������");
            }
            //�ͷ���Դ
            release();
        }

    }


}
