package cn.designpattern.chainOfResp;

public class Client {
    public static void main(String[] args) {
        Leader a = new Director("����");
        Leader b = new Manager("����");
        Leader c = new ViceGeneralManager("��С��");
        Leader d = new GeneralManager("����");
        //��֯����������Ĺ�ϵ
        a.setNextLeader(b);
        b.setNextLeader(c);
        c.setNextLeader(d);

        //��ʼ��ٲ���
        LeaveRequest request = new LeaveRequest("TOM",15,"��Ӣ���ϼ�̽�ף�");
        a.handleRequest(request);
    }
}
