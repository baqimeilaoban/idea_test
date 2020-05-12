package cn.designpattern.chainOfResp;

public class Manager extends Leader{
    public Manager(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveRequest request) {
        if (request.getLeaveDays()<10){
            System.out.println("Ա����" + request.getEmpName() + "��٣�������" + request.getLeaveDays() + "���ɣ�" + request.getReason());
            System.out.println("����" + this.name + "����ͨ����");
        }else {
            if (this.nextLeader!=null){
                this.nextLeader.handleRequest(request);
            }
        }
    }
}
