package cn.designpattern.chainOfResp;

public class Client {
    public static void main(String[] args) {
        Leader a = new Director("张三");
        Leader b = new Manager("李四");
        Leader c = new ViceGeneralManager("李小四");
        Leader d = new GeneralManager("王五");
        //组织责任链对象的关系
        a.setNextLeader(b);
        b.setNextLeader(c);
        c.setNextLeader(d);

        //开始请假操作
        LeaveRequest request = new LeaveRequest("TOM",15,"回英国老家探亲！");
        a.handleRequest(request);
    }
}
