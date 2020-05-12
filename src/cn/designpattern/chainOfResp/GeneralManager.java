package cn.designpattern.chainOfResp;

public class GeneralManager extends Leader{
    public GeneralManager(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveRequest request) {
        if (request.getLeaveDays()<30){
            System.out.println("Ա����" + request.getEmpName() + "��٣�������" + request.getLeaveDays() + "���ɣ�" + request.getReason());
            System.out.println("�ܾ���" + this.name + "����ͨ����");
        }else {
            System.out.println("Ī��" + request.getEmpName() + "���ְ����Ȼ���" + request.getLeaveDays() + "�죡");
        }
    }
}

