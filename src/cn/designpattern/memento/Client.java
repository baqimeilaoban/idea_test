package cn.designpattern.memento;

public class Client {
    public static void main(String[] args) {
        CareTaker taker = new CareTaker();
        Emp emp = new Emp("����",18,900);
        System.out.println("��һ�δ�ӡ����" + emp.getEname() + "---" + emp.getAge() + "---" + emp.getSalary());
        //����һ��
        taker.setMemento(emp.memento());
        emp.setAge(25);
        emp.setEname("hjb");
        emp.setSalary(9000);
        System.out.println("�ڶ��δ�ӡ����" + emp.getEname() + "---" + emp.getAge() + "---" + emp.getSalary());
        //�ָ�������¼���󱣴��״̬
        emp.recovery(taker.getMemento());
        System.out.println("�����δ�ӡ����" + emp.getEname() + "---" + emp.getAge() + "---" + emp.getSalary());
    }
}
