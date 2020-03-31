package cn.sxt.udp;

/**
 * 加入多线程，实现双向交流 模拟在线咨询
 * @author 黄建波
 */
public class TalkTeacher {
    public static void main(String[] args) {
        //接收
        new Thread(new TalkReceive(9999,"老师")).start();

        //发送
        new Thread(new TalkSend(5555,"localhost",8888)).start();
    }
}
