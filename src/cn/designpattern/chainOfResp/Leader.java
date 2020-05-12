package cn.designpattern.chainOfResp;

/**
 * ������
 * @author hjb
 */
public class Leader {
    protected String name;
    /**
     * �������ϵĺ�̶���
     */
    protected Leader nextLeader;
    public Leader(String name) {
        this.name = name;
    }

    /**
     * �趨�������ϵĺ�̶���
     * @param nextLeader ��̶���
     */
    public void setNextLeader(Leader nextLeader) {
        this.nextLeader = nextLeader;
    }

    /**
     * ��������ĺ��ĵ�ҵ�񷽷�
     *
     * @param request
     */
    public void handleRequest(LeaveRequest request) {

    }
}
