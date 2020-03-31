package cn.sxt.udp;

/**
 * 加入多线程，实现双向交流 模拟在线咨询
 * @author 黄建波
 */
public class TalkStudent {
    public static void main(String[] args) {
        //发送
        new Thread(new TalkSend(7777,"localhost",9999)).start();

        //接收
        new Thread(new TalkReceive(8888,"学生")).start();
    }
}
