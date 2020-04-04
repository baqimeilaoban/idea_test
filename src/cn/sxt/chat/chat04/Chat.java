package cn.sxt.chat.chat04;

import cn.sxt.chat.chat03.SxtUtils;
import com.company.datastructure.linetable.ArrayList;
import com.company.datastructure.linetable.List;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 在线聊天室：服务器
 * 目标：加入容器实现群聊
 * @author 黄建波
 */
public class Chat {
    private static CopyOnWriteArrayList<Channel> all = new CopyOnWriteArrayList<>();
    public static void main(String[] args) throws IOException{
        System.out.println("---Server---");
        //指定端口
        ServerSocket server = new ServerSocket(8888);
        //阻塞式等待连接
        while (true){
            Socket client = server.accept();
            System.out.println("一个客户端建立了连接");
            Channel c = new Channel(client);
            all.add(c);
            new Thread(c).start();
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
        private String name;

        public Channel( Socket client) {
            this.client = client;
            isRunning = true;
            try {
                dis = new DataInputStream(client.getInputStream());
                dos = new DataOutputStream(client.getOutputStream());
                //获取名称
                this.name = receive();
                //欢迎你的到来
                this.send("欢迎你的到来");
                sendOthers(this.name + "来了shsxt聊天室",true);
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

        /**
         * 群聊；获取自己的消息，发给其他人
         * @param msg 消息
         */
        private void sendOthers(String msg,boolean isSys){
            for (Channel other:all){
                if (other==this){
                    //自己
                    continue;
                }
                if (!isSys){
                    other.send(this.name + "对所有人说：" + msg);
                }else {
                    other.send(msg);
                }

            }
        }
        //释放资源
        private void release(){
            this.isRunning = false;
            SxtUtils.close(dis,dos,client);
            //退出
            all.remove(this);
            sendOthers(this.name + "离开了大家庭。。。",true);
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
