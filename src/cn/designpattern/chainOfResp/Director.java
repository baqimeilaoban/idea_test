package cn.designpattern.chainOfResp;

/**
 * ����
 * @author hjb
 */
public class Director extends Leader{

    public Director(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveRequest request) {
        if (request.getLeaveDays()<3){
            System.out.println("Ա����" + request.getEmpName() + "��٣�������" + request.getLeaveDays() + "���ɣ�" + request.getReason());
            System.out.println("���Σ�" + this.name + "����ͨ����");
        }else {
            if (this.nextLeader!=null){
                this.nextLeader.handleRequest(request);
            }
        }
    }
}
