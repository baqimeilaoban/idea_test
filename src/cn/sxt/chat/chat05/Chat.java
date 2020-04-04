package cn.sxt.chat.chat05;

import cn.sxt.chat.chat03.SxtUtils;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * ���������ң�������
 * Ŀ�꣺˽��
 * @author �ƽ���
 */
public class Chat {
    private static CopyOnWriteArrayList<Channel> all = new CopyOnWriteArrayList<>();
    public static void main(String[] args) throws IOException{
        System.out.println("---Server---");
        //ָ���˿�
        ServerSocket server = new ServerSocket(8888);
        //����ʽ�ȴ�����
        while (true){
            Socket client = server.accept();
            System.out.println("һ���ͻ��˽���������");
            Channel c = new Channel(client);
            all.add(c);
            new Thread(c).start();
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
        private String name;

        public Channel( Socket client) {
            this.client = client;
            isRunning = true;
            try {
                dis = new DataInputStream(client.getInputStream());
                dos = new DataOutputStream(client.getOutputStream());
                //��ȡ����
                this.name = receive();
                //��ӭ��ĵ���
                this.send("��ӭ��ĵ���");
                sendOthers(this.name + "����shsxt������",true);
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

        /**
         * Ⱥ�ģ���ȡ�Լ�����Ϣ������������
         * ˽�ģ�Լ�����ݸ�ʽ��@xxx:msg
         * @param msg ��Ϣ
         */
        private void sendOthers(String msg,boolean isSys){
            boolean isPrivate = msg.startsWith("@");
            if (isPrivate){
                int idx = msg.indexOf(":");
                //˽�ģ���ȡĿ�������
                String targetName = msg.substring(1,idx);
                msg = msg.substring(idx+1);
                for (Channel other:all){
                    if (other.name.equals(targetName)){
                        other.send(this.name + "���ĵĶ���˵��" + msg);
                    }
                }
            }else {
                for (Channel other:all){
                    if (other==this){
                        //�Լ�
                        continue;
                    }
                    if (!isSys){
                        other.send(this.name + "��������˵��" + msg);
                    }else {
                        other.send(msg);
                    }
                }
            }
        }
        //�ͷ���Դ
        private void release(){
            this.isRunning = false;
            SxtUtils.close(dis,dos,client);
            //�˳�
            all.remove(this);
            sendOthers(this.name + "�뿪�˴��ͥ������",true);
        }

        @Override
        public void run() {
            while (isRunning){
                String msg = receive();
                if (!"".equals(msg)){
                    sendOthers(msg,false);
                }
            }
        }
    }
}
